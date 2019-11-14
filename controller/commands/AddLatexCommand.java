package controller.commands;

import model.VersionsManager;

public class AddLatexCommand extends Command  {
	
	
	public AddLatexCommand(VersionsManager versionsManager) {
		super(versionsManager);	
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveContents();
	}

}
