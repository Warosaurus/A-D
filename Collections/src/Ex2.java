import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Warosaurus
 */

public class Ex2 {

	public static void main(String[] args) throws IOException {
		File file = new File("Ex2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String word = "";
		HashMap<String, Integer> words = new HashMap<String, Integer>();

		while((word = br.readLine()) != null) { // Words in the text file need to separated by a new line.
			if (words.containsKey(word))
				words.put(word, words.get(word) + 1); // If the word exists in the map then increment it's value with 1.
			else
				words.put(word, 1); // Else place the word in the map with 1 occurrence.
		}

		System.out.println(words.toString()); // Print out the contents of the words map.
	}
}
