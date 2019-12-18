package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CreateCommand extends Command {
	
	public CreateCommand(DocumentManager documentManager, LatexEditorController latexEditorController,VersionsManager versionsManager) {
		super(documentManager,latexEditorController,versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = latexEditorController.getType();
		//System.out.println(type);
		//System.exit(1);
		Document document = documentManager.createDocument(type);
		latexEditorController.setCurrentDocument(document);
		//latexEditorController.setCurrentVersion(document);
		//latexEditorController.setVersionsManager(versionsManager);//going to add later
		//versionsManager.setCurrentVersion(document); // possible remove of this line
	}

}
