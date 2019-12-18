package controller.commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;
import view.LatexEditorView;

class SaveCommandTest {
	private LatexEditorView latexEditorView = new LatexEditorView();//possible remove
	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null, latexEditorView);
	private LatexEditorController latexEditorController = new LatexEditorController(versionsManager,latexEditorView);
	private CreateCommand createCommand = new CreateCommand(documentManager, latexEditorController, versionsManager);
	private SaveCommand saveCommand = new SaveCommand(latexEditorController);

	@Test
	void test() {
		latexEditorController.setType("articleTemplate");
		createCommand.execute();
		latexEditorController.setFilename("test.tex");
		saveCommand.execute();
		
		String fileContents = "";
		try {
			Scanner scanner = new Scanner(new FileInputStream("test.tex"));
			while(scanner.hasNextLine()) {
				fileContents = fileContents + scanner.nextLine() + "\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualContents = latexEditorController.getCurrentDocument().getContents();
		
		assertEquals(fileContents, actualContents);
	}

}
