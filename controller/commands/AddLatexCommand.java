package controller.commands;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import model.Document;
import model.VersionsManager;
import view.LatexEditorView;

public class AddLatexCommand implements Command  {
	private VersionsManager versionsManager;
	private LatexEditorView latexEditorView;
	private Document currentDocument;
	private HashMap<String,String> latexCommands;
	
	
	public AddLatexCommand(VersionsManager versionsManager) {
		super();
		this.versionsManager = versionsManager;
		this.latexEditorView = versionsManager.getLatexEditorView();
		latexCommands = new HashMap<String, String>();
		
		File[] templateFiles = new File("/home/steve/Documents/LatexCommands").listFiles();
		try {
			for(File file : templateFiles) {
				 if (file.isFile()) {
					 String commandName = removeFileExtension(file.getName());
					 
					 FileInputStream fileInputStream = new FileInputStream(file);
					 byte[] data = new byte[(int) file.length()];
					 fileInputStream.read(data);
					 fileInputStream.close();
					 
					 String commandText = new String(data, "UTF-8");
					 
					 latexCommands.put(commandName ,commandText);
				 }
			}
			for(String command : latexCommands.keySet()) {
				System.out.println(latexCommands.get(command)+ "\n");
			}
		}
		catch(Exception e) {
			System.err.format("Exception occurred trying to read .");
		    e.printStackTrace();
		}
	}
	
	private String removeFileExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}
	
	public Document getCurrentDocument() {
		return currentDocument;
	}
	public void setCurrentDocument(Document currentDocument) {
		this.currentDocument = currentDocument;
	}

	@Override
	public void execute() {
		if(versionsManager.isEnabled()) {
			versionsManager.putVersion(currentDocument);
			currentDocument.changeVersion();
		}
		
		currentDocument.setContents(latexEditorView.getText());
		
	}
	
	
}
