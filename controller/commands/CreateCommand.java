package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand extends Command {
	
	public CreateCommand(DocumentManager documentManager, LatexEditorController latexEditorController,VersionsManager versionsManager) {
		super(documentManager,latexEditorController,versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = latexEditorController.getType();
		Document document = documentManager.createDocument(type);
		latexEditorController.setCurrentDocument(document);
		
	}

}
