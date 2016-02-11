import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;


public class Map {

	private final int width = 100, height =100;
	protected Vector<Vertex> graph = new Vector<Vertex>();
	protected Point startPoint;
	private int[] x_points, y_points;

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

		/*	for(int i = 0; i < graph.size(); i++){


			g.drawOval(graph.get(i).getX(), graph.get(i).getY(), Vertex.width, Vertex.height);
		}*/
	}


	public Vector<Vertex> getGraph(){

		return graph;
	}

	public Point getStartPoint(){

		return startPoint;
	}
}
