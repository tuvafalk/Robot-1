import java.util.ArrayList;
import java.util.Random;

/**
 * A robot that moves randomly throughout a given {@code Maze}.
 * The robot keeps track of its current {@code Position},
 * its previous {@code Position} and the given maze.
 */
public class RandomRobot
{
    private Maze maze;
    private Position previousPos;
    private Position position;

    /**
     * Initializes the robots previous and current position
     * which is the starting {@code Position} since the robot has not moved.
     *
     * @param maze that was constructed in the maze class.
     */
    public RandomRobot(Maze maze)
    {
        this.maze = maze;
        position = maze.getStart();
        previousPos = maze.getStart();
    }

    /**
     * Determines in which directions the robot can legally move and
     * randomises a direction based on the legal moves. The robot may
     * not move to its previous position if it can move in another direction.
     * The robot moves one step at a time and can not move diagonally.
     */
    public void move ()
    {
        ArrayList<String> directions = new ArrayList<>();

        //Adds all possible directions to the list.
        if(maze.isMovable(position.getPosToNorth()) && !(previousPos.equals(position.getPosToNorth())))
        {
            directions.add("North");
        }
        if(maze.isMovable(position.getPosToSouth()) && !(previousPos.equals(position.getPosToSouth())))
        {
            directions.add("South");
        }
        if(maze.isMovable(position.getPosToEast()) && !(previousPos.equals(position.getPosToEast())))
        {
            directions.add("East");
        }
        if(maze.isMovable(position.getPosToWest()) && !(previousPos.equals(position.getPosToWest())))
        {
            directions.add("West");
        }

        //If no other move is possible move back to the previous position.
        if (directions.size() == 0)
        {
            Position temp = new Position(position);
            position = previousPos;
            previousPos = temp;
        }
        //randomise the direction based in the legal moving paths.
        else
        {
            Random random = new Random();
            int direction = random.nextInt(directions.size());
            switch (directions.get(direction)) {
                case "North":
                    previousPos = position;
                    setPosition(position.getPosToNorth());
                    break;
                case "South":
                    previousPos = position;
                    setPosition(position.getPosToSouth());
                    break;
                case "East":
                    previousPos = position;
                    setPosition(position.getPosToEast());
                    break;
                case "West":
                    previousPos = position;
                    setPosition(position.getPosToWest());
                    break;
                default:
            }
        }
    }
    /**
     * Gets and returns the current x and y coordinates of the robot.
     *
     * @return the robots current {@code Position}.
     */
    public Position getPosition()
    {
        return new Position((position.getX()),(position.getY()));
    }

    /**
     * Takes a given {@code Position} and sets it to the robots current {@code Position}.
     *
     * @param p a {@code Position} to place the robot on.
     */
    private void setPosition (Position p)
    {
        position = p;
    }

    /**
     * returns true or false whether the given {@code Position}
     * is a goal or not. The goal is marked with a G in the maze.
     *
     * @return boolean depending on if the given {@code Position} is a goal
     * or not.
     */
    public boolean hasReachedGoal()
    {
        return(maze.isGoal(position));
    }
}