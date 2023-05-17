import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;

public class FinalMarketTwoTest {
    private MarketTwo market;
    private Player player;
  

    @Test
    public void testGetAthletes() {
        MarketTwo market = new MarketTwo();
        assertEquals(0, market.getAthletes().size());

        // Add some athletes to the market
        Athlete athlete1 = new Athlete("John", 100, 80, 70, "Forward", 100, 80, 1);
        Athlete athlete2 = new Athlete("Mike", 90, 75, 85, "Midfielder", 90, 70, 1);
        market.addAthlete(athlete1);
        market.addAthlete(athlete2);

        // Test the getAthletes method
        assertEquals(2, market.getAthletes().size());
        assertTrue(market.getAthletes().contains(athlete1));
        assertTrue(market.getAthletes().contains(athlete2));
    }

    @Test
    public void testGetItems() {
        MarketTwo market = new MarketTwo();
        assertEquals(0, market.getItems().size());

        // Add some items to the market
        Item item1 = new Item("Football", "Equipment", 50, 30, 1);
        Item item2 = new Item("Basketball", "Equipment", 40, 25, 1);
        market.addItem(item1);
        market.addItem(item2);

        // Test the getItems method
        assertEquals(2, market.getItems().size());
        assertTrue(market.getItems().contains(item1));
        assertTrue(market.getItems().contains(item2));
    }

    @Test
    public void testGettersAndSetters(){
        // test the getAthleteByName method
        MarketTwo market = new MarketTwo();
        Athlete athlete1 = new Athlete("John", 100, 80, 70, "Forward", 100, 80, 1);
        market.addAthlete(athlete1);
      

        Athlete athlete = market.getAthleteByName("John");
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteByStamina method
        athlete = market.getAthleteByStamina(100);
        System.out.println(athlete.getName()); // expected output: LeBron James

        // test the getAthleteByoffence method
        athlete = market.getAthleteByoffence(80);
        System.out.println(athlete.getName()); // expected output: Michael Jordan

        // test the getAthleteByDefence method
        athlete = market.getAthleteByDefence(70);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteByRole method
        athlete = market.getAthleteByRole("Forward");
        System.out.println(athlete.getName()); // expected output: LeBron James

        // test the getAthleteByStoreValue method
        athlete = market.getAthleteByStoreValue(100);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteBySellbackprice method
        athlete = market.getAthleteBySellbackprice(80);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteAmount method
        int athleteAmount = market.getAthleteAmount();
        System.out.println(athleteAmount); // expected output: 3

        Item item1 = new Item("Football", "Equipment", 50, 30, 1);
        Item item2 = new Item("Basketball", "Equipment", 40, 25, 1);
        market.addItem(item1);
        market.addItem(item2);

        // test the getItemByName method
        Item item = market.getItemByName("Football");
        System.out.println(item.getName()); // expected output: Running Shoes

        // test the getItemByType method
        item = market.getItemByType("Equipment");
        System.out.println(item.getName()); // expected output: Basketball

        // test the getItemByStoreValue method
       
        int x =item1.getStoreValue();
        item = market.getItemByStoreValue(x);
        System.out.println(item.getName()); // expected output: Running Shoes

        // test the getItemBySellbackPrice method
        int y =item2.getSellbackPrice();
        item = market.getItemBySellbackPrice(y);
        System.out.println(item.getName()); // expected output: Water Bottle

        // test the getItemAmount method
        int itemAmount = market.getItemAmount("Basketball");
        System.out.println(itemAmount);

    }

    @Before
    public void setup() {
        market = new MarketTwo();
        player = new Player("Easy", "t");
        Item item = new Item("Football", "Equipment", 50, 30, 1);

        market.addItem(item);
    }

