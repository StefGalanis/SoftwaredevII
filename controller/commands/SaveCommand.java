package controller.commands;

import model.VersionsManager;

public class SaveCommand extends Command {
	
	public SaveCommand(VersionsManager versionsManager) {
		// TODO Auto-generated constructor stub
		super(versionsManager);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.saveToFile();
	}

}
