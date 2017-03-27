package prog5;

import java.awt.image.BufferedImage;//import buffered image so we can read the file
import java.io.IOException;//import IO exception so we can check for IO errors
import java.awt.Color;//import color so we can check for proper darkness

public class GImage {

    private final BufferedImage pic;//initialize instance variable that will hold the buffered pic

    public GImage(BufferedImage image) throws IOException {//construct the buffered image
        this.pic = image;
    }

    public BufferedImage convertToGrey(BufferedImage image) {//create buffered image
        BufferedImage poopy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        int red, green, blue, alpha, grey;

        int[] average = new int[765];
        for (int i = 0; i < average.length; i++) {
            average[i] = (int) (i / 3);
        }
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                alpha = new Color(image.getRGB(i, j)).getAlpha();//initialize colors alpha through blue
                red = new Color(image.getRGB(i, j)).getAlpha();
                green = new Color(image.getRGB(i, j)).getAlpha();
                blue = new Color(image.getRGB(i, j)).getAlpha();
                grey = red + green + blue;
                grey = average[grey];
                grey = correctRGB(alpha, grey, grey, grey);
                poopy.setRGB(i, j, grey);
            }
        }
        return poopy;//i hope you find my varibles comical
    }

    public void convertToChars() {//now we convert the pixels to characters
        char[][] charac = new char[pic.getWidth()][pic.getHeight()];//set size
        int avg = 0;
       
        for (int i = 0; i < getWidth(); i++) {//work though the whole image
            for (int j = 0; j < getHeight(); j++) {
                int blue = new Color(pic.getRGB(i, j)).getBlue();//find intensity of the Blue
                int green = new Color(pic.getRGB(i, j)).getGreen();//find intensity of the Green
                int red = new Color(pic.getRGB(i, j)).getRed();//find intensity of the Red
                avg = (red + blue + green) / 3;//find the average intensity of all three
                if (avg < 25.5) {//set characters to certain colors based on shades
                    charac[i][j] = '@';
                } else if (avg >= 25.5 && avg < 51) {
                    charac[i][j] = '%';
                } else if (avg >= 51 && avg < 77) {
                    charac[i][j] = '#';
                } else if (avg >= 77 && avg < 100) {
                    charac[i][j] = '*';
                } else if (avg >= 100 && avg < 127.5) {
                    charac[i][j] = '+';
                } else if (avg >= 127.5 && avg < 153) {
                    charac[i][j] = '=';
                } else if (avg >= 153 && avg < 180) {
                    charac[i][j] = '-';
                } else if (avg >= 180 && avg < 205) {
                    charac[i][j] = ':';
                } else if (avg >= 205 && avg < 255) {
                    charac[i][j] = '.';
                } else {
                    charac[i][j] = ' ';
                }
            }
            avg = 0;//reset average for the next pixel
        }
        display(charac);//call display so it displays the char array of cahracters
    }

    public int getHeight() {//method to get the height
        int height = pic.getHeight();
        return height;
    }

    public int getWidth() {//method to get width
        int width = pic.getWidth();
        return width;
    }

    public void display(char[][] buttHoles) {//work through entire char array and display each pixel
        for (int i = 0; i < buttHoles.length; i++) {
            for (int j = 0; j < buttHoles.length; j++) {
                System.out.print(buttHoles[j][i]);//print character at the specific location
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int correctRGB(int blue, int green, int red, int alphaAsFuck) {//method to correct for Red Blue Green values
        int pix = 0;
        pix += alphaAsFuck;
        pix = pix << 8;
        pix += blue;
        pix = pix << 8;
        pix += green;
        pix = pix << 8;
        pix += red;

        return pix;
    }
}
