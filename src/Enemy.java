import java.awt.image.BufferedImage;

public class Enemy extends Sprite{
	private final static int moveSpeed = 5;
	public Enemy(int x, int y, BufferedImage img) {
		super(x, y, moveSpeed, moveSpeed, img);
		// TODO Auto-generated constructor stub
	}

}
