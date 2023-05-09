import java.util.ArrayList;

public class MarketTwo {
    private ArrayList<Athlete> athletes;
    private ArrayList<Item> items;
    private ArrayList<EffectItem> effectItems;
    
    
    public MarketTwo() {
        this.athletes = new ArrayList<Athlete>();
        this.items = new ArrayList<Item>();
    }
    
    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }
    
    public void addItem(Item item) {
        items.add(item);
    }

    public void addEffectItem(EffectItem effectItem){
        effectItems.add(effectItem);
    }
    
    public ArrayList<Athlete> getAthletes() {
        return athletes;
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    
    public void removeAthlete(Athlete athlete) {
        athletes.remove(athlete);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public Athlete getAthleteByName(String name) {
        for (Athlete athlete : athletes) {
            if (athlete.getName().equals(name)) {
                return athlete;
            }
        }
        return null;
    }
    
    public Athlete getAthleteByStamina(int stamina) {
        for (Athlete athlete : athletes) {
            if (athlete.getStamina() == stamina) {
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByoffence(int offence) {
        for (Athlete athlete : athletes) {
            if (athlete.getOffence() == offence) {
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByDefence(int defence){
        for (Athlete athlete : athletes){
            if (athlete.getDefence()==defence){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByRole(String role){
        for(Athlete athlete : athletes){
            if(athlete.getRole()==role){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByStoreValue(int storeValue){
        for(Athlete athlete : athletes){
            if(athlete.getStoreValue()==storeValue){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteBySellbackprice(int sellbackPrice){
        for(Athlete athlete : athletes){
            if(athlete.getSellbackPrice()==sellbackPrice){
                return athlete;
            }
        }
        return null;
    }

    public int getAthleteAmount() {
        int totalAmount = 0;
        for (Athlete athlete : athletes) {
            totalAmount += athlete.getAmount();
        }
        return totalAmount;
    }
    

    
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemByType(String type) {
        for (Item item : items) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }

    public Item getItemByStoreValue(int storeValue){
        for(Item item:items){
            if(item.getStoreValue()==(storeValue)){
                return item;
            }
        }
        return null;
    }

    public Item getItemBySellbackPrice(int sellbackPrice){
        for(Item item:items){
            if(item.getSellbackPrice()==(sellbackPrice)){
                return item;
            }
        }
        return null;
    }
  
    public EffectItem getEffectItemByName(String name) {
        for (EffectItem effectItem : effectItems) {
            if (effectItem.getName().equals(name)) {
                return effectItem;
            }
        }
        return null;
    }

    public EffectItem getEffectItemBytype(String type){
        for(EffectItem effectItem : effectItems){
            if(effectItem.getType().equals(type)){
                return effectItem;
            }
        }
        return null;
    }

    public EffectItem getEffectItemByStaminaBoost(int staminaBoost){
        for(EffectItem effectItem : effectItems){
            if(effectItem.getStaminaBoost()==(staminaBoost)){
                return effectItem;
            }
        }
        return null;
    }

    public  EffectItem getEffectItemByOffenseBoost(int  offenseBoost){
        for(EffectItem effectItem : effectItems){
            if(effectItem.getOffenseBoost()==(offenseBoost)){
                return effectItem;
            }
        }
        return  null;
    }

    public EffectItem getEffectItemBydefenseBoost(int defenseBoost){
        for(EffectItem effectItem : effectItems){
            if(effectItem.getDefenseBoost()==(defenseBoost)){
                return effectItem;
            }
        }
        return null;

    }
    

    public int getItemAmount(String itemName) {
        int totalAmount = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                totalAmount += item.getAmount();
            }
        }
        return totalAmount;
    }

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
    //1.Here, the method takes in a Player object and an Item object as parameters. 
    //It first checks if the player has enough gold to buy the item and if the item is available in the market. 
    //If both conditions are met, it reduces the item amount by 1 and updates the player's gold by reducing the item's price from it.

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
    
    public void generateEffectItems(int attributeStrength) {
        String[] effectNames = {"Elixir", "Potion", "Tonic", "Serum", "Ointment"};
        for (int i = 0; i < 10; i++) {
            String name = effectNames[(int) (Math.random() * effectNames.length)];
            int staminaBoost = (int) ((Math.random() * 20) + 10) * attributeStrength;
            int offenseBoost = (int) ((Math.random() * 5) + 1) * attributeStrength;
            int defenseBoost = (int) ((Math.random() * 5) + 1) * attributeStrength;
            EffectItem effectItem = new EffectItem(name, "effect", staminaBoost, offenseBoost, defenseBoost);
            addEffectItem(effectItem);
        }

        String[] athleteNames = {"John", "Jane", "Bob", "Alice", "Tom", "Jerry", "Mike", "Sarah"};
        String[] roles = {"Forward", "Midfielder", "Defender", "Goalkeeper"};
    
        for (int i = 0; i < 5; i++) {
            String name = athleteNames[(int) (Math.random() * athleteNames.length)];
            int stamina = (int) (Math.random() * 50) + 50;
            int offense = (int) (Math.random() * 10) + 10;
            int defence = (int) (Math.random() * 10) + 10;
            String role = roles[(int) (Math.random() * roles.length)];
            int value = (int) (Math.random() * 500) + 500;
            int amount = (int) (Math.random() * 2) + 1;
            Athlete athlete = new Athlete(name, stamina, offense, defence, role, value, value / 2, amount);
            addAthlete(athlete);;
        }
    }

    // 2.If as the attribute strength of a character increases, 
    //so does the attribute strength of things that can support that character and athletes.
    //By Andy's idea anything need change andy go on 

 
}

