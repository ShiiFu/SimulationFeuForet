package foret;

import java.util.Random;

public class Position
{
    private int x;
    private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public static Position random()
    {
        Random random = new Random();
        int x = random.nextInt(Foret.hauteur);
        int y = random.nextInt(Foret.largeur);
        return new Position(x, y);
    }
}
