package model.map;

import model.CollisionObject;
import model.Movable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Feraijo on 06.10.2016.
 */
public class River extends CollisionObject
{
    private int length;


    private ArrayList<Water> longRiver = new ArrayList<>();
    public River(int x, int y, int seed)
    {
        super(x, y);

        length = random.nextInt(500)+1000;
        int i = 0;
        while (i != length){
            if (i%3 == 0)
                y = y+new Random().nextInt(11+seed)-5+seed;
            longRiver.add(new Water(x+i, y));
            i++;
        }
    }

    public int size(){
        return longRiver.size();
    }
    public ArrayList<Water> getRiver() {
        return longRiver;
    }

    private class Water{
        private int leftUpperCornerX = getX() - getWidth() / 2;
        private int leftUpperCornerY = getY() - getHeight() / 2;

        public Water(int leftUpperCornerX, int leftUpperCornerY) {
            this.leftUpperCornerX = leftUpperCornerX;
            this.leftUpperCornerY = leftUpperCornerY;
        }
    }
    public int getWaterX(int num){
        return longRiver.get(num).leftUpperCornerX;
    }
    public int getWaterY(int num){
        return longRiver.get(num).leftUpperCornerY;
    }



    @Override
    public void draw(Graphics graphics)
    {
        graphics.setColor(new Color(0, 100, 150));

        for (Water w : longRiver){
            graphics.drawRect(w.leftUpperCornerX, w.leftUpperCornerY, getWidth(), getHeight());
            graphics.fillRect(w.leftUpperCornerX, w.leftUpperCornerY, getWidth(), getHeight());
        }


    }
}
