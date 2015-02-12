import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Warosaurus
 */

public class Ex1 {

	public static void main(String[] args) throws IOException {

		File file = new File("Ex1.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		Set<String> words = new HashSet<String>();

		while((line = br.readLine()) != null) // Words in the text file need to separated by a new line.
			words.add(line); // Duplicate words will not be added, leaving only unique words.

		System.out.println(words.toString()); // Print out the unique words.
	}
}
