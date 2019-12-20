package controller;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import javax.swing.JEditorPane;

import controller.commands.AddLatexCommand;
import controller.commands.ChangeVersionsStrategyCommand;
import controller.commands.Command;
import controller.commands.CommandFactory;
import controller.commands.CreateDocumentCommand;
import controller.commands.DisableVersionsManagementCommand;
import controller.commands.EditCommand;
import controller.commands.EnableVersionsManagementCommand;
import controller.commands.LoadCommand;
import controller.commands.RollbackToPreviousVersionCommand;
import controller.commands.SaveCommand;
import model.Document;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;
import view.MainWindow;

public class LatexEditorController{
	private HashMap<String, Command> commands;
	private Document currentDocument;
	private String type;
	private String text;
	private String filename;
	private String strategy;
	private VersionsManager versionsManager;
	private String addLatexCommandType;
	private JEditorPane editorPane;
	

	public LatexEditorController() {
		
		VersionsStrategy versionsStrategy = new VolatileVersionsStrategy();
		VersionsManager versionsManager = new VersionsManager(versionsStrategy);
		
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
	
	public JEditorPane getEditorPane() {
		return editorPane;
	}

	public void setEditorPane(JEditorPane editorPane) {
		this.editorPane = editorPane;
	}

	public String getAddLatexCommandType() {
		return addLatexCommandType;
	}

	public void setAddLatexCommandType(String addLatexCommandType) {
		this.addLatexCommandType = addLatexCommandType;
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
		return versionsManager;
	}

	public String getDocumentContents() {
		return currentDocument.getContents();
	}
	
	public void setDocumentContents(String contents) {
		currentDocument.setContents(contents);
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;		
	}

}
