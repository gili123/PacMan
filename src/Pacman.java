import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;


public class Pacman extends Sprite implements ActionListener, Runnable {

	public static final int width = 20, height = 20;
	private final int mouthAngle = 30;
	private final int moveSpeed = 3;
	private Vector<Vertex> graph = new Vector<Vertex>();
	private Vertex correntVer, nextVer, prevVer;
	private int mouthState, direction;
	private Timer timer;

	public Pacman(int x, int y){
		super(x, y, 0, 0);

		mouthState = 0;
		direction = 0;
		timer = new Timer(400, this);

		(new Thread(this)).start();
	}

	public void setGraph(Vector<Vertex> v){

		graph = v;
		correntVer = graph.get(0);

		nextVer = correntVer.getNeighbor(0);
	}

	public void moveRight(){

		if(correntVer != null){
			if(correntVer.getDir(0) != -1)
				if(locX > correntVer.getX() && locX + Pacman.width < correntVer.getX() + Vertex.width && locY > correntVer.getY() && locY + Pacman.height < correntVer.getY() + Vertex.height)
					direction = 0;
		}

		else if(direction == 2){
			Vertex tmp = nextVer;
			nextVer = prevVer;
			prevVer = tmp;
			direction = 0;
		}
	}

	public void moveUp(){

		if(correntVer != null){
			if(correntVer.getDir(1) != -1)
				if(locX > correntVer.getX() && locX + Pacman.width < correntVer.getX() + Vertex.width && locY > correntVer.getY() && locY + Pacman.height < correntVer.getY() + Vertex.height)
					direction = 1;
		}

		else if(direction == 3){
			Vertex tmp = nextVer;
			nextVer = prevVer;
			prevVer = tmp;
			direction = 1;
		}
	}

	public void moveLeft(){

		if(correntVer != null){
			if(correntVer.getDir(2) != -1)
				if(locX > correntVer.getX() && locX + Pacman.width < correntVer.getX() + Vertex.width && locY > correntVer.getY() && locY + Pacman.height < correntVer.getY() + Vertex.height)
					direction = 2;
		}

		else if(direction == 0){
			Vertex tmp = nextVer;
			nextVer = prevVer;
			prevVer = tmp;
			direction = 2;
		}
	}

	public void moveDown(){

		if(correntVer != null){
			if(correntVer.getDir(3) != -1)
				if(locX > correntVer.getX() && locX + Pacman.width < correntVer.getX() + Vertex.width && locY > correntVer.getY() && locY + Pacman.height < correntVer.getY() + Vertex.height)
					direction = 3;
		}

		else if(direction == 1){
			Vertex tmp = nextVer;
			nextVer = prevVer;
			prevVer = tmp;
			direction = 3;
		}
	}

	@Override
	public void drawSprite(Graphics g){

		int sAngle = 0, eAngle = 0;

		g.setColor(Color.yellow);

		if(mouthState == 0){
			sAngle = 0;
			eAngle = 360;
		}

		else if(mouthState == 1){
			sAngle = direction * 90 + mouthAngle;
			eAngle = 360 - 2 * mouthAngle;
		}

		g.fillArc(locX, locY, width, height, sAngle, eAngle);

		move();
	}

	private void move() {

		if(correntVer != null){
			if(locX < correntVer.getX() || locX + Pacman.width > correntVer.getX() + Vertex.width || locY < correntVer.getY() || locY + Pacman.height > correntVer.getY() + Vertex.height){
				prevVer = correntVer;
				correntVer = null;
				nextVer = prevVer.getNeighbor(direction);
			}
		}

		/*if(prevVer != null)
			nextVer = prevVer.getNeighbor(direction);*/

		if(nextVer != null){
			if(locX >= nextVer.getX() && locX + Pacman.width <= nextVer.getX() + Vertex.width && locY >= nextVer.getY() && locY + Pacman.height <= nextVer.getY() + Vertex.height){
				correntVer = nextVer;
				nextVer = correntVer.getNeighbor(direction);
			}
		}

		switch(direction){

		case 0:

			if(correntVer != null){
				if(correntVer.getDir(0) != -1)
					locX += moveSpeed;
				else if(locX + moveSpeed + Pacman.width < correntVer.getX() + Vertex.width)
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
				else if(locY + moveSpeed + Pacman.height < correntVer.getY() + Vertex.height)
					locY += moveSpeed;
			}

			else if(nextVer != null)
				locY += moveSpeed;

			break;
		}
	}

	@Override
	public Rectangle getBoundingBox()
	{
		return new Rectangle(getLocX(), getLocY(), width, height);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mouthState = (mouthState + 1) % 2;

	}
	public void setPacmanStartPoint(Point p){
		this.locX=p.x;
		this.locY=p.y;
	}

	@Override
	public void run() {

		timer.start();
	}

}
