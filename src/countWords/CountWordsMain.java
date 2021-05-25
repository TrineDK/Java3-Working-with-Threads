package countWords;

/**
 * This Class runs the CountWords app
 */

import javax.swing.SwingUtilities;

public class CountWordsMain {


	public static void main(String[] args) {



		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CountWordsInterface view = new CountWordsInterface();
				CountWordsModel model = new CountWordsModel();
				CountWordsController controller = new CountWordsController(view, model);
			}
		});

	}

}
