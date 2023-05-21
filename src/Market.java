import java.util.ArrayList;

/**
 * The Market class represents a market where athletes and items are available for sale.
 */
public class Market {
    private ArrayList<Athlete> athletes;
    private ArrayList<Item> items;
    
    /**
     * Constructs a new Market object.
     */
    public Market() {
        this.athletes = new ArrayList<Athlete>();
        this.items = new ArrayList<Item>();
    }

    /**
     * Returns the list of athletes in the market.
     *
     * @return The list of athletes.
     */
    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }
        /**
     * Returns the list of items in the market.
     *
     * @return The list of items.
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Removes the specified athlete from the market.
     *
     * @param athlete The athlete to remove.
     */
    public void removeAthlete(Athlete athlete) {
        athletes.remove(athlete);
    }
    /**
     * Removes the specified item from the market.
     *
     * @param item The item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }
    /**
     * Retrieves an athlete from the market based on the specified name.
     *
     * @param name The name of the athlete.
     * @return The found athlete or null if not found.
     */
    public Athlete getAthleteByName(String name) {
        for (Athlete athlete : athletes) {
            if (athlete.getName().equals(name)) {
                return athlete;
            }
        }
        return null;
    }
/**
     * Retrieves an athlete from the market based on the specified stamina.
     *
     * @param stamina The stamina of the athlete.
     * @return The found athlete or null if not found.
     */
    public Athlete getAthleteByStamina(int stamina) {
        for (Athlete athlete : athletes) {
            if (athlete.getStamina() == stamina) {
                return athlete;
            }
        }
        return null;
    }
    /**
     * Retrieves an athlete from the market based on the specified offence.
     *
     * @param offence The offence of the athlete.
     * @return The found athlete or null if not found.
     */
    public Athlete getAthleteByoffence(int offence) {
        for (Athlete athlete : athletes) {
            if (athlete.getOffence() == offence) {
                return athlete;
            }
        }
        return null;
    }
    /**
     * Retrieves an athlete from the market based on the specified defence.
     *
     * @param defence The defence of the athlete.
     * @return The found athlete or null if not found.
     */
    public Athlete getAthleteByDefence(int defence){
        for (Athlete athlete : athletes){
            if (athlete.getDefence()==defence){
                return athlete;
            }
        }
        return null;
    }
/**
 * Retrieves an athlete from the market based on the specified role.
 *
 * @param role The role of the athlete.
 * @return The found athlete or null if not found.
 */
    public Athlete getAthleteByRole(String role){
        for(Athlete athlete : athletes){
            if(athlete.getRole()==role){
                return athlete;
            }
        }
        return null;
    }
/**
 * Retrieves an athlete from the market based on the specified store value.
 *
 * @param storeValue The store value of the athlete.
 * @return The found athlete or null if not found.
 */
    public Athlete getAthleteByStoreValue(int storeValue){
        for(Athlete athlete : athletes){
            if(athlete.getStoreValue()==storeValue){
                return athlete;
            }
        }
        return null;
    }
/**
 * Retrieves an athlete from the market based on the specified sellback price.
 *
 * @param sellbackPrice The sellback price of the athlete.
 * @return The found athlete or null if not found.
 */
    public Athlete getAthleteBySellbackprice(int sellbackPrice){
        for(Athlete athlete : athletes){
            if(athlete.getSellbackPrice()==sellbackPrice){
                return athlete;
            }
        }
        return null;
    }
/**
 * Calculates the total amount of athletes in the market.
 *
 * @return The total amount of athletes.
 */
    public int getAthleteAmount() {
        int totalAmount = 0;
        for (Athlete athlete : athletes) {
            totalAmount += athlete.getAmount();
        }
        return totalAmount;
    }
    

/**
 * Retrieves an item from the market based on the specified name.
 *
 * @param name The name of the item.
 * @return The found item or null if not found.
 */
    
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
/**
 * Retrieves an item from the market based on the specified type.
 *
 * @param type The type of the item.
 * @return The found item or null if not found.
 */
    public Item getItemByType(String type) {
        for (Item item : items) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }
/**
 * Retrieves an item from the market based on the specified store value.
 *
 * @param storeValue The store value of the item.
 * @return The found item or null if not found.
 */

    public Item getItemByStoreValue(int storeValue){
        for(Item item:items){
            if(item.getStoreValue()==(storeValue)){
                return item;
            }
        }
        return null;
    }
/**
 * Retrieves an item from the market based on the specified sellback price.
 *
 * @param sellbackPrice The sellback price of the item.
 * @return The found item or null if not found.
 */
    public Item getItemBySellbackPrice(int sellbackPrice){
        for(Item item:items){
            if(item.getSellbackPrice()==(sellbackPrice)){
                return item;
            }
        }
        return null;
    }
  
/**
 * Adds an athlete to the market.
 *
 * @param athlete The athlete to be added.
 */
    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }
/**
 * Adds an item to the market.
 *
 * @param item The item to be added.
 */
    public void addItem(Item item) {
        items.add(item);
    }
    
/**
 * Calculates the total amount of a specific item in the market.
 *
 * @param itemName The name of the item.
 * @return The total amount of the item.
 */
    public int getItemAmount(String itemName) {
        int totalAmount = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                totalAmount += item.getAmount();
            }
        }
        return totalAmount;
    }
