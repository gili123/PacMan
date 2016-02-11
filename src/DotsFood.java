import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DotsFood extends Sprite {

	private final static int width = 15,height = 15;

	private Color color;

	public DotsFood(int x, int y,BufferedImage img){

		super(x, y, 0, 0, img);

		Random rand = new Random();

		float r = rand.nextFloat();
		float l = rand.nextFloat();
		float b = rand.nextFloat();

		color = new Color(r, l, b);
	}
	@Override
	public Rectangle getBoundingBox()
	{
		return new Rectangle(getLocX(), getLocY(), width, height);
	}
	@Override
	public void drawSprite(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);

		Ellipse2D.Double circle = new Ellipse2D.Double(locX, locY, width, height);
		g2d.fill(circle);
	}
}
