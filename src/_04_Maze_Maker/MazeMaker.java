package _04_Maze_Maker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class MazeMaker{
	
	private static int width;
	private static int height;
	
	private static Maze maze;
	
	private static Random randGen = new Random();
	private static Stack<Cell> uncheckedCells = new Stack<Cell>();
	
	
	public static Maze generateMaze(int w, int h){
		width = w;
		height = h;
		maze = new Maze(width, height);
		
		//4. select a random cell to start
		int randNumX = randGen.nextInt(width);
		int randNumY = randGen.nextInt(height);
		
		//5. call selectNextPath method with the randomly selected cell
		selectNextPath(maze.joe[randNumX][randNumY]);
		
		return maze;
	}

	//6. Complete the selectNextPathMethod
	private static void selectNextPath(Cell currentCell) {
		Random randy = new Random();
		//A. mark cell as visited
		currentCell.setBeenVisited(true);
		//B. Get an ArrayList of unvisited neighbors using the current cell and the method below
		ArrayList<Cell> unvis = getUnvisitedNeighbors(currentCell);
		//C. if has unvisited neighbors,
		if (unvis.size() > 0) {
			//C1. select one at random.
			int randIndex = randy.nextInt(unvis.size());
			//C2. push it to the stack
			uncheckedCells.push(unvis.get(randIndex));
			//C3. remove the wall between the two cells
			removeWalls(currentCell, unvis.get(randIndex));
			//C4. make the new cell the current cell and mark it as visited
			Cell newCurrentCell = unvis.get(randIndex);
			newCurrentCell.setBeenVisited(true);
			//C5. call the selectNextPath method with the current cell
			selectNextPath(newCurrentCell);
		}
		//D. if all neighbors are visited
		else {
			//D1. if the stack is not empty
			if (uncheckedCells.size() > 0) {
				// D1a. pop a cell from the stack
				Cell temp = uncheckedCells.pop();
				// D1b. make that the current cell
				Cell newCurrentCell = temp;
				// D1c. call the selectNextPath method with the current cell
				selectNextPath(newCurrentCell);
			}
		}
	}

	//7. Complete the remove walls method.
	//   This method will check if c1 and c2 are adjacent.
	//   If they are, the walls between them are removed.
	private static void removeWalls(Cell c1, Cell c2) {
		
		
	}
	
	//8. Complete the getUnvisitedNeighbors method
	//   Any unvisited neighbor of the passed in cell gets added
	//   to the ArrayList
	private static ArrayList<Cell> getUnvisitedNeighbors(Cell c) {
		return null;
	}
}
