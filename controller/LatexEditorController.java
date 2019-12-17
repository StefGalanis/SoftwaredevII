package controller;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import controller.commands.AddLatexCommand;
import controller.commands.ChangeVersionsStrategyCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.commands.CreateCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.LoadCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import controller.commands.SaveCommand;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;
import view.MainWindow;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	private Document currentDocument;
	
	
	public LatexEditorController(VersionsManager versionsManager) {

		CommandFactory commandFactory = new CommandFactory(versionsManager);
		
		commands = new HashMap<String, Command>();
		String commandsFile = "commandsFile.txt";
		
		try {
			BufferedReader commandsFileReader = new BufferedReader(new FileReader(commandsFile));
			String commandName;
			while ((commandName = commandsFileReader.readLine()) != null) {
				commands.put(commandName, commandFactory.createCommand(commandName));
			}
			commandsFileReader.close();
		}
		catch(Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", commandsFile);
		    e.printStackTrace();
		}
	}
	
	public void enact(String command) {
		commands.get(command).execute();
	}
	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}
	
	
}
