package Game;

import Game.Units.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<Hero> team1 = new ArrayList<>();
    public static ArrayList<Hero> team2 = new ArrayList<>();
    public static ArrayList<Hero> allTeam = new ArrayList<>();

    public static void main(String[] args) {

        int teamCount = 10;
        boolean sortedInitiative = false;
        Random rand = new Random();

        for (int i = 0; i < teamCount; i++) {
            int val = rand.nextInt(7);
            addRandomUnit(val, i, team1, 1);

            val = rand.nextInt(7);
            addRandomUnit(val, i, team2, 10);
        }

        while (!sortedInitiative) {
            sortedInitiative = true;
            for (int i = 0; i < team1.size() - 1; i++) {
                if (team1.get(i).initiative < team1.get(i + 1).initiative) {
                    Collections.swap(team1, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }

        sortedInitiative = false;

        while (!sortedInitiative) {
            sortedInitiative = true;
            for (int i = 0; i < team2.size() - 1; i++) {
                if (team2.get(i).initiative < team2.get(i + 1).initiative) {
                    Collections.swap(team2, i, i + 1);
                    sortedInitiative = false;
                }
            }
        }
        allTeam.addAll(team1);
        allTeam.addAll(team2);

        View.view();

        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            String message = " ";

            int init1 = 0, init2 = 0;
            Hero tmpTeam1 = team1.get(init1);
            Hero tmpTeam2 = team2.get(init2);

            for (int i = 0; i < teamCount * 2; i++) {
                if (isTeamDie(team1)) {
                    message = "Team 2 win!";
                    break;
                }
                if (isTeamDie(team2)) {
                    message = "Team 1 win!";
                    break;
                }
                if ((tmpTeam1.initiative >= tmpTeam2.initiative && init1 < 10) || (tmpTeam1.initiative < tmpTeam2.initiative && init2 == 10)) {
                    tmpTeam1.step(team2, team1);
                    init1++;
                    if (init1 < 10) tmpTeam1 = team1.get(init1);
                } else {
                    tmpTeam2.step(team1, team2);
                    init2++;
                    if (init2 < 10) tmpTeam2 = team2.get(init2);
                }
            }

            View.view();

            if (message.equals("Team 2 win!") || message.equals("Team 1 win")) {
                System.out.println(message);
                break;
            }
        }
    }

    public static boolean isTeamDie(ArrayList<Hero> team) {
        for (Hero hero : team) {
            if (!hero.state.equals("Dead")) return false;
        }
        return true;
    }

    private static void addRandomUnit(int num, int i, ArrayList<Hero> units, int teamPos) {
        Random rand = new Random();
        switch (num)
        {
            case 0:
                units.add(new Archer(teamPos, i + 1, rand.nextInt(21)));
                break;
            case 1:
                units.add(new Spearman(teamPos, i + 1, rand.nextInt(21)));
                break;
            case 2:
                units.add(new WhiteMag(teamPos, i + 1, rand.nextInt(21), 1));
                break;
            case 3:
                units.add(new Monk(teamPos, i + 1, rand.nextInt(21), 1));
                break;
            case 4:
                units.add(new Farmer(teamPos, i + 1, rand.nextInt(21), 1));
                break;
            case 5:
                units.add(new Outlaw(teamPos, i + 1, rand.nextInt(21)));
                break;
            case 6:
                units.add(new Sniper(teamPos, i + 1, rand.nextInt(21)));
                break;
        }
    }
}
