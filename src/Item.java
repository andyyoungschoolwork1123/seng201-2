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
        this.setStoreValue();
        this.setSellbackPrice();
        
    }
    public int getStoreValue() {
        return this.storeValue;
    }

    public int getSellbackPrice() {
        return this.sellbackPrice;
    }

    public int getAmount() {
        return this.amount;
    }
    public int getStaminaBoost() {
        return this.staminaBoost;
    }
   
    public int getOffenseBoost() {
        return this.offenseBoost;
    }
   
    public int getDefenseBoost() {
        return this.defenseBoost;
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

    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }

   
    public void setSellbackPrice(int sellbackPrice) {
        
        this.sellbackPrice = sellbackPrice;    }

    public void setAmount(int amount) {
        this.amount = amount;    }

    public void applyToAthlete(Athlete athlete) {
            athlete.increaseStamina(this.getStaminaBoost());
            athlete.increaseOffense(this.getOffenseBoost());
            athlete.increaseDefense(this.getDefenseBoost());
        
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
    private static Item generate_consumableitem(int turn) {
        String[] consumableNames = {"staminapotion", "offensepotion", "defensepotion"};
        String name = consumableNames[(int) (Math.random() * consumableNames.length)];
        int staminaBoost = 0;
        int offenseBoost = 0;
        int defenseBoost = 0;
        if (name.equals("staminapotion")) {
            staminaBoost = 5 + 5 * turn;
        } else if (name.equals("offensepotion")) {
            offenseBoost = 5 + 5 * turn;
        } else if (name.equals("defensepotion")) {
            defenseBoost = 5 + 5 * turn;
        }
        Item item = new Item(name, "ConsumableItem", staminaBoost, offenseBoost, defenseBoost);
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
