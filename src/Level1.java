/*
 * class of level 1 at the game
 */

import java.awt.Point;


public class Level1 extends Map {

	//constructor
	public Level1(){

		super(5, 1);

		numOfDotsFoods = 0;

		/*******************create vertexes***************************/
		
		Vertex v11 = new Vertex(100, 30);
		Vertex v12 = new Vertex(250, 30);
		Vertex v13 = new Vertex(400, 30);
		Vertex v14 = new Vertex(500, 30);
		Vertex v15 = new Vertex(650, 30);
		Vertex v16 = new Vertex(800, 30);

		Vertex v21 = new Vertex(100, 110);
		Vertex v22 = new Vertex(250, 110);
		Vertex v23 = new Vertex(315, 110);
		Vertex v24 = new Vertex(400, 110);
		Vertex v25 = new Vertex(500, 110);
		Vertex v26 = new Vertex(575, 110);
		Vertex v27 = new Vertex(650, 110);
		Vertex v28 = new Vertex(800, 110);

		Vertex v31 = new Vertex(100, 170);
		Vertex v32 = new Vertex(250, 170);
		Vertex v33 = new Vertex(315, 170);
		Vertex v34 = new Vertex(400, 170);
		Vertex v35 = new Vertex(500, 170);
		Vertex v36 = new Vertex(575, 170);
		Vertex v37 = new Vertex(650, 170);
		Vertex v38 = new Vertex(800, 170);

		Vertex v41 = new Vertex(315, 230);
		Vertex v42 = new Vertex(400, 230);
		Vertex v43 = new Vertex(500, 230);
		Vertex v44 = new Vertex(575, 230);

		Vertex v51 = new Vertex(250, 300);
		Vertex v52 = new Vertex(315, 300);
		Vertex v53 = new Vertex(575, 300);
		Vertex v54 = new Vertex(650, 300);

		Vertex v61 = new Vertex(315, 370);
		Vertex v62 = new Vertex(575, 370);

		Vertex v71 = new Vertex(100, 430);
		Vertex v72 = new Vertex(250, 430);
		Vertex v73 = new Vertex(315, 430);
		Vertex v74 = new Vertex(400, 430);
		Vertex v75 = new Vertex(500, 430);
		Vertex v76 = new Vertex(575, 430);
		Vertex v77 = new Vertex(650, 430);
		Vertex v78 = new Vertex(800, 430);

		Vertex v81 = new Vertex(100, 490);
		Vertex v82 = new Vertex(175, 490);
		Vertex v83 = new Vertex(250, 490);
		Vertex v84 = new Vertex(315, 490);
		Vertex v85 = new Vertex(400, 490);
		Vertex v86 = new Vertex(500, 490);
		Vertex v87 = new Vertex(575, 490);
		Vertex v88 = new Vertex(650, 490);
		Vertex v89 = new Vertex(725, 490);
		Vertex v810 = new Vertex(800, 490);

		Vertex v91 = new Vertex(100, 550);
		Vertex v92 = new Vertex(175, 550);
		Vertex v93 = new Vertex(250, 550);
		Vertex v94 = new Vertex(315, 550);
		Vertex v95 = new Vertex(575, 550);
		Vertex v96 = new Vertex(650, 550);
		Vertex v97 = new Vertex(725, 550);
		Vertex v98 = new Vertex(800, 550);

		/***********************************create neighbors******************************/
		
		v11.addNeighbor(v12, 0);
		v12.addNeighbor(v11, 2);
		v12.addNeighbor(v13, 0);
		v13.addNeighbor(v12, 2);	
		v14.addNeighbor(v15, 0);
		v15.addNeighbor(v14, 2);
		v15.addNeighbor(v16, 0);
		v16.addNeighbor(v15, 2);

		v11.addNeighbor(v21, 3);
		v21.addNeighbor(v11, 1);
		v12.addNeighbor(v22, 3);
		v22.addNeighbor(v12, 1);
		v13.addNeighbor(v24, 3);
		v24.addNeighbor(v13, 1);
		v14.addNeighbor(v25, 3);
		v25.addNeighbor(v14, 1);	
		v15.addNeighbor(v27, 3);
		v27.addNeighbor(v15, 1);	
		v16.addNeighbor(v28, 3);
		v28.addNeighbor(v16, 1);
		v21.addNeighbor(v22, 0);
		v22.addNeighbor(v21, 2);
		v22.addNeighbor(v23, 0);
		v23.addNeighbor(v22, 2);
		v23.addNeighbor(v24, 0);
		v24.addNeighbor(v23, 2);
		v24.addNeighbor(v25, 0);
		v25.addNeighbor(v24, 2);	
		v25.addNeighbor(v26, 0);
		v26.addNeighbor(v25, 2);
		v26.addNeighbor(v27, 0);
		v27.addNeighbor(v26, 2);
		v27.addNeighbor(v28, 0);
		v28.addNeighbor(v27, 2);
		v31.addNeighbor(v21, 1);
		v21.addNeighbor(v31, 3);
		v32.addNeighbor(v22, 1);
		v22.addNeighbor(v32, 3);
		v33.addNeighbor(v23, 1);
		v23.addNeighbor(v33, 3);
		v36.addNeighbor(v26, 1);
		v26.addNeighbor(v36, 3);	
		v37.addNeighbor(v27, 1);
		v27.addNeighbor(v37, 3);
		v38.addNeighbor(v28, 1);
		v28.addNeighbor(v38, 3);	
		v31.addNeighbor(v32, 0);
		v32.addNeighbor(v31, 2);	
		v33.addNeighbor(v34, 0);
		v34.addNeighbor(v33, 2);	
		v35.addNeighbor(v36, 0);
		v36.addNeighbor(v35, 2);
		v37.addNeighbor(v38, 0);
		v38.addNeighbor(v37, 2);
		v42.addNeighbor(v34, 1);
		v34.addNeighbor(v42, 3);
		v43.addNeighbor(v35, 1);
		v35.addNeighbor(v43, 3);	
		v41.addNeighbor(v42, 0);
		v42.addNeighbor(v41, 2);	
		v42.addNeighbor(v43, 0);
		v43.addNeighbor(v42, 2);
		v43.addNeighbor(v44, 0);
		v44.addNeighbor(v43, 2);
		v51.addNeighbor(v32, 1);
		v32.addNeighbor(v51, 3);
		v52.addNeighbor(v41, 1);
		v41.addNeighbor(v52, 3);
		v53.addNeighbor(v44, 1);
		v44.addNeighbor(v53, 3);
		v54.addNeighbor(v37, 1);
		v37.addNeighbor(v54, 3);
		v51.addNeighbor(v52, 0);
		v52.addNeighbor(v51, 2);
		v53.addNeighbor(v54, 0);
		v54.addNeighbor(v53, 2);
		v61.addNeighbor(v52, 1);
		v52.addNeighbor(v61, 3);	
		v62.addNeighbor(v53, 1);
		v53.addNeighbor(v62, 3);
		v61.addNeighbor(v62, 0);
		v62.addNeighbor(v61, 2);	
		v72.addNeighbor(v51, 1);
		v51.addNeighbor(v72, 3);
		v73.addNeighbor(v61, 1);
		v61.addNeighbor(v73, 3);	
		v76.addNeighbor(v62, 1);
		v62.addNeighbor(v76, 3);
		v77.addNeighbor(v54, 1);
		v54.addNeighbor(v77, 3);
		v71.addNeighbor(v72, 0);
		v72.addNeighbor(v71, 2);
		v72.addNeighbor(v73, 0);
		v73.addNeighbor(v72, 2);
		v73.addNeighbor(v74, 0);
		v74.addNeighbor(v73, 2);
		v75.addNeighbor(v76, 0);
		v76.addNeighbor(v75, 2);
		v76.addNeighbor(v77, 0);
		v77.addNeighbor(v76, 2);
		v77.addNeighbor(v78, 0);
		v78.addNeighbor(v77, 2);

		v81.addNeighbor(v71, 1);
		v71.addNeighbor(v81, 3);
		v83.addNeighbor(v72, 1);
		v72.addNeighbor(v83, 3);
		v85.addNeighbor(v74, 1);
		v74.addNeighbor(v85, 3);
		v86.addNeighbor(v75, 1);
		v75.addNeighbor(v86, 3);
		v88.addNeighbor(v77, 1);
		v77.addNeighbor(v88, 3);
		v810.addNeighbor(v78, 1);
		v78.addNeighbor(v810, 3);

		v81.addNeighbor(v82, 0);
		v82.addNeighbor(v81, 2);
		v83.addNeighbor(v84, 0);
		v84.addNeighbor(v83, 2);
		v84.addNeighbor(v85, 0);
		v85.addNeighbor(v84, 2);
		v85.addNeighbor(v86, 0);
		v86.addNeighbor(v85, 2);
		v86.addNeighbor(v87, 0);
		v87.addNeighbor(v86, 2);
		v87.addNeighbor(v88, 0);
		v88.addNeighbor(v87, 2);
		v89.addNeighbor(v810, 0);
		v810.addNeighbor(v89, 2);

		v92.addNeighbor(v82, 1);
		v82.addNeighbor(v92, 3);
		v93.addNeighbor(v83, 1);
		v83.addNeighbor(v93, 3);
		v94.addNeighbor(v84, 1);
		v84.addNeighbor(v94, 3);
		v95.addNeighbor(v87, 1);
		v87.addNeighbor(v95, 3);
		v96.addNeighbor(v88, 1);
		v88.addNeighbor(v96, 3);
		v97.addNeighbor(v89, 1);
		v89.addNeighbor(v97, 3);
		v91.addNeighbor(v92, 0);
		v92.addNeighbor(v91, 2);
		v92.addNeighbor(v93, 0);
		v93.addNeighbor(v92, 2);
		v93.addNeighbor(v94, 0);
		v94.addNeighbor(v93, 2);
		v94.addNeighbor(v95, 0);
		v95.addNeighbor(v94, 2);
		v95.addNeighbor(v96, 0);
		v96.addNeighbor(v95, 2);
		v96.addNeighbor(v97, 0);
		v97.addNeighbor(v96, 2);
		v97.addNeighbor(v98, 0);
		v98.addNeighbor(v97, 2);

		/******************************add vertexes to the graph*********************************/
		
		graph.add(v11);
		graph.add(v12);
		graph.add(v13);
		graph.add(v14);
		graph.add(v15);
		graph.add(v16);

		graph.add(v21);
		graph.add(v22);
		graph.add(v23);
		graph.add(v24);
		graph.add(v25);
		graph.add(v26);
		graph.add(v27);
		graph.add(v28);

		graph.add(v31);
		graph.add(v32);
		graph.add(v33);
		graph.add(v34);
		graph.add(v35);
		graph.add(v36);
		graph.add(v37);
		graph.add(v38);

		graph.add(v41);
		graph.add(v42);
		graph.add(v43);
		graph.add(v44);

		graph.add(v51);
		graph.add(v52);
		graph.add(v53);
		graph.add(v54);

		graph.add(v61);
		graph.add(v62);

		graph.add(v71);
		graph.add(v72);
		graph.add(v73);
		graph.add(v74);
		graph.add(v75);
		graph.add(v76);
		graph.add(v77);
		graph.add(v78);

		graph.add(v81);
		graph.add(v82);
		graph.add(v83);
		graph.add(v84);
		graph.add(v85);
		graph.add(v86);
		graph.add(v87);
		graph.add(v88);
		graph.add(v89);
		graph.add(v810);

		graph.add(v91);
		graph.add(v92);
		graph.add(v93);
		graph.add(v94);
		graph.add(v95);
		graph.add(v96);
		graph.add(v97);
		graph.add(v98);

		setStartPoint();

		/*********************************set foods locations*************************/
		
		setDotFood(v31, v32, 0);
		setDotFood(v37, v38, 0);
		setDotFood(v71, v72, 0);
		setDotFood(v77, v78, 0);
		setDotFood(v94, v95, 0);
		setDotFood(v41, v42, 0);
		setDotFood(v43, v44, 0);
		setDotFood(v82, v92, 3);
		setDotFood(v89, v97, 3);
		setDotFood(v16, v28, 3);
		setDotFood(v26, v36, 3);
		setDotFood(v23, v33, 3);
		setDotFood(v61, v62, 0);
		setDotFood(v11, v21, 3);

		SpecialFood sf = new SpecialFood((v98.getX() + Vertex.width/2) - (SpecialFood.width/2), (v98.getY() + Vertex.height/2) - (SpecialFood.height/2));
		sFoods.add(sf);
		
		//add enemies
		for(int i = 0; i < this.numOfEnemies; i++){
			Enemy newEnemy = new Enemy((400 + Vertex.width/2) - (Enemy.width/2), (230 + Vertex.height/2) - (Enemy.height/2), v42);
			enemies.add(newEnemy);
		}
	}

