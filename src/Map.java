import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;


public class Map {

	private final int width = 100, height =100;
	protected Vector<Vertex> graph = new Vector<Vertex>();
	protected Point startPoint;

	public void draw(Graphics g){

		for(int i = 0; i < graph.size(); i++){

			g.drawOval(graph.get(i).getX(), graph.get(i).getY(), Vertex.width, Vertex.height);
		}
	}
	
	public Vector<Vertex> getGraph(){
		
		return graph;
	}

	public Point getStartPoint(){

		return startPoint;
	}
}
