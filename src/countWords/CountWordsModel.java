package countWords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CountWordsModel {

	List<File> userFiles = new ArrayList<>();

	public int countWords(File userFile) throws IOException {

		FileInputStream fileStream = new FileInputStream(userFile);
		InputStreamReader input = new InputStreamReader(fileStream);
		BufferedReader reader = new BufferedReader(input);

		int wordCount = 0;
		String data;


			while ((data = reader.readLine()) != null) {

				String[] words = data.split("\\s+");
				wordCount = wordCount + words.length;
			}

		return wordCount;
	}

}
