/** 
 * This is a Javadoc
 * Represents Athletes in a game.
*/

public class Athlete{
    private String name;
    private int stamina;
    private boolean injury;
    private int offence;
    private int defence;
    private String role;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
    private int injury_time = 0;

    /**
     * Constructs an athlete with the specified attributes.
     *
     * @param name          The name of the athlete.
     * @param stamina       The stamina level of the athlete.
     * @param injury        Indicates if the athlete is injured.
     * @param offence       The offensive ability of the athlete.
     * @param defence       The defensive ability of the athlete.
     * @param role          The role or position of the athlete.
     * @param storeValue    The value of the athlete in the market.
     * @param sellbackPrice The price at which the athlete can be sold back.
     * @param amount        The availability or quantity of the athlete.
     */

    public Athlete(String name, int stamina,  int offence, int defence, String role, int storeValue, int sellbackPrice, int amount) {
        this.name = name;
        this.stamina = stamina;
        this.offence = offence;
        this.defence = defence;
        this.role = role;
        this.injury = false;
        this.storeValue = storeValue;
        this.sellbackPrice = sellbackPrice;
        this.amount = amount;
    }

/**
 * using for generating an athlete.then caculate values. there have a defualt boolean value means Innjury,which is false.
 * @param name     The name of the athlete.
 * @param stamina  The stamina level of the athlete.
 * @param offence  The offensive ability of the athlete.
 * @param defence  The defensive ability of the athlete.
 * @param role     The role or position of the athlete.
 */
    public Athlete(String name, int stamina,  int offence, int defence, String role) {
        this.name = name;
        this.stamina = stamina;
        
        this.offence = offence;
        this.defence = defence;
        this.role = role;
        this.injury = false;

        this.storeValue = (int) (stamina * 2 + offence * 5 + defence * 5);
        this.sellbackPrice = (int) (storeValue *0.8);
        this.amount = 1;
    }
/**to print the athelete description */
    public String toString() {
        return "Name: " + name + ", Stamina: " + stamina + ", Injury: " + injury +
                ", Offence: " + offence + ", Defence: " + defence + ", Role: " + role +
                ", Store Value: " + storeValue + ", Sellback Price: " + sellbackPrice +
                ", Injury time: " + injury_time + "\n";
    }
 /**
     * Returns the name of the athlete.
     *
     * @return The name of the athlete.
     */

    public String getName() {
        return name;
    }

 /**
     * Returns the stamina level of the athlete.
     *
     * @return The stamina level of the athlete.
     */

    public int getStamina() {
        return stamina;
    }

    /**
     * Checks if the athlete is injured.
     *
     * @return true if the athlete is injured, false otherwise.
     */

    public boolean getInjury() {
        if (this.stamina <= 20){
            this.injury = true;
        }
        return injury;
    }

    /**
     * Changes the injury status of the athlete.
     * If the athlete is currently injured, it sets the injury status to false (recovered).
     * If the athlete is currently not injured, it sets the injury status to true (injured).
     */

    public void changeInjury() {
        this.injury =  !this.injury;
    }

    /**
     * Returns the offensive ability of the athlete.
     *
     * @return The offensive ability of the athlete.
     */

    public int getOffence() {
        return offence;
    }

    /**
     * Sets the stamina value of the athlete.
     * 
     * @param stamina the new stamina value to set
     */
    public void setStamina(int i) {
            this.stamina = i;
        }

  /**
     * Returns the defensive ability of the athlete.
     *
     * @return The defensive ability of the athlete.
     */
    public int getDefence() {
        return defence;
    }

        /**
     * Returns the role or position of the athlete.
     *
     * @return The role or position of the athlete.
     */

    public String getRole() {
        return role;
    }
/**
 * Increases the stamina of the athlete by the specified amount.
 * 
 * @param staminaBoost the amount by which to increase the stamina
 */

	public void increaseStamina(int staminaBoost) {
		
		this.stamina += staminaBoost;
	}

/**
 * Increases the defense of the athlete by the specified amount.
 * 
 * @param defenseBoost the amount by which to increase the defense
 */

