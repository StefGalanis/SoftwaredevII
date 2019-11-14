package controller.commands;

import model.VersionsManager;

public class EditCommand extends Command {
	
	
	public EditCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveContents();
	}

}
