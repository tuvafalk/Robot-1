import java.util.Objects;
/**
 * A point representing a location in {@code (x, y)} coordinate space,
 * specified in integer precision.
 */
public class Position
{
    /**
     * Mutable by design - opt for modifying a position rather
     * than creating a new one.
     */
    private int x;
    private int y;

    /**
     * Constructs and initializes a point at the specified
     * {@code (x, y)} location in the coordinate space
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
    public Position(int x, int y)
    {
       this.x = x;
       this.y = y;
    }

    /**
     * Creates a copy of the given position.
     * @param p The Position to copy
     * @throws NullPointerException If the given position is null.
     */
    public Position(Position p)
    {
      x = p.x;
      y = p.y;
    }

    /**
     * Returns the x-coordinate of this {@code Position}
     * in integer precision.
     *
     * @return the x-coordinate of this {@code Position}
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns the y-coordinate of this {@code Position}
     * in integer precision
     *
     * @return the y-coordinates of this {@code Position}
     */
    public int getY()
    {
        return y;
    }

    /**
     * Sets the x-coordinate of this {@code Position}
     * in integer precision.
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of this {@code Position}
     * in integer precision.
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Returns the position to the south of this {@code Position}
     * in integer precision. The position to the south is the position
     * straight below the given position (y-position +1)
     *
     * @return the position south of this {@code Position}
     */
    public Position getPosToSouth()
    {
        return new Position(x, y+1);
    }

    /**
     * Returns the position to the north of this {@code Position}
     * in integer precision. The position to the north is the position
     * straight above the given position (y-position -1)
     *
     * @return the position north of this {@code Position}
     */
    public Position getPosToNorth()
    {
        return new Position(x, y-1);
    }

    /**
     * Returns the position to the east of this {@code Position}
     * in integer precision. The position to the east is the position
     * straight below the given position (x-position +1)
     *
     * @return the position east of this {@code Position}
     */
    public Position getPosToEast()
    {
        return new Position(x+1, y);
    }

    /**
     * Returns the position to the west of this {@code Position}
     * in integer precision. The position to the west is the position
     * straight below the given position (x-position -1)
     *
     * @return the position west of this {@code Position}
     */
    public Position getPosToWest()
    {
        return new Position(x-1, y);
    }

    /**
     * Returns a String that represents the value of this {@code Position},
     * , "(x, y)"
     * @return a string representation of this {@code Position}.
     */
    @Override
    public String toString ()
    {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns true or false whether the given position {@code Position} is equal
     * to the given object or not.
     * @param o given object.
     * @return a boolean depending on equals status.
     */
    @Override
    public boolean equals(Object o)
    {
        if((o != null) && (o.getClass()==this.getClass()))
        {
            return ((((Position) o).getX() == x) && (((Position) o).getY() == y));
        }

        return false;
    }

    /**
     * Returns the hash value of this position.
     * @return hash code representation of this {@code Position}.
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(x, y);
    }
}

