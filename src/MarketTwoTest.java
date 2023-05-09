public class MarketTwoTest {
    public static void main(String[] args) {
        MarketTwo market = new MarketTwo();

        // create and add athletes to the market
        Athlete a1 = new Athlete("LeBron James", 90, 80, 70, "Small Forward", 1000, 500,1);
        Athlete a2 = new Athlete("Kobe Bryant", 85, 85, 75, "Shooting Guard", 800, 400,1);
        Athlete a3 = new Athlete("Michael Jordan", 95, 90, 85, "Shooting Guard", 1500, 750,1);

        market.addAthlete(a1);
        market.addAthlete(a2);
        market.addAthlete(a3);

        // create and add items to the market
        Item i1 = new Item("Basketball", "Equipment", 50, 25, 100);
        Item i2 = new Item("Running Shoes", "Footwear", 100, 50, 200);
        Item i3 = new Item("Water Bottle", "Accessories", 10, 5, 50);

        market.addItem(i1);
        market.addItem(i2);
        market.addItem(i3);

        // test the getAthleteByName method
        Athlete athlete = market.getAthleteByName("Kobe Bryant");
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteByStamina method
        athlete = market.getAthleteByStamina(90);
        System.out.println(athlete.getName()); // expected output: LeBron James

        // test the getAthleteByoffence method
        athlete = market.getAthleteByoffence(90);
        System.out.println(athlete.getName()); // expected output: Michael Jordan

        // test the getAthleteByDefence method
        athlete = market.getAthleteByDefence(75);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteByRole method
        athlete = market.getAthleteByRole("Small Forward");
        System.out.println(athlete.getName()); // expected output: LeBron James

        // test the getAthleteByStoreValue method
        athlete = market.getAthleteByStoreValue(800);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteBySellbackprice method
        athlete = market.getAthleteBySellbackprice(400);
        System.out.println(athlete.getName()); // expected output: Kobe Bryant

        // test the getAthleteAmount method
        int athleteAmount = market.getAthleteAmount();
        System.out.println(athleteAmount); // expected output: 3

        // test the getItemByName method
        Item item = market.getItemByName("Running Shoes");
        System.out.println(item.getName()); // expected output: Running Shoes

        // test the getItemByType method
        item = market.getItemByType("Equipment");
        System.out.println(item.getName()); // expected output: Basketball

        // test the getItemByStoreValue method
        item = market.getItemByStoreValue(100);
        System.out.println(item.getName()); // expected output: Running Shoes

        // test the getItemBySellbackPrice method
        item = market.getItemBySellbackPrice(50);
        System.out.println(item.getName()); // expected output: Water Bottle

        // test the getItemAmount method
        int itemAmount = market.getItemAmount("Basketball");
        System.out.println(itemAmount);
    }
}

