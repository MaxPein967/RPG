package Game.Units;


import java.util.ArrayList;

public interface GameInterface {

    void step(ArrayList<Hero> team1, ArrayList<Hero> team2);
    String getInfo();
}
