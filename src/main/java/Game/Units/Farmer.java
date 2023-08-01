package Game.Units;
import java.util.ArrayList;


public class Farmer extends Mag {

    public Farmer(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative, 0, 0, 1, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Farmer [" + coordinates.x + ", " + coordinates.y + "] HP: " + hp + "/" + max_hp + " " + state;
    }

    @Override
    public void step(ArrayList<Hero> enemy, ArrayList<Hero> team) {
        if (isAlive) {
            if (state == "Busy") {
                state = "Stand";
            }
        }
    }
}