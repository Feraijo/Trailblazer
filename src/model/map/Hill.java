package model.map;

import model.GameObject;

import java.awt.*;

/**
 * Created by Feraijo on 06.10.2016.
 */
public class Hill extends GameObject
{
    public Hill(int x, int y)
    {
        super(x, y, 2, 2);
    }

    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.RED);
        int leftUpperCornerX = getX() - getWidth() / 2;
        int leftUpperCornerY = getY() - getHeight() / 2;

        graphics.drawOval(leftUpperCornerX, leftUpperCornerY, getWidth(),getHeight());
        graphics.fillOval(leftUpperCornerX, leftUpperCornerY, getWidth(), getHeight());
    }
}
