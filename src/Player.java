import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//class contain setup information for player and team
public class Player {
    private String difficulty;
    private int gold;
    private ArrayList<Athlete> team;
    private int points;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int Turn = 1;
    private String name;
    private ArrayList<Athlete> subs;
    public int maxturn;

    public Player(String difficulty,String name) {
        this.difficulty = difficulty;
        this.team = new ArrayList<Athlete>();
        this.name = name;
        // set starting gold based on difficulty
        if (difficulty.equals("Easy")) {
            this.gold = 500;
            this.maxturn = 10;
        } else if (difficulty.equals("Medium")) {
            this.gold = 250;
            this.maxturn = 15;
        } else if (difficulty.equals("Hard")) {
            this.gold = 100;
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
        if (this.subs == null){
            this.subs = new ArrayList<Athlete>();
        }
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
        //5.15 By TONG
        
    }
    public void setteam(Team team){
        this.team = team.getteam();
        this.subs = team.getsubs();
        
    }
    public void removefromteam(Athlete athlete){
        this.team.remove(athlete);
    }
    public void addtoteam(Athlete athlete){
        this.team.add(athlete);
    }
    public void removeInjury(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            athlete.heal_check();
        }
    }
    public void printsubs(){
        if (this.subs == null){
            this.subs = new ArrayList<Athlete>();
        }
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
        if (this.team == null){
            this.team = new ArrayList<Athlete>();
        }
        return this.team;
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
        return this.points;
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
    public void InitInventory(){
        Item i1 = new Item("Basketball", "Equipment", 50, 25, 100);
        Item i2 = new Item("Running Shoes", "Footwear", 100, 50, 200);
        Item i3 = new Item("Water Bottle", "Accessories", 10, 5, 50);

        inventory.add(i1);
        inventory.add(i2);
        inventory.add(i3);
    }
    public void displayinventory() {
        if (inventory.size() == 0) {
            System.out.println("No items in inventory");
        }
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getName());
            System.out.println(inventory.get(i).getStoreValue());
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
    public ArrayList<Athlete> init_team(){
        ArrayList<Athlete> selection = new ArrayList<Athlete>();
            Athlete athlete1 = Athlete.generateAthlete(1, "Forward");
            selection.add(athlete1);
            Athlete athlete2 = Athlete.generateAthlete(1, "Midfielder");
            selection.add(athlete2);
            Athlete athlete3 = Athlete.generateAthlete(1, "Defender");
            selection.add(athlete3);
            Athlete athlete4 = Athlete.generateAthlete(1, "Goalkeeper");
            selection.add(athlete4);
            for (int i = 0; i < 6; i++) {
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
            auto_sortteam(selection);
            return selection;
    }
    public void init_team_commandline() {
        System.out.println("Now please select your athletes:");
            ArrayList<Athlete> selection = new ArrayList<Athlete>();
            Athlete athlete1 = Athlete.generateAthlete(1, "Forward");
            selection.add(athlete1);
            Athlete athlete2 = Athlete.generateAthlete(1, "Midfielder");
            selection.add(athlete2);
            Athlete athlete3 = Athlete.generateAthlete(1, "Defender");
            selection.add(athlete3);
            Athlete athlete4 = Athlete.generateAthlete(1, "Goalkeeper");
            selection.add(athlete4);
            for (int i = 0; i < 6; i++) {
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
            auto_sortteam(selection);
            for (int i = 0; i < selection.size(); i++) {
                System.out.println(i + ". " + selection.get(i).getName() + " (" + selection.get(i).getRole() + ")");
                System.out.println(" Offense: " + selection.get(i).getOffence() + " Defense: " + selection.get(i).getDefence());
            }
            System.out.println("Please select 5 athletes:");
            ArrayList<Athlete> team = new ArrayList<Athlete>();
            for (int i = 0; i < 5; i++) {
                int index = Integer.parseInt(System.console().readLine());
                team.add(selection.get(index));
            }
            auto_sortteam(team);

            this.setTeam(team);
        }

        
        public void applyfrominventory(){
            displayinventory();
            if (inventory.size() == 0) {
                System.out.println("action cancelled");
                return;
            }
            System.out.println("do you want to apply an item? (y/n)");
            String comfirm = System.console().readLine();
            if (comfirm.equals("y")) {
                System.out.println("Please select item to apply");
                int selection = Integer.parseInt(System.console().readLine());
                System.out.println("Please select player to apply item to");
                displayteam();
                int selection2 = Integer.parseInt(System.console().readLine());
                inventory.get(selection - 1).applyToAthlete(team.get(selection2 - 1));
                inventory.remove(selection - 1);
                
            }
            else{
                System.out.println("action cancelled");
                return;
            }
            
        

        
    }

    public void applyfrominventory(int selection, int selection2) {
        inventory.get(selection - 1).applyToAthlete(team.get(selection2 - 1));
        inventory.remove(selection - 1);
    }

    public ArrayList<Athlete> auto_sortteam(ArrayList<Athlete> team) {
        List<String> predefinedOrder = List.of("Forward", "Midfielder", "Defender", "Goalkeeper");

        Collections.sort(team, new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                int index1 = predefinedOrder.indexOf(o1.getRole());
                int index2 = predefinedOrder.indexOf(o2.getRole());
                return Integer.compare(index1, index2);
            }
        });
        
        
    
        return team;   
    }
    public void train_athletes() {
        System.out.println("Select Training athletes...");
        displayteam();
        int selection = Integer.parseInt(System.console().readLine());
        
        team.get(selection-1).train();

            
        
    }
    //random events
    


    public void handleRandomEvents() {
        // 1. Athlete's stat is increased
        handleStatBoostEvent();

        // 2. Athlete quits
        handleAthleteQuitEvent();

        // 3. Random new athlete joins
        handleNewAthleteJoinEvent();
    }

    private void handleStatBoostEvent() {
        double chance = calculateEventChance(0.05); // Adjust the chance as desired

        for (Athlete athlete : team) {
            // Check if the athlete is resting and eligible for a stat boost
            if (chance > Math.random()) {
                // Increase the athlete's stat (adjust as desired)
                athlete.train();
                System.out.println("Random Event: " + athlete.getName() + "'s stat has increased!");
            }
        }
    }

    private void handleAthleteQuitEvent() {
        double chance = calculateEventChance(0.02); // Adjust the chance as desired

        for (Athlete athlete : team) {
            // Check if the athlete was injured in the previous weeks and eligible to quit
            if (chance > Math.random()) {
                // Remove the athlete from the team
                team.remove(athlete);
                System.out.println("Random Event: " + athlete.getName() + " has quit the team!");
                break; // Exit the loop to handle only one quitting athlete at a time
            }
        }
    }

    private void handleNewAthleteJoinEvent() {
        double chance = calculateEventChance(0.02); // Adjust the chance as desired
        int freeSlots = calculateFreeSlots(); // Method to calculate the number of free slots in reserves

        // Check if there are free slots and eligible for a new athlete to join
        if (freeSlots > 0 && chance > Math.random()) {
            Athlete newAthlete = Athlete.generateAthlete(Turn); // Method to generate a new random athlete
            subs.add(newAthlete);
            System.out.println("Random Event: A new athlete, " + newAthlete.getName() + ", has joined the team!");
        }
    }

    private double calculateEventChance(double baseChance) {
        // Adjust the baseChance based on the difficulty setting or other factors
        // Return the adjusted chance value
        if (difficulty.equals("Easy")) {
            baseChance *= 1.5;
        } else if (difficulty.equals("Hard")) {
            baseChance *= 0.5;
        }
        return baseChance;
    }

    private int calculateFreeSlots() {
        // Calculate the number of free slots in the reserves
        // Return the number of free slots
        int slots = 5 - this.subs.size();
        return slots;
    }

    
}

