import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Warosaurus
 * Standard deviation: http://www.wikihow.com/Calculate-Standard-Deviation
 */

public class Ex4 {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt())
			numbers.add(scanner.nextInt());

		// Maximum
		int max = 0;
		for (Integer n: numbers)
				max = (n > max) ? n: max;

		System.out.println("Maximum: " + max);

		// Sum
		int sum = 0;
		for (Integer n : numbers)
			sum += n;

		// Mean
		double mean = sum/numbers.size();

		System.out.println("Mean: " + (mean));

		// Variance
		double variance = 0;
		for (Integer n: numbers)
			variance += Math.sqrt(n - mean);
		variance = variance/numbers.size() -1;

		// Std deviation
		double stdDeviation = Math.sqrt(variance);

		System.out.println("Standard Deviation: " + stdDeviation);
	}
}
