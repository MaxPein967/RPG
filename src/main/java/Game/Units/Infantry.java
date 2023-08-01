package Game.Units;


import java.util.ArrayList;

public abstract class Infantry extends Game.Units.Hero {
    protected int attacksAmount, attackRange;
    public Infantry(int x, int y, int initiative, int damage, int moveDistance, int attacksAmount, int attackRange) {
        super(x, y, 100, 100, damage, moveDistance, initiative, true);
        this.attacksAmount = attacksAmount;
        this.attackRange = attackRange;
    }

    @Override
    public void step(ArrayList<Game.Units.Hero> enemy, ArrayList<Game.Units.Hero> team) {
        if (!isAlive) return;

        Game.Units.Hero tmp = nearest(enemy);

        if (coordinates.countDistance(tmp.coordinates) <= attackRange) {
            for (int i = 0; i < attacksAmount; i++) {
                tmp.getDamage(damage);
            }
            state = "Attack";
        } else {
            move(tmp.coordinates, team);
            state = "Moving";
        }
    }
}