package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorController latexEditorController;
	
	
	public CommandFactory(VersionsManager versionsManager,LatexEditorController latexEditorController,
			Document currentDocument) {
		super();
		this.versionsManager = versionsManager;
		this.latexEditorController = latexEditorController;
		documentManager = new DocumentManager();
	}


	public Command createCommand(String type) {
		if(type.equals("addLatex")) {
			return new AddLatexCommand(latexEditorController);
		}
		if(type.equals("changeVersionsStrategy")) {
			return new ChangeVersionsStrategyCommand(versionsManager);
		}
		if(type.equals("create")) {
			return new CreateDocumentCommand(documentManager,latexEditorController,versionsManager);
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("edit")) {
			return new EditCommand(latexEditorController);
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("load")) {
			return new LoadCommand(latexEditorController);
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand(versionsManager,latexEditorController);
		}
		if(type.equals("save")) {
			return new SaveCommand(latexEditorController);
		}
		if(type.equals("atbashEncryption")) {
			return new AtbashEncryptionCommand(latexEditorController);
		}
		if(type.equals("atbashDecryption")) {
			return new AtbashDecryptionCommand(latexEditorController);
		}
		if(type.equals("rot13Encryption")) {
			return new Rot13EncryptionCommand(latexEditorController);
		}
		if(type.equals("rot13Decryption")) {
			return new Rot13DecryptionCommand(latexEditorController);
		}
		if(type.equals("loadEncryptedFile")) {
			return new LoadEncryptedFileCommand(latexEditorController);
		}
		return null;
	}
}
