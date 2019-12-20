package controller.commands;

import controller.LatexEditorController;

public class Rot13EncryptionCommand extends Command {
	String contentToEncrypt;
	String encryptedContent;

	public Rot13EncryptionCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
		
	}

	public void execute() {
		tempname();
	}
	
	private void tempname() {
		
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
		System.out.print(encryptedContent);
	}
}
