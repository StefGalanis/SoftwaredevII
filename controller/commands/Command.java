package controller.commands;

import model.DocumentManager;
import model.VersionsManager;

public class Command {
	protected VersionsManager versionsManager;
	protected DocumentManager documentManager;
	public Command(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	
	public Command(DocumentManager documentManager,VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
		this.documentManager = documentManager;
	}
	
	public void execute() {
		
	};
}
