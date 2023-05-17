import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

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
        subs.add(new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0));
        player.setsubs(subs);
        Assert.assertEquals(subs, player.getsubs());
    }

    @Test
    public void testAddSubs() {
        ArrayList<Athlete> subs = new ArrayList<>();
        
        Athlete athlete = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
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
        Athlete athlete1 = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
        Athlete athlete2 = new Athlete("Athlete 2", 0, 0, 0, "Midfielder", 0, 0, 0);
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
        Athlete athlete1 = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
        Athlete athlete2 = new Athlete("Athlete 2", 0, 0, 0, "Midfielder", 0, 0, 0);
        subs.add(athlete1);
        subs.add(athlete2);
        player.setsubs(subs);

        player.printsubs(); // Assuming the method only performs console output
    }

    @Test
    public void testGetGold() {
        int expectedGold = 0;
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
        int expectedGold = 100;
        int actualGold = player.addgold(100);
        int expectedGold = initialGold + goldToAdd;
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
        Athlete athlete = new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0);
        expectedTeam.add(athlete);
        player.setTeam(expectedTeam);
        ArrayList<Athlete> actualTeam = player.getTeam();
        Assert.assertEquals(expectedTeam, actualTeam);
    }

    // This is just an example to show the usage of printteam() method
    @Test
    public void testPrintTeam() {
        ArrayList<Athlete> team = new ArrayList<>();
        team.add(new Athlete("Athlete 1", 0, 0, 0, "Forward", 0, 0, 0));
        team.add(new Athlete("Athlete 2", 0, 0, 0, "Midfielder", 0, 0, 0));
        team.add(new Athlete("Athlete 3", 0, 0, 0, "Defender", 0, 0, 0));
        player.setTeam(team);
        player.printteam();
    }
}


