package controller.commands;

import javax.swing.JEditorPane;

import controller.LatexEditorController;

public class AtbashDecryptionCommand extends Command {
	
	private String alpaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String reverseAlpaUpper = "";
	private String alpaLower = "abcdefghijklmnopqrstuvwxyz";
	private String reverseAlpaLower = "";

	public AtbashDecryptionCommand(LatexEditorController latexEditorController) { // extra argument as VersionManager .. EncryptionManager
		super(latexEditorController);
		computeReverseAlphabet();
		// TODO Auto-generated constructor stub
	}
	
	public void execute() {
		decrypt();
	}

	public void decrypt() {
		//should be something like versionManager and versionStrategies this function doesnt belong here
		String contents = latexEditorController.getDocumentContents();
		
        char [] contentsToArrayOfChar = new char[contents.length()];
        contentsToArrayOfChar = contents.toCharArray();
        
        String dencryptedText = "";
        for ( char character : contentsToArrayOfChar) {
            if(character < (char)65 || character > (char)122 ||
            		(character < (char)97 && character > (char)90)){
            	dencryptedText += character;
            } else {
                for (int j = 0; j < alpaUpper.length(); j++) {
                    if (character == alpaUpper.charAt(j)){
                    	dencryptedText += reverseAlpaUpper.charAt(j);
                    	break;
                    }
                } 
                for (int j = 0; j < alpaLower.length(); j++) {
                    if (character == alpaLower.charAt(j)){
                    	dencryptedText += reverseAlpaLower.charAt(j);
                    	break;
                    }
                }
            } 
        }
        System.out.println(dencryptedText);
        latexEditorController.setDocumentContents(dencryptedText);
	}
	
	private void computeReverseAlphabet() {
		for (int i = alpaUpper.length()-1; i > -1; i--) {
            reverseAlpaUpper += alpaUpper.charAt(i);
        }
        for (int i = alpaLower.length()-1; i > -1; i--) {
            reverseAlpaLower += alpaLower.charAt(i);
        }
	}
}
