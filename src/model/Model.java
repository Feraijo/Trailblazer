package model;

import controller.EventListener;
import model.map.Hill;
import model.map.Mountain;
import model.map.Player;
import model.map.River;

import java.nio.file.Paths;

/**
 * Created by Feraijo on 09.10.2016.
 */
public class Model {
    static final int FIELD_SELL_SIZE = 4;
    private EventListener eventListener;
    private GameObjects gameObjects;
    private int currentLevel = 1;
    private LevelLoader levelLoader = new LevelLoader(Paths.get("src\\res\\levels.txt"));


    public void move(Direction direction){

        Player player = gameObjects.getPlayer();

        if (checkMountainCollision(player, direction)) {
            return;
        }
        if (checkRiverCollision(direction)){
            return;
        }

        int sellSize = FIELD_SELL_SIZE;
        switch (direction) {
            case W:
                player.move(-sellSize, 0);
                break;
            case E:
                player.move(sellSize, 0);
                break;
            case N:
                player.move(0, -sellSize);
                break;
            case S:
                player.move(0, sellSize);
                break;
            case NW:
                player.move(-sellSize, -sellSize);
                break;
            case NE:
                player.move(sellSize, -sellSize);
                break;
            case SE:
                player.move(sellSize, sellSize);
                break;
            case SW:
                player.move(-sellSize, sellSize);
        }

    }

    public boolean checkMountainCollision(CollisionObject gameObject, Direction direction){
        for (Mountain mountain : gameObjects.getMountains()){

            if(gameObject.isCollision(mountain, direction)){
                return true;
            }
        }
        return false;
    }



    public boolean checkRiverCollision(Direction direction){

        Player player = gameObjects.getPlayer();

        // найдем во что уперся игрок
        GameObject stoped = null;
        for (GameObject gameObject: gameObjects.getAll()){
            if (!(gameObject instanceof Player)&&!(gameObject instanceof Hill) && player.isCollision(gameObject, direction)){
                stoped = gameObject;
            }
        }
        //свободное место или дом
        if ((stoped == null)){
            return false;
        }
        if (stoped instanceof River){
            River stopedRiver = (River)stoped;
            if (checkMountainCollision(stopedRiver, direction)){
                return true;
            }
            for (River river : gameObjects.getRivers()){
                if(stopedRiver.isCollision(river, direction)){
                    return true;
                }
            }

        }
        return false;

    }


    public void restart() {
        restartLevel();
    }
    public void restartLevel() {
        this.gameObjects = levelLoader.initLevel();
    }

    public GameObjects getGameObjects() {
        return gameObjects;
    }


    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }
}
