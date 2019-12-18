package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class Command {
	protected VersionsManager versionsManager;
	protected DocumentManager documentManager;
	protected LatexEditorView latexEditorView;
	protected Document currentDocument;//possible remove
	protected LatexEditorController latexEditorController;
	
	public Command(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	public Command(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
	}//possible remove of this super constructor
	
	public Command(LatexEditorController latexEditorController) {
		this.latexEditorController = latexEditorController;
	}
	
	public Command(DocumentManager documentManager,VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		this.documentManager = documentManager;
	}
	
	public Command(DocumentManager documentManager,LatexEditorController latexEditorController,VersionsManager versionsManager) {
		this.latexEditorController = latexEditorController;
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
	}
	
	public Command(LatexEditorController latexEditorController, Document currentDocument) {
		// TODO Auto-generated constructor stub
		this.latexEditorController = latexEditorController;
		this.currentDocument = currentDocument;
	}

	public Command(VersionsManager versionsManager, LatexEditorController latexEditorController) {
		// TODO Auto-generated constructor stub
		this.latexEditorController = latexEditorController;
		this.versionsManager = versionsManager;
	}

	public void execute() {
		
	};
}
