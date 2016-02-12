import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;

public class Enemy extends Sprite{

	public static final int width = 30, height = 30;
	private final String img = "enemy.png";
	private static int moveSpeed = 3;

	private int direction;
	private Vertex correntVer, nextVer, prevVer;
	private Vector<Vertex> graph = new Vector<Vertex>();


	public Enemy(int x, int y, Vector<Vertex> g, Vertex cur) {

		super(x, y, moveSpeed, moveSpeed, null);

		image_w = width;
		image_h = height;
		graph = g;
		correntVer = cur;
		
		File file1 = new File(new File("src").getAbsolutePath()+ "//" + img);
		try {
			bImage = ImageIO.read(file1);
			//setting enemies icons


		} catch (IOException ex) {
			System.out.println("error loading files");
		}
	}

	public void move(){

		if(correntVer != null){

			if(locX < correntVer.getX() || locX + Enemy.width > correntVer.getX() + Vertex.width || locY < correntVer.getY() || locY + Enemy.height > correntVer.getY() + Vertex.height){
				prevVer = correntVer;
				correntVer = null;
				nextVer = prevVer.getNeighbor(direction);
			}

			if(correntVer != null){
				do{
					Random rand = new Random();
					direction = rand.nextInt(4);

				}while(correntVer.getDir(direction) == -1);
			}
		}

		/*if(prevVer != null)
			nextVer = prevVer.getNeighbor(direction);*/

		if(nextVer != null){
			if(locX >= nextVer.getX() && locX + Enemy.width <= nextVer.getX() + Vertex.width && locY >= nextVer.getY() && locY + Enemy.height <= nextVer.getY() + Vertex.height){
				correntVer = nextVer;
				nextVer = correntVer.getNeighbor(direction);
			}
		}

		switch(direction){

		case 0:

			if(correntVer != null){
				if(correntVer.getDir(0) != -1)
					locX += moveSpeed;
				else if(locX + moveSpeed + Enemy.width < correntVer.getX() + Vertex.width)
					locX += moveSpeed;
			}

			else if(nextVer != null)
				locX += moveSpeed;

			break;

		case 1:

			if(correntVer != null){
				if(correntVer.getDir(1) != -1)
					locY -= moveSpeed;
				else if(locY - moveSpeed > correntVer.getY())
					locY -= moveSpeed;
			}

			else if(nextVer != null)
				locY -= moveSpeed;

			break;

		case 2:

			if(correntVer != null){
				if(correntVer.getDir(2) != -1)
					locX -= moveSpeed;
				else if(locX - moveSpeed > correntVer.getX())
					locX -= moveSpeed;
			}

			else if(nextVer != null)
				locX -= moveSpeed;

			break;

		case 3:

			if(correntVer != null){
				if(correntVer.getDir(3) != -1)
					locY += moveSpeed;
				else if(locY + moveSpeed + Enemy.height < correntVer.getY() + Vertex.height)
					locY += moveSpeed;
			}

			else if(nextVer != null)
				locY += moveSpeed;

			break;
		}

	}
}
