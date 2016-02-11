import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;

public class GameEngine {

	private Pacman pacman;
	private Vector<Enemy> enemies;
	private Vector<DotsFood> dFoods;
	private Vector<SpecialFood> sFoods;
	private int numOfEnemies,numOfDotsFoods,numOfSpecialFood;
	private Map map;
	private int level;
	private int numOfEatenDotsFood;
	private int numOfEatenSpecialFood;



	public GameEngine(int numOfDotsFoods,int numOfEnemies,int numOfSpecialFood,int level){

		numOfEatenDotsFood=0;
		numOfEatenSpecialFood=0;
		this.numOfEnemies=numOfEnemies;
		this.numOfDotsFoods=numOfDotsFoods;
		this.numOfSpecialFood=numOfSpecialFood;
		this.level=level;
		switch(level){
		case 1:
			this.map=new Level1();
			Point start = map.getStartPoint();
			pacman=new Pacman(start.x,start.y);
			pacman.setGraph(map.getGraph());
			break;
		}


		//enemies
		enemies=new Vector<Enemy>(this.numOfEnemies);
		//getting the image of an enemy
		//File file1 = new File(new File(".").getAbsolutePath()+ "//enemy.png");
		File file1 = new File(new File("src").getAbsolutePath()+ "//enemy.png");
		BufferedImage img1 = null;
		try {
			img1 = ImageIO.read(file1);
			//setting enemies icons
			for(int i=0;i<this.numOfEnemies;i++){
				enemies.add(new Enemy(0, 0, img1));
			}	

		} catch (IOException ex) {
			System.out.println("error loading files");
		}	




		//SpecialFoods
		sFoods=new Vector<SpecialFood>(this.numOfSpecialFood);
		//getting the image of an enemy
		File file2 = new File(new File("src").getAbsolutePath()+ "//food.png");
		//File file2 = new File(new File(".").getAbsolutePath()+ "//food.png");
		BufferedImage img2 = null;
		try {
			img2 = ImageIO.read(file2);
			//setting enemies icons
			for(int i=0;i<this.numOfSpecialFood;i++){
				sFoods.add(new SpecialFood(0, 0, img2));
			}	

		} catch (IOException ex) {
			System.out.println("error loading files");
		}	



		//dots food
		dFoods=new Vector<DotsFood>(this.numOfDotsFoods);
		for(int i=0;i<this.numOfDotsFoods;i++){
			dFoods.add(new DotsFood(0, 0, img2));
		}

	}




	public void isEatingDotsFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(DotsFood d:dFoods){
			Rectangle dotBox = d.getBoundingBox();
			if(pacmanBox.intersects(dotBox))
				numOfEatenDotsFood++;
		}
	}
	
	
	
	public void isEatingSpecialFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(SpecialFood s:sFoods){
			Rectangle SpecialFoodBox = s.getBoundingBox();
			if(pacmanBox.intersects(SpecialFoodBox))
				numOfEatenSpecialFood++;
		}
	}
	
	
	
	
	public boolean isKilledByEnemy(){
		boolean bool=false;
		Rectangle pacmanBox = pacman.getBoundingBox();

		for(Enemy e:enemies){
			Rectangle enemyBox = e.getBoundingBox();
			if(pacmanBox.intersects(enemyBox))
				return true;
		}

		return bool;
	}

	
	
	
	public boolean isLevelOver(){
		return numOfEatenDotsFood==numOfDotsFoods;
	}


	
	
	
	public Pacman getPacman() {
		return pacman;
	}


	public void draw(Graphics g){
		//dots food
		for(DotsFood d: dFoods){
			d.drawSprite(g);
		}

		//SpecialFoods
		for(Enemy e: enemies){
			e.drawSprite(g);
		}

		//enemies
		for(Enemy e: enemies){
			e.drawSprite(g);
		}	
		pacman.drawSprite(g);
		map.draw(g);
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




	public Map getMap() {
		return map;
	}




	public int getLevel() {
		return level;
	}




	public int getNumOfEatenDotsFood() {
		return numOfEatenDotsFood;
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




	public void setMap(Map map) {
		this.map = map;
	}




	public void setLevel(int level) {
		this.level = level;
	}




	public void setNumOfEatenDotsFood(int numOfEatenDotsFood) {
		this.numOfEatenDotsFood = numOfEatenDotsFood;
	}





}
