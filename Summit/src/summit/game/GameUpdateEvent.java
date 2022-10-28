package summit.game;

import summit.game.GameMap;

public class GameUpdateEvent{

    GameMap map;

    public GameUpdateEvent(GameMap map){
        this.map = map;
    }
}