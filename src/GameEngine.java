import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

public class GameEngine {

	private GameComponents comps;
	private int numOfEatenDotsFood;
	public GameEngine(){
		comps=new GameComponents(1, 1,1,1);
		numOfEatenDotsFood=0;
	}


	public void isEatingDotsFood(){
		Vector<DotsFood> dFood=comps.getdFoods();
		Pacman pacman=comps.getPacman();
		Rectangle pacmanBox = pacman.getBoundingBox();
		
		
		for(DotsFood d:dFood){
			Rectangle dotBox = d.getBoundingBox();
			if(pacmanBox.intersects(dotBox))
				numOfEatenDotsFood++;
		}

		
		
	}
	public boolean isKilledByEnemy(){
		boolean bool=false;
		Pacman pacman=comps.getPacman();
		Rectangle pacmanBox = pacman.getBoundingBox();
		
		Vector<Enemy> enemies=comps.getEnemies();
		for(Enemy e:enemies){
			Rectangle enemyBox = e.getBoundingBox();
			if(pacmanBox.intersects(enemyBox))
				return true;
		}

		return bool;
	}
	public Point getStartPoint(){
		return comps.getMap().getStartPoint();
	}
	public boolean isLevelOver(){
		return numOfEatenDotsFood==comps.getNumOfDotsFoods();
	}

}
