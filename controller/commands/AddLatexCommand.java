package controller.commands;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.swing.JEditorPane;

import controller.LatexEditorController;

public class AddLatexCommand extends Command  {
	
	private HashMap<String, String> latexCommands;
	
	public AddLatexCommand(LatexEditorController latexEditorController) {
		super(latexEditorController);
		
		latexCommands = new HashMap<String, String>();
		
		File[] latexCommandFiles = new File("LatexCommands").listFiles();
		try {
			for(File file : latexCommandFiles) {
				 if (file.isFile()) {
					 String latexCommandName = removeFileExtension(file.getName());
					 
					 FileInputStream fileInputStream = new FileInputStream(file);
					 byte[] data = new byte[(int) file.length()];
					 fileInputStream.read(data);
					 fileInputStream.close();
					 
					 String contents = new String(data, "UTF-8");
					 
					 latexCommands.put(latexCommandName ,contents);
				 }
			}
		}
		catch(Exception e) {
			System.err.format("Exception occurred trying to read .");
		    e.printStackTrace();
		}
	}


	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editContents();
		latexEditorController.enact("edit");
	}
	
	public void editContents() {
		JEditorPane editorPane = latexEditorController.getEditorPane();
		String type = latexEditorController.getAddLatexCommandType();
		String contents = editorPane.getText();
		String before = contents.substring(0, editorPane.getCaretPosition());
		String after = contents.substring(editorPane.getCaretPosition());

		contents = before + latexCommands.get(type) +after;
		
		latexEditorController.setText(contents);
		
		editorPane.setText(contents);
		latexEditorController.setEditorPane(editorPane);
	}
	
	private String removeFileExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

}
