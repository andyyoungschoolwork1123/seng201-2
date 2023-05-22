import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a player in the game, containing setup information, team composition, gold, points, and inventory.
 */
//class contain setup information for player and team
public class Player {
    private String difficulty;
    private int gold;
    private ArrayList<Athlete> team = new ArrayList<Athlete>();
    private int points;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private int Turn = 1;
    private String name;
    private ArrayList<Athlete> subs = new ArrayList<Athlete>();
    public int maxturn;
    /**
     * Constructs a player with the given difficulty and name.
     *
     * @param difficulty the difficulty level of the player (Easy, Medium, Hard)
     * @param name       the name of the player
     */
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
    /**
     * Returns a string representation of the player.
     *
     * @return a string representation of the player
     */
    public String toString() {
        return "Name: " + name +" ,week "+Turn+ ", point " + (points) + "\n" + "gold: " + gold;
    }

    /**
     * Returns the name of the player.
     *
     * @return the player's name
     */
    public String getName(){
        return this.name;
    }
     /**
     * Returns the difficulty level of the player.
     *
     * @return the difficulty level
     */
    public String getDifficulty() {
        return difficulty;
    }
     /**
     * Increases the turn counter by 1.
     *
     * @return the updated turn count
     */
    public int inc_trun(){
        this.Turn += 1;
        return this.Turn;
    }
    /**
     * Sets the difficulty level of the player.
     *
     * @param difficulty the new difficulty level
     */
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    /**
     * Returns the substitute athletes of the player.
     *
     * @return the list of substitute athletes
     */
    public ArrayList<Athlete> getsubs(){
        if (this.subs == null){
            this.subs = new ArrayList<Athlete>();
        }
        return this.subs;
    }
    /**
     * Sets the substitute athletes of the player.
     *
     * @param subs the list of substitute athletes
     */
    public void setsubs(ArrayList<Athlete> subs){
        this.subs = subs;
    }
    /**
     * Adds an athlete to the list of substitute athletes.
     *
     * @param athlete the athlete to be added
     */
    public void addsubs(Athlete athlete){
        this.subs.add(athlete);
    }   
     /**
     * Removes an athlete from the list of substitute athletes.
     *
     * @param athlete the athlete to be removed
     */
    public void removesubs(Athlete athlete){
        this.subs.remove(athlete);
        //5.15 By TONG
        
    }
    /**

    *restore stamina of all athletes in the team
    *used in turn end
     */
    public void restoreStamina() {
        for (Athlete athlete : team) {
            athlete.setStamina(100);
        }
        for (Athlete athlete : subs) {
            athlete.setStamina(100);
        }
    }
     /**
     * Sets the team composition of the player.
     *
     * @param team the team object representing the player's team
     */
    public void setteam(Team team){
        this.team = team.getteam();
        this.subs = team.getsubs();
        
    }
/**
 * Removes an athlete from the player's team.
 *
 * @param athlete The athlete to be removed from the team.
 */
    public void removefromteam(Athlete athlete){
        this.team.remove(athlete);
    }
 /**
 * Adds an athlete to the player's team.
 *
 * @param athlete The athlete to be added to the team.
 */
    public void addtoteam(Athlete athlete){
        this.team.add(athlete);
    }
/**
 * Removes injuries from all athletes in the player's team.
 */
    public void removeInjury(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            athlete.heal_check();
        }
    }
/**
 * Prints the information of substitute athletes.
 * Displays the name, role, stamina, offense, and defense of each substitute athlete.
 */
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
/**
 * Retrieves the current gold amount of the player.
 *
 * @return The current gold amount of the player.
 */

    public int getGold() {
        return gold;
    }
/**
 * Retrieves the current turn number.
 *
 * @return The current turn number.
 */    
    public int getTurn() {
        return Turn;
    }
/**
 * Increases the player's gold amount by the specified value.
 *
 * @param gold The amount of gold to add.
 * @return The updated gold amount.
 */
    public int addgold(int gold) {
        this.gold += gold;
        return this.gold;
    }
/**
 * Sets the player's gold amount to the specified value.
 *
 * @param gold The new gold amount.
 */
    public void setGold(int gold) {
        this.gold = gold;
    }
/**
 * Retrieves the list of athletes in the player's team.
 * If the team is null, it initializes an empty list.
 *
 * @return The list of athletes in the player's team.
 */
    public ArrayList<Athlete> getTeam() {
        if (this.team == null){
            this.team = new ArrayList<Athlete>();
        }
        return this.team;
    }
