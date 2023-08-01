package Game.Units;

public class Outlaw extends Game.Units.Infantry {
    public Outlaw(int x, int y, int initiative) {
        super (x, y, initiative + 4, 5, 2, 2, 1);
    }

    @Override
    public String getInfo() {
        return "Outlaw [" + coordinates.x + ", " + coordinates.y + "] HP: " + hp + "/" + max_hp + " " + state;
    }
}