/**
 * Initializes the market by adding predefined athletes and items.
 */
    public void init_market() {//5.17
        // Create and add some athletes to the market
        Athlete a1 = new Athlete("LeBron James", 90, 80, 70, "Small Forward", 1000, 500,1);
        Athlete a2 = new Athlete("Kobe Bryant", 85, 85, 75, "Shooting Guard", 800, 400,1);
        Athlete a3 = new Athlete("Michael Jordan", 95, 90, 85, "Shooting Guard", 1500, 750,1);

        athletes.add(a1);
        athletes.add(a2);
        athletes.add(a3);

        // create and add items to the market
        Item i1 = new Item("Basketball", "Equipment", 50, 25, 100);
        Item i2 = new Item("Running Shoes", "Footwear", 100, 50, 200);
        Item i3 = new Item("Water Bottle", "Accessories", 10, 5, 50);

        items.add(i1);
        items.add(i2);
        items.add(i3);
    }
/**
 * Displays the athletes and items available in the market.
 */
    public void displaymarket() {
        System.out.println("Athletes in market:");
        for (int i = 0; i < this.athletes.size(); i++) {
            System.out.println(this.athletes.get(i).getName()+ "   "
            +(this.athletes.get(i).getStoreValue()));
        }

        if (this.athletes.size() == 0) {
            System.out.println("No althele in market");
        }
        System.out.println("Items in market:");
        for (int i = 0; i < this.items.size(); i++) {
            System.out.println(this.items.get(i).getName()+ "   "
            +(this.items.get(i).getStoreValue()));
        }
        if (this.items.size() == 0) {
            System.out.println("No items in market");
        }
    }
/**Here, the method takes in a Player object and an Item object as parameters. 
    It first checks if the player has enough gold to buy the item and if the item is available in the market. 
    If both conditions are met, it reduces the item amount by 1 and updates the player's gold by reducing the item's price from it.
 */
    public boolean buyItem(Player player, Item item) {
        // check if the player has enough gold to buy the item
        if (player.getGold() < item.getStoreValue()) {
            System.out.println("You don't have enough gold to buy this item!");
            return false;
        }
    
        // check if the item is available in the market
        if (!items.contains(item)) {
            System.out.println("This item is not available in the market!");
            return false;
        }
    
        // reduce the item amount and update the player's gold
        item.decreaseAmount(1);
        player.setGold(player.getGold() - item.getStoreValue());
    
        System.out.println("You bought " + item.getName() + " for " + item.getStoreValue() + " gold!");
        return true;
    }
 
/**the attribute strength of a character increases, 
    so does the attribute strength of things that can support that character and athletes.
    by using relvant function in Athlete and Item class to generate the item and athlete. */
    public void generateItems(int attributeStrength) {
        String[] offenseNames = {"Sword", "Axe", "Mace", "Dagger", "Bow"};
        String[] defenseNames = {"Shield", "Helmet", "Armor", "Gauntlets", "Boots"};
    
        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.33) {
                String name = offenseNames[(int) (Math.random() * offenseNames.length)];
                int value = (int) ((Math.random() * 50) + 50) * attributeStrength;
                int amount = (int) ((Math.random() * 5) + 1) * attributeStrength;
                Item item = new Item(name, "offense", value, value / 2, amount);
                addItem(item);
            } else if (Math.random() < 0.66) {
                String name = defenseNames[(int) (Math.random() * defenseNames.length)];
                int value = (int) ((Math.random() * 100) + 100) * attributeStrength;
                int amount = (int) ((Math.random() * 3) + 1) * attributeStrength;
                Item item = new Item(name, "defense", value, value / 2, amount);
                addItem(item);
            } else {
                // generate a random item
                String name = "Random Item " + i;
                int value = (int) ((Math.random() * 50) + 50) * attributeStrength;
                int amount = (int) ((Math.random() * 5) + 1) * attributeStrength;
                Item item = new Item(name, "random", value, value / 2, amount);
                addItem(item);
            }
        }
    }
    


/**
 * Generates athletes and items for the market based on the given turn.
 *
 * @param turn the current turn of the game
 */    
    public void generatemarket(int turn){
        for (int i = 0; i < 4; i++) {
            if (Math.random() >0.25){
                Athlete athlete = Athlete.generateAthlete(turn, "Forward");
                addAthlete(athlete);
            }
            else if (Math.random() >0.5){
                Athlete athlete = Athlete.generateAthlete(turn, "Midfielder");
                addAthlete(athlete);
            }
            else if (Math.random() >0.75){
                Athlete athlete = Athlete.generateAthlete(turn, "Defender");
                addAthlete(athlete);
            }
            else{
                Athlete athlete = Athlete.generateAthlete(turn, "Goalkeeper");
                addAthlete(athlete);
            }
            
        }
        String[] itemNames = {"Stamina Potion", "Attack Potion", "Defense Potion","EquipmentItem"};
        for (int i = 0; i < 5; i++) {
            
            Item item = Item.generate_item(turn, itemNames[(int) (Math.random() * itemNames.length)]);
            addItem(item);
        }

       

    }

/**
 * Buys an athlete from the market for the given player.
 *
 * @param player  the player who wants to buy the athlete
 * @param athlete the athlete to be bought
 * @return true if the athlete was successfully bought, false otherwise
 */
    public boolean buyAthlete(Player player, Athlete athlete) {
        // Check if the player has enough gold to buy the athlete
        if (player.getGold() < athlete.getStoreValue()) {
            System.out.println("You don't have enough gold to buy this athlete!");
            return false;
        }
    
        // Check if the athlete is available in the market
        if (!athletes.contains(athlete)) {
            System.out.println("This athlete is not available in the market!");
            return false;
        }
    
        // Reduce the athlete's availability and update the player's gold
        athlete.decreaseAmount(getAthleteAmount());;
        player.setGold(player.getGold() - athlete.getStoreValue());
    
        System.out.println("You bought " + athlete.getName() + " for " + athlete.getStoreValue() + " gold!");
        return true;
    }
    
    


    
 
}

