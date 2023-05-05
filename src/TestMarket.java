public class TestMarket {
    public static void main(String[] args) {
        Market market = new Market();
        Item item1 = new Item("Sword", "offense", 50, 25, 1);
        Item item2 = new Item("Shield", "defense", 100, 50, 2);
        Athlete athlete1 = new Athlete("John", 70, 12, 8, "Forward", 800, 400, 1);

        market.addpurchaseable(item1);
        market.addpurchaseable(item2);
        market.addpurchaseable(athlete1);

        System.out.println("Initial items in market:");
        for (purchaseable p : market.getItems()) {
            System.out.println("Name: " + p.getName() + ", Type: " + p.getClass().getSimpleName() +
                    ", Store Value: " + p.getStoreValue() + ", Sellback Price: " + p.getSellbackPrice() +
                    ", Amount: " + p.getAmount());
        }

        market.buy(item1);
        market.buy(item1);
        market.buy(item2);
        market.sell(item1);

        System.out.println("\nUpdated items in market:");
        for (purchaseable p : market.getItems()) {
            System.out.println("Name: " + p.getName() + ", Type: " + p.getClass().getSimpleName() +
                    ", Store Value: " + p.getStoreValue() + ", Sellback Price: " + p.getSellbackPrice() +
                    ", Amount: " + p.getAmount());
        }
    }
}
