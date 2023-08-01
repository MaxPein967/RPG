package Game.Units;

public class Spearman extends Game.Units.Infantry {
    public Spearman(int x, int y, int initiative) {
        super(x, y, initiative + 4, 10, 1, 1, 2);
    }

    @Override
    public String getInfo() {
        return "Spearman [" + coordinates.x + ", " + coordinates.y + "] HP: " + hp + "/" + max_hp + " " + state;
    }
}