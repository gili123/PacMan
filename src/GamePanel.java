/*
 * game interface
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class GamePanel extends JPanel implements KeyListener, Runnable {

	private BufferedImage screeen = null;
	private boolean running=false;
	private Pacman pacman;
	private Map m;
	private GameEngine game;
	public final static int DOT_FOOD_EVENT=0,SPECIAL_FOOD_EVENT=1,LEVEL_OVER_EVENT=2,ENEMY_EVENT=3,MAX_DEATHS=3;
	private JLabel score_lbl,life_lbl,level_lbl;
	private JButton cntrl_btn;
	private int level;
	private JPanel cntrl_pnl;
	private boolean game_started=false;
	//constructor
	public GamePanel(int level) {

		life_lbl=new JLabel("life: 3");
		level_lbl=new JLabel("level: "+level);
		score_lbl=new JLabel();
		score_lbl.setBackground(Color.RED);
		score_lbl.setFont (new Font("Courier", Font.BOLD,20));
		life_lbl.setFont (new Font("Courier", Font.BOLD,20));
		cntrl_btn=new JButton("Play");
		//adding action listener for button
		cntrl_btn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				game_started=true;
				startGame();
			}
		});
		cntrl_pnl=new JPanel();
		cntrl_pnl.add(score_lbl);
		cntrl_pnl.add(life_lbl);
		cntrl_pnl.add(level_lbl);
		cntrl_pnl.add(cntrl_btn);
		this.setLayout(new BorderLayout());
		this.add(cntrl_pnl);





		this.level=level;



	}

	@Override
	public void run() {
		gameRender();
		while(!game_started);
		initiate();

		while(running){

			gameUpdate();
			gameRender();
			paintScreen();
			gameCourse();



			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}


	private void gameCourse() {
		int res=game.gameCourse();

		switch(res){
		case DOT_FOOD_EVENT:
			score_lbl.setText("TOTAL SCORE: "+game.getGameScore());

			break;
		case SPECIAL_FOOD_EVENT:
			score_lbl.setText("TOTAL SCORE: "+game.getGameScore());
			break;
		case LEVEL_OVER_EVENT:
			stopGame();
			level++;
			initiate();		
			level_lbl.setText("level: "+level);
			startGame();
			break;
		case ENEMY_EVENT:
			score_lbl.setText("Game Over: YOU DEAD!");
			level=1;
			level_lbl.setText("level: "+level);
			life_lbl.setText("life: "+(MAX_DEATHS-game.getNumOfDeaths()));
			game_started=false;
			stopGame();
			break;
		}

		score_lbl.repaint();
		life_lbl.repaint();
		level_lbl.repaint();
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
		System.out.println("error loading files");
		Graphics g = null;
			
		screeen = new BufferedImage(Main.win_width, Main.win_height, BufferedImage.OPAQUE);
		g = screeen.createGraphics();
		if(game_started){
		game.draw(g);
		}
		else{
			try {
				GameEngine.playAudio("pacman_beginning.wav");
				File frontLayer_file = new File(new File("src").getAbsolutePath()+ "//logo.png");
				BufferedImage img = null;
				try {
					img = ImageIO.read(frontLayer_file);
				} catch (IOException ex) {
					System.out.println("error loading files");
				}	
				g.drawImage(img, 0, 0, null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	//update game engine
	private void gameUpdate() {

		game.update();
		life_lbl.setText("life: "+(MAX_DEATHS-game.getNumOfDeaths()));
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
			score_lbl.setText("TOTAL SCORE: "+game.getGameScore());
			life_lbl.setText("life: 3");
			addKeyListener(this);
			setFocusable(true);
			requestFocusInWindow();
		

	}
}