    @Test
    public void testDisplayMarket() {
        // Test case with athletes and items in the market
        Athlete athlete = new Athlete("Kobe Bryant", 100, 80, 70, "Forward", 100, 80, 1);
        market.addAthlete(athlete);

        String expectedOutput = "Athletes in market:\nKobe Bryant   100\nItems in market:\nFootball   255";
        Assert.assertEquals(expectedOutput, captureStandardOutput(() -> market.displaymarket()));
    }


    @Test
    public void testBuyItemSuccess() {
        // Test case for successful item purchase
       
        Item item = new Item("Football", "Equipment", 50, 30, 1);
        market.addItem(item);
        boolean result = market.buyItem(player, item);
        Assert.assertTrue(result);
        Assert.assertEquals(245, player.getGold());
        Assert.assertEquals(0, item.getAmount());
    }

    @Test
    public void testBuyItemInsufficientGold() {
        // Test case for insufficient gold to buy the item
        player.setGold(50);
        Item item = new Item("Football", "Equipment", 50, 30, 1);

        boolean result = market.buyItem(player, item);

        Assert.assertFalse(result);
        Assert.assertEquals(50, player.getGold());
        Assert.assertEquals(1, item.getAmount());
    }

    @Test
    public void testBuyItemNotAvailable() {
        // Test case for item not available in the market
        Item otherItem = new Item("Armor", "Equipment", 200, 5, 0);
        

        boolean result = market.buyItem(player, otherItem);

        Assert.assertFalse(result);
        Assert.assertEquals(500, player.getGold());
    }

    // Helper method to capture console output
    private String captureStandardOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream standardOut = System.out;
        System.setOut(printStream);

        action.run();

        System.out.flush();
        System.setOut(standardOut);
        return outputStream.toString().trim();
    }

    @Test
    public void testGenerateItems() {
        int attributeStrength = 50;
    market.generateItems(attributeStrength);

    // Assert that items have been generated
    Assert.assertFalse(market.getItems().isEmpty());

    // Assert that all generated items have the correct attribute boosts
    for (Item item : market.getItems()) {
        int expectedOffenseBoost = attributeStrength * item.getOffenseBoost()/50;
        int expectedDefenseBoost = attributeStrength * item.getDefenseBoost()/50;
        Assert.assertEquals(expectedOffenseBoost, item.getOffenseBoost());
        Assert.assertEquals(expectedDefenseBoost, item.getDefenseBoost());
    }
}




    @Test
    public void testGenerateMarket() {
        int turn = 1;
        market.generatemarket(turn);

        // Assert that athletes and items have been generated
        Assert.assertFalse(market.getAthletes().isEmpty());
        Assert.assertFalse(market.getItems().isEmpty());
    }

    @Test
    public void testBuyAthleteSuccess() {
        // Test case for successful athlete purchase
        Athlete athlete = new Athlete("Kobe Bryant", 100, 80, 70, "Forward", 100, 80, 1);
        market.addAthlete(athlete);

        boolean result = market.buyAthlete(player, athlete);

        Assert.assertTrue(result);
        Assert.assertEquals(400, player.getGold());
        Assert.assertEquals(0, athlete.getAmount());
    }

    @Test
    public void testBuyAthleteInsufficientGold() {
        // Test case for insufficient gold to buy the athlete
        player.setGold(50);

        Athlete athlete = new Athlete("Kobe Bryant", 100, 80, 70, "Forward", 100, 80, 1);

        boolean result = market.buyAthlete(player, athlete);

        Assert.assertFalse(result);
        Assert.assertEquals(50, player.getGold());
        Assert.assertEquals(1, athlete.getAmount());
    }

    @Test
    public void testBuyAthleteNotAvailable() {
        // Test case for athlete not available in the market
        Athlete athlete = new Athlete("Kobe Bryant", 100, 80, 70, "Forward", 100, 80, 1);

        boolean result = market.buyAthlete(player, athlete);

        Assert.assertFalse(result);
        Assert.assertEquals(500, player.getGold());
    }




}




   

    



