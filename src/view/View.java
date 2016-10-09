package view;

import controller.Controller;
import controller.EventListener;
import model.GameObjects;

import javax.swing.*;

/**
 * Created by Feraijo on 09.10.2016.
 */

public class View extends JFrame {
    private Controller controller;
    private Field field;

    public void update(){
        field.repaint();
    }
    public GameObjects getGameObjects(){
        return controller.getGameObjects();
    }

    public View(Controller controller) {
        this.controller = controller;
    }

    public void completed(int level){
        update();
        JOptionPane.showMessageDialog(null, level + "Completed", "Level", JOptionPane.INFORMATION_MESSAGE);
        controller.startNextLevel();
    }

    public void init() {
        field = new Field(this);
        add(field);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1500, 1000);
        setLocationRelativeTo(null);
        setTitle("Trailblazer");
        setVisible(true);
    }
    public void setEventListener(EventListener eventListener){
        field.setEventListener(eventListener);
    }
}