	public void increaseDefense(int defenseBoost) {
		
		this.defence += defenseBoost ;
	}
/**
 * Increases the offense of the athlete by the specified amount.
 * 
 * @param offenseBoost the amount by which to increase the offense
 */
	public void increaseOffense(int offenseBoost) {
		
		this.offence += offenseBoost ;
	}

/**
 * Estimates the power of the athlete based on their stamina, offense, and defense values.
 * 
 * @return the estimated power of the athlete
 */
    public int esimatepower(){
        return (int) (this.stamina  + this.offence *2 + this.defence * 2);
    }

    /**
     * Returns the value of the athlete in the market.
     *
     * @return The value of the athlete in the market.
     */

    public int getStoreValue() {
        
        
        return this.storeValue;
    }

    /**
 * Sets the store value of the athlete to the specified value.
 * 
 * @param storeValue the new store value of the athlete
 */

   
    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }

    /**
     * Sets the store value of the athlete based on their stamina, offense, and defense values.
     * The store value is calculated as (stamina * 2 + offense * 5 + defense * 5).
     */
    public void setStoreValue() {
        this.storeValue = (int) (this.stamina * 2 + this.offence * 5 + this.defence * 5);
    }

    /**
     * Returns the price at which the athlete can be sold back.
     *
     * @return The sellback price of the athlete.
     */
    
    public int getSellbackPrice() {
        return this.sellbackPrice;
    }

 /**
 * Sets the sellback price of the athlete to the specified value.
 * 
 * @param sellbackPrice the new sellback price of the athlete
 */   
    public void setSellbackPrice(int sellbackPrice) {
        this.sellbackPrice = sellbackPrice;
    }

/**
 * Sets the sellback price of the athlete based on their store value.
 * The sellback price is calculated as 80% of the store value.
 */

    public void setSellbackPrice() {
        this.sellbackPrice = (int) (this.storeValue * 0.8);
    }


    /**
     * Returns the availability or quantity of the athlete.
     *
     * @return The availability or quantity of the athlete.
     */

    public int getAmount() {
        return this.amount;    }

/**
 * Sets the amount of the athlete to the specified value.
 *
 * @param amount the new amount of the athlete
 */

    public void setAmount(int amount) {
        this.amount = amount;    }

 /**
 * Increases the amount of the athlete by the specified value.
 *
 * @param amount the value to increase the amount by
 */   
    public void increaseAmount(int amount) {
        this.amount += amount ;
    }

/**
 * Decreases the amount of the athlete by the specified value.
 * If the resulting amount is less than zero, it is set to zero.
 *
 * @param amount the value to decrease the amount by
 */

    public void decreaseAmount(int amount) {
        this.amount -= amount;
        if (this.amount < 0){
            this.amount = 0;
        }
    }

/**
 * Generates a new Athlete with random attributes based on the turn and role.
 *
 * @param turn the current turn
 * @param role the role of the athlete
 * @return a new Athlete object with generated attributes
 */
    public static Athlete generateAthlete(int turn, String role) {
        int stamina = 100;
        int offence = calculateOffence(role, turn);
        int defence = calculateDefence(role, turn);
        String name = generateName();
        int value = generateValue(offence, defence);
        int sellBackValue = generateSellBackValue(value);
        
        return new Athlete(name, stamina, offence, defence, role, value, sellBackValue,1);
    }

/**
 * Generates a new Athlete with random attributes based on the given turn.
 *
 * @param turn the current turn
 * @return a new Athlete object with randomly generated attributes
 */

    public static Athlete generateAthlete(int turn){
        int stamina = 100;
        int offence = (int)(Math.random()*100);
        int defence = (int)(Math.random()*100);
        String[] roles = {"Forward","Midfielder","Defender","Goalkeeper"};
        String role = roles[(int)(Math.random()*4)];
        String name = generateName();
        int value = generateValue(offence, defence);
        int sellBackValue = generateSellBackValue(value);
        return new Athlete(name, stamina, offence, defence, role, value, sellBackValue,1);
    }
/**
 * Generates the sell-back value for an item based on its original value.
 *
 * @param value the original value of the item
 * @return the sell-back value of the item
 */
    private static int generateSellBackValue(int value) {
        return (int) (value * 0.8);
    }
/**
 * Generates the value for an item based on its offence and defence attributes.
 *
 * @param offence the offence attribute of the item
 * @param defence the defence attribute of the item
 * @return the value of the item
 */
    private static int generateValue(int offence, int defence) {
        return (int) (offence * 2 + defence * 2);
    }

