package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import model.strategies.StableVersionsStrategy;
import model.strategies.VersionsStrategy;
import model.strategies.VolatileVersionsStrategy;

class ChangeVersionsStrategyCommandTest {
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController(versionsManager);
	private ChangeVersionsStrategyCommand changeCommand = new ChangeVersionsStrategyCommand(versionsManager);
	
	@Test
	void testVolatile() {
		VersionsStrategy strategy = new VolatileVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		latexEditorController.setStrategy("stable");
		changeCommand.execute();
		
		String test = "test ok";
		if(versionsManager.getStrategy() instanceof VolatileVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
	
	@Test
	void testStable() {
		VersionsStrategy strategy = new StableVersionsStrategy();
		versionsManager.setStrategy(strategy);
		
		latexEditorController.setType("articleTemplate");
		latexEditorController.setVersionsManager(versionsManager);
		latexEditorController.setStrategy("volatile");
		changeCommand.execute();
		
		String test = "test ok";
		if(versionsManager.getStrategy() instanceof StableVersionsStrategy)
			test = "not ok";
		
		assertEquals("test ok", test);
	}
		
}
