/**
 * IPR | Graphics - Exercise : Images
 * 
 * This is the handout and the exercise for the IPR Graphics Exercise.
 * *
 * 
 * @Contact: If you have any questions, please contact the tutors or the
 *           instructor (David Schedl, email: david.schedl@fh-hagenberg.at)
 */
public class LectureStatsFinished {

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
		if (false) {
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

			// compute the number of (true/1) white pixels
			int numWhitePixels = 0;
			for (int y = 0; y < pixels_bw.length; y++) {
				for (int x = 0; x < pixels_bw[y].length; x++) {
					if (getPixel(pixels_bw, x, y) == 1) {
						numWhitePixels++;
					}
				}
			}
			System.out.println("Number of white pixels: " + numWhitePixels);
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

			// compute the number of W,H,A,B pixels
			int numWhitePixels = 0;
			int numHalfGrayPixels = 0;
			int numAlmostWhitePixels = 0;
			int numBlackPixels = 0;
			for (int y = 0; y < pixels_gray.length; y++) {
				for (int x = 0; x < pixels_gray[y].length; x++) {
					if (getPixel(pixels_gray, x, y) == 255) {
						numWhitePixels++;
					} else if (getPixel(pixels_gray, x, y) == 128) {
						numHalfGrayPixels++;
					} else if (getPixel(pixels_gray, x, y) == 204) {
						numAlmostWhitePixels++;
					} else if (getPixel(pixels_gray, x, y) == 0) {
						numBlackPixels++;
					}
				}
			}
			System.out.println("Number of white pixels: " + numWhitePixels);
			System.out.println("Number of half gray pixels: " + numHalfGrayPixels);
			System.out.println("Number of almost white pixels: " + numAlmostWhitePixels);
			System.out.println("Number of black pixels: " + numBlackPixels);
			System.out.println("Number of all pixels: "
					+ (numWhitePixels + numHalfGrayPixels + numAlmostWhitePixels + numBlackPixels));

			// Let's get more general and compute the number of pixels for each gray level
			// [0 to 255]. You might have heard this already: "The histogram of an image".
			int[] histogram = new int[256];
			for (int y = 0; y < pixels_gray.length; y++) {
				for (int x = 0; x < pixels_gray[y].length; x++) {
					int grayLevel = getPixel(pixels_gray, x, y);
					histogram[grayLevel]++;
				}
			}

			// Lets visualize it in a nicer way!
			int numberOfPixels = pixels_gray.length * pixels_gray[0].length;
			// get the maximum value of the histogram
			int max = 0;
			boolean histImage[][] = new boolean[256][256];
			for (int i = 0; i < histogram.length; i++) {
				int numPixels = histogram[i];
				int numPixelsInHistImage = (int) Math.ceil(numPixels / (float) numberOfPixels * histImage.length);
				for (int j = 0; j < numPixelsInHistImage; j++) {
					histImage[histImage.length - 1 - j][i] = true;
				}
			}
			IPR.imageShow("Histogram of grayscale smiley image", histImage);

		}

		/*
		 * Let's read an image form disk.
		 */
		if (false) {
			float[][] image = IPR.imageReadGrayscale("cat.png");
			IPR.imageShow("Cat", image);

			// Let's get more general and compute the number of pixels for each gray level
			// [0 to 255]. You might have heard this already: "The histogram of an image".
			int[] histogram = new int[256];
			for (int y = 0; y < image.length; y++) {
				for (int x = 0; x < image[y].length; x++) {
					int grayLevel = getPixel(image, x, y);
					histogram[grayLevel]++;
				}
			}

			// Lets visualize it in a nicer way!
			int numberOfPixels = image.length * image[0].length;
			boolean histImage[][] = new boolean[256][256];
			// get the maximum value of the histogram
			int max = 0;
			for (int i = 0; i < histogram.length; i++) {
				if (histogram[i] > max) {
					max = histogram[i];
				}
			}
			for (int i = 0; i < histogram.length; i++) {
				int numPixels = histogram[i];
				int numPixelsInHistImage = (int) Math.ceil(numPixels / (float) max * histImage.length);
				for (int j = 0; j < numPixelsInHistImage; j++) {
					histImage[histImage.length - 1 - j][i] = true;
				}
			}
			IPR.imageShow("Histogram of the Cat image", histImage);
		}

	}
}