/**
 * Calculates the offence value for an athlete based on their role and the current turn.
 *
 * @param role the role of the athlete ("Forward", "Midfielder", "Defender", "Goalkeeper")
 * @param turn the current turn number
 * @return the calculated offence value for the athlete
 */
    private static int calculateOffence(String role, int turn) {
        int offence = 50;
        if (role.equals("Forward")) {
            offence = 30+ (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Midfielder")) {
            offence = 20+ (int)(Math.random()*25) + (turn * 2);
        } else if (role.equals("Defender")) {
            offence = (int)(Math.random()*40) + (turn * 2);
        } else if (role.equals("Goalkeeper")) {
            offence = 20 + (turn * 2);
        }
        return offence;
    }

/**
 * Calculates the defence value for an athlete based on their role and the current turn.
 *
 * @param role the role of the athlete ("Forward", "Midfielder", "Defender", "Goalkeeper")
 * @param turn the current turn number
 * @return the calculated defence value for the athlete
 */
    private static int calculateDefence(String role, int turn) {
        int defence = 50;
        if (role.equals("Forward")) {
            defence = (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Midfielder")) {
            defence = 25 + (int)(Math.random()*25) + (turn * 2);
        } else if (role.equals("Defender")) {
            defence = 30+ (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Goalkeeper")) {
            defence = 60 + (turn * 2);
        }
        return defence;
    }


/**
 * Checks if the athlete is injured based on their stamina level.
 * If the stamina is less than or equal to 0, the athlete is considered injured.
 * The injury status is updated, and the injury time is set to 2.
 *
 * @return true if the athlete is injured, false otherwise
 */   
     boolean injury_check(){
        if (this.stamina <= 0){
            this.injury = true;
            injury_time = 2;
        }
        return this.injury;
    }

/**
 * Checks if the athlete has healed from their injury based on the injury time.
 * If the injury time is 0, the athlete is considered healed.
 * The injury status is updated accordingly.
 *
 * @return true if the athlete is still injured, false if they have healed
 */
    boolean heal_check(){
        if (this.injury_time == 0){
            this.injury = false;
        }
        return this.injury;

    }

/**
 * Performs a personal duel between the current athlete and another athlete.
 * The duel outcome is determined based on the athletes' attributes and luck.
 *
 * @param j     the opponent athlete
 * @param round the current round of the duel
 * @return true if the current athlete wins the duel, false otherwise
 */
    public boolean personal_duel( Athlete j,int round){
        double attackerluck = Math.random()*15;
        double temp_attack = this.getOffence() *round*attackerluck;
        double temp_def = j.getDefence() *j.getStamina()/100;
        double temp = temp_attack - temp_def;
        double chance_success = (temp)/100 +33;
        if (chance_success > 100){
            chance_success = 100;
        }
        if (Math.random()*100 > chance_success){
            this.increaseStamina(-3);
            j.increaseStamina(-7);
            this.injury_check();
            j.injury_check();
            return false;
        }
        else{
            this.increaseStamina(-4);
            j.increaseStamina(-10);
            this.injury_check();
            j.injury_check();
        return true;

        }
    }

/**
 * Generates a random full name by combining a random first name and last name.
 *
 * @return the randomly generated full name
 */

    private static String generateName() {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Chris", "David", "Emily", "Frank", "Grace", "Henry"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Jones", "Davis", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};
        String firstName = firstNames[(int) (Math.random() * firstNames.length)];
        String lastName = lastNames[(int) (Math.random() * lastNames.length)];
        return firstName + " " + lastName;
    }

/**
 * Trains the athlete to improve their skills based on their role.
 * The training results in an increase in offense or defense, depending on the athlete's role.
 * Forwards increase their offense by 5.
 * Midfielders increase their offense by 3 and defense by 3.
 * Defenders increase their defense by 5.
 */
    public void train() {
        if (this.getRole() == "Forward"){
            this.increaseOffense(5);
        }
        else if (this.getRole() == "Midfielder"){
            this.increaseOffense(3);
            this.increaseDefense(3);
        }
        else if (this.getRole() == "Defender"){
            this.increaseDefense(5);
        }
        else if (this.getRole() == "Goalkeeper"){
            this.increaseDefense(5);
        }
        this.increaseStamina(-5);
    }

    /**
     * Returns the injury time of the athlete.
     *
     * @return The injury time of the athlete.
     */

    public int getInjurtTime() {
        injury_time=0;
        return this.injury_time;
    }
    

    
}
