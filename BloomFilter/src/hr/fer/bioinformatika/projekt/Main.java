package hr.fer.bioinformatika.projekt;

import hr.fer.bioinformatika.projekt.bloomfilter.BloomFilter;
import hr.fer.bioinformatika.projekt.util.Utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * {@code Main} contains the main function that starts a simple interactive
 * application where the user can query if a element is a bloom filter.
 * 
 * @author Ivan Kraljević
 * 
 */
public class Main {

	/**
	 * Simple argument parser.
	 * 
	 * @param args
	 *            user defined values
	 * @return user defined or default values
	 */
	private static String[] parseArgs(String[] args) {
		String[] a = new String[] { "keyList.txt", "0.01", "0" };
		if (args == null || args.length == 0) {
			return a;
		}
		File f = new File(args[0]);
		if (f.exists()) {
			a[0] = args[0];
		}
		if (args.length > 1) {
			try {
				// if it fails then the argument is not a valid double
				Double.parseDouble(args[1]);
				a[1] = args[1];
			} catch (NumberFormatException e) {
			}
		}
		if (args.length > 2 && args[2].startsWith("1")) {
			a[2] = "1";
		}
		return a;
	}

	/**
	 * Loads the dictionary from the specified location.
	 * 
	 * @param path
	 *            file path
	 * @param isFasta
	 *            1 if the data is stored in FASTA format
	 * @return data collection
	 */
	public static Collection<String> getData(String path, String isFasta) {
		if (isFasta.startsWith("1")) {
			return Utilities.loadFasta(path);
		} else {
			return Utilities.loadStrings(path);
		}
	}

	/**
	 * Loads the dictionary from the specified location and adds it to a bloom
	 * filter.<br>
	 * Then the user can query the bloom filter via the system console.
	 * <p>
	 * ARGS:
	 * <ul>
	 * <li>1 - path to the file containing the keys which will be added to the
	 * bloom filter</li>
	 * <li>2 - acceptable false positive probability</li>
	 * <li>3 - data format - if the data is stored in the FASTA format the
	 * argument value should be "1", otherwise the program presumes that the key
	 * list is a simple text file where a single line represents a key.</li>
	 * </ul>
	 * </p>
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		args = parseArgs(args);
		double falsePositiveProbability = Double.parseDouble(args[1]);
		Collection<String> words = getData(args[0], args[2]);

		long startTime = System.currentTimeMillis();
		BloomFilter<String> filter = new BloomFilter<String>(words.size(),
				falsePositiveProbability);
		filter.addAll(words);
		double loadTime = (System.currentTimeMillis() - startTime) / 1000.;

		System.out.println("Key List loaded in: " + loadTime + " seconds.");
		System.out.println("Key List load from: " + args[0]);
		System.out.println("Key List size: " + words.size());

		try (BufferedReader r = new BufferedReader(new InputStreamReader(
				System.in))) {
			while (true) {
				System.out.print("Query: ");
				String l = r.readLine();
				if (l == null || l.length() == 0) {
					break;
				}
				System.out.println("Is '" + l + "' in the filter: "
						+ filter.query(l));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
