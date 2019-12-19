package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class Command {
	protected VersionsManager versionsManager;
	protected DocumentManager documentManager;
	protected LatexEditorController latexEditorController;
	
	public Command(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	public Command(LatexEditorController latexEditorController) {
		this.latexEditorController = latexEditorController;
	}
	
	public Command(DocumentManager documentManager,LatexEditorController latexEditorController,VersionsManager versionsManager) {
		this.latexEditorController = latexEditorController;
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
	}

	public Command(VersionsManager versionsManager, LatexEditorController latexEditorController) {
		// TODO Auto-generated constructor stub
		this.latexEditorController = latexEditorController;
		this.versionsManager = versionsManager;
	}

	public void execute() {
		
	};
}
