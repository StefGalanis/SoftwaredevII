package controller.commands;

import java.util.HashMap;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

public class CommandFactory {
	private DocumentManager documentManager;
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	
	
	public CommandFactory(VersionsManager versionsManager,LatexEditorView latexEditorView) {
		super();
		this.versionsManager = versionsManager;
		this.latexEditorView = latexEditorView;
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
			return new CreateCommand(documentManager, latexEditorView,versionsManager);
		}
		if(type.equals("disableVersionsManagement")) {
			return new DisableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("edit")) {
			return new EditCommand(latexEditorView);
		}
		if(type.equals("enableVersionsManagement")) {
			return new EnableVersionsManagementCommand(versionsManager);
		}
		if(type.equals("load")) {
			return new LoadCommand(latexEditorView);
		}
		if(type.equals("rollbackToPreviousVersion")) {
			return new RollbackToPreviousVersionCommand(versionsManager);
		}
		if(type.equals("save")) {
			return new SaveCommand(latexEditorView);
		}
		return null;
	}
}
