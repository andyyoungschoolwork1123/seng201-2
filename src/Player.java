import java.util.ArrayList;
//class contain setup information for player and team
public class Player {
    private String difficulty;
    private int gold;
    private ArrayList<Athlete> team;
    private int points;
    private ArrayList<EffectItem> inventory;

    public Player(String difficulty) {
        this.difficulty = difficulty;
        this.team = new ArrayList<Athlete>();
    
        // set starting gold based on difficulty
        if (difficulty.equals("Easy")) {
            this.gold = 50;
        } else if (difficulty.equals("Medium")) {
            this.gold = 25;
        } else if (difficulty.equals("Hard")) {
            this.gold = 10;
        } else {
            System.out.println("ValueError") ;  // default to 0 if difficulty level is unknown
        }
    
        this.points = 0;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public ArrayList<Athlete> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Athlete> team) {
        this.team = team;
    }

    public int getpoints() {
        return points;
    }
    public void setpoints(int points) {
        this.points = points;
    }
    public void increasepoints(int points) {
        this.points += points;
    }
    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getName());
        }
    }
    public void getTeamanmes() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName());
        }
    }

    public void setInventory(ArrayList<EffectItem> inventory2) {
    }
}