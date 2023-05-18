import org.junit.Test;
import static org.junit.Assert.*;

public class FinalItemTest {

    @Test
    public void testItemConstructor() {
        Item item = new Item("Sword", "Weapon", 100, 80, 70, 5, 10, 5);

        // Assert the values are set correctly
        assertEquals("Sword", item.getName());
        assertEquals("Weapon", item.getType());
        assertEquals(100, item.getStoreValue());
        assertEquals(80, item.getSellbackPrice());
        assertEquals(70, item.getAmount());
        assertEquals(5, item.getStaminaBoost());
        assertEquals(10, item.getOffenseBoost());
        assertEquals(5, item.getDefenseBoost());
    }

    @Test
    public void testIncreaseAmount() {
        Item item = new Item("Potion", "Consumable", 50, 0, 0);

        // Increase the amount and assert the updated value
        item.increaseAmount(3);
        assertEquals(4, item.getAmount());

        // Increase the amount again and assert the updated value
        item.increaseAmount(2);
        assertEquals(6, item.getAmount());
    }

    @Test
    public void testDecreaseAmount() {
        Item item = new Item("Potion", "Consumable", 50, 0, 0);

        // Set the initial amount to 5
        item.setAmount(5);

        // Decrease the amount and assert the updated value
        item.decreaseAmount(2);
        assertEquals(3, item.getAmount());

        // Decrease the amount again and assert the updated value
        item.decreaseAmount(2);
        assertEquals(1, item.getAmount());
    }

  

    

    
        @Test
        public void testGettersAndSetters() {
            Item item = new Item("Sword", "Weapon", 100, 80, 70, 5, 10, 5);
    
            // Test getters
            assertEquals("Sword", item.getName());
            assertEquals("Weapon", item.getType());
            assertEquals(100, item.getStoreValue());
            assertEquals(80, item.getSellbackPrice());
            assertEquals(70, item.getAmount());
            assertEquals(5, item.getStaminaBoost());
            assertEquals(10, item.getOffenseBoost());
            assertEquals(5, item.getDefenseBoost());
    
            // Test setters
            item.setName("Axe");
            item.setStoreValue(200);
            item.setSellbackPrice(160);
            item.setAmount(50);
            assertEquals("Axe", item.getName());
            assertEquals(200, item.getStoreValue());
            assertEquals(160, item.getSellbackPrice());
            assertEquals(50, item.getAmount());
        }
    
        @Test
        public void testApplyToAthlete() {
            Athlete athlete = new Athlete("John", 100, 50, 50, "Forward", 100, 80, 1);
            Item item = new Item("Potion", "Consumable", 0, 0, 0, 10, 5, 5);
    
            // Apply the item to the athlete and assert the updated stats
            item.applyToAthlete(athlete);
            assertEquals(110, athlete.getStamina());
            assertEquals(55, athlete.getOffence());
            assertEquals(55, athlete.getDefence());
        }
    
        @Test
        public void testSetStoreValueAndSellbackPrice() {
            Item item = new Item("Sword", "Weapon", 100, 0, 0, 5, 10, 5);
    
            // Set the store value and assert the updated value
            item.setStoreValue();
            assertEquals(85, item.getStoreValue());
    
            // Set the sellback price and assert the updated value
            item.setSellbackPrice();
            assertEquals(68, item.getSellbackPrice());
        }
    
        @Test
        public void testGenerateItem() {
           
    
            Item item1 = Item.generate_item(1, "Attack Potion");
            assertNotNull(item1);
            assertEquals("ConsumableItem", item1.getType());
    
            Item item2 = Item.generate_item(1, "InvalidType");
            assertNull(item2);
        }
    
      
    
    }
    



