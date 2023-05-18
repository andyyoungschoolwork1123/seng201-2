public class ItemTest {
        public static void main(String[] args) {
            // create an instance of the Item class with values
            Item item = new Item("Sword", "Weapon", 500, 250, 1);
    
            // test get methods
            System.out.println("Item name: " + item.getName());
            System.out.println("Item type: " + item.getType());
            System.out.println("Item store value: " + item.getStoreValue());
            System.out.println("Item sellback price: " + item.getSellbackPrice());
            System.out.println("Item amount: " + item.getAmount());
    
            // test set methods
            item.setStoreValue(600);
            item.setSellbackPrice(300);
            item.setAmount(2);
    
            // test get methods after setting new values
            System.out.println("Item name: " + item.getName());
            System.out.println("Item type: " + item.getType());
            System.out.println("Item store value: " + item.getStoreValue());
            System.out.println("Item sellback price: " + item.getSellbackPrice());
            System.out.println("Item amount: " + item.getAmount());
    
            // test increase and decrease amount methods
            item.increaseAmount(1);
            System.out.println("Item amount after increasing: " + item.getAmount());
    
            item.decreaseAmount(1);
            System.out.println("Item amount after decreasing: " + item.getAmount());
        }
    }
    
