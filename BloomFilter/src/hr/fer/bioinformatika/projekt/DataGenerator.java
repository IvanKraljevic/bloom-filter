package hr.fer.bioinformatika.projekt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

	/**
	 * Generates a random key list and saves it to a text file.
	 * 
	 * @param numOfKeys
	 *            size of the key list.
	 * @param minLength
	 *            minimum length of a single key.
	 * @param maxLength
	 *            maximum length of a single key.
	 * @param rand
	 *            random number generator.
	 * @param outputPath
	 *            path where the new key list will be saved.
	 */
	public static void generateKeyList(int numOfKeys, int minLength,
			int maxLength, String outputPath, Random rand) {
		int interval = maxLength - minLength;

		try (BufferedWriter w = new BufferedWriter(new FileWriter(outputPath))) {
			for (int i = 0; i < numOfKeys; i++) {
				int length = rand.nextInt(interval) + minLength;
				char[] arr = new char[length];
				for (int j = 0; j < length; j++) {
					arr[j] = (char) (48 + rand.nextInt(74));
				}
				w.write(arr);
				w.write('\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
