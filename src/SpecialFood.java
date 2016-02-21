/*
 * class of special food
 */

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpecialFood extends Sprite {

	public static final int width = 20, height = 20;
	private final String img = "food.png";
	
	
	//constructor
	public SpecialFood(int x, int y) {
		
		super(x, y, 0, 0);
		
		image_w = width;
		image_h = height;
		
		File file = new File(new File("src").getAbsolutePath()+ "//" + img);
		

		try {
			bImage = ImageIO.read(file);
			//setting special food icons


		} catch (IOException ex) {
			System.out.println("error loading files");
		}
	}

}
