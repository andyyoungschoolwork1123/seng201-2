import java.util.ArrayList;
public class PlayerTestTwo {
    public static void main(String[] args) {
        Player player = new Player("Easy","John Doe");

        // get difficulty
        System.out.println("Difficulty: " + player.getDifficulty());

        // get gold
        System.out.println("Starting gold: " + player.getGold());

        // set and get team
        ArrayList<Athlete> team = new ArrayList<Athlete>();
        Athlete athlete1 = new Athlete("John Doe", 100, 70, 60, "Forward", 200, 100, 1);
        Athlete athlete2 = new Athlete("Mike", 70, 50, 40, "Midfielder");
        player.setTeam(team);
        System.out.println("Team: " + player.getTeam());

        // set and get points
        player.increasepoints(10);
        System.out.println("Points: " + player.getpoints());

        // add and get inventory
        ArrayList<Item> inventory = new ArrayList<Item>();
        inventory.add(new Item("Super Drink", "Consumable", 10, 5, 2));
        inventory.add(new Item("Revive", "Consumbale", 12, 4, 3));
        player.setInventory(inventory);
        System.out.println("Inventory: ");
        player.getInventory();

        // get team names
        System.out.println("Team Names: ");
        player.getTeamanmes();
    }
}

