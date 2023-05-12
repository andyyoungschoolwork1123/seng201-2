import java.util.ArrayList;
//class contain setup information for player and team
public class Player {
    private String difficulty;
    private int gold;
    private ArrayList<Athlete> team;
    private int points;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int Turn = 0;
    private String name;
    private ArrayList<Athlete> subs;
    public int maxturn;

    public Player(String difficulty,String name) {
        this.difficulty = difficulty;
        this.team = new ArrayList<Athlete>();
        this.name = name;
        // set starting gold based on difficulty
        if (difficulty.equals("Easy")) {
            this.gold = 50;
            this.maxturn = 10;
        } else if (difficulty.equals("Medium")) {
            this.gold = 25;
            this.maxturn = 15;
        } else if (difficulty.equals("Hard")) {
            this.gold = 10;
            this.maxturn = 20;
        } else {
            System.out.println("ValueError:diffculty") ;  // default to 0 if difficulty level is unknown
            return;
        }
    
        this.points = 0;
    }
    public String getName(){
        return this.name;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public int inc_trun(){
        this.Turn += 1;
        return this.Turn;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public ArrayList<Athlete> getsubs(){
        return this.subs;
    }
    public void setsubs(ArrayList<Athlete> subs){
        this.subs = subs;
    }
    public void addsubs(Athlete athlete){
        this.subs.add(athlete);
    }   
    public void removesubs(Athlete athlete){
        this.subs.remove(athlete);
    }
    public void printsubs(){
        for (int i = 0; i < this.subs.size(); i++) {
            Athlete athlete = this.subs.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
            System.out.println("Stamina: " + athlete.getStamina());
            System.out.println("Offense: " + athlete.getOffence());
            System.out.println("Defense: " + athlete.getDefence());
        }
    }

    public int getGold() {
        return gold;
    }
    public int getTurn() {
        return Turn;
    }
    public int addgold(int gold) {
        this.gold += gold;
        return this.gold;
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
    public ArrayList<Item> getInventory() {
        return this.inventory;
        
    }
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void addInventory(Item item) {
        this.inventory.add(item);
    }
    public void removeInventory(Item item) {
        this.inventory.remove(item);
    }
    
    public void getTeamanmes() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName());
        }
    }
    public void heal_injury() {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).heal_check();
        }
    }
    public void displayinventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getName());
            System.out.println(inventory.get(i).getStoreValue());
        }
        if (inventory.size() == 0) {
            System.out.println("No items in inventory");
        }
    }
    public void displayteam() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName());
        }
    }
    public int getmaxTurns(){
        return this.maxturn;
    }
    public void init_team_commandline() {
        System.out.println("Now please select your athletes:");
            ArrayList<Athlete> selection = new ArrayList<Athlete>();
            for (int i = 0; i < 10; i++) {
                if (Math.random() >0.25){
                    Athlete athlete = Athlete.generateAthlete(1, "Forward");
                    selection.add(athlete);
                }
                else if (Math.random() >0.5){
                    Athlete athlete = Athlete.generateAthlete(1, "Midfielder");
                    selection.add(athlete);
                }
                else if (Math.random() >0.75){
                    Athlete athlete = Athlete.generateAthlete(1, "Defender");
                    selection.add(athlete);
                }
                else{
                    Athlete athlete = Athlete.generateAthlete(1, "Goalkeeper");
                    selection.add(athlete);
                }
                
            }
            for (int i = 0; i < selection.size(); i++) {
                System.out.println(i + ". " + selection.get(i).getName());
            }
            System.out.println("Please select 5 athletes:");
            ArrayList<Athlete> team = new ArrayList<Athlete>();
            for (int i = 0; i < 5; i++) {
                int index = Integer.parseInt(System.console().readLine());
                team.add(selection.get(index));
            }
            this.setTeam(team);
    }
    public void applyfrominventory() {
        displayinventory();
        System.out.println("do you want to apply an item? (y/n)");
        String comfirm = System.console().readLine();
        if (comfirm.equals("y")) {
            applyfrominventory();
        }
        else{
            System.out.println("action cancelled");
            return;
        }
        if (inventory.size() == 0) {
            System.out.println("action cancelled");
            return;
        }
        System.out.println("Please select item to apply");
        int selection = Integer.parseInt(System.console().readLine());
        System.out.println("Please select player to apply item to");
        displayteam();
        int selection2 = Integer.parseInt(System.console().readLine());
        inventory.get(selection - 1).applyToAthlete(team.get(selection2 - 1));
        inventory.remove(selection - 1);
    }
    public void applyfrominventory(int selection, int selection2) {
        inventory.get(selection - 1).applyToAthlete(team.get(selection2 - 1));
        inventory.remove(selection - 1);
    }

    public void reduceGold(int storeValue) {
    }
}