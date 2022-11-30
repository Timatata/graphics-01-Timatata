/**
 * IPR | Graphics - Exercise : Images
 * 
 * This is the handout and the exercise for the IPR Graphics Exercise.
 * *
 * 
 * @Contact: If you have any questions, please contact the tutors or the
 *           instructor (David Schedl, email: david.schedl@fh-hagenberg.at)
 */
public class LectureImages {

	public static void main(String[] args) {

		/*
		 * Pixels of a binary image in Java are encoded as Boolean values (true/false).
		 */
		{
			final Boolean W = true; // white
			final Boolean B = false; // black
			// false is black

			boolean[][] pixels_bw = {
					// col/u --->
					{ B, B, W, W, W, W, B, B }, // row/v 0
					{ B, W, B, B, B, B, W, B }, // row 1
					{ W, B, W, B, B, W, B, W }, // row 2
					{ W, B, B, B, B, B, B, W }, // row 3
					{ W, B, W, B, B, W, B, W }, // row 4
					{ W, B, B, W, W, B, B, W }, // row 5
					{ B, W, B, B, B, B, W, B }, // row 6
					{ B, B, W, W, W, W, B, B } // row 7
			};
			// Make sure that this file (`.java`) is in the same directory as the `IPR.java`
			// file, to get access to the `IPR.imageShow` function for displaying images.
			IPR.imageShow("Binary smiley image", pixels_bw);
		}

		/*
		 * Pixels of a grayscale image in Java are encoded as float values in the range
		 * [0, 1].
		 */
		{
			final float W = 1.0f; // white
			final float H = 0.5f; // half gray
			final float A = 0.8f; // almost white
			final float B = 0.0f; // black
			// zero is black

			float[][] pixels_gray = {
					// col/u --->
					{ B, B, H, H, H, H, B, B }, // row/v 0
					{ B, H, B, B, B, B, H, B }, // row 1
					{ H, B, W, B, B, W, B, H }, // row 2
					{ H, B, B, B, B, B, B, H }, // row 3
					{ H, B, A, B, B, A, B, H }, // row 4
					{ H, B, B, A, A, B, B, H }, // row 5
					{ B, H, B, B, B, B, H, B }, // row 6
					{ B, B, H, H, H, H, B, B } // row 7
			};
			IPR.imageShow("Grayscale smiley image", pixels_gray);
		}

		/*
		 * Pixels of a grayscale image in Java are encoded as float values in the range
		 * [0, 1].
		 */
		{
			final float W = 1.0f; // white
			final float H = 0.5f; // half gray
			final float A = 0.8f; // almost white
			final float B = 0.0f; // black
			// zero is black

			float[][] pixels_gray = {
					// col/u --->
					{ 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.0f, 0.0f }, // row/v 0
					{ 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f }, // row 1
					{ 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.5f }, // row 2
					{ 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f }, // row 3
					{ 0.5f, 0.0f, 0.8f, 0.0f, 0.0f, 0.8f, 0.0f, 0.5f }, // row 4
					{ 0.5f, 0.0f, 0.0f, 0.8f, 0.8f, 0.0f, 0.0f, 0.5f }, // row 5
					{ 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f }, // row 6
					{ 0.0f, 0.0f, 0.5f, 0.5f, 0.5f, 0.5f, 0.0f, 0.0f } // row 7
			};
			IPR.imageShow("Grayscale smiley image", pixels_gray);
		}

		/*
		 * Drawing with Code.
		 */
		{
			final float W = 1.0f; // white
			final float H = 0.5f; // half gray
			final float A = 0.8f; // almost white
			final float B = 0.0f; // black
			// zero is black

			float[][] pixels_gray = new float[10][8];

			// fill image with half gray
			for (int v = 0; v < pixels_gray.length; v++) {
				for (int u = 0; u < pixels_gray[v].length; u++) {
					pixels_gray[v][u] = 0.5f;
				}
			}

			// Draw a diagonal line from top left to bottom right
			for (int u = 0; u < pixels_gray.length; u++) {
				// boundary check
				if (u < pixels_gray.length && u < pixels_gray[0].length) {
					pixels_gray[u][u] = 1.0f;
				}
			}

			IPR.imageShow("Drawn image", pixels_gray);
		}

		/*
		 * Encode an RGB pixel in one 32-bit integer value
		 * 
		 * In Java RGB pixels are encoded in 32-bit integers for efficiency. Let's look
		 * at an example below.
		 */
		{
			int r = 0xFF; // red
			int g = 0x64; // green
			int b = 0x0B; // blue
			int rgb = 0xFF640B; // 24-bit representation of the Color

			// print in a decimal, hexadecimal and binary number system
			System.out.println("red: \t" + r + " \t0x" + Integer.toHexString(r) + " \t" + Integer.toBinaryString(r));
			System.out.println("green: \t" + g + " \t0x" + Integer.toHexString(g) + " \t" + Integer.toBinaryString(g));
			System.out.println("blue: \t" + b + " \t0x" + Integer.toHexString(b) + " \t" + Integer.toBinaryString(b));
			System.out.println(
					"RGB: \t" + rgb + " \t0x" + Integer.toHexString(rgb) + " \t" + Integer.toBinaryString(rgb));
			System.out.println("-------------------");

		}
		/*
		 * Bitwise Operations
		 * 
		 * Java has built-in functions to perform bitwise operations. You'll see a few
		 * examples below.
		 */
		{
			int a = 0b10011100;
			int b = 0b00110100;
			System.out.println("a \t" + Integer.toBinaryString(a));
			System.out.println("b \t" + Integer.toBinaryString(b));
			int bit_or = a | b; // bitwise OR (|)
			int bit_and = a & b; // bitwise AND (&)
			System.out.println("OR \t" + Integer.toBinaryString(bit_or));
			System.out.println("AND \t" + Integer.toBinaryString(bit_and));
			System.out.println("-------------------");

			int bit = 0b100111;
			int bit_left = bit << 1;// bitwise shift left (<<)
			int bit_right = bit_left >> 1; // bitwise shift right (>>)
			System.out.println("bit \t" + Integer.toBinaryString(bit));
			System.out.println("<<1 \t" + Integer.toBinaryString(bit_left));
			System.out.println(">>1 \t" + Integer.toBinaryString(bit_right));
			System.out.println("-------------------");
		}

	}
}
