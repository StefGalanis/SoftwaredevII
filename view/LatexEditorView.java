package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class LatexEditorView {
	private LatexEditorController controller;
	private Document currentDocument;
	private String type;
	private String text;
	private String filename;
	private String strategy;
	private VersionsManager versionsManager;
	
	public VersionsManager getVersionsManager() {
		return versionsManager;
	}//possible remove of method
	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}//possible remove of method
	public String getStrategy() {
		return strategy;
	}//possible remove of method
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}//possible remove of method
	public String getText() {
		return text;
	}//possible remove of method
	public void setText(String text) {
		this.text = text;
	}//possible remove of method
	public LatexEditorController getController() {
		return controller;
	}//possible remove of method
	public void setController(LatexEditorController controller) {
		this.controller = controller;
	}//possible remove of method
	public Document getCurrentDocument() {
		return currentDocument;
	}//possible remove of method
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
		this.text = currentDocument.getContents();//evala grammh edw
	}//possible remove of method
	public String getType() {
		return type;
	}//possible remove of method
	public void setType(String type) {
		this.type = type;
	}//possible remove of method
	public void saveContents() {
		// TODO Auto-generated method stub
		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(text);
	}
	public void saveToFile() {
		// TODO Auto-generated method stub
		currentDocument.save(filename);
	}//possible remove of method
	public String getFilename() {
		return filename;
	}//possible remove of method
	public void setFilename(String filename) {
		this.filename = filename;
	}//possible remove of method
	public void loadFromFile() {
		// TODO Auto-generated method stub
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(filename));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentDocument = new Document();
		currentDocument.setContents(fileContents);
		
		type = "emptyTemplate";
		
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			type = "articleTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			type = "bookTemplate";
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			type = "reportTemplate";
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			type = "letterTemplate";
		}
	}
	
}
