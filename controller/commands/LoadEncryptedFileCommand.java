package controller.commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JEditorPane;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class LoadEncryptedFileCommand extends Command {
	
	private HashMap<Integer, String> encryptionTypes;
	
	public LoadEncryptedFileCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);	
		encryptionTypes = new HashMap<Integer, String>();
		String encryptionTypesFile = "encryptionTypesFile.txt";
		
		try {
			BufferedReader encryptionTypesFileReader = new BufferedReader(new FileReader(encryptionTypesFile));
			String encryptionType;
			int id = 0;
			while ((encryptionType = encryptionTypesFileReader.readLine()) != null) {
				encryptionTypes.put(id, encryptionType);
				id++;
			}
			encryptionTypesFileReader.close();
		}
		catch(Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", encryptionTypesFile);
		    e.printStackTrace();
		}
	}


	@Override
	public void execute() {
		loadEncryptedFile();
		
	}
	
	public void loadEncryptedFile() {
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(latexEditorController.getFilename()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String originalContents = fileContents;
		for(int i=0; i<encryptionTypes.size(); i++) {
			String encryptionType = encryptionTypes.get(i);
			latexEditorController.setDocumentContents(originalContents);
			latexEditorController.enact(encryptionType);
			fileContents = latexEditorController.getDocumentContents();
			fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			latexEditorController.setType("articleTemplate");
			break;
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			latexEditorController.setType("bookTemplate");
			break;
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			latexEditorController.setType("reportTemplate");
			break;
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			latexEditorController.setType("letterTemplate");
			break;
		}
		}
	}


}
