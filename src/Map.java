import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;


public class Map {

	private final int width = 100, height =100;
	protected Vector<Vertex> graph = new Vector<Vertex>();
	protected Point startPoint;
	private int[] x_points, y_points;


	protected Vector<Enemy> enemies;
	private Vector<DotsFood> dFoods;
	private Vector<SpecialFood> sFoods;
	protected int numOfEnemies,numOfDotsFoods,numOfSpecialFood;





	public Map(){

	}

	public Map(int numOfDotsFoods,int numOfEnemies,int numOfSpecialFood){
		this.numOfEnemies=numOfEnemies;
		this.numOfDotsFoods=numOfDotsFoods;
		this.numOfSpecialFood=numOfSpecialFood;

		//enemies
		enemies = new Vector<Enemy>(this.numOfEnemies);


			









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










	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[] getX_points() {
		return x_points;
	}

	public int[] getY_points() {
		return y_points;
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

	public void setGraph(Vector<Vertex> graph) {
		this.graph = graph;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public void setX_points(int[] x_points) {
		this.x_points = x_points;
	}

	public void setY_points(int[] y_points) {
		this.y_points = y_points;
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




	public void draw(Graphics g){

		Vertex nei;

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
		for(DotsFood d: dFoods){
			d.drawSprite(g);
		}

		//SpecialFoods
		for(Enemy e: enemies){
			e.drawSprite(g);
		}

		//enemies
		for(SpecialFood s: sFoods){
			s.drawSprite(g);
		}	

	}


	public Vector<Vertex> getGraph(){

		return graph;
	}

	public Point getStartPoint(){

		return startPoint;
	}
}
