package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.Document;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class EditCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private LatexEditorController latexEditorController = new LatexEditorController(versionsManager,latexEditorView);
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController,versionsManager);
	//private Document currentDocument = new Document();
	private EditCommand editCommand = new EditCommand(latexEditorController,latexEditorController.getCurrentDocument() );

	@Test
	void test() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		//System.out.println(latexEditorView.getText());
		latexEditorController.setText("test edit contents\n");
		System.out.println(latexEditorController.getText());
		editCommand.execute();
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		//System.out.println(actualContents);
		assertEquals("test edit contents\n", actualContents);
	}

}
