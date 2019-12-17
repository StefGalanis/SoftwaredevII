package controller.commands;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class Command {
	protected VersionsManager versionsManager;
	protected DocumentManager documentManager;
	protected LatexEditorView latexEditorView;
	
	public Command(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	public Command(LatexEditorView latexEditorView) {
		this.latexEditorView = latexEditorView;
	}
	
	public Command(DocumentManager documentManager,VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		this.documentManager = documentManager;
	}
	
	public Command(DocumentManager documentManager,LatexEditorView latexEditorView,VersionsManager versionsManager) {
		this.latexEditorView = latexEditorView;
		this.documentManager = documentManager;
		this.versionsManager = versionsManager;
	}
	
	public void execute() {
		
	};
}
