/*
 * class of the game's map
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;


public class Map {

	private final int width = 100, height = 100;
	private final Color color = Color.BLUE;
	protected Vector<Vertex> graph = new Vector<Vertex>();
	protected Point startPoint;


	protected Vector<Enemy> enemies;
	protected Vector<DotsFood> dFoods;
	protected Vector<SpecialFood> sFoods;
	protected int numOfEnemies,numOfDotsFoods,numOfSpecialFood;




	//default constructor
	public Map(){

	}

	//constructor
	public Map(int numOfEnemies,int numOfSpecialFood){
		this.numOfEnemies=numOfEnemies;
		this.numOfSpecialFood=numOfSpecialFood;

		//enemies
		enemies = new Vector<Enemy>(this.numOfEnemies);
		
		//dotFoods
		dFoods=new Vector<DotsFood>(this.numOfDotsFoods);
		
		//SpecialFoods
		sFoods=new Vector<SpecialFood>(this.numOfSpecialFood);
			

	}


	//get width
	public int getWidth() {
		return width;
	}

	//get height
	public int getHeight() {
		return height;
	}

	//get Enemies vector
	public Vector<Enemy> getEnemies() {
		return enemies;
	}

	//get dot Foods vector
	public Vector<DotsFood> getdFoods() {
		return dFoods;
	}

	//gets special Foods vector
	public Vector<SpecialFood> getsFoods() {
		return sFoods;
	}

	//get Number Of Enemies
	public int getNumOfEnemies() {
		return numOfEnemies;
	}

	//get Number Of Dots Foods
	public int getNumOfDotsFoods() {
		return numOfDotsFoods;
	}

	//get Number Of Special Food
	public int getNumOfSpecialFood() {
		return numOfSpecialFood;
	}

	//set Number Of Enemies
	public void setNumOfEnemies(int numOfEnemies) {
		this.numOfEnemies = numOfEnemies;
	}

	//set Number Of Dots Foods
	public void setNumOfDotsFoods(int numOfDotsFoods) {
		this.numOfDotsFoods = numOfDotsFoods;
	}

	//set Number Of Special Food
	public void setNumOfSpecialFood(int numOfSpecialFood) {
		this.numOfSpecialFood = numOfSpecialFood;
	}




	public void draw(Graphics g){

		Vertex nei;

		g.setColor(color);
		for(int i = 0; i < graph.size(); i++){

			Vertex cur = graph.get(i);
			int[] directions = cur.getDirections();

			for(int j = 0; j < directions.length; j++){

				switch(directions[j]){

				case -1:

					if(j == 0)
						g.drawLine(cur.getX() + Vertex.width, cur.getY(), cur.getX() + Vertex.width, cur.getY() + Vertex.height);

					else if(j == 1)
						g.drawLine(cur.getX(), cur.getY(), cur.getX() + Vertex.width, cur.getY());

					else if(j == 2)
						g.drawLine(cur.getX(), cur.getY(), cur.getX(), cur.getY() + Vertex.height);

					else if(j == 3)
						g.drawLine(cur.getX(), cur.getY() + Vertex.height, cur.getX() + Vertex.width, cur.getY() + Vertex.height);

					break;

				case 0:

					nei = cur.getNeighbor(0);
					g.drawLine(cur.getX() + Vertex.width, cur.getY(), nei.getX(), nei.getY());
					g.drawLine(cur.getX() + Vertex.width, cur.getY() + Vertex.height, nei.getX(), nei.getY() + Vertex.height);
					break;

				case 1:

					nei = cur.getNeighbor(1);
					g.drawLine(cur.getX(), cur.getY(), nei.getX(), nei.getY() + Vertex.height);
					g.drawLine(cur.getX() + Vertex.width, cur.getY(), nei.getX() + Vertex.width, nei.getY() + Vertex.height);

					break;

				case 2:

					nei = cur.getNeighbor(2);
					g.drawLine(cur.getX(), cur.getY(), nei.getX() + Vertex.width, nei.getY());
					g.drawLine(cur.getX(), cur.getY() + Vertex.height, nei.getX() + Vertex.width, nei.getY() + Vertex.height);

					break;

				case 3:

					nei = cur.getNeighbor(3);
					g.drawLine(cur.getX(), cur.getY() + Vertex.height, nei.getX(), nei.getY());
					g.drawLine(cur.getX() + Vertex.width, cur.getY() + Vertex.height, nei.getX() + Vertex.width, nei.getY());

					break;
				}


			}
		}

		//drawing foods && enemies
		//dots food
		for(int i=0;i<dFoods.size();i++)
			dFoods.elementAt(i).drawSprite(g);
		//SpecialFoods
		for(int i=0;i<enemies.size();i++)
			enemies.elementAt(i).drawSprite(g);
		//enemies
		for(int i=0;i<sFoods.size();i++)
			sFoods.elementAt(i).drawSprite(g);

	}


	public Vector<Vertex> getGraph(){

		return graph;
	}

	public Point getStartPoint(){

		return startPoint;
	}
}
