package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CreateCommand extends Command {
	
	public CreateCommand(DocumentManager documentManager, LatexEditorView latexEditorView,VersionsManager versionsManager) {
		super(documentManager,latexEditorView,versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = latexEditorView.getType();
		Document document = documentManager.createDocument(type);
		latexEditorView.setCurrentDocument(document);
		latexEditorView.setVersionsManager(versionsManager);
		//versionsManager.setCurrentVersion(document); // possible remove of this line
	}

}
