package controller.commands;

import controller.LatexEditorController;
import model.Document;
import model.VersionsManager;//possible remove of import
import view.LatexEditorView;

public class SaveCommand extends Command {
	
	public SaveCommand(LatexEditorController latexEditorController) {
		// TODO Auto-generated constructor stub
		super(latexEditorController);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		saveToFile();
	}
	public void saveToFile() {
		// TODO Auto-generated method stub
		latexEditorController.getCurrentDocument().save(latexEditorController.getFilename());
	}

}
