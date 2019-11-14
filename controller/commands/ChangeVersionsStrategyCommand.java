package controller.commands;

import model.VersionsManager;

public class ChangeVersionsStrategyCommand extends Command {
	
	public ChangeVersionsStrategyCommand(VersionsManager versionsManager) {
		super(versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		versionsManager.changeStrategy();
	}

}
