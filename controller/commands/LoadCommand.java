package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand extends Command {
	//private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	
	public LoadCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
		this.latexEditorView = versionsManager.getLatexEditorView();
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		latexEditorView.loadFromFile();
	}

}
