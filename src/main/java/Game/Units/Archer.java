package Game.Units;


public class Archer extends Shooter{
    public Archer(int x, int y, int initiative) {
        super(x, y, initiative + 3, 5, 20, 0);
    }

    @Override
    public String getInfo() {
        return "Archer [" + coordinates.x + ", " + coordinates.y + "] arrows: " + arrows + " HP: " + hp + "/" + max_hp + " " + state;
    }
}
