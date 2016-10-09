package view;

import controller.EventListener;
import model.Direction;
import model.GameObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;


/**
 * Created by Feraijo on 09.10.2016.
 */
public class Field extends JPanel
{
    private EventListener eventListener;
    private View view;

    public Field(View view)
    {
        this.view = view;
        this.addKeyListener(new KeyHandler());
        this.setFocusable(true);
    }
    public void paint(Graphics g){
        g.setColor(new Color(75,150,0));
        g.fillRect(0, 0, 1500,1000);
        Set<GameObject> gameObjectSet = view.getGameObjects().getAll();

        for (GameObject gameObject : gameObjectSet) {
            gameObject.draw(g);
        }

    }


    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e)
        {

            switch (e.getKeyCode()){
                case (KeyEvent.VK_NUMPAD4):
                    eventListener.move(Direction.W);
                    break;
                case (KeyEvent.VK_NUMPAD6):
                    eventListener.move(Direction.E);
                    break;
                case (KeyEvent.VK_NUMPAD8):
                    eventListener.move(Direction.N);
                    break;
                case (KeyEvent.VK_NUMPAD2):
                    eventListener.move(Direction.S);
                    break;
                case (KeyEvent.VK_NUMPAD7):
                    eventListener.move(Direction.NW);
                    break;
                case (KeyEvent.VK_NUMPAD9):
                    eventListener.move(Direction.NE);
                    break;
                case (KeyEvent.VK_NUMPAD3):
                    eventListener.move(Direction.SE);
                    break;
                case (KeyEvent.VK_NUMPAD1):
                    eventListener.move(Direction.SW);
                    break;
                case (KeyEvent.VK_NUMPAD5):
                    eventListener.interact();
                    break;
                case (KeyEvent.VK_R):
                    eventListener.restart();
                    break;
            }
        }
    }


}
