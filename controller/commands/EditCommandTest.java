package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class EditCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorView,versionsManager);
	private EditCommand editCommand = new EditCommand(latexEditorView);

	@Test
	void test() {
		latexEditorView.setType("articleTemplate");
		createCommand.execute();
		//System.out.println(latexEditorView.getText());
		latexEditorView.setText("test edit contents\n");
		//System.out.println(latexEditorView.getText());
		editCommand.execute();
		String actualContents = latexEditorView.getCurrentDocument().getContents();
		//System.out.println(actualContents);
		assertEquals("test edit contents\n", actualContents);
	}

}
