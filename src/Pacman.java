import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Pacman implements ActionListener, Runnable {

	private final int width = 40, height = 40;
	private final int mouthAngle = 30;
	private final int moveSpeed = 10;
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

	public void moveRight(){

		x += moveSpeed;
		direction = 0;
	}

	public void moveUp(){

		y -= moveSpeed;
		direction = 1;
	}

	public void moveLeft(){

		x -= moveSpeed;
		direction = 2;
	}
	
	public void moveDown(){

		y += moveSpeed;
		direction = 3;
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
