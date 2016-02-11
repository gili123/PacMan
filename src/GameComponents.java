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
	private int numOfEnemies,numOfDotsFoods,numOfSpecialFood;
	private Map map;
	private int level;
	public GameComponents(int numOfDotsFoods,int numOfEnemies,int numOfSpecialFood,int level){
		this.numOfEnemies=numOfEnemies;
		this.numOfDotsFoods=numOfDotsFoods;
		this.numOfSpecialFood=numOfSpecialFood;
		this.level=level;
		switch(level){
		case 1:
			this.map=new Level1();
			break;
		}


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


	public Map getMap() {
		return map;
	}


	public int getLevel() {
		return level;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public void setLevel(int level) {
		this.level = level;
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


	public int getNumOfDotsFoods() {
		return numOfDotsFoods;
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


	public void setNumOfDotsFoods(int numOfDotsFoods) {
		this.numOfDotsFoods = numOfDotsFoods;
	}


	public void setNumOfSpecialFood(int numOfSpecialFood) {
		this.numOfSpecialFood = numOfSpecialFood;
	}
}
