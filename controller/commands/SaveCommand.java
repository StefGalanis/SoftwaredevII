package controller.commands;

import controller.LatexEditorController;

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
