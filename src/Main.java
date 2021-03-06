/*
 * authors: Gili Mizrahi  302976840
 *          Netanel Gabay 303095228
 *          
 * project: pacman game
 * 
 * Date: 11/02/16 
 */

import javax.swing.JFrame;


public class Main {

	
	public static final int win_width = 976;
	public static final int win_height = 700;       //window size
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setSize(win_width, win_height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		GamePanel panel = new GamePanel(1);
		frame.add(panel);
		frame.setVisible(true);
	}

}