/**
 * Sets the list of athletes in the player's team.
 *
 * @param team The new list of athletes.
 */
    public void setTeam(ArrayList<Athlete> team) {
        this.team = team;
    }
/**
 * Prints the information of athletes in the player's team.
 * Displays the name and role of each athlete.
 */
    public void printteam(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
    }

/**
 * Retrieves the current points of the player.
 *
 * @return The current points of the player.
 */
    public int getpoints() {
        return this.points;
    }
/**
 * Sets the points of the player to the specified value.
 *
 * @param points The new points value.
 */
    public void setpoints(int points) {
        this.points = points;
    }
/**
 * Increases the points of the player by the specified value.
 *
 * @param points The amount to increase the points by.
 */
    public void increasepoints(int points) {
        this.points += points;
    }
/**
 * Retrieves the inventory of the player.
 *
 * @return The inventory of the player.
 */
    public ArrayList<Item> getInventory() {
        return this.inventory;
        
    }
/**
 * Sets the inventory of the player to the specified list.
 *
 * @param inventory The new inventory list.
 */
    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
/**
 * Adds an item to the player's inventory.
 *
 * @param item The item to add.
 */
    public void addInventory(Item item) {
        this.inventory.add(item);
    }
/**
 * Removes an item from the player's inventory.
 *
 * @param item The item to remove.
 */
    public void removeInventory(Item item) {
        this.inventory.remove(item);
    }
/**
 * Prints the names of athletes in the player's team.
 */
    public void getTeamanmes() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName());
        }
    }
/**
 * Heals any injured athletes in the player's team.
 */
    public void heal_injury() {
        for (int i = 0; i < team.size(); i++) {
            team.get(i).heal_check();
        }
    }
/**
 * Initializes the inventory with default items.
 */
    public void InitInventory(){
        Item i1 = new Item("Basketball", "Equipment", 50, 25, 100);
        Item i2 = new Item("Running Shoes", "Footwear", 100, 50, 200);
        Item i3 = new Item("Water Bottle", "Accessories", 10, 5, 50);

        inventory.add(i1);
        inventory.add(i2);
        inventory.add(i3);
    }
/**
 * Displays the items in the player's inventory.
 */
    public void displayinventory() {
        if (inventory.size() == 0) {
            System.out.println("No items in inventory");
        }
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println(inventory.get(i).getName());
            System.out.println(inventory.get(i).getStoreValue());
        }
        
    }
/**
 * Displays the items in the player's inventory.
 */
    public void displayteam() {
        for (int i = 0; i < team.size(); i++) {
            System.out.println(team.get(i).getName());
        }
    }
/**
 * Retrieves the maximum number of turns for the player.
 *
 * @return The maximum number of turns.
 */
    public int getmaxTurns(){
        return this.maxturn;
    }
/**
 * Initializes the player's team with a default set of athletes.
 *
 * @return The initialized team.
 */
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
/**
 * Initializes the player's team through the command line interface.
 */
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

        /**
         * Allows the player to apply items from their inventory to athletes in their team.
         */
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
/**
 * Applies the selected item from inventory to the specified player in the team.
 *
 * @param selection  The index of the item in the inventory.
 * @param selection2 The index of the player in the team.
 */

    public void applyfrominventory(int selection, int selection2) {
        inventory.get(selection - 1).applyToAthlete(team.get(selection2 - 1));
        inventory.remove(selection - 1);
    }
/**
 * Sorts the team list based on a predefined order of athlete roles.
 *
 * @param team The team list to be sorted.
 * @return The sorted team list.
 */
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
/**
 * Allows the player to select an athlete from their team and train them.
 * The selected athlete will undergo training.
 */
    public void train_athletes() {
        System.out.println("Select Training athletes...");
        displayteam();
        int selection = Integer.parseInt(System.console().readLine());
        
        team.get(selection-1).train();

            
        
    }
    //random events
    


    
    
/**
 * Handles random events that can occur during gameplay.
 * This method triggers different random events such as stat boosts, athlete quits, and new athlete joins.
 */
public String handleRandomEvents() {
    String statBoostEvents = handleStatBoostEvent();
    String quitEvents = handleAthleteQuitEvent();
    String newAthleteEvents = handleNewAthleteJoinEvent();

    return statBoostEvents+ "\n" + quitEvents+"\n" + newAthleteEvents+"\n";
}
/**
 * Handles the event where an athlete's stat is boosted randomly.
 * Each athlete in the team has a chance to receive a stat boost.
 */

    private void handleStatBoostEvent_cmd() {
        double chance = calculateEventChance(0.05); // Adjust the chance as desired

        for (Athlete athlete : team) {
            // Check if the athlete is resting and eligible for a stat boost
            if (chance > Math.random()) {
                // Increase the athlete's stat (adjust as desired)
                athlete.train();
                System.out.println("Random Event: " + athlete.getName() + "'s stat has increased!\n");
            }
        }
    }
