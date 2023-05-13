import java.util.ArrayList;

public class PlayerFinalTest {
    public static void main(String[] args) {
        Player player = new Player("Easy", "John");
        System.out.println(player.getName());
        System.out.println(player.getDifficulty());
        System.out.println(player.getGold());
        System.out.println(player.getTurn());
        player.inc_trun();
        System.out.println(player.getTurn());
        ArrayList<Athlete> subs = new ArrayList<Athlete>();
        player.setsubs(subs);
        player.addsubs(new Athlete("Alice", 100, 50, 90, "Forward", 10, 20, 30));
        player.addsubs(new Athlete("Bob", 90, 89, 89, "Midfielder", 20, 30, 40));
        player.printsubs();
        System.out.println(player.getGold());
        player.addgold(10);
        System.out.println(player.getGold());
        ArrayList<Athlete> team = new ArrayList<Athlete>();
        team.add(new Athlete("Charlie", 77, 98, 65, "Defender", 30, 40, 50));
        team.add(new Athlete("David", 89, 98, 99, "Goalkeeper", 40, 50, 60));
        player.setTeam(team);
        player.printteam();
        System.out.println(player.getpoints());
        player.increasepoints(10);
        System.out.println(player.getpoints());
        ArrayList<Item> inventory = new ArrayList<Item>();
        player.setInventory(inventory);
        player.addInventory(new Item("Item 1", "Description 1"));
        player.addInventory(new Item("Item 2", "Description 2"));
        player.displayinventory();
        player.removeInventory(inventory.get(0));
        player.displayinventory();
        player.displayteam();
        player.init_team_commandline();
        player.applyfrominventory();

    }
}

