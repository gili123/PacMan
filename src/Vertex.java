/*
 * class of graph's vertex
 */

import java.awt.Point;


public class Vertex {

	public static final int width = 40, height = 40;   //vertex size
	private int x, y, numOfNeighbors;
	private Vertex[] neighbors;
	private int[] direction;

	//constructor
	public Vertex(int x, int y){

		this.x = x;
		this.y = y;

		numOfNeighbors = 0;
		neighbors = new Vertex[4];
		direction = new int[4];

		for(int i = 0; i < direction.length; i++)
			direction[i] = -1;
	}

	//get vertex's x location
	public int getX(){
		return x;
	}

	//get vertex's y location
	public int getY(){
		return y;
	}
	
	//get vertex's neighbors
	public Vertex[] getNeighbors(){
		
		return neighbors;
	}
	
	//get vertex's directions
	public int[] getDirections(){

		return direction;
	}
	
	//get vertex's neighbor by direction
	public Vertex getNeighbor(int dir){
		
		if(dir >= 0 && dir < 4){
			return neighbors[dir];
		}
		
		return null;
	}

	//get vertex's direction by direction
	public int getDir(int dir){
		
		if(dir >= 0 && dir < 4){
			return direction[dir];
		}
		
		return -1;
	}

	//add new neighbor
	public void addNeighbor(Vertex v, int dir){

		if(dir >= 0 && dir < 4){
			neighbors[dir] = v;
			direction[dir] = dir;
			numOfNeighbors++;
		}
	}
	
	//check if this vertex equal to other vertex 
	public boolean equals(Vertex other){
		
		if(this.x == other.getX() && this.y == other.getY())
			return true;
		
		else
			return false;
	}

}
