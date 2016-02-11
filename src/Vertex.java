import java.awt.Point;


public class Vertex {

	public static final int width = 40, height = 40;
	private int x, y, numOfNeighbors;
	private Vertex[] neighbors;
	private int[] direction;

	public Vertex(int x, int y){

		this.x = x;
		this.y = y;

		numOfNeighbors = 0;
		neighbors = new Vertex[4];
		direction = new int[4];

		for(int i = 0; i < direction.length; i++)
			direction[i] = -1;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public Vertex[] getNeighbors(){
		
		return neighbors;
	}
	
	public int[] getDirections(){
		
		/*int[] directions = new int[numOfNeighbors];
		int j = 0;
		
		for(int i = 0; i < direction.length; i++){
			
			if(direction[i] != -1){
				directions[j] = direction[i];
				j++;
			}
		}*/

		return direction;
	}
	
	public Vertex getNeighbor(int dir){
		
		if(dir >= 0 && dir < 4){
			return neighbors[dir];
		}
		
		return null;
	}

	public int getDir(int dir){
		
		if(dir >= 0 && dir < 4){
			return direction[dir];
		}
		
		return -1;
	}

	public void addNeighbor(Vertex v, int dir){

		if(dir >= 0 && dir < 4){
			neighbors[dir] = v;
			direction[dir] = dir;
			numOfNeighbors++;
		}
	}

}
