package controller;

import model.Direction;
import model.GameObjects;
import model.Model;
import view.View;

import javax.swing.*;

/**
 * Created by Feraijo on 09.10.2016.
 */
public class Controller implements EventListener {
    private View view;
    private Model model;

    public Controller() {
        model = new Model();
        model.restart();
        model.setEventListener(this);
        view = new View(this);
        view.init();
        view.setEventListener(this);

    }

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    public GameObjects getGameObjects() {
        return model.getGameObjects();
    }

    @Override
    public void move(Direction direction) {
        model.move(direction);
        view.update();
    }

    @Override
    public void restart() {
        model.restart();
        view.update();
    }

    @Override
    public void startNextLevel() {
        model.startNextLevel();
        view.update();
    }

    @Override
    public void levelCompleted(int level) {
        view.completed(level);
    }

    @Override
    public void interact() {
        JOptionPane.showMessageDialog(null, "Interacted", "", JOptionPane.INFORMATION_MESSAGE);
    }
}
