import java.awt.Point;


public class Level1 extends Map {

	public Level1(){
		
		Vertex v1 = new Vertex(100, 100);
		Vertex v2 = new Vertex(200, 100);
		Vertex v3 = new Vertex(300, 100);
		Vertex v4 = new Vertex(200, 400);
		
		v1.addNeighbor(v2, 0);
		v2.addNeighbor(v1, 2);
		
		v2.addNeighbor(v3, 0);
		v3.addNeighbor(v2, 2);
		
		v2.addNeighbor(v4, 3);
		v4.addNeighbor(v2, 1);
		
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		
		setStartPoint();
	}
	
	private void setStartPoint(){

		startPoint = new Point(graph.get(0).getX() + Vertex.width/2 - Pacman.width/2 , graph.get(0).getY() + Vertex.height/2 - Pacman.width/2);

	}
}
