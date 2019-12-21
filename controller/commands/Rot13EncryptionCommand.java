package controller.commands;

import controller.LatexEditorController;

public class Rot13EncryptionCommand extends Command {
	String contentToEncrypt;
	String encryptedContent;

	public Rot13EncryptionCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
		
	}

	public void execute() {
		encrypt();
	}
	
	private void encrypt() {
		
		contentToEncrypt = latexEditorController.getDocumentContents();
		encryptedContent = "";
		for (int i = 0; i < contentToEncrypt.length(); i++) {
            char c = contentToEncrypt.charAt(i);
            if       (c >= 'a' && c <= 'm') {
            	c += 13;
            	encryptedContent += c ;
            }
            else if  (c >= 'A' && c <= 'M') {
            	c += 13;
            	encryptedContent += c ;
            }
            else if  (c >= 'n' && c <= 'z') {
            	c -= 13;
            	encryptedContent += c ;
            }
            else if  (c >= 'N' && c <= 'Z') {
            	c -= 13;
            	encryptedContent += c ;
            }
            else {
				encryptedContent += c ;
			}
        }
		latexEditorController.setDocumentContents(encryptedContent);
		//System.out.print(encryptedContent);
	}
}
