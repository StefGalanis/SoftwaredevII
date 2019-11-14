package controller.commands;

import model.VersionsManager;

public class LoadCommand extends Command {
	
	public LoadCommand(VersionsManager versionsManager) {
		super(versionsManager);
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
		versionsManager.loadFromFile();
	}

}
