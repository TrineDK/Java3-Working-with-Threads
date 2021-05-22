package countWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountWordsModel {



	public int countWords(File userFile) throws IOException {



		// FileInputStream fileStream = new FileInputStream(userFile);
		// InputStreamReader input = new InputStreamReader(fileStream);
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(userFile)));

		int wordCount = 0;
		String data;
		int i = 0;

			while ((data = reader.readLine()) != null) {

				String[] words = data.split("\\s+");

				for (i = 0; i < words.length; i++) {
					System.out.println(words[i]);
				}

				wordCount = wordCount + words.length;
			}

			reader.close();
			System.out.println(wordCount);
		return wordCount;
	}

}
