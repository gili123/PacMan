import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
//this class deals with the performance of the game
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
	
		this.map=new Level1(level);
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


	
	//moves the enemies
	public void update(){

		for(int i = 0; i < enemies.size(); i++)
			enemies.get(i).move();
	}

	
	//this method check if pacman ate dot food
	public boolean isEatingDotsFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(int i=0;i<dFoods.size();i++){
			Rectangle dotBox = dFoods.elementAt(i).getBoundingBox();
			if(pacmanBox.intersects(dotBox)){
				numOfEatenDotsFood++;
				gameScore+=DOT_FOOD_POINTS;
				dFoods.removeElementAt(i);
				try {
					playAudio("pacman_chomp.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}


	
	//this method play a sound file
	public static void playAudio(String audio) throws Exception
	{

		File audioFile = new File(new File("src").getAbsolutePath()+ "//" + audio);

		AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);		  

		AudioFormat format = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(Clip.class, format);
		Clip audioClip = (Clip) AudioSystem.getLine(info);


		audioClip.open(audioStream);
		audioClip.start();
	}




	//this method check if pacman ate special  food
	public boolean isEatingSpecialFood(){
		Rectangle pacmanBox = pacman.getBoundingBox();
		for(SpecialFood s:sFoods){
			Rectangle SpecialFoodBox = s.getBoundingBox();
			if(pacmanBox.intersects(SpecialFoodBox)){
				numOfEatenSpecialFood++;
				gameScore+=SPECIAL_FOOD_POINTS;
				sFoods.remove(s);
				try {
					playAudio("pacman_eatfruit.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}



	//this method check if pacman was killed by an ememy
	public boolean isKilledByEnemy() {
		Rectangle pacmanBox = pacman.getBoundingBox();


		for(int i=0;i<enemies.size();i++){
			Rectangle enemyBox = enemies.elementAt(i).getBoundingBox();
			if(pacmanBox.intersects(enemyBox)){
				numOfDeaths++;
				enemies.remove(i);
				try {
					playAudio("pacman_eatghost.wav");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(numOfDeaths==MAX_DEATHS){
			try {
				playAudio("pacman_death.wav");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return numOfDeaths==MAX_DEATHS;
	}




	//this method checks if level is over
	public boolean isLevelOver(){
		return numOfEatenDotsFood==6;
	}


	
	//this method return enumerator indicating an event
	public int gameCourse() {

		int res = -1;
		if(isLevelOver()){
			res=LEVEL_OVER_EVENT;

		}
		else if(isKilledByEnemy())
			res=ENEMY_EVENT;
		else if(isEatingDotsFood())
			res=DOT_FOOD_EVENT;
		else if(isEatingSpecialFood())
			res=SPECIAL_FOOD_EVENT;
		return res;
	}


	
	
	
	//getters and setters
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
	public int getNumOfDeaths() {
		return numOfDeaths;
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
