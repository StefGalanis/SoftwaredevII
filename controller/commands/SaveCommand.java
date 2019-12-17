package controller.commands;

import model.VersionsManager;//possible remove of import
import view.LatexEditorView;

public class SaveCommand extends Command {
	
	public SaveCommand(LatexEditorView latexEditorView) {
		// TODO Auto-generated constructor stub
		super(latexEditorView);
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		latexEditorView.saveToFile();
	}

}
