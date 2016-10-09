package model;

import model.map.Hill;
import model.map.Mountain;
import model.map.Player;
import model.map.River;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Feraijo on 06.10.2016.
 */
public class GameObjects
{
    private Set<Mountain> mountains;
    private Set<River> rivers;
    private Set<Hill> hills;
    private Player player;
    public Set<GameObject> getAll(){
        Set<GameObject> allObjs = new HashSet<>();
        allObjs.addAll(mountains);
        allObjs.addAll(rivers);
        allObjs.addAll(hills);
        allObjs.add(player);
        return allObjs;
    }

    public GameObjects(Set<Mountain> mountains, Set<River> rivers, Set<Hill> hills, Player player)
    {
        this.mountains = mountains;
        this.rivers = rivers;
        this.hills = hills;
        this.player = player;
    }

    public Set<Mountain> getMountains()
    {
        return mountains;
    }

    public Set<River> getRivers()
    {
        return rivers;
    }

    public Set<Hill> getHills()
    {
        return hills;
    }

    public Player getPlayer()
    {
        return player;
    }
}
