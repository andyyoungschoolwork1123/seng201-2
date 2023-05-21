/**
 * Represents an item in the game.
 */


public class Item{
    //item class
    public String name;
    private String type;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
    private int staminaBoost;
    private int offenseBoost;
    private int defenseBoost;
   
    /**
     * Constructs an Item object with the specified properties.
     *
     * @param name           The name of the item.
     * @param type           The type of the item.
     * @param storeValue     The value of the item when purchased from a store.
     * @param sellbackPrice  The price at which the item can be sold back to a store.
     * @param amount         The quantity of the item.
     * @param staminaBoost   The amount of stamina boost provided by the item.
     * @param offenseBoost   The amount of offense boost provided by the item.
     * @param defenseBoost   The amount of defense boost provided by the item.
     */

    public Item(String name, String type, int storeValue, int sellbackPrice, int amount,int staminaBoost, int offenseBoost, int defenseBoost) {
        this.name = name;
        this.type = type;
        this.storeValue = storeValue;
        this.sellbackPrice = sellbackPrice;
        this.amount = amount;
        this.staminaBoost = staminaBoost;
        this.offenseBoost = offenseBoost;
        this.defenseBoost = defenseBoost;

    }

  /**
     * for generate Item.
     *
     * @param name           The name of the item.
     * @param type           The type of the item.
     * @param staminaBoost   The amount of stamina boost provided by the item.
     * @param offenseBoost   The amount of offense boost provided by the item.
     * @param defenseBoost   The amount of defense boost provided by the item.
     */
    public Item(String name, String type, int staminaBoost, int offenseBoost, int defenseBoost) {
        this.name = name;
        this.type = type;
        this.amount = 1;
        this.staminaBoost = staminaBoost;
        this.offenseBoost = offenseBoost;
        this.defenseBoost = defenseBoost;
        this.setStoreValue();
        this.setSellbackPrice();
        
    }
    /**
     * Returns a string representation of the item.
     *
     * @return A string representation of the item.
     */
    public String toString() {
        return this.name;
    }

    // ... constructor and other methods
    
    /**
     * Returns the store value of the item.
     *
     * @return The store value of the item.
     */  
    public int getStoreValue() {
        return this.storeValue;
    }
    /**
     * Returns the sellback price of the item.
     *
     * @return The sellback price of the item.
     */
    public int getSellbackPrice() {
        return this.sellbackPrice;
    }

    /**
     * Returns the amount of the item.
     *
     * @return The amount of the item.
     */

    public int getAmount() {
        return this.amount;
    }

    /**
     * Returns the stamina boost provided by the item.
     *
     * @return The stamina boost provided by the item.
     */

    public int getStaminaBoost() {
        return this.staminaBoost;
    }
    /**
     * Returns the offense boost provided by the item.
     *
     * @return The offense boost provided by the item.
     */

    public int getOffenseBoost() {
        return this.offenseBoost;
    }
     /**
     * Returns the defense boost provided by the item.
     *
     * @return The defense boost provided by the item.
     */  
    public int getDefenseBoost() {
        return this.defenseBoost;
    }
    /**
     * Increases the amount of the item by the specified value.
     *
     * @param amount The value by which to increase the item amount.
     */
    public void increaseAmount(int amount) {
        this.amount += amount;
    }
    /**
     * Decreases the amount of the item by the specified value.
     *
     * @param amount The value by which to decrease the item amount.
     */
    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }
  
    /**
     * Returns the type of the item.
     *
     * @return The type of the item.
     */
    public String getType() {
        return type;
    }
       /**
     * Sets the name of the item.
     *
     * @param name The name to set for the item.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the store value of the item.
     *
     * @param storeValue The store value to set for the item.
     */
    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }

     /**
     * Sets the sellback price of the item.
     *
     * @param sellbackPrice The sellback price to set for the item.
     */
    public void setSellbackPrice(int sellbackPrice) {
        
        this.sellbackPrice = sellbackPrice;    }
 /**
     * Sets the amount of the item.
     *
     * @param amount The amount to set for the item.
     */
    public void setAmount(int amount) {
        this.amount = amount;    }

    /**
     * Applies the item's boosts to the specified athlete.
     *
     * @param athlete The athlete to apply the item's boosts to.
     */
    public void applyToAthlete(Athlete athlete) {
            athlete.increaseStamina(this.getStaminaBoost());
            athlete.increaseOffense(this.getOffenseBoost());
            athlete.increaseDefense(this.getDefenseBoost());
        
    }
    /**
     * Displays the details of the item.
     * Prints the item's name, type, store value, sellback price, amount,
     * stamina boost, offense boost, and defense boost.
     */
    public String displayitem(Item item){
        StringBuilder itemInfo = new StringBuilder();
        itemInfo.append("Name: ").append(item.getName()).append("\n");
        itemInfo.append("Type: ").append(item.getType()).append("\n");
        itemInfo.append("Price: ").append(item.getStoreValue()).append("\n");
        itemInfo.append("Offence: ").append(item.getOffenseBoost()).append("\n");
        itemInfo.append("Defence: ").append(item.getDefenseBoost()).append("\n");
        return itemInfo.toString();
    }
    /**
     * Sets the store value of the item based on its boosts.
     * The store value is calculated using a formula.
     */
    public void setStoreValue() {
        this.storeValue = (int) (this.staminaBoost * 2 + this.offenseBoost * 5 + this.defenseBoost * 5);
    }
    /**
     * Sets the sellback price of the item based on its store value.
     * The sellback price is calculated as 80% of the store value.
     */
    public void setSellbackPrice() {
        this.sellbackPrice = (int) (this.storeValue * 0.8);
    }

    /**
     * Generates an item based on the specified turn and type.
     *
     * @param turn The turn number.
     * @param type The type of item to generate.
     * @return The generated item.
     */
    public static Item generate_item(int turn,String type){
        if (type =="EquipmentItem" | type =="AttEquipment" | type =="DefEquipment"){
            return generate_Equipmentitem(turn, type = "EquipmentItem");
        }
        else if (type =="ConsumableItem"| type =="Stamina Potion" | type =="Attack Potion" | type =="Defense Potion"){
            return generate_consumableitem(turn);
        }
        else{
            return null;
        }
    }

