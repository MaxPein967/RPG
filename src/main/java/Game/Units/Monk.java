package Game.Units;

import java.util.ArrayList;


public class Monk extends Game.Units.Mag {
    public Monk(int x, int y, int initiative, int actionPriority) {
        super(x, y, initiative + 2, 10, 5, 2, actionPriority);
    }

    @Override
    public String getInfo() {
        return "Monk [" + coordinates.x + ", " + coordinates.y + "] mana: " + mana + "/" + 10 + " HP: " + hp + "/" + max_hp + " " + state;
    }

    @Override
    public void step(ArrayList<Game.Units.Hero> enemy, ArrayList<Game.Units.Hero> team) {
        super.step(enemy, team);
        Game.Units.Hero tmpAlly = team.get(0);
        double minAllyHealth = 1;

        if (!isAlive) return;

        for (Game.Units.Hero unit: team) {
            if (unit.hp / unit.max_hp < minAllyHealth && unit.isAlive) {
                minAllyHealth = unit.hp / unit.max_hp;
                tmpAlly = unit;
            }
        }
        if (minAllyHealth < 1 && mana > 0) {
            tmpAlly.getDamage(-damage);
            mana -= 1;
            state = "Healing";

            return;
        }
    }
}
