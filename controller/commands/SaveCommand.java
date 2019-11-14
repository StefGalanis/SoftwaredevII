package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class SaveCommand extends Command {
	//private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private LatexEditorController latexEditorController;
	
	public SaveCommand(VersionsManager versionsManager, LatexEditorController latexEditorController) {
		// TODO Auto-generated constructor stub
		//this.versionsManager = versionsManager;
		super(versionsManager);
		this.latexEditorController = latexEditorController;
		this.currentDocument = latexEditorController.getCurrentDocument();
		this.latexEditorView = versionsManager.getLatexEditorView();
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
			currentDocument = latexEditorController.getCurrentDocument();
			System.out.println(latexEditorView.getText());
			currentDocument.setContents(latexEditorView.getText());
			currentDocument.save(latexEditorView.getFilename());
	}

}
