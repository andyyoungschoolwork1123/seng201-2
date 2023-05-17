import junit.framework.TestCase;

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

    public void testEstimatePower() {
        assertEquals(280, athlete.esimatepower());
    }

    public void testGetStoreValue() {
        assertEquals(200, athlete.getStoreValue());
    }

    public void testSetStoreValue() {
        athlete.setStoreValue(250);
        assertEquals(250, athlete.getStoreValue());
    }

    public void testSetStoreValue_default() {
        athlete.setStoreValue();
        assertEquals(320, athlete.getStoreValue());
    }

    public void testGetSellbackPrice() {
        assertEquals(160, athlete.getSellbackPrice());
    }

    public void testSetSellbackPrice() {
        athlete.setSellbackPrice(120);
        assertEquals(120, athlete.getSellbackPrice());
    }

    public void testSetSellbackPrice_default() {
        athlete.setSellbackPrice();
        assertEquals(160, athlete.getSellbackPrice());
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

    // Add more tests as needed

}


