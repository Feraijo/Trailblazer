package model.map;

import model.CollisionObject;
import model.Movable;

import java.awt.*;

/**
 * Created by Feraijo on 06.10.2016.
 */
public class Player extends CollisionObject implements Movable
{
    public Player(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void move(int x, int y)
    {
        this.setX(this.getX()+x);
        this.setY(this.getY()+y);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth()*2, getHeight()*2);
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth()*2, getHeight()*2);

    }
}
