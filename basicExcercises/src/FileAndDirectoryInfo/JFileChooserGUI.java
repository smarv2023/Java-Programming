package FileAndDirectoryInfo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JFileChooserGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JTextArea outputArea;
	
	// set up GUI
	public JFileChooserGUI() throws IOException {
		super("JFileChooser Demo");
		outputArea = new JTextArea();
		add(new JScrollPane(outputArea));
		analyzePath();
	}
	
	public void analyzePath() throws IOException {
		Path path = getFileOrDirectoryPath();
		
		if (path != null && Files.exists(path)) {
			StringBuilder builder = new StringBuilder();
			builder.append(String.format("%s:%n", path.getFileName()));
			builder.append(String.format("%s a direactory%n", Files.isDirectory(path) ? "Is" : "Is not"));
			builder.append(String.format("Last modified: %s%n", Files.getLastModifiedTime(path)));
			builder.append(String.format("Size: %s%n", Files.size(path)));
			builder.append(String.format("Absolute path: %s%n", path.toAbsolutePath()));
			
			if (Files.isDirectory(path)) {
				builder.append(String.format("%nDirectory contents:%n"));
				
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
				
				for (Path p : directoryStream)
					builder.append(String.format("%s%n", p));
			}
			
			outputArea.setText(builder.toString());
		} else {
			JOptionPane.showMessageDialog(this, path.getFileName() + " does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	// open window
	private Path getFileOrDirectoryPath() {
		//configure dialog allowing section of a file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		
		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		return fileChooser.getSelectedFile().toPath();	
	}
}
