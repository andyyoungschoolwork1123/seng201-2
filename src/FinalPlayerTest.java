import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinalPlayerTest {
    private Player player;

    @Before
    public void setup() {
        // Create a new Player instance before each test
        player = new Player("Easy", "John");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("John", player.getName());
    }

    @Test
    public void testGetDifficulty() {
        Assert.assertEquals("Easy", player.getDifficulty());
    }

    @Test
    public void testIncTurn() {
        Assert.assertEquals(1, player.inc_trun());
        Assert.assertEquals(2, player.inc_trun());
    }

    @Test
    public void testSetDifficulty() {
        player.setDifficulty("Medium");
        Assert.assertEquals("Medium", player.getDifficulty());
    }

    @Test
    public void testGetSubs() {
        ArrayList<Athlete> subs = new ArrayList<>();
        subs.add(new Athlete("John", 100, 80, 70, "Forward", 800, 700, 1));
        player.setsubs(subs);
        Assert.assertEquals(subs, player.getsubs());
    }

    @Test
    public void testAddSubs() {
        ArrayList<Athlete> subs = new ArrayList<>();
        
        Athlete athlete = new Athlete("Mike", 100, 80, 80, "Forward", 600, 589, 1);
        player.setsubs(subs);
        player.addsubs(athlete);
        subs.add(athlete);
    
        // Compare the elements of the lists individually
        Assert.assertEquals(subs.size(), player.getsubs().size());
        for (int i = 0; i < subs.size(); i++) {
            Athlete expectedAthlete = subs.get(i);
            Athlete actualAthlete = player.getsubs().get(i);
            Assert.assertEquals(expectedAthlete.getName(), actualAthlete.getName());
            Assert.assertEquals(expectedAthlete.getRole(), actualAthlete.getRole());
            // Add more assertions for other attributes if needed
        }
    }
    



    @Test
    public void testRemoveSubs() {
       
        ArrayList<Athlete> subs = new ArrayList<>();
        Athlete athlete1 = new Athlete("Alex", 100, 80, 90, "Forward", 700, 600, 1);
        Athlete athlete2 = new Athlete("Asher", 70, 80, 90, "Midfielder", 800, 780, 1);
        subs.add(athlete1);
        subs.add(athlete2);
        player.setsubs(subs);

        player.removesubs(athlete1);
        Assert.assertEquals(1, player.getsubs().size());
        Assert.assertEquals(athlete2, player.getsubs().get(0));
    }

    // Add more test methods for the remaining methods

    @Test
    public void testPrintSubs() {
        ArrayList<Athlete> subs = new ArrayList<>();
        Athlete athlete1 = new Athlete("Alexander", 100, 100, 90, "Forward", 100, 80, 1);
        Athlete athlete2 = new Athlete("Aiden", 160, 100, 95, "Midfielder", 100, 80, 1);
        subs.add(athlete1);
        subs.add(athlete2);
        player.setsubs(subs);

        player.printsubs(); // Assuming the method only performs console output
    }

    @Test
    public void testGetGold() {
        Player player = new Player("Easy", "T");
        int expectedGold = 500;
        int actualGold = player.getGold();
        Assert.assertEquals(expectedGold, actualGold);
    }

    @Test
    public void testGetTurn() {
        int expectedTurn = 0;
        int actualTurn = player.getTurn();
        Assert.assertEquals(expectedTurn, actualTurn);
    }

    @Test
    public void testAddGold() {
        Player player = new Player("Easy", "T");
        int expectedGold = 600;
        int actualGold = player.addgold(100);
        
        Assert.assertEquals(expectedGold, actualGold);
    }

    @Test
    public void testSetGold() {
        int expectedGold = 500;
        player.setGold(expectedGold);
        int actualGold = player.getGold();
        Assert.assertEquals(expectedGold, actualGold);
    }

    @Test
    public void testGetTeam() {
        ArrayList<Athlete> expectedTeam = new ArrayList<>();
        ArrayList<Athlete> actualTeam = player.getTeam();
        Assert.assertEquals(expectedTeam, actualTeam);
    }

    @Test
    public void testSetTeam() {
        ArrayList<Athlete> expectedTeam = new ArrayList<>();
        Athlete athlete = new Athlete("James", 180, 100, 98, "Forward", 900, 780, 1);
        expectedTeam.add(athlete);
        player.setTeam(expectedTeam);
        ArrayList<Athlete> actualTeam = player.getTeam();
        Assert.assertEquals(expectedTeam, actualTeam);
    }

    // This is just an example to show the usage of printteam() method
    @Test
    public void testPrintTeam() {
        ArrayList<Athlete> team = new ArrayList<>();
        team.add(new Athlete("James", 180, 100, 98, "Forward", 900, 780, 1));
        team.add(new Athlete("Daniel", 130, 150, 90, "Midfielder", 980, 800, 1));
        team.add(new Athlete("Oliver", 150, 200, 80, "Defender", 800, 780, 1));
        player.setTeam(team);
        player.printteam();

    }
    @Test
    public void testGetPoints() {
        int expectedPoints = 0;
        int actualPoints = player.getpoints();
        Assert.assertEquals(expectedPoints, actualPoints);
    }

    @Test
    public void testSetPoints() {
        int expectedPoints = 100;
        player.setpoints(expectedPoints);
        int actualPoints = player.getpoints();
        Assert.assertEquals(expectedPoints, actualPoints);
    }

    public void testIncreasePoints() {
        int expectedPoints = 100;
        player.increasepoints(100);
        int actualPoints = player.getpoints();
        Assert.assertEquals(expectedPoints, actualPoints);
    }


    @Test
    public void testGetInventory() {
        Assert.assertNotNull(player.getInventory());
    }

    @Test
    public void testSetInventory() {
        ArrayList<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Ball", "DefEquipment", 10, 20, 30));

        player.setInventory(inventory);

        Assert.assertEquals(inventory, player.getInventory());
    }

    @Test
    public void testAddInventory() {
        Item item = new Item("Nets", "DefEquipment", 10, 20, 30);

        player.addInventory(item);

        Assert.assertTrue(player.getInventory().contains(item));
    }

    @Test
    public void testRemoveInventory() {
        Item item = new Item("Sticks", "DefEquipment", 10, 20, 30);
        player.addInventory(item);

        player.removeInventory(item);

        Assert.assertFalse(player.getInventory().contains(item));
    }

    @Test
    public void testGetTeamanmes() {
        // Set up the player's team
        Athlete athlete1 = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
        Athlete athlete2 = new Athlete("Athlete 2", 0, 0, 0, "Midfielder", 0, 0, 0);
        player.getTeam().add(athlete1);
        player.getTeam().add(athlete2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        player.getTeamanmes();

        String expectedOutput = "Athlete 1\nAthlete 2\n";
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testHealInjury() {
        // Set up the player's team with injured athletes
        Athlete athlete1 = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
        Athlete athlete2 = new Athlete("Athlete 2", 0, 0, 0, "Midfielder", 0, 0, 0);
        athlete1.heal_check();
        athlete2.heal_check();
        player.getTeam().add(athlete1);
        player.getTeam().add(athlete2);

        player.heal_injury();
    }

    @Test
    public void testDisplayInventory_Empty() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        player.displayinventory();

        String expectedOutput = "No items in inventory\n";
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testApplyFromInventory_EmptyInventory() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("n\n".getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        player.applyfrominventory();

        String expectedOutput = "No items in inventory\naction cancelled\n";
        Assert.assertEquals(expectedOutput, outputStream.toString());
    }



    @Test
    public void testAutoSortTeam() {
        Athlete athlete1 = new Athlete("Athlete 1", 0, 0, 0, "Defender", 0, 0, 0);
        Athlete athlete2 = new Athlete("Athlete 2", 0, 0, 0, "Forward", 0, 0, 0);
        Athlete athlete3 = new Athlete("Athlete 3", 0, 0, 0, "Goalkeeper", 0, 0, 0);
        Athlete athlete4 = new Athlete("Athlete 4", 0, 0, 0, "Midfielder", 0, 0, 0);
        ArrayList<Athlete> team = new ArrayList<>(Arrays.asList(athlete1, athlete2, athlete3, athlete4));

        ArrayList<Athlete> sortedTeam = player.auto_sortteam(team);

        List<String> expectedOrder = List.of("Forward", "Midfielder", "Defender", "Goalkeeper");
        for (int i = 0; i < sortedTeam.size(); i++) {
            Assert.assertEquals(expectedOrder.get(i), sortedTeam.get(i).getRole());
        }
    }




    @Test
    public void testRemoveInjury_AllAthletesInjured() {
        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(new Athlete("Player 1", 0, 0, 0, "Forward", 0, 0, 0));
        athletes.add(new Athlete("Player 2", 0, 0, 0, "Midfielder", 0, 0, 0));
        athletes.add(new Athlete("Player 3", 0, 0, 0, "Defender", 0, 0, 0));

        player = new Player("Easy", "T");
        // Set all athletes in the player's team as injured
        for (Athlete athlete : player.getTeam()) {
           
            athlete.getInjury();
        }

        player.removeInjury();

        // Verify that all athletes' injuries have been removed
        for (Athlete athlete : player.getTeam()) {
            Assert.assertFalse(athlete.getInjury());
            Assert.assertEquals(0, athlete.getInjurtTime());
        }
    }

    @Test
    public void testRemoveInjury_NoInjuredAthletes() {
        // No injured athletes in the player's team

        player.removeInjury();

        // Verify that no changes are made to the athletes' injuries
        for (Athlete athlete : player.getTeam()) {
            Assert.assertFalse(athlete.getInjury());
            Assert.assertEquals(0, athlete.getInjurtTime());
        }
    }
    

    
}

    


       





