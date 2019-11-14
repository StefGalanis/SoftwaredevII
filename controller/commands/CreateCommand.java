package controller.commands;

import model.Document;
import model.DocumentManager;
import model.VersionsManager;

public class CreateCommand extends Command {
	
	public CreateCommand(DocumentManager documentManager, VersionsManager versionsManager) {
		super(documentManager,versionsManager);
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		String type = versionsManager.getType();
		Document document = documentManager.createDocument(type);
		versionsManager.setCurrentVersion(document);
	}

}
