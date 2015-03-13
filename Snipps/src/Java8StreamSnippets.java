import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Warosaurus
 *
 * Java 8 Stream Snippets, Search through a text file for all occurances of a given word and return those occurances
 * with a certain number of words surrounding it, to show the context of that word.
 *
 * Exmaple:
 *
 * Text: "The quick brown fox jumped over the fence."
 *
 * Keyword: "Fox"
 * limit: 3
 *
 * Would the return: "The quick brown fox jumped over the"
 *
 * Time complexity in Big-O notation would be:
 * - Creating the list of all words: O(n)
 * - Finding all matches of the keyword: O(n)
 * - Equals: O(n)
 *
 */
public class Java8StreamSnippets {

	public static void findWord(String word, int l) throws IOException {
		Path path = Paths.get("resources/text.txt");
		System.out.println("Number of lines in file: " + Files.lines(path).count());

		// Create a list of all words in the text file, separated by whitespace
		List<String> words = Files.lines(path)
				.parallel() // Do everything below in parallel
				.flatMap(Pattern.compile(" ")::splitAsStream)
				.collect(Collectors.toList());

		List<String> matches= IntStream.range(0, words.size())
				.parallel() // Do everything below in parallel
				// Find all matches, ignoring case
				.filter(ix -> words.get(ix).equalsIgnoreCase(word))
				// Create subLists around the matches
				.mapToObj(ix -> words.subList(Math.max(0, ix -1), Math.min(ix+2, words.size())))
				// Reconvert lists into context (joined on white space)
				.map(list -> list.stream().collect(Collectors.joining(" ")))
				// Collect all matches into a list
				.collect(Collectors.toList());

		System.out.println("Number of matches: " + matches.size());
		// Print out all the matches
		System.out.println("Matches:");
		for (String s: matches)
			System.out.println(s);
	}

	public static void main(String[] args) throws IOException {
		Java8StreamSnippets.findWord("the", 1);
	}
}
