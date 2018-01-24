package webcam;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

/**
 * @author olena.viliuzhanina
 *
 */
public class WebCamTest {

	public static void main(String[] args){
//		Webcam webcam = Webcam.getDefault();
//		webcam.open();
//		try {
//			ImageIO.write(webcam.getImage(), "PNG", new File("hello-world.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		int a = 14;
		int b = 23; 
		System.out.println(a^b); 
		
		  byte x = 3;
		  x = (byte)~x;
		   System.out.println(x);
	}
}
