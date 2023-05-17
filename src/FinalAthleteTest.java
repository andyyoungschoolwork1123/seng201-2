import junit.framework.TestCase;
import org.junit.Test;



public class FinalAthleteTest extends TestCase {

    private Athlete athlete;

    protected void setUp() {
        athlete = new Athlete("John Doe", 80, 70, 60, "Forward", 200, 160, 1);
    }

    public void testGetName() {
        assertEquals("John Doe", athlete.getName());
    }

    public void testGetStamina() {
        assertEquals(80, athlete.getStamina());
    }

    public void testGetInjury() {
        assertFalse(athlete.getInjury());
        athlete.setStamina(10);
        assertTrue(athlete.getInjury());
    }

    public void testChangeInjury() {
        assertFalse(athlete.getInjury());
        athlete.changeInjury();
        assertTrue(athlete.getInjury());
        athlete.changeInjury();
        assertFalse(athlete.getInjury());
    }

    public void testGetOffence() {
        assertEquals(70, athlete.getOffence());
    }

    public void testGetDefence() {
        assertEquals(60, athlete.getDefence());
    }

    public void testGetRole() {
        assertEquals("Forward", athlete.getRole());
    }

    public void testIncreaseStamina() {
        athlete.increaseStamina(20);
        assertEquals(100, athlete.getStamina());
    }

    public void testIncreaseDefense() {
        athlete.increaseDefense(10);
        assertEquals(70, athlete.getDefence());
    }

    public void testIncreaseOffense() {
        athlete.increaseOffense(5);
        assertEquals(75, athlete.getOffence());
    }



    public void testGetStoreValue() {
        assertEquals(200, athlete.getStoreValue());
    }

    public void testSetStoreValue() {
        athlete.setStoreValue(250);
        assertEquals(250, athlete.getStoreValue());
    }

    public void testGetSellbackPrice() {
        assertEquals(160, athlete.getSellbackPrice());
    }

    public void testSetSellbackPrice() {
        athlete.setSellbackPrice(120);
        assertEquals(120, athlete.getSellbackPrice());
    }


    public void testGetAmount() {
        assertEquals(1, athlete.getAmount());
    }

    public void testSetAmount() {
        athlete.setAmount(2);
        assertEquals(2, athlete.getAmount());
    }

    public void testIncreaseAmount() {
        athlete.increaseAmount(3);
        assertEquals(4, athlete.getAmount());
    }

    public void testDecreaseAmount() {
        athlete.decreaseAmount(1);
        assertEquals(0, athlete.getAmount());
        athlete.decreaseAmount(2);
        assertEquals(0, athlete.getAmount());
    }

    @Test
    public void testGenerateAthlete() {
        int turn = 1;
        String role = "Forward";

        Athlete athlete = Athlete.generateAthlete(turn, role);

        assertNotNull(athlete);
        assertEquals("Forward", athlete.getRole());
        assertEquals(100, athlete.getStamina());

    
    

        // Assert the correctness of name, value, and sellBackValue
        assertNotNull(athlete.getName());
        athlete.getStoreValue();
        athlete.getSellbackPrice();
    }

    @Test
    public void testPersonalDuel() {
        Athlete athlete1 = new Athlete("Athlete 1", 100, 80, 70, "Forward", 120, 100, 1);
        Athlete athlete2 = new Athlete("Athlete 2", 100, 75, 80, "Defender", 140, 110, 1);

        boolean result = athlete1.personal_duel(athlete2, 1);

        // Assert the expected changes in stamina and injury status
        if (result) {
            assertEquals(96, athlete1.getStamina());
            assertEquals(90, athlete2.getStamina());
        } else {
            assertEquals(97, athlete1.getStamina());
            assertEquals(93, athlete2.getStamina());
        }

       
    }


    @Test
    public void testTrain() {
        Athlete forward = new Athlete("Forward", 100, 80, 70, "Forward", 120, 100, 1);
        Athlete midfielder = new Athlete("Midfielder", 100, 75, 80, "Midfielder", 140, 110, 1);
        Athlete defender = new Athlete("Defender", 100, 70, 85, "Defender", 130, 105, 1);

        forward.train();
        midfielder.train();
        defender.train();

        // Assert the expected changes in offense and defense
        assertEquals(85, forward.getOffence());
        assertEquals(70, forward.getDefence());

        assertEquals(78, midfielder.getOffence());
        assertEquals(83, midfielder.getDefence());

        assertEquals(70, defender.getOffence());
        assertEquals(90, defender.getDefence());
    }

    









}





