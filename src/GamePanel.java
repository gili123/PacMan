/*
 * game interface
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements KeyListener, Runnable {

	private BufferedImage screeen = null;
	private boolean running;
	private Pacman pacman;
	private Map m;
	private GameEngine game;
	public final static int DOT_FOOD_EVENT=0,SPECIAL_FOOD_EVENT=1,LEVEL_OVER_EVENT=2,ENEMY_EVENT=3;
	private JLabel lbl;
	private JButton cntrl_btn;
	private int level;
	
	
	//constructor
	public GamePanel(int level) {
		
		
		lbl=new JLabel();
		lbl.setForeground(Color.RED);
		lbl.setFont (new Font("Courier", Font.BOLD,50));
		cntrl_btn=new JButton("Start");
		//adding action listener for button
		cntrl_btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				startGame();
			}
		});
		
		add(lbl);
		add(cntrl_btn);
		

		
		
		
		this.level=level;
		running = true;
		
		
		
	}

	@Override
	public void run() {
		initiate();
		while(running){

			gameUpdate();
			gameRender();
			paintScreen();
			gameCourse();

			try {
				Thread.sleep(20);
			}
			catch(InterruptedException e){}
		}
	}


	private void gameCourse(){
		int res=game.gameCourse();

		switch(res){
		case DOT_FOOD_EVENT:
			lbl.setText("TOTAL SCORE: "+game.getGameScore());

			break;
		case SPECIAL_FOOD_EVENT:
			lbl.setText("TOTAL SCORE: "+game.getGameScore());
			break;
		case LEVEL_OVER_EVENT:
			lbl.setText("Level is over!");
			stopGame();
			break;
		case ENEMY_EVENT:
			lbl.setText("Game Over: YOU DEAD!");
			stopGame();
			break;
		}

		lbl.repaint();
	}

	//paint the buffer on the screen
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

	//draw all elements
	private void gameRender() {
		Graphics g;
		screeen = new BufferedImage(Main.win_width, Main.win_height, BufferedImage.OPAQUE);
		g = screeen.createGraphics();
		game.draw(g);

	}

	//update game engine
	private void gameUpdate() {

		game.update();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); 
		gameRender();
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

	//starts the game thread
	public void startGame()
	{
		
		running=true;
		(new Thread(this)).start();
		
	}
	//stops the game thread
	public void stopGame()
	{
		running=false;
	
		
	}
	private void initiate(){
		game=new GameEngine(level);
		m=game.getMap();
		pacman=game.getPacman();
		lbl.setText("TOTAL SCORE: "+game.getGameScore());
		addKeyListener(this);
		setFocusable(true);
		requestFocusInWindow();
	}
}
