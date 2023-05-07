import java.util.ArrayList;
//class contain setup information for player and team
public class Player {
    private String difficulty;
    private int gold;
    private ArrayList<Athlete> team;
    private int points;
    private ArrayList<EffectItem> inventory;
    private int Turn = 0;
    private String name;

    public Player(String difficulty,String name) {
        this.difficulty = difficulty;
        this.team = new ArrayList<Athlete>();
        this.name = name;
        // set starting gold based on difficulty
        if (difficulty.equals("Easy")) {
            this.gold = 50;
        } else if (difficulty.equals("Medium")) {
            this.gold = 25;
        } else if (difficulty.equals("Hard")) {
            this.gold = 10;
        } else {
            System.out.println("ValueError:diffculty") ;  // default to 0 if difficulty level is unknown
            return;
        }
    
        this.points = 0;
    }
    public String getname(){
        return this.name;
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
    public int getTurn() {
        return Turn;
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
    public void printteam(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
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

    public void init_team_commandline() {
        System.out.println("Please select 5 players for your team");
        for (int i = 0; i < 5; i++) {
            System.out.println("Please select player " + (i + 1));
            for (int j = 0; j < team.size(); j++) {
                System.out.println((j + 1) + ". " + team.get(j).getName());
            }
            int selection = Integer.parseInt(System.console().readLine());
            team.add(team.get(selection - 1));
            team.remove(selection - 1);
        }
    }
}