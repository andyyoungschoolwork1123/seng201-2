import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamBattle {
    
    public static void main(String[] args) {
        List<String> athletes = new ArrayList<>();
        athletes.add("Athlete 1");
        athletes.add("Athlete 2");
        athletes.add("Athlete 3");
        athletes.add("Athlete 4");
        athletes.add("Athlete 5");

        for (int i = 0; i < athletes.size(); i++) {
            for (int j = i+1; j < athletes.size(); j++) {
                System.out.println(athletes.get(i) + " VS " + athletes.get(j));
            }
        }

        List<String> team = new ArrayList<>();
        Random rand = new Random();

        while (athletes.size() > 0) {
            int index = rand.nextInt(athletes.size());
            String athlete = athletes.remove(index);
            team.add(athlete);

            if (team.size() == 2) {
                System.out.println("Team: " + team.get(0) + " and " + team.get(1) + " battle!");
                team.clear();
            }
        }

        if (team.size() == 1) {
            System.out.println("Team: " + team.get(0) + " has no one left to battle!");
        }
    }
}

//Idea : every athelet have chance to battle to another one and without repeat . based my idea output by chatgpt Test seems good .any change idea by Andy.



