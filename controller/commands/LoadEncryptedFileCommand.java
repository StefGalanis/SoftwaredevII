package controller.commands;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JEditorPane;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class LoadEncryptedFileCommand extends Command {
	
	public LoadEncryptedFileCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);	
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		loadEncryptedFile();
		
	}
	
	public void loadEncryptedFile() {
		// TODO Auto-generated method stub
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream(latexEditorController.getFilename()));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		latexEditorController.setDocumentContents(fileContents);
		
		latexEditorController.enact("atbashDecryption");
		
		fileContents = latexEditorController.getDocumentContents();
		latexEditorController.setType("emptyTemplate");
		System.out.println(fileContents);
		fileContents = fileContents.trim();
		if(fileContents.startsWith("\\documentclass[11pt,twocolumn,a4paper]{article}")) {
			latexEditorController.setType("articleTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{book}")) {
			latexEditorController.setType("bookTemplate");
		}
		else if(fileContents.startsWith("\\documentclass[11pt,a4paper]{report}")) {
			latexEditorController.setType("reportTemplate");
		}
		else if(fileContents.startsWith("\\documentclass{letter}")) {
			latexEditorController.setType("letterTemplate");
		}
	}


}
