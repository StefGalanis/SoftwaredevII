package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

class EnableVersionsManagementCommandTest {

	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController(versionsManager);
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController , versionsManager);
	private Document currentDocument = new Document();
	private EditCommand editCommand = new EditCommand(latexEditorController,currentDocument );
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);

	@Test
	void testVolatile() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		createCommand.execute();
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		latexEditorController.setStrategy("volatile");
		enableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		String contents = strategy.getVersion().getContents();
		
		assertEquals(contents, actualContents);
	}
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		createCommand.execute();
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		latexEditorController.setStrategy("stable");
		enableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		
		String contents = strategy.getVersion().getContents();
		
		assertEquals(contents, actualContents);
	}
}
