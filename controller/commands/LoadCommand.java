package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class LoadCommand extends Command {
	
	public LoadCommand(LatexEditorView latexEditorView) {
		super(latexEditorView);	
	}

	public VersionsManager getVersionsManager() {
		return versionsManager;
	}//possible remove of method

	public void setVersionsManager(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}//possible remove of method

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		latexEditorView.loadFromFile();
	}

}
