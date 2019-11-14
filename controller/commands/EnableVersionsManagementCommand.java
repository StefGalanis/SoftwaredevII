package controller.commands;

import model.VersionsManager;

public class EnableVersionsManagementCommand extends Command {
	
	public EnableVersionsManagementCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.enableStrategy();
	}

}
