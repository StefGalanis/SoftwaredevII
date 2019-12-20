package view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import controller.LatexEditorController;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBoxMenuItem;

public class MainWindow {

	private JFrame frame;
	private JEditorPane editorPane = new JEditorPane();
	private LatexEditorController latexEditorController;
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param latexEditorView 
	 */
	public MainWindow(LatexEditorController latexEditorController) {
		this.latexEditorController = latexEditorController;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 823, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 805, 26);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewFile = new JMenuItem("New file");
		mntmNewFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChooseTemplate chooseTemplate = new ChooseTemplate(latexEditorController, "main");
				frame.dispose();
			}
		});
		mnFile.add(mntmNewFile);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorController.setText(editorPane.getText());
				latexEditorController.enact("edit");
			}
		});
		mnFile.add(mntmSave);
		JMenuItem addChapter = new JMenuItem("Add chapter");
		JMenu mnCommands = new JMenu("Commands");
		JMenuItem mntmLoadFile = new JMenuItem("Load file");
		mntmLoadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					
					latexEditorController.setFilename(filename);//fix
					latexEditorController.enact("load");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					if(latexEditorController.getType().equals("letterTemplate")) {
						mnCommands.setEnabled(false);
					}
					if(latexEditorController.getType().equals("articleTemplate")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(latexEditorController.getDocumentContents());
				}
			}
		});
		mnFile.add(mntmLoadFile);
		
		JMenuItem loadEncryptedFile = new JMenuItem("Load Encrypted File");
		mnFile.add(loadEncryptedFile);
		
		loadEncryptedFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showOpenDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					
					latexEditorController.setFilename(filename);//fix
					latexEditorController.enact("loadEncryptedFile");
					mnCommands.setEnabled(true);
					addChapter.setEnabled(true);
					if(latexEditorController.getType().equals("letterTemplate")) {
						mnCommands.setEnabled(false);
					}
					if(latexEditorController.getType().equals("articleTemplate")) {
						addChapter.setEnabled(false);
					}
					editorPane.setText(latexEditorController.getDocumentContents());
				}
			}
		});
		
		JMenuItem mntmSaveFile = new JMenuItem("Save As...");
		mntmSaveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser filechooser = new JFileChooser();
				int option = filechooser.showSaveDialog(null);
				if(option == JFileChooser.APPROVE_OPTION) {
					String filename = filechooser.getSelectedFile().toString();
					if(filename.endsWith(".tex") == false) {
						filename = filename+".tex";
					}
					latexEditorController.setFilename(filename);//fix
					latexEditorController.enact("save");
				}
				
			}
		});
		mnFile.add(mntmSaveFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);
		
		
		menuBar.add(mnCommands);
		if(latexEditorController.getType().equals("letterTemplate")) {
			mnCommands.setEnabled(false);
		}
		
		addChapter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setCommandExecutionData("chapter");
				latexEditorController.enact("addLatex");
			}
		});
		mnCommands.add(addChapter);
		if(latexEditorController.getType().equals("articleTemplate")) {
			addChapter.setEnabled(false);
		}
		
		JMenu addSection = new JMenu("Add Section");
		mnCommands.add(addSection);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		mntmAddSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("section");
				latexEditorController.enact("addLatex");
			}
		});
		addSection.add(mntmAddSection);
		
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		mntmAddSubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("subsection");
				latexEditorController.enact("addLatex");
			}
		});
		addSection.add(mntmAddSubsection);
		
		JMenuItem mntmAddSubsubsection = new JMenuItem("Add subsubsection");
		mntmAddSubsubsection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("subsubsection");
				latexEditorController.enact("addLatex");
			}
		});
		addSection.add(mntmAddSubsubsection);
		
		JMenu addEnumerationList = new JMenu("Add enumeration list");
		mnCommands.add(addEnumerationList);
		
		JMenuItem mntmItemize = new JMenuItem("Itemize");
		mntmItemize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("itemize");
				latexEditorController.enact("addLatex");
			}
		});
		addEnumerationList.add(mntmItemize);
		
		JMenuItem mntmEnumerate = new JMenuItem("Enumerate");
		mntmEnumerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("enumerate");
				latexEditorController.enact("addLatex");
			}
		});
		addEnumerationList.add(mntmEnumerate);
		
		JMenuItem addTable = new JMenuItem("Add table");
		addTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("table");
				latexEditorController.enact("addLatex");
			}
		});
		mnCommands.add(addTable);
		
		JMenuItem addFigure = new JMenuItem("Add figure");
		addFigure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCommandExecutionData("figure");
				latexEditorController.enact("addLatex");
			}
		});
		mnCommands.add(addFigure);
		
		JMenu mnStrategy = new JMenu("Strategy");
		menuBar.add(mnStrategy);
		
		JMenu mnEnable = new JMenu("Enable");
		mnStrategy.add(mnEnable);
		
		JCheckBoxMenuItem menuVolatile = new JCheckBoxMenuItem("Volatile");
		JCheckBoxMenuItem menuStable = new JCheckBoxMenuItem("Stable");
		menuStable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorController.setStrategy("stable");
				if(latexEditorController.isVersionsManagerEnabled() == false) {
					latexEditorController.enact("enableVersionsManagement");
				}
				else {
					latexEditorController.enact("changeVersionsStrategy");
				}
				menuVolatile.setSelected(false);
				menuStable.setEnabled(false);
				menuVolatile.setEnabled(true);
			}
		});

		menuVolatile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				latexEditorController.setStrategy("volatile");
				if(latexEditorController.isVersionsManagerEnabled() == false) {
					latexEditorController.enact("enableVersionsManagement");
				}
				else {
					latexEditorController.enact("changeVersionsStrategy");
				}
				menuStable.setSelected(false);
				menuVolatile.setEnabled(false);
				menuStable.setEnabled(true);
			}
		});
		mnEnable.add(menuVolatile);
		
		mnEnable.add(menuStable);
		
		JMenuItem mntmDisable = new JMenuItem("Disable");
		mntmDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				latexEditorController.enact("disableVersionsManagement");
				latexEditorController.getEditorPane();
			}
		});
		mnStrategy.add(mntmDisable);
		
		JMenuItem mntmRollback = new JMenuItem("Rollback");
		mntmRollback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorController.enact("rollbackToPreviousVersion");
				editorPane.setText(latexEditorController.getDocumentContents());
			}
		});
		mnStrategy.add(mntmRollback);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 783, 467);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		editorPane.setText(latexEditorController.getDocumentContents());
		
		JMenu mnEncryption = new JMenu("Encryption");
		menuBar.add(mnEncryption);
		
		JMenuItem atbashEncryption = new JMenuItem("Atbash");
		mnEncryption.add(atbashEncryption);
		
		JMenuItem rot13Encryption = new JMenuItem("Rot-13");
		mnEncryption.add(rot13Encryption);
		
		atbashEncryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorController.enact("atbashEncryption");
			}
		});

		rot13Encryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorController.enact("rot13Encryption");
			}
		});
		
		JMenu mnDecryption = new JMenu("Decryption");
		menuBar.add(mnDecryption);
		
		JMenuItem atbashDecryption = new JMenuItem("Atbash");
		mnDecryption.add(atbashDecryption);
		
		atbashDecryption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				latexEditorController.enact("atbashDecryption");
			}
		});
		
		
		
	}
	
	public void setCommandExecutionData(String addLatexCommandType) {
		latexEditorController.setAddLatexCommandType(addLatexCommandType);
		latexEditorController.setEditorPane(this.editorPane);
	}
}
