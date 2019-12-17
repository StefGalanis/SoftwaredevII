package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class DocumentManager {
	private HashMap<String, Document> templates;
	
	public DocumentManager() {
		templates = new HashMap<String, Document>();
		Document document = new Document();
		
		
		File[] templateFiles = new File("templates").listFiles();
		try {
			for(File file : templateFiles) {
				 if (file.isFile()) {
					 String templateName = removeFileExtension(file.getName());
					 
					 FileInputStream fileInputStream = new FileInputStream(file);
					 byte[] data = new byte[(int) file.length()];
					 fileInputStream.read(data);
					 fileInputStream.close();
					 
					 String contents = new String(data, "UTF-8");
					 document = new Document();
					 document.setContents(contents);
					 
					 templates.put(templateName ,document);
				 }
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
	public Document createDocument(String type) {
		return templates.get(type).clone();
	}
	
}
