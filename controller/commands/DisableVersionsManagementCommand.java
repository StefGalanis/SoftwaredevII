package controller.commands;

import model.VersionsManager;

public class DisableVersionsManagementCommand extends Command {

	//private VersionsManager versionsManager;
	
	public DisableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
		this.versionsManager = versionsManager;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.disable();
	}

}
