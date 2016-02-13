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
	private Map map;
	private int level;
	private int numOfEatenDotsFood;
	private int numOfEatenSpecialFood;
	private int numOfDeaths;
	private Vector<Enemy> enemies;
	private Vector<DotsFood> dFoods;
	private Vector<SpecialFood> sFoods;
	private int numOfEnemies,numOfDotsFoods,numOfSpecialFood;
	public final static int DOT_FOOD_EVENT=0,SPECIAL_FOOD_EVENT=1,LEVEL_OVER_EVENT=2,ENEMY_EVENT=3;
	public final static int DOT_FOOD_POINTS=1,SPECIAL_FOOD_POINTS=5,MAX_DEATHS=3;
	
	private int gameScore;
	
	public GameEngine(int level){

		numOfEatenDotsFood=0;
		numOfEatenSpecialFood=0;
		gameScore=0;
		numOfDeaths=0;
		
		
		
		this.level=level;
		switch(level){
		case 1:
			this.map=new Level1();
			break;
		}
		Point start = map.getStartPoint();
		pacman=new Pacman(start.x,start.y);
		pacman.setGraph(map.getGraph());
		enemies=map.getEnemies();
		dFoods=map.getdFoods();
		sFoods=map.getsFoods();
		numOfEnemies=map.getNumOfEnemies();
		numOfDotsFoods=map.getNumOfDotsFoods();
		numOfSpecialFood=map.getNumOfSpecialFood();	

	}


	public void update(){
		
		for(int i = 0; i < enemies.size(); i++)
			enemies.get(i).move();
	}

	public boolean isEatingDotsFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(DotsFood d:dFoods){
			Rectangle dotBox = d.getBoundingBox();
			if(pacmanBox.intersects(dotBox)){
				numOfEatenDotsFood++;
				gameScore+=DOT_FOOD_POINTS;
				return true;
			}
		}
		return false;
	}
	
	
	
	public boolean isEatingSpecialFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(SpecialFood s:sFoods){
			Rectangle SpecialFoodBox = s.getBoundingBox();
			if(pacmanBox.intersects(SpecialFoodBox)){
				numOfEatenSpecialFood++;
				gameScore+=SPECIAL_FOOD_POINTS;
				return true;
			}
		}
		return false;
	}
	
	
	
	
	public boolean isKilledByEnemy(){
		
		Rectangle pacmanBox = pacman.getBoundingBox();

		for(Enemy e:enemies){
			Rectangle enemyBox = e.getBoundingBox();
			if(pacmanBox.intersects(enemyBox)){
				numOfDeaths++;
			}
		}

		return numOfDeaths==MAX_DEATHS;
	}

	
	
	
	public boolean isLevelOver(){
		return numOfEatenDotsFood==numOfDotsFoods;
	}


	public int gameCourse(){
		int res = -1;
		if(isLevelOver())
			res=LEVEL_OVER_EVENT;
		else if(isKilledByEnemy())
			res=ENEMY_EVENT;
		else if(isEatingDotsFood())
			res=DOT_FOOD_EVENT;
		else if(isEatingSpecialFood())
			res=SPECIAL_FOOD_EVENT;
		return res;
	}
	
	
	public Pacman getPacman() {
		return pacman;
	}


	public void draw(Graphics g){
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


	public int getGameScore() {
		return gameScore;
	}


	public void setGameScore(int gameScore) {
		this.gameScore = gameScore;
	}





}
