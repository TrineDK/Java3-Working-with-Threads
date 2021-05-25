package countWords;

/**
 * This Class is the interface for CountWords.
 */

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class CountWordsInterface extends JFrame {

	JFrame frame = new JFrame();
	JButton getFileButton = new JButton("Click here to upload a file");
	JButton countWordsButton = new JButton("Click here to count words");
	JPanel mainPanel = new JPanel();
	JFileChooser fileChooser = new JFileChooser();



	public CountWordsInterface() {


			this.add(mainPanel);
			this.setTitle("Count Words");
			this.setLayout(new GridLayout(2, 0));
			this.setSize(200, 200);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);


			mainPanel.add(getFileButton);
			mainPanel.add(countWordsButton);

		}


		/**
		 * This method adds an action listener to each of the buttons.
		 *
		 * @param listenForButton
		 */
		public void addAnswerListener(ActionListener listenForButton) {

			getFileButton.addActionListener(listenForButton);
			countWordsButton.addActionListener(listenForButton);
		}


		/**
		 * This method gets the file selected by the user
		 *
		 * @return File userFile
		 */
		public File getFile() {

			File userFile = null;

			int returnVal = fileChooser.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {

				userFile = fileChooser.getSelectedFile();

			}
			return userFile;
		}
	}






