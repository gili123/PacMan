import java.awt.Point;


public class Vertex {

	public static final int width = 80, height = 80;
	private int x, y;
	private Vertex[] neighbors;
	private int[] direction;

	public Vertex(int x, int y){

		this.x = x;
		this.y = y;

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
		}
	}

}
