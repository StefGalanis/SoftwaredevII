package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;

public class RollbackToPreviousVersionCommand extends Command {
	
	
	public RollbackToPreviousVersionCommand(VersionsManager versionsManager,LatexEditorController latexEditorController) {
		super(versionsManager,latexEditorController);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		Document doc = versionsManager.rollback();
		System.out.print(doc.getContents());
		latexEditorController.setCurrentDocument(doc);
		
	}

}
