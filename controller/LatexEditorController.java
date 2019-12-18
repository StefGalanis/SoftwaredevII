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
	private String type;
	private String text;
	private String filename;
	private String strategy;
	private VersionsManager versionsManager;
	
	
	
	public LatexEditorController(VersionsManager versionsManager,LatexEditorView latexEditorView) {
		
		this.currentDocument = new Document();
		this.versionsManager = versionsManager;
		
		CommandFactory commandFactory = new CommandFactory(versionsManager,this,currentDocument);
		
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
	
	public boolean isVersionsManagerEnabled() {
		return versionsManager.isEnabled();
	}
	
	public void setCurrentVersion(Document document) {
		versionsManager.putVersion(document);
	}
	
	public void setContents(String text) {
		currentDocument.setContents(text);
	}
	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
		this.text = currentDocument.getContents();
		//versionsManager.putVersion(currentDocument);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) { 
		this.type = type;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getStrategy() {
		return strategy;
	}
	
	public void setStrategy(String strategy) {
		this.strategy = strategy;
		versionsManager.setStrategyType(strategy);
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public VersionsManager getVersionsManager() {
		// TODO Auto-generated method stub
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager2) {
		// TODO Auto-generated method stub
		
	}

}
