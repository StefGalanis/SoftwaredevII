package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;

class EditCommandTest {

	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController();
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController,versionsManager);
	private EditCommand editCommand = new EditCommand(latexEditorController);

	@Test
	void test() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		latexEditorController.setText("test edit contents\n");
		editCommand.execute();
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		assertEquals("test edit contents\n", actualContents);
	}

}
