package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CreateCommand extends Command {
	private DocumentManager documentManager;
	//private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private LatexEditorController latexEditorController;
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager,
			LatexEditorController latexEditorController) {
		super(versionsManager);
		this.latexEditorController = latexEditorController;
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
		this.latexEditorView = versionsManager.getLatexEditorView();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = latexEditorView.getType();
		Document document = documentManager.createDocument(type);
		latexEditorView.setText(document.getContents());
		System.out.println(latexEditorController);
		latexEditorController.setCurrentDocument(document);
	}

}
