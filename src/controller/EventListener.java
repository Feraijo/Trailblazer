package controller;

import model.Direction;

/**
 * Created by Feraijo on 09.10.2016.
 */
public interface EventListener {

    void move(Direction direction);
    void restart();
    void interact();
}