/**
 * IPR | Graphics - Exercise : Images
 * 
 * This is the handout and the exercise for the IPR Graphics Exercise.
 * *
 * 
 * @Contact: If you have any questions, please contact the tutors or the
 *           instructor (David Schedl, email: david.schedl@fh-hagenberg.at)
 */
public class LectureStats {

	/**
	 * Verify that pixel coordinates x,y are within the image bounds w,h.
	 * 
	 * @param w width of the image
	 * @param h height of the image
	 * @param x x coordinate of the pixel
	 * @param y y coordinate of the pixel
	 * @return
	 */
	public static boolean isCoordinateValid(int w, int h, int x, int y) {
		if (x < 0 || x >= w || y < 0 || y >= h) {
			return false;
		}
		return true;
	}

	public static int getPixel(boolean[][] image, int x, int y) {
		if (isCoordinateValid(image[0].length, image.length, x, y)) {
			if (image[y][x] == true) {
				return 1;
			} else {
				return 0;
			}
		}
		return -1;
	}

	public static int getPixel(float[][] image, int x, int y) {
		if (isCoordinateValid(image[0].length, image.length, x, y)) {
			return Math.round(image[y][x] * 255.0f); // map to [0, 255]
		}
		return -1;

	}

	public static void main(String[] args) {

		/*
		 * Pixels of a binary image in Java are encoded as Boolean values (true/false).
		 */
		if (true) {
			final boolean W = true; // white
			final boolean B = false; // black
			// false is black

			boolean[][] pixels_bw = {
					// col/u --->
					{ B, B, B, B, B, B, B, B }, // row/v 0
					{ B, B, W, W, W, W, B, B },
					{ B, W, B, B, B, B, W, B },
					{ W, B, W, B, B, W, B, W },
					{ W, B, B, B, B, B, B, W },
					{ W, B, W, B, B, W, B, W },
					{ W, B, B, W, W, B, B, W },
					{ B, W, B, B, B, B, W, B },
					{ B, B, W, W, W, W, B, B },
					{ B, B, B, B, B, B, B, B }
			};

			IPR.imageShow("Binary smiley image", pixels_bw);
		}

		/*
		 * Pixels of a grayscale image in Java are encoded as float values in the range
		 * [0, 1].
		 */
		if (false) {
			final float W = 1.0f; // white (8-bit: 255)
			final float H = 0.5f; // half gray (8-bit: 128)
			final float A = 0.8f; // almost white (8-bit: 204)
			final float B = 0.0f; // black (8-bit: 0)
			// zero is black

			float[][] pixels_gray = {
					// col/u --->
					{ B, B, B, B, B, B, B, B }, // row/v 0
					{ B, B, H, H, H, H, B, B },
					{ B, H, B, B, B, B, H, B },
					{ H, B, W, B, B, W, B, H },
					{ H, B, B, B, B, B, B, H },
					{ H, B, A, B, B, A, B, H },
					{ H, B, B, A, A, B, B, H },
					{ B, H, B, B, B, B, H, B },
					{ B, B, H, H, H, H, B, B },
					{ B, B, B, B, B, B, B, B }
			};
			IPR.imageShow("Grayscale smiley image", pixels_gray);

		}

		/*
		 * Let's read an image form disk.
		 */
		if (false) {
			float[][] image = IPR.imageReadGrayscale("cat.png");
			IPR.imageShow("Cat", image);
		}

	}
}
