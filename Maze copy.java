import java.util.Scanner;
import java.util.ArrayList;

/**
 * A {@code Maze} represented by walls '*' and ' ' in a coordinate system.
 * 'S' represents the start and 'G' represents the goal.
 */
public class Maze
{
    private ArrayList<ArrayList<Character>> mazeMatrix;
    private Position start;

    /**
     * Takes a file scanner and creates a 2d ArrayList representing the {@code Maze}.
     * Makes sure that the maze contains exactly onestart and at least one goal.
     * Also makes sure that no illegal characters are used in the maze.
     *
     * @param scnr takes the scanner of the mazefile.
     */
    public Maze (Scanner scnr)
    {
        mazeMatrix = new ArrayList<>();
        int numStarts = 0;
        int numGoals = 0;

        //Scan the entire file row by row.
        while (scnr.hasNextLine())
        {
            int rowNum = 0;

            String row = scnr.nextLine();

            ArrayList<Character> mazeRows = new ArrayList<>();

            //Read one character at a time to the mazeRows list.
            for (int i = 0; i < row.length(); i++)
            {
                if (row.charAt(i) == 'S')
                {
                    start = new Position(rowNum, i);
                    numStarts++;
                }
                else if( row.charAt(i) == 'G')
                {
                    numGoals++;
                }
                else if (!((row.charAt(i) == '*') || (row.charAt(i) == ' ') || (row.charAt(i) == 'G')))
                {
                    throw new IllegalArgumentException("Error: The maze may only contain ' ', 'G', 'S' and '*' ");
                }

                mazeRows.add(row.charAt(i));
            }
            rowNum++;
            //Add the ArrayList containing every character in the row to the Matrix.
            mazeMatrix.add(mazeRows);
        }

        if (numGoals < 1)
        {
            throw new IllegalArgumentException("Error: the maze needs to contain atleast one goal (G)");
        }
        if (numStarts != 1)
        {
            throw new IllegalArgumentException("Error: the maze must contain exactly one start");
        }

        scnr.close();
    }

    /**
     * returns the number of rows in the {@code Maze}.
     *
     * @return number of rows to integer precision.
     */
    public int getNumRows()
    {
        return mazeMatrix.size();
    }

    /**
     * returns the maximum number of columns in the {@code Maze}.
     *
     * @return number of columns to integer precision.
     */
    public int getNumColumns()
    {
        int numColumns = 0;
        for (int row = 0 ; row < getNumRows() ; row ++)
        {
            if (mazeMatrix.get(row).size() > numColumns)
            {
                numColumns = mazeMatrix.get(row).size();
            }
        }
        return numColumns;
    }

    /**
     * Prints the {@code Maze} matrix, it should look identical to the txt file.
     */
    public void printMaze()
    {
        //For every row in the maze.
        for(int row = 0; row < mazeMatrix.size(); row++)
        {
            //Print every column on that row.
            for(int col = 0; col < mazeMatrix.get(row).size(); col++)
            {
                System.out.print(mazeMatrix.get(row).get(col));
            }
            System.out.println("");
        }

    }

    /**
     * Returns {@code Position} of the start in a {@code Maze}
     * The start is marked with an S.
     *
     * @return {@code Position} of the start.
     */
    public Position getStart()
    {
        return start;
    }

    /**
     * returns true or false whether the given {@code Position}
     * is a position that the robot is able to move into.
     * The function checks whether the positions index is within the maze and
     * whether the given position is a wall or not. If the position is not a wall
     * and is within the maze the robot is fre to move.
     *
     * @param p position to check if the robot can move into.
     * @return boolean depending on if the given {@code Position} a legal move or not.
     */
    public boolean isMovable(Position p)
    {
        //Check if the position is within the maze.
        if(!(( (p.getX() < 0) || (p.getY() >= getNumRows()) ||
                ((p.getY() < 0) || (p.getX() >= mazeMatrix.get(p.getY()).size())))))
        {
            //Check if the position is a wall.
            return !(mazeMatrix.get(p.getY()).get(p.getX()) == '*');
        }
        else
        {
            return false;
        }
    }

    /**
     * returns true or false whether the given {@code Position}
     * is a goal or not. The goal is marked with a G in the maze.
     *
     * @param p position to check if it is a goal
     * @return boolean depending on if the given {@code Position} is a goal
     * or not.
     */
    public boolean isGoal(Position p)
    {
        return (mazeMatrix.get(p.getY()).get(p.getX()) == 'G');
    }

}