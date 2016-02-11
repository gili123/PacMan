import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class GameComponents {
	private Pacman pacman;
	private Vector<Enemy> enemies;
	private Vector<DotsFood> dFoods;
	private Vector<SpecialFood> sFoods;
	private int numOfEnemies,numOfFoods,numOfSpecialFood;


	public GameComponents(int numOfFoods,int numOfEnemies,int numOfSpecialFood){
		this.numOfEnemies=numOfEnemies;
		this.numOfFoods=numOfFoods;
		this.numOfSpecialFood=numOfSpecialFood;



		//enemies
		enemies=new Vector<Enemy>(this.numOfEnemies);
		//getting the image of an enemy
		File file1 = new File(new File(".").getAbsolutePath()+ "//enemy.png");
		BufferedImage img1 = null;
		try {
			img1 = ImageIO.read(file1);
			//setting enemies icons
			for(Enemy e: enemies){
				e=new Enemy(0, 0, img1);
			}	

		} catch (IOException ex) {
			System.out.println("error loading files");
		}	
	



		//SpecialFoods
		sFoods=new Vector<SpecialFood>(this.numOfSpecialFood);
		//getting the image of an enemy
		File file2 = new File(new File(".").getAbsolutePath()+ "//food.png");
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(file2);
			//setting enemies icons
			for(SpecialFood f: sFoods){
				f=new SpecialFood(0, 0, img2);
			}

		} catch (IOException ex) {
			System.out.println("error loading files");
		}	
	

		
		//dots food
		for(DotsFood d: dFoods){
			d=new DotsFood(0, 0, null);
		}

	}


	public Pacman getPacman() {
		return pacman;
	}


	public Vector<Enemy> getEnemies() {
		return enemies;
	}


	public Vector<DotsFood> getdFoods() {
		return dFoods;
	}


	public Vector<SpecialFood> getsFoods() {
		return sFoods;
	}


	public int getNumOfEnemies() {
		return numOfEnemies;
	}


	public int getNumOfFoods() {
		return numOfFoods;
	}


	public int getNumOfSpecialFood() {
		return numOfSpecialFood;
	}


	public void setPacman(Pacman pacman) {
		this.pacman = pacman;
	}


	public void setEnemies(Vector<Enemy> enemies) {
		this.enemies = enemies;
	}


	public void setdFoods(Vector<DotsFood> dFoods) {
		this.dFoods = dFoods;
	}


	public void setsFoods(Vector<SpecialFood> sFoods) {
		this.sFoods = sFoods;
	}


	public void setNumOfEnemies(int numOfEnemies) {
		this.numOfEnemies = numOfEnemies;
	}


	public void setNumOfFoods(int numOfFoods) {
		this.numOfFoods = numOfFoods;
	}


	public void setNumOfSpecialFood(int numOfSpecialFood) {
		this.numOfSpecialFood = numOfSpecialFood;
	}
}
