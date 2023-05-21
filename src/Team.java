import java.util.ArrayList;
/**
 * Represents a team consisting of athletes.
 */
public class Team {
    public ArrayList<Athlete> team;
    private ArrayList<Athlete> subs = new ArrayList<Athlete>();
    public int score;
    public String name;
    private int pos = 0;
    private int maxSize = 5;
    public Team(Team team) {
        this.name = team.name;
        this.team = team.team;
        this.score = team.score;
        this.subs = team.subs;
    }
    /**
     * Creates a new Team object by copying the properties of another Team object.
     * @param team The Team object to copy.
     */
    public Team(String name) {
        this.name = name;
        this.team = new ArrayList<Athlete>();
        this.score = 0;
        this.subs = new ArrayList<Athlete>();
    }
    /**
     * Creates a new Team object with the specified name.
     * @param name The name of the team.
     */
    public Team(String name, ArrayList<Athlete> team,ArrayList<Athlete> subs) {
        this.name = name;
        this.team = team;
        this.score = 0;
        this.subs = subs;

    }

     /**
     * Creates a default Team object with default athletes.
     */
    public Team(){
        this.name = "default";
        this.team = new ArrayList<Athlete>();
        this.score = 0;
        this.subs = new ArrayList<Athlete>();
        this.team.add(new Athlete("a", 100, 100, 100, "default"));
        this.team.add(new Athlete("b", 100, 100, 100, "default"));
        this.team.add(new Athlete("c", 100, 100, 100, "default"));
        this.team.add(new Athlete("d", 100, 100, 100, "default"));
        this.team.add(new Athlete("e", 100, 100, 100, "default"));
        this.subs.add(new Athlete("f", 100, 100, 100, "default"));
        this.subs.add(new Athlete("g", 100, 100, 100, "default"));
        this.subs.add(new Athlete("h", 100, 100, 100, "default"));

    }

    /**
     * Creates a Team object with the specified name and team.
     * @param name The name of the team.
     * @param team The list of athletes in the team.
     */
    public Team(String name, ArrayList<Athlete> team) {
        this.name = name;
        this.team = team;
        this.score = 0;
        this.subs = new ArrayList<Athlete>();

    }
    /**
     * Creates a Team object based on the specified Player's information.
     * @param player The player object from which to create the team.
     */
    public Team(Player player) {
        this.name = player.getName();
        this.team = player.getTeam();
        this.score = 0;
        this.subs = player.getsubs();

    }
    /**return a String representation of Team */
    public String toString() {
        return "Name: " + name + ", stregth " + this.gettotalestpower() + "\n";
    }
  /**
     * Returns the current position of the team.
     * @return The position of the team.
     */
    public int getpos(){
        return this.pos;
    }
/**
     * Sets the position of the team.
     * @param pos The position to set.
     */
    public void setpos(int pos){
        this.pos = pos;
    }
     /**
     * Returns the substitutes list.
     * If the list is null, it initializes an empty list and returns it.
     * @return The substitutes list.
     */
    public ArrayList<Athlete> getsubs(){
        if (this.subs == null){
            this.subs = new ArrayList<Athlete>();
        }
        return this.subs;
    }
    /**
     * Sets the substitutes list.
     * @param subs The substitutes list to set.
     */

    public void setsubs(ArrayList<Athlete> subs){
        this.subs = subs;
    }
    /**
     * Adds an athlete to the team.
     * If the maximum team size has been reached, it displays a message.
     * @param athlete The athlete to add.
     */
    public void addAthlete(Athlete athlete) {
        if (team.size() < maxSize) {
            team.add(athlete);
        } else {
            System.out.println("Maximum team size reached.");
        }
    }
  /**
     * Adds an athlete to the substitutes list.
     * If the maximum substitutes size has been reached, it displays a message.
     * @param athlete The athlete to add.
     */
    public void addSubs(Athlete athlete) {
        if (subs.size() < maxSize) {
            subs.add(athlete);
        } else {
            System.out.println("Maximum subs size reached.");
        }
    }
    /**
     * Removes an athlete from the substitutes list.
     * @param athlete The athlete to remove.
     */
    public void removesubs(Athlete athlete){
        this.subs.remove(athlete);
    }
    /**
     * Removes an athlete from the team if they are injured.
     * @param athlete The athlete to check and remove.
     */
    public void injuryremove(Athlete athlete){
        if (athlete.getInjury() == true){
            this.team.remove(athlete);
        }
        this.team.remove(athlete);
    }
    /**
     * Prints the list of substitutes.
     */

