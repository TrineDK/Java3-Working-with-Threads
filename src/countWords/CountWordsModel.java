package countWords;

/**
 * This Class handles the data for the CountWords app and has one method to count words in a file
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsModel {


	/**
	 * This method counts the words in a file
	 *
	 * @param userFile as a File
	 * @return number of words as an int
	 */
	public int countWords(File userFile) {

		int wordCount = 0;
		String data;

		// create BufferedReader to read content of file
		try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {

			// Reads until the end of the document
			while ((data = reader.readLine()) != null) {

				// Creates an array of the words, so each word is an element
				String[] words = data.split("\\s+");

				// Sets the word count, which is the same as the number of elements in the word
				// array
				wordCount = wordCount + words.length;
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordCount;
	}
}
