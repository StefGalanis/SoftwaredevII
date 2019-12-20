package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

class DisableVersionsManagementCommandTest {

	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateDocumentCommand createCommand = new CreateDocumentCommand(documentManager, latexEditorController , versionsManager);
	private EditCommand editCommand = new EditCommand(latexEditorController);
	private DisableVersionsManagementCommand disableCommand = new DisableVersionsManagementCommand(versionsManager);

	@Test
	void testVolatile() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		createCommand.execute();
		latexEditorController.setStrategy("volatile");
		disableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		assertEquals(versionsManager.isEnabled(), false);
		assertEquals(strategy.getEntireHistory().size(), 0);
	}
}
