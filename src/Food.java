import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Food {

	private final int width = 15, height = 15;
	private int x, y;
	private Color color;

	public Food(int x, int y){

		this.x = x;
		this.y = y;

		Random rand = new Random();

		float r = rand.nextFloat();
		float l = rand.nextFloat();
		float b = rand.nextFloat();

		color = new Color(r, l, b);
	}

	public void draw(Graphics g){

		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(color);

		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, width, height);
		g2d.fill(circle);
	}
}
