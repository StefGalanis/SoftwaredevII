package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateDocumentCommand extends Command {
	
	String type;
	Document document;
	
	public CreateDocumentCommand(DocumentManager documentManager, LatexEditorController latexEditorController,VersionsManager versionsManager) {
		super(documentManager,latexEditorController,versionsManager);
	}

	@Override
	public void execute() {
		createDocument();
	}
	
	private void createDocument() {
		type = latexEditorController.getType();
		document = documentManager.createDocument(type);
		latexEditorController.setCurrentDocument(document);
	}

}
