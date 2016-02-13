/*
 * class of dot foods
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class DotsFood extends Sprite {

	public final static int width = 10, height = 10;

	private Color color;

	//constructor
	public DotsFood(int x, int y){

		super(x, y, 0, 0);

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
	
	//draw food
	@Override
	public void drawSprite(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);

		Ellipse2D.Double circle = new Ellipse2D.Double(locX, locY, width, height);
		g2d.fill(circle);
	}
}
