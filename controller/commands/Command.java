package controller.commands;

import model.Document;
import model.VersionsManager;

public class Command {
	protected VersionsManager versionsManager;
	protected Document currentDocument;
	public Command(VersionsManager versionsManager) {
		this.versionsManager = versionsManager;
	}
	public Command(VersionsManager versionsManager,Document currentDocument) {
		this.versionsManager = versionsManager;
		this.currentDocument = currentDocument;
	}
	//public void execute();
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
