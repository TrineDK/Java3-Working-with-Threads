package countWords;

/**
 * This class contains the AnswerListeners for CountWordsInterface and runs the
 * model.countWords method in separate threads
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CountWordsController{

	private CountWordsInterface view;
	private CountWordsModel model;
	List<File> userFiles = new ArrayList<>();


	CountWordsController(CountWordsInterface view, CountWordsModel model) {
		this.view = view;
		this.model = model;

		this.view.addAnswerListener(new AnswerListener());
	}



	class AnswerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == view.getFileButton) {
					userFiles.add(view.getFile());
			}

			if (e.getSource() == view.countWordsButton) {

				// For when countWordsButton is clicked without any files being selected
				if (userFiles.size() == 0) {

					System.out.println("Please select a file to continue");

				} else {

					// Sets up thread pool with enough threads for each file
				ExecutorService executorService = Executors.newFixedThreadPool(userFiles.size());

					// Loops through each file, assign thread with executorService and call
					// countWords method
				for (File userFile : userFiles) {

					executorService.execute(() -> {
						System.out.println(userFile.getName() + ": " + model.countWords(userFile));
					});
				}
				executorService.shutdown();
			}
		}
	}
}
}


