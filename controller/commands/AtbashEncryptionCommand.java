package controller.commands;

import controller.LatexEditorController;

public class AtbashEncryptionCommand extends Command{
	
	private String alpaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String reverseAlpaUpper = "";
	private String alpaLower = "abcdefghijklmnopqrstuvwxyz";
	private String reverseAlpaLower = "";

	public AtbashEncryptionCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
		computeReverseAlphabet();
	}
	
	public void execute() {
		encrypt();
	}
	
	public void encrypt() {
		String contents = latexEditorController.getDocumentContents();

        String encryptedText = "";
        
        char [] contentsToArrayOfChar = new char[contents.length()];
        contentsToArrayOfChar = contents.toCharArray();
        
        for ( char character : contentsToArrayOfChar) {
            if(character < (char)65 || character > (char)122 ||
            		(character < (char)97 && character > (char)90)){
            	encryptedText += character;
            } else {
                for (int j = 0; j < alpaUpper.length(); j++) {
                    if (character == alpaUpper.charAt(j)){
                    	encryptedText += reverseAlpaUpper.charAt(j);
                    	break;
                    }
                } 
                for (int j = 0; j < alpaLower.length(); j++) {
                    if (character == alpaLower.charAt(j)){
                    	encryptedText += reverseAlpaLower.charAt(j);
                    	break;
                    }
                }
            } 
        } 
        
        latexEditorController.setDocumentContents(encryptedText);
        System.out.println("Encrypted Text: " + encryptedText);
       /*
        contentsToArrayOfChar = new char[encryptedText.length()];
        contentsToArrayOfChar = encryptedText.toCharArray();
        
        String dencryText = "";
        for ( char character : contentsToArrayOfChar) {
            if(character < (char)65){
                dencryText += character;
            } else {
                int count = 0;
                for (int j = 0; j < reverseAlpa.length(); j++) {
                    if (encryText.charAt(i) == reverseAlpa.charAt(j)){
                        dencryText += alpa.charAt(j);
                        break;
                    }
                } // inner for
            } // if-else
        } // for
        

        System.out.println("Decrypted Text: " + dencryText);
       */ 
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
