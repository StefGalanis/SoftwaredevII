package controller.commands;

import javax.swing.JEditorPane;

import controller.LatexEditorController;
import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand extends Command  {
	
	
	public AddLatexCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);	
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		//latexEditorController.
		editContents();
		latexEditorController.enact("edit");
	}
	
	public void editContents() {
		JEditorPane editorPane = latexEditorController.getEditorPane();
		String type = latexEditorController.getAddLatexCommandType();
		String contents = editorPane.getText();
		String before = contents.substring(0, editorPane.getCaretPosition());
		String after = contents.substring(editorPane.getCaretPosition());
		
		if(type.equals("chapter")) {
			contents = before + "\n\\chapter{...}"+"\n"+after;
		}
		else if(type.equals("section")) {
			contents = before + "\n\\section{...}"+"\n"+after;
		}
		else if(type.equals("subsection")) {
			contents = before + "\n\\subsection{...}"+"\n"+after;
		}
		else if(type.equals("subsubsection")) {
			contents = before + "\n\\subsubsection{...}"+"\n"+after;
		}
		else if(type.equals("enumerate")) {
			contents = before + 
					"\\begin{enumerate}\n"+
					"\\item ...\n"+
					"\\item ...\n"+
					"\\end{enumerate}\n"+after;
		}
		else if(type.equals("itemize")) {
			contents = before + 
					"\\begin{itemize}\n"+
					"\\item ...\n"+
					"\\item ...\n"+
					"\\end{itemize}\n"+after;
		}
		else if(type.equals("table")) {
			contents = before + 
					"\\begin{table}\n"+
					"\\caption{....}\\label{...}\n"+
					"\\begin{tabular}{|c|c|c|}\n"+
					"\\hline\n"+
					"... &...&...\\\\\n"+
					"... &...&...\\\\\n"+
					"... &...&...\\\\\n"+
					"\\hline\n"+
					"\\end{tabular}\n"+
					"\\end{table}\n"+after;
		}
		else if(type.equals("figure")) {
			contents = before + 
					"\\begin{figure}\n"+
					"\\includegraphics[width=...,height=...]{...}\n"+
					"\\caption{....}\\label{...}\n"+
					"\\end{figure}\n"+after;
;
		}
		latexEditorController.setText(contents);
		//latexEditorController.enact("addLatex");
		editorPane.setText(contents);
		latexEditorController.setEditorPane(editorPane);
	}

}
