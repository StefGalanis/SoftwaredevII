package controller.commands;

import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand extends Command  {
	
	
	public AddLatexCommand(LatexEditorView latexEditorView) {
		super(latexEditorView);	
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		latexEditorView.saveContents();
	}

}
