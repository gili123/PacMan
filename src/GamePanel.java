import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener, Runnable {

	private BufferedImage screeen = null;
	private boolean running;
	private Pacman pacman;
	private Map m;

	public GamePanel() {

		setFocusable(true);
		requestFocusInWindow();
		
		m = new Level1();
		Point start = m.getStartPoint();
		pacman = new Pacman(start.x, start.y);
		pacman.setGraph(m.getGraph());
		running = true;
		
		addKeyListener(this);
	}

	@Override
	public void run() {

		while(running){

			gameUpdate();
			gameRender();
			paintScreen();

			try {
				Thread.sleep(20);
			}
			catch(InterruptedException e){}
		}
	}

	private void paintScreen() {

		Graphics g;
		try {
			g = getGraphics();
			if(g != null && screeen != null)
				g.drawImage(screeen, 0, 0, null);
			g.dispose();
		}
		catch(Exception e)
		{
			System.out.println("Graphics error");
		}
	}

	private void gameRender() {

		Graphics g;

		screeen = new BufferedImage(Main.win_width, Main.win_height, BufferedImage.OPAQUE);
		g = screeen.createGraphics();

		pacman.draw(g);
		m.draw(g);
	}

	private void gameUpdate() {


	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()){

		case KeyEvent.VK_LEFT:
			pacman.moveLeft();
			break;

		case KeyEvent.VK_RIGHT:
			pacman.moveRight();
			break;

		case KeyEvent.VK_UP:
			pacman.moveUp();
			break;

		case KeyEvent.VK_DOWN:
			pacman.moveDown();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	// only start the animation once the JPanel has been added to the JFrame
	public void addNotify()
	{ 
		super.addNotify(); 
		startGame();    
	}

	//start the game thread
	public void startGame()
	{
		(new Thread(this)).start();
	}
}
