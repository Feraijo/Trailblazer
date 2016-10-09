package model;

import model.map.Hill;
import model.map.Mountain;
import model.map.Player;
import model.map.River;

import java.nio.file.Path;

import java.util.HashSet;


/**
 * Created by Feraijo on 06.10.2016.
 */
public class LevelLoader
{
    private Path levels;

    public LevelLoader(Path levels)
    {
        this.levels = levels;
    }

    public GameObjects initLevel(){

        HashSet<Mountain> mountains = new HashSet<>();
        HashSet<River> rivers = new HashSet<>();
        HashSet<Hill> hills = new HashSet<>();
        Player player = null;
        int cellSize = Model.FIELD_SELL_SIZE;
        int x0 = cellSize / 2;
        int y0 = cellSize / 2;

        player = new Player(x0 + cellSize, y0 + 500);


        return new GameObjects(mountains, rivers, hills, player);
    }
}
