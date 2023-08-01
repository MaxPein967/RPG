package Game.Units;

import java.util.ArrayList;
import java.util.Random;

public class WhiteMag extends Game.Units.Mag {
    public WhiteMag(int x, int y, int initiative, int actionPriority) {
        super(x ,y, initiative + 2, 100, 10, 3, actionPriority);
    }

    @Override
    public String getInfo() {
        return "WhiteMage [" + coordinates.x + ", " + coordinates.y + "] mana: " + mana + "/" + 10 + " HP: " + hp + "/" + max_hp + " " + state;
    }

    @Override
    public void step(ArrayList<Game.Units.Hero> enemy, ArrayList<Game.Units.Hero> team) {

        super.step(enemy, team);
        ArrayList<Game.Units.Hero> deadTeammates = new ArrayList<>();
        Game.Units.Hero tmpAlly = team.get(0);
        if (!isAlive) return;
        for (Game.Units.Hero unit: team) {
            if (!unit.isAlive) {
                deadTeammates.add(unit);
            }
        }
        if (deadTeammates.size() > team.size() / 2 - 1 && mana >= 5) {
            int rand = new Random().nextInt(deadTeammates.size() - 1);

            deadTeammates.get(rand).isAlive = true;
            deadTeammates.get(rand).hp = deadTeammates.get(rand).max_hp / 2;
            //tmpAlly.state = "Revived";
            state = "Revive";
            mana = 0;
            return;
        }
    }
}
