package controller.commands;

import java.util.HashMap;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorController latexEditorController;
	private LatexEditorView latexEditorView;//possible remove
	private Document currentDocument;//possible remove
	
	
	public CommandFactory(VersionsManager versionsManager,LatexEditorController latexEditorController,
			Document currentDocument) {
		super();
		this.versionsManager = versionsManager;
		this.latexEditorController = latexEditorController;
		this.latexEditorView = latexEditorView;//possible remove
		this.currentDocument = currentDocument;//possible remove
		documentManager = new DocumentManager();
	}


	public Command createCommand(String type) {
		if(type.equals("addLatex")) {
			return new AddLatexCommand(latexEditorView);
		}
		if(type.equals("changeVersionsStrategy")) {
			return new ChangeVersionsStrategyCommand(versionsManager);
		}
		if(type.equals("create")) {
			return new CreateCommand(documentManager,latexEditorController,versionsManager);
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("edit")) {
			return new EditCommand(latexEditorController,currentDocument);
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("load")) {
			return new LoadCommand(latexEditorController);
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand(versionsManager,latexEditorController);
		}
		if(type.equals("save")) {
			return new SaveCommand(latexEditorController);
		}
		return null;
	}
}
