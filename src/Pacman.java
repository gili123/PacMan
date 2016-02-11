import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;


public class Pacman implements ActionListener, Runnable {

	public static final int width = 40, height = 40;
	private final int mouthAngle = 30;
	private final int moveSpeed = 5;
	private Vector<Vertex> graph = new Vector<Vertex>();
	private Vertex correntVer, nextVer, prevVer;
	private int x, y;
	private int mouthState, direction;
	private Timer timer;

	public Pacman(int x, int y){

		this.x = x;
		this.y = y;

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
				direction = 3;
		}
		
		else if(direction == 1){
			Vertex tmp = nextVer;
			nextVer = prevVer;
			prevVer = tmp;
			direction = 3;
		}
	}


	public void draw(Graphics g){

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

		g.fillArc(x, y, width, height, sAngle, eAngle);

		move();
	}

	private void move() {

		if(correntVer != null){
			if(x <= correntVer.getX() || x + Pacman.width >= correntVer.getX() + Vertex.width || y <= correntVer.getY() || y + Pacman.height >= correntVer.getY() + Vertex.height){
				prevVer = correntVer;
				correntVer = null;
			}
		}

		if(prevVer != null)
			nextVer = prevVer.getNeighbor(direction);

		if(nextVer != null){
			if(x > nextVer.getX() && x + Pacman.width < nextVer.getX() + Vertex.width && y > nextVer.getY() && y + Pacman.height < nextVer.getY() + Vertex.height){
				correntVer = nextVer;
				nextVer = correntVer.getNeighbor(direction);
			}
		}

		switch(direction){

		case 0:

			if(correntVer != null){
				if(correntVer.getDir(0) != -1)
					x += moveSpeed;
				else if(x + moveSpeed + Pacman.width < correntVer.getX() + Vertex.width)
					x += moveSpeed;
			}

			else
				x += moveSpeed;

			break;

		case 1:

			if(correntVer != null){
				if(correntVer.getDir(1) != -1)
					y -= moveSpeed;
				else if(y - moveSpeed > correntVer.getY())
					y -= moveSpeed;
			}

			else
				y -= moveSpeed;

			break;

		case 2:

			if(correntVer != null){
				if(correntVer.getDir(2) != -1)
					x -= moveSpeed;
				else if(x - moveSpeed > correntVer.getX())
					x -= moveSpeed;
			}

			else
				x -= moveSpeed;

			break;

		case 3:

			if(correntVer != null){
				if(correntVer.getDir(3) != -1)
					y += moveSpeed;
				else if(y + moveSpeed + Pacman.height < correntVer.getY() + Vertex.height)
					y += moveSpeed;
			}

			else
				y += moveSpeed;

			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		mouthState = (mouthState + 1) % 2;

	}


	@Override
	public void run() {

		timer.start();
	}

}
