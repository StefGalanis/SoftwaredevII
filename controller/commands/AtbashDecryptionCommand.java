package controller.commands;

import controller.LatexEditorController;

public class AtbashDecryptionCommand extends Command {
	
	private String upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String reverseUpperCaseAlphabet = "";
	private String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
	private String reverseLowerCaseAlphabet = "";

	public AtbashDecryptionCommand(LatexEditorController latexEditorController) { // extra argument as VersionManager .. EncryptionManager
		super(latexEditorController);
		computeReverseAlphabet();
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
                for (int j = 0; j < upperCaseAlphabet.length(); j++) {
                    if (character == upperCaseAlphabet.charAt(j)){
                    	dencryptedText += reverseUpperCaseAlphabet.charAt(j);
                    	break;
                    }
                } 
                for (int j = 0; j < lowerCaseAlphabet.length(); j++) {
                    if (character == lowerCaseAlphabet.charAt(j)){
                    	dencryptedText += reverseLowerCaseAlphabet.charAt(j);
                    	break;
                    }
                }
            } 
        }
        latexEditorController.setDocumentContents(dencryptedText);
	}
	
	private void computeReverseAlphabet() {
		for (int i = upperCaseAlphabet.length()-1; i > -1; i--) {
            reverseUpperCaseAlphabet += upperCaseAlphabet.charAt(i);
        }
        for (int i = lowerCaseAlphabet.length()-1; i > -1; i--) {
            reverseLowerCaseAlphabet += lowerCaseAlphabet.charAt(i);
        }
	}
}
