package countWords;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CountWordsController{

	private CountWordsInterface view;
	private CountWordsModel model;
	private static int fileCount = 0;
	List<File> userFiles = new ArrayList<>();




	CountWordsController(CountWordsInterface view, CountWordsModel model) {
		this.view = view;
		this.model = model;


		this.view.addAnswerListener(new AnswerListener());
	}


	public static int getFileCount() {
		return fileCount;
	}


	class AnswerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == view.getFileButton) {
					userFiles.add(view.getFile());
			}

			if (e.getSource() == view.countWordsButton) {

				for (File userFile : userFiles) {
					try {
						System.out.println(userFile.getName() + ": " + model.countWords(userFile));
					} catch (IOException e1) {

						e1.printStackTrace();
					}
				}
			}
		}
	}
}

