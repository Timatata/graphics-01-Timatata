import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

public class IPR {

    /**
     * Displays the image in a window and keep it open till the user closes it.
     * 
     * @param title  the title of the image
     * @param pixels the image to be displayed as a 2D array of pixels
     */
    public static void imageShow(String title, int[][] pixels) {

        var h = pixels.length;
        var w = pixels[0].length;

        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        for (int x = 0; x < w; ++x) {
            for (int y = 0; y < h; ++y) {
                var px = pixels[y][x]; // flip u,v here!
                img.setRGB(x, y, px);
            }
        }

        JFrame frame = new JFrame();
        frame.setSize(512, 512 * h / w);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title + " (" + w + "x" + h + ")");
        var label = new JLabel();
        var icon = new ImageIcon(img.getScaledInstance(512, 512 * h / w, java.awt.Image.SCALE_FAST));
        label.setIcon(icon);
        label.setSize(512, 512);
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        frame.repaint();
    }

    /**
     * Displays a binary image in a window and keeps it open till the user closes
     * it.
     * 
     * @param title  the title of the image
     * @param pixels the image to be displayed as a 2D array of pixels
     */
    public static void imageShow(String title, boolean[][] pixels) {
        var h = pixels.length;
        var w = pixels[0].length;

        int[][] colors = new int[h][w];

        for (int x = 0; x < w; ++x) {
            for (int y = 0; y < h; ++y) {
                colors[y][x] = pixels[y][x] ? 0xFFFFFF : 0x000000;
            }
        }

        imageShow(title, colors);
    }

    /**
     * Displays a grayscale image in a window and keeps it open till the user closes
     * it.
     * 
     * @param title  the title of the image
     * @param pixels the image to be displayed as a 2D array of pixels
     */
    public static void imageShow(String title, float[][] pixels) {

        var h = pixels.length;
        var w = pixels[0].length;

        int[][] colors = new int[h][w];

        for (int x = 0; x < w; ++x) {
            for (int y = 0; y < h; ++y) {
                var c = (int) (pixels[y][x] * 255.0f);
                // clip to [0,255]
                c = c < 0 ? 0 : c > 255 ? 255 : c;
                colors[y][x] = (c << 16) | (c << 8) | c;
            }
        }

        imageShow(title, colors);
    }

    // Additional functions for reading/writing images ------------

    /**
     * Reads an image from a file.
     * 
     * @param fileName the name of the file
     * @return the image
     */
    public static float[][] imageReadGrayscale(String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        float[][] image = new float[img.getHeight()][img.getWidth()];
        for (int x = 0; x < img.getWidth(); ++x) {
            for (int y = 0; y < img.getHeight(); ++y) {
                var px = ((img.getRGB(x, y) & 0xFF00) >> 8) / 255.0f; // only the green channel
                image[y][x] = px;
            }
        }
        return image;
    }

}
