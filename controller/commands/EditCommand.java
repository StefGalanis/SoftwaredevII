package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class EditCommand extends Command {
	//private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private LatexEditorController latexEditorController;
	
	public EditCommand(VersionsManager versionsManager,LatexEditorController latexEditorController) {
		super(versionsManager);
		this.versionsManager = versionsManager;
		this.latexEditorController = latexEditorController;
		this.currentDocument = latexEditorController.getCurrentDocument();
		this.latexEditorView = versionsManager.getLatexEditorView();
	}


	public Document getCurrentDocument() {
		return currentDocument;
	}
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}

	@Override
	public void execute() {
		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		currentDocument.setContents(latexEditorView.getText());
	}
}
