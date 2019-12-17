package controller.commands;

import model.VersionsManager;//possible remove import
import view.LatexEditorView;

public class EditCommand extends Command {
	
	
	public EditCommand(LatexEditorView latexEditorView) {
		super(latexEditorView);
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//System.out.println(latexEditorView.getText());
		latexEditorView.saveContents();
		System.out.println(latexEditorView.getCurrentDocument().getContents());
	}

}