/**
 * Displays the details of the item.
 * Prints the item's name, type, store value, sellback price, amount,
 * stamina boost, offense boost, and defense boost.
 */
    public void display(){
        System.out.println("Item name: " + this.getName());
        System.out.println("Item type: " + this.getType());
        System.out.println("Item store value: " + this.getStoreValue());
        System.out.println("Item sellback price: " + this.getSellbackPrice());
        System.out.println("Item amount: " + this.getAmount());
        System.out.println("Item stamina boost: " + this.getStaminaBoost());
        System.out.println("Item offense boost: " + this.getOffenseBoost());
        System.out.println("Item defense boost: " + this.getDefenseBoost());
    }
/**
 * Generates a consumable item based on the given turn.
 *
 * @param turn The current turn.
 * @return The generated consumable item.
 */
    private static Item generate_consumableitem(int turn) {
        String[] consumableNames = {"Stamina Potion", "Attack Potion", "Defense Potion"};
        String name = consumableNames[(int) (Math.random() * consumableNames.length)];
        int staminaBoost = 0;
        int offenseBoost = 0;
        int defenseBoost = 0;
        if (name.equals("Stamina Potion")) {
            staminaBoost = 5 + 5 * turn;
        } else if (name.equals("Attack Potion")) {
            offenseBoost = 5 + 5 * turn;
        } else if (name.equals("Defense Potion")) {
            defenseBoost = 5 + 5 * turn;
        }
        Item item = new Item(name, "ConsumableItem", staminaBoost, offenseBoost, defenseBoost);
        return item;
    }

/**
 * Generates an equipment item based on the given turn and type.
 *
 * @param turn The current turn.
 * @param type The type of equipment item to generate.
 * @return The generated equipment item.
 */
    private static Item generate_Equipmentitem(int turn, String type) {
        String[] offenseNames = {"Shoes", "Head Band", "Boots"};
        String[] defenseNames = {"Gloves", "Book: Teamwork", "Pads"};
        if (type == "AttEquipment"){
            String name = offenseNames[(int) (Math.random() * offenseNames.length)];
            int offenseBoost = 5 + 5*turn;
            
            Item item = new Item(name, "AttEquipment",0, offenseBoost, 0);
            return item;}
        else if (type == "DefEquipment"){
            String name = defenseNames[(int) (Math.random() * defenseNames.length)];
            int defenseBoost =  5 + 5*turn;
            
            Item item = new Item(name, "DefEquipment",0, 0, defenseBoost);
            return item;
        }
        else{
            if (Math.random() < 0.5) {
                String name = offenseNames[(int) (Math.random() * offenseNames.length)];
                int offenseBoost = (int) (5) + 5*turn;
                
                Item item = new Item(name, "AttEquipment",0, offenseBoost, 0);
                return item;}
            else {
                String name = defenseNames[(int) (Math.random() * defenseNames.length)];
                int defenseBoost = (int) (5) + 5*turn;
                Item item = new Item(name, "DefEquipment",0, 0, defenseBoost);
                return item;
            }
        
        }
    }
    

    
}