/**
 * Handles the event where an athlete quits the team randomly.
 * Each athlete in the team has a chance to quit.
 * cmd version
 */
    private void handleAthleteQuitEvent_cmd() {
        double chance = calculateEventChance(0.02); // Adjust the chance as desired

        for (Athlete athlete : team) {
            // Check if the athlete was injured in the previous weeks and eligible to quit
            if (chance > Math.random()) {
                // Remove the athlete from the team
                team.remove(athlete);
                System.out.println("Random Event: " + athlete.getName() + " has quit the team!\n");
                break; // Exit the loop to handle only one quitting athlete at a time
            }
        }
    }
/**
 * Handles the event where a new athlete joins the team randomly.
 * A new athlete can join if there are free slots available in the reserves.
 * cmd version
 */

    private void handleNewAthleteJoinEvent_cmd() {
        double chance = calculateEventChance(0.02); // Adjust the chance as desired
        int freeSlots = calculateFreeSlots(); // Method to calculate the number of free slots in reserves

        // Check if there are free slots and eligible for a new athlete to join
        if (freeSlots > 0 && chance > Math.random()) {
            Athlete newAthlete = Athlete.generateAthlete(Turn); // Method to generate a new random athlete
            subs.add(newAthlete);
            System.out.println("Random Event: A new athlete, " + newAthlete.getName() + ", has joined the team!\n");
        }
    }
/**
 * Calculates the adjusted event chance based on the base chance and other factors such as difficulty setting.
 * @param baseChance The base chance of the event.
 * @return The adjusted chance value.
 * 
 */
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
/**
 * Calculates the number of free slots in the reserves.
 * @return The number of free slots.
 */
    private int calculateFreeSlots() {
        // Calculate the number of free slots in the reserves
        // Return the number of free slots
        int slots = 5 - this.subs.size();
        return slots;
    }
    
    /** 
     * Handles the event where an athlete's stat is boosted randomly.
     * Each athlete in the team has a chance to receive a stat boost.
     * @return The string representation of the event.
     */
    private String handleStatBoostEvent() {
        StringBuilder sb = new StringBuilder();
        double chance = calculateEventChance(0.05); // Adjust the chance as desired
    
        for (Athlete athlete : team) {
            // Check if the athlete is resting and eligible for a stat boost
            if (chance > Math.random()) {
                // Increase the athlete's stat (adjust as desired)
                athlete.train();
                sb.append("Random Event: ").append(athlete.getName()).append("'s stat has increased!\n");
            }
        }
        return sb.toString();
    }
    /** 
     * Handles the event where an athlete quits the team randomly.
     * Each athlete in the team has a chance to quit.
     * @return The string representation of the event.
     */
    private String handleAthleteQuitEvent() {
        StringBuilder sb = new StringBuilder();
        double chance = calculateEventChance(0.02); // Adjust the chance as desired
    
        for (Athlete athlete : team) {
            // Check if the athlete was injured in the previous weeks and eligible to quit
            if (chance > Math.random()) {
                // Remove the athlete from the team
                team.remove(athlete);
                sb.append("Random Event: ").append(athlete.getName()).append(" has quit the team!\n");
                break; // Exit the loop to handle only one quitting athlete at a time
            }
        }
        return sb.toString();
    }
    /** 
     * Handles the event where a new athlete joins the team randomly.
     * A new athlete can join if there are free slots available in the reserves.
     * @return The string representation of the event.
     */
    private String handleNewAthleteJoinEvent() {
        StringBuilder sb = new StringBuilder();
        double chance = calculateEventChance(0.02); // Adjust the chance as desired
        int freeSlots = calculateFreeSlots(); // Method to calculate the number of free slots in reserves
    
        // Check if there are free slots and eligible for a new athlete to join
        if (freeSlots > 0 && chance > Math.random()) {
            Athlete newAthlete = Athlete.generateAthlete(Turn); // Method to generate a new random athlete
            subs.add(newAthlete);
            sb.append("Random Event: A new athlete, ").append(newAthlete.getName()).append(", has joined the team!\n");
        }
        return sb.toString();
    }
    
    
}

