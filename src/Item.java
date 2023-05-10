public class Item implements purchaseable{
    //item class
    private String name;
    private String type;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
    private int staminaBoost;
    private int offenseBoost;
    private int defenseBoost;
   
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
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
        this.storeValue = 0;
        this.sellbackPrice = 0;
        this.amount = 0;
        this.staminaBoost = 0;
        this.offenseBoost = 0;
        this.defenseBoost = 0;
    }
    public Item(String name, String type, int staminaBoost, int offenseBoost, int defenseBoost) {
        this.name = name;
        this.type = type;
        this.amount = 1;
        this.staminaBoost = staminaBoost;
        this.offenseBoost = offenseBoost;
        this.defenseBoost = defenseBoost;
        setStoreValue();
        setSellbackPrice();
        
    }
    public int getStoreValue() {
        return storeValue;
    }

    public int getSellbackPrice() {
        return sellbackPrice;
    }

    public int getAmount() {
        return amount;
    }
    public int getStaminaBoost() {
        return staminaBoost;
    }
   
    public int getOffenseBoost() {
        return offenseBoost;
    }
   
    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }
    public String getName() {
        return name;
    }
   
    public String getType() {
        return type;
    }
   
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }

    @Override
    public void setSellbackPrice(int sellbackPrice) {
        
        this.sellbackPrice = sellbackPrice;    }

    public void setAmount(int amount) {
        this.amount = amount;    }

    public void applyToAthlete(Athlete athlete) {
        if (this instanceof EffectItem) {
            Item Item = (Item) this;
            athlete.increaseStamina(Item.getStaminaBoost());
            athlete.increaseOffense(Item.getOffenseBoost());
            athlete.increaseDefense(Item.getDefenseBoost());
        }
    }

    public void setStoreValue() {
        this.storeValue = (int) (this.staminaBoost * 2 + this.offenseBoost * 5 + this.defenseBoost * 5);
    }
    public void setSellbackPrice() {
        this.sellbackPrice = (int) (this.storeValue * 0.8);
    }

    
    public static Item generate_item(int turn,String type){
        if (type =="EquipmentItem" | type =="AttEquipment" | type =="DefEquipment"){
            return generate_Equipmentitem(turn, type = "EquipmentItem");
        }
        else if (type =="ConsumableItem"| type =="staminapotion" | type =="offensepotion" | type =="defensepotion"){
            return generate_consumableitem(turn);
        }
        else{
            return null;
        }
    }
    private static Item generate_consumableitem(int turn) {
        String[] consumableNames = {"staminapotion", "offensepotion", "defensepotion"};
        String name = consumableNames[(int) (Math.random() * consumableNames.length)];
        int staminaBoost = 0;
        int offenseBoost = 0;
        int defenseBoost = 0;
        if (name == "staminapotion"){
             staminaBoost = (int) (5) + 5*turn;
        }
        else if (name == "offensepotion"){
             offenseBoost = (int) (5) + 5*turn;
        }
        else if (name == "defensepotion"){
             defenseBoost = (int) (5) + 5*turn;
        }
        
        Item item = new Item(name, "ConsumableItem",0, 0, 0, staminaBoost, offenseBoost, defenseBoost);

        return item;
    }
    private static Item generate_Equipmentitem(int turn, String type) {
        String[] offenseNames = {"Sword", "Hammer", "Shiv"};
        String[] defenseNames = {"Shield", "Chainmail", "Platemail"};
        if (type == "AttEquipment"){
            String name = offenseNames[(int) (Math.random() * offenseNames.length)];
            int offenseBoost = (int) (5) + 5*turn;
            
            Item item = new Item(name, "AttEquipment",0, offenseBoost, 0);
            return item;}
        else if (type == "DefEquipment"){
            String name = defenseNames[(int) (Math.random() * defenseNames.length)];
            int defenseBoost = (int) (5) + 5*turn;
            
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