	//set pacman start point on the graph
	private void setStartPoint(){

		startPoint = new Point(graph.get(0).getX() + Vertex.width/2 - Pacman.width/2 , graph.get(0).getY() + Vertex.height/2 - Pacman.width/2);

	}

	//add foods from vertex v1 to vertex v2
	private void setDotFood(Vertex v1, Vertex v2, int dir){

		DotsFood food;

		if(dir == 0){
			if(v1.getDir(0) != -1)
				if(v1.getNeighbor(0).equals(v2)){

					int x_loc = (v1.getX() + Vertex.width/2) - (DotsFood.width/2);
					int y_loc = (v1.getY() + Vertex.height/2) - (DotsFood.height/2);
					int end = (v2.getX() + Vertex.width/2) - (DotsFood.width/2);

					while(x_loc <= end){

						food = new DotsFood(x_loc, y_loc);
						dFoods.add(food);
						numOfDotsFoods++;

						x_loc += DotsFood.width * 3;
					}

				}
		}

		else if(dir == 3){

			 if(v1.getDir(3) != -1)
				if(v1.getNeighbor(3).equals(v2)){

					int x_loc = (v1.getX() + Vertex.width/2) - (DotsFood.width/2);
					int y_loc = (v1.getY() + Vertex.height/2) - (DotsFood.height/2);
					int end = (v2.getY() + Vertex.height/2) - (DotsFood.height/2);

					while(y_loc <= end){

						food = new DotsFood(x_loc, y_loc);
						dFoods.add(food);
						numOfDotsFoods++;

						y_loc += DotsFood.height * 3;
					}
				}
		}
	}
}
