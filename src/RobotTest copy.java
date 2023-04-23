import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RobotTest
{
    public static void main(String[] args) throws IOException
    {
        //Read file and create scanner.
        File mazeFile = new File(args[0]);
        Scanner scnr = new Scanner(mazeFile);

        Maze maze = new Maze(scnr);

        RandomRobot robot = new RandomRobot(maze);
        Position p = new Position(robot.getPosition());

        maze.printMaze();

        //While the robot has not reached goal, continue to move the robot.
        while (!maze.isGoal(p))
        {
            robot.move();

            p = (robot.getPosition());
            System.out.println("the robots position is: " + p);
        }

        System.out.println("The robot has reached a goal!");
    }
}