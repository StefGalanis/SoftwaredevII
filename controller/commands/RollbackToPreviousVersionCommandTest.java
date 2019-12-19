package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;

class RollbackToPreviousVersionCommandTest {

	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController(versionsManager);
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController,versionsManager);
	private EditCommand editCommand = new EditCommand(latexEditorController,latexEditorController.getCurrentDocument() );
	private EnableVersionsManagementCommand enableCommand = new EnableVersionsManagementCommand(versionsManager);
	private RollbackToPreviousVersionCommand rollback = new RollbackToPreviousVersionCommand(versionsManager,latexEditorController);
	
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		createCommand.execute();
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		latexEditorController.setStrategy("stable");
		System.out.println(versionsManager.getStrategyType());
		enableCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		System.out.println(latexEditorController.getCurrentDocument().getContents());
		rollback.execute();
		String contents = latexEditorController.getCurrentDocument().getContents();
		
		assertEquals(contents, actualContents);
	}
}
