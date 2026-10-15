import java.util.*;

public class Battle {
    List<Hero> team1 = new ArrayList<>();
    List<Hero> team2 = new ArrayList<>();
    Random rand = new Random();

    public void addToTeam1(Hero h) { team1.add(h); }
    public void addToTeam2(Hero h) { team2.add(h); }

    private boolean isTeamAlive(List<Hero> team) {
        for (Hero h : team) {
            if (h.isAlive) return true;
        }
        return false;
    }

    private Hero pickTarget(List<Hero> team) {
        List<Hero> alive = new ArrayList<>();
        for (Hero h : team) {
            if (h.isAlive) alive.add(h);
        }
        if (alive.isEmpty()) return null;
        return alive.get(rand.nextInt(alive.size()));
    }

    public void start() {
        int round = 1;
        System.out.println("Начало сражения");

        while (isTeamAlive(team1) && isTeamAlive(team2) && round <= 20) {
            System.out.println("\nРаунд" + round);

            for (Hero h : team1) {
                if (!h.isAlive) continue;
                Hero target = pickTarget(team2);
                if (target == null) break;
                h.attack(target);
            }

            for (Hero h : team2) {
                if (!h.isAlive) continue;
                Hero target = pickTarget(team1);
                if (target == null) break;
                h.attack(target);
            }

            printStatus();
            round++;
        }

        System.out.println("\nКонец)))");
        boolean t1 = isTeamAlive(team1);
        boolean t2 = isTeamAlive(team2);

        if (t1 && t2) System.out.println("НИЧЬЯ: закончились попытки.");
        else if (t1) System.out.println("ПОБЕДА отряда 1");
        else if (t2) System.out.println("ПОБЕДА отряда 2");
        else System.out.println("НИЧЬЯ: все померли.");
    }

    private void printStatus() {
        System.out.println("Отряд 1: " + status(team1));
        System.out.println("Отряд 2: " + status(team2));
    }

    private String status(List<Hero> team) {
        StringBuilder sb = new StringBuilder();
        for (Hero h : team) {
            sb.append(h.name).append("(").append(h.hp).append(") ");
        }
        return sb.toString();
    }
}