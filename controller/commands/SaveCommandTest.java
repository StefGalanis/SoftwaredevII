package controller.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import controller.LatexEditorController;
import model.DocumentManager;
import model.VersionsManager;

class SaveCommandTest {

	private DocumentManager documentManager = new DocumentManager();
	private VersionsManager versionsManager = new VersionsManager(null);
	private LatexEditorController latexEditorController = new LatexEditorController();
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
