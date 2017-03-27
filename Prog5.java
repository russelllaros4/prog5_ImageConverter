 /*
CSE 17
Russell Laros
Program Description: This program will take a picture and convert it into ascii art
Program 5*/
package prog5;

import java.util.Scanner;//import scanner so we can get input from the user
import java.net.URL;//impoort URL so we can take in a URL
import javax.imageio.ImageIO;//import Image IO
import java.awt.image.BufferedImage;//import buffered image so we can create a buffered image
import java.net.MalformedURLException;//import URL exception so we can check if what user input isnt a URL
import java.io.File;//import File so we can take in a local file from the user
import java.io.IOException;//import IO exception to cehck if user inputs a correct local file

public class Prog5 {

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Pics or it didn't happen ----> ");//prompt for input
        String file = scan.next();
        BufferedImage img = null;//create the buffered image
        
        try{//start of try block
            if(file.charAt(0) == 'h' && file.charAt(1) == 't' && file.charAt(2) == 't' && file.charAt(3) == 'p') {//check if the input is a URL
                 
                URL url = new URL(file);//create new URL object to store the URL if it is a URL
                img = ImageIO.read(url);//input the URL object into a buffered image
                GImage pic = new GImage(img);//create a new GImage object with the buffered image
                pic.convertToChars();//convert the buffered image to ascii characters
            }else {//else if its a File
                File f = new File(file);//create a file object
                img = ImageIO.read(f);//make the buffered image the file
                GImage pic = new GImage(img);//create a new image object from the buffered image
                pic.convertToChars();//convert the image to ascii characters
            }
        } catch (MalformedURLException fuck) {//please excuse my variable names, they're innocent
            System.out.println(fuck.getMessage());//print the error message if a link is not inputted
            return;
        } catch (IOException dick) {//catch if it is not a local file
            System.out.println(dick.getMessage());//print error message
            return;
        }
    }
    
    
}