    public void printsubs(){
        for (int i = 0; i < this.subs.size(); i++) {
            Athlete athlete = this.subs.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
    }
    /**
     * Substitutes an athlete on the team with an athlete from the substitutes list.
     * @param onathlete The athlete to substitute on.
     * @param off_pos The position of the athlete to substitute off.
     */
    public void subtite(Athlete onathlete, int off_pos){
        //gui in mind
        this.subs.add(this.team.get(off_pos));
        this.team.set(off_pos, onathlete);
    }
     /**
     * Substitutes an athlete on the team with a specific athlete from the substitutes list.
     * @param onathlete The athlete to substitute on.
     * @param offathlete The athlete to substitute off.
     */
    public void subtite(Athlete onathlete, Athlete offathlete){
        //gui in mind
        this.subs.add(offathlete);
        this.team.set(this.team.indexOf(offathlete), onathlete);
        this.subs.remove(onathlete);
    }
    /**
     * Substitutes an athlete on the team with an athlete from the substitutes list based on their positions.
     * @param on_pos The position of the athlete to substitute on from the substitutes list.
     * @param off_pos The position of the athlete to substitute off from the team.
     */
    public void subtite(int on_pos, int off_pos){
        //grouping with the select_subon() and select_suboff()
        System.out.println("Substituting " + this.team.get(off_pos).getName() + " with " + this.subs.get(on_pos).getName() + "comfirm? (y/n)");
        String comfirm = System.console().readLine();
        if (comfirm.equals("y")){
            this.subs.add(this.team.get(off_pos));
            this.team.set(off_pos, this.subs.get(on_pos));
        }
        else{
            System.out.println("Substitution cancelled");
        }   
        
    }
    /**
     * Returns the list of athletes in the team.
     * @return The list of athletes.
     */
    
    public ArrayList<Athlete> getteam(){
        return this.team;
    }
    /**
     * Prints the list of athletes in the team.
     */
    public void printteam(){
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
        }
    }
    /**
 * Allows the user to select the athlete they want to substitute on from the substitutes list.
 * @return The position of the selected athlete in the substitutes list.
 */
    public int select_subon(){
        System.out.println("Select the athlete you want to sub on:");
        this.printsubs();
        int subon_pos = Integer.parseInt(System.console().readLine());
        return subon_pos;
    }
    /**
 * Allows the user to select the athlete they want to substitute off from the team.
 * @return The position of the selected athlete in the team.
 */
    public int select_suboff(){
        System.out.println("Select the athlete you want to sub off:");
        this.printteam();
        int suboff_pos = Integer.parseInt(System.console().readLine());
        return suboff_pos;
    }
    /**
 * Sets the team with the specified list of athletes.
 * @param team The list of athletes to set as the team.
 */
    public void setteam(ArrayList<Athlete> team){
        this.team = team;
    }
    /**
 * Returns the current score of the team.
 * @return The score of the team.
 */
    public int getscore(){
        return this.score;
    }
    /**
 * Sets the score of the team.
 * @param score The score to set.
 */
    public void setscore(int score){
        this.score = score;
    }
    /**
 * Returns the name of the team.
 * @return The name of the team.
 */
    public String getname(){
        return this.name;
    }
    /**
 * Sets the name of the team.
 * @param name The name to set.
 */
    public void setname(String name){
        this.name = name;
    }
    /**
 * Removes the specified athlete from the team.
 * @param athlete The athlete to remove.
 */
    public void removeAthlete(Athlete athlete) {
        this.team.remove(athlete);
    }
    /**
 * Adds the specified score to the team's current score.
 * @param score The score to add.
 */
    public void addScore(int score) {
        this.score += score;
    }

/**
 * Calculates and returns the total estimated power of the team.
 * @return The total estimated power of the team.
 */
    public int gettotalestpower(){
        int total = 0;
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            total += athlete.esimatepower();
        }
        return total;
    }
/**
 * Displays the team information in the command-line interface.
 */
    public void displayTeam_cmd() {
        System.out.println("Team " + this.name + ":");
        for (int i = 0; i < this.team.size(); i++) {
            Athlete athlete = this.team.get(i);
            System.out.println((i+1) + ". " + athlete.getName() + " (" + athlete.getRole() + ")");
            System.out.println("Stamina: " + athlete.getStamina());
            System.out.println("Offence: " + athlete.getOffence());
            System.out.println("Defence: " + athlete.getDefence());
            System.out.println("Injury: " + athlete.getInjury());

        }
    }
/**
 * Returns the number of athletes in the team.
 * @return The number of athletes in the team.
 */
    public int size() {
        return this.team.size();
    }

    
    
}
