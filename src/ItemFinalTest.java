public class ItemFinalTest {
    public static void main(String[] args) {
        Item item1 = new Item("Sword", "AttEquipment", 100, 80, 1, 0, 10, 0);
        Item item2 = new Item("Shield", "DefEquipment", 120, 96, 1, 0, 0, 12);
        Item item3 = new Item("staminapotion", "ConsumableItem", 0, 10, 0, 20, 0, 0);

        // Test the getters
        System.out.println("Item 1 name: " + item1.getName());
        System.out.println("Item 1 type: " + item1.getType());
        System.out.println("Item 1 store value: " + item1.getStoreValue());
        System.out.println("Item 1 sellback price: " + item1.getSellbackPrice());
        System.out.println("Item 1 amount: " + item1.getAmount());
        System.out.println("Item 1 stamina boost: " + item1.getStaminaBoost());
        System.out.println("Item 1 offense boost: " + item1.getOffenseBoost());
        System.out.println("Item 1 defense boost: " + item1.getDefenseBoost());

        // Test the setters
        item1.setName("Greatsword");
        item1.setStoreValue(150);
        item1.setSellbackPrice(120);
        item1.setAmount(2);
        System.out.println("Item 1 new name: " + item1.getName());
        System.out.println("Item 1 new store value: " + item1.getStoreValue());
        System.out.println("Item 1 new sellback price: " + item1.getSellbackPrice());
        System.out.println("Item 1 new amount: " + item1.getAmount());

        // Test the increase and decrease amount methods
        item2.increaseAmount(3);
        System.out.println("Item 2 new amount after increase: " + item2.getAmount());
        item3.decreaseAmount(1);
        System.out.println("Item 3 new amount after decrease: " + item3.getAmount());

        // Test the applyToAthlete method
        Athlete athlete = new Athlete("John", 20, 10, 5, "Forward", 100, 90, 1);
        Item item = new Item("Energy Drink","DefEquipment" , 30, 40, 1);
        item.applyToAthlete(athlete);

        // Test the generate_item method
        Item item4 = Item.generate_item(2, "AttEquipment");
        System.out.println("Generated item 4: " + item4.getName());
        Item item5 = Item.generate_item(3, "ConsumableItem");
        System.out.println("Generated item 5: " + item5.getName());
       
      

    }
}

