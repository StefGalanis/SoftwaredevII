package controller.commands;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;

public class Rot13DecryptionCommand extends Command {

	private String contentToDecrypt;
	private String decryptedContent;

	public Rot13DecryptionCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
	}

	public void execute() {
		decrypt();
	}

	private void decrypt() {
		contentToDecrypt = latexEditorController.getDocumentContents();
		decryptedContent = "";
		for (int i = 0; i < contentToDecrypt.length(); i++) {
            char c = contentToDecrypt.charAt(i);
            if       (c >= 'a' && c <= 'm') {
            	c += 13;
            	decryptedContent += c ;
            }
            else if  (c >= 'A' && c <= 'M') {
            	c += 13;
            	decryptedContent += c ;
            }
            else if  (c >= 'n' && c <= 'z') {
            	c -= 13;
            	decryptedContent += c ;
            }
            else if  (c >= 'N' && c <= 'Z') {
            	c -= 13;
            	decryptedContent += c ;
            }
            else {
            	decryptedContent += c ;
			}
        }
		System.out.println(decryptedContent);
		latexEditorController.setDocumentContents(decryptedContent);
	}
	
}
