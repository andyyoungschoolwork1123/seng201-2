import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
public class ArenaTest {

    private Arena arena;

    @Before
    public void setUp() {
        arena = new Arena();
    }

    @Test
    public void testInitAvailableOpponents() {
        arena.InitAvailableOpponents(1);
        assertEquals(4, arena.getAvailableOpponents().size());
    }

    @Test
    public void testGenerate_AvailableTeamAthletes() {
        ArrayList<Athlete> team1 = arena.generate_AvailableTeamAthletes(1, "balance");
        assertEquals(5, team1.size());

        ArrayList<Athlete> team2 = arena.generate_AvailableTeamAthletes(1, "offense");
        assertEquals(5, team2.size());

        ArrayList<Athlete> team3 = arena.generate_AvailableTeamAthletes(1, "defense");
        assertEquals(5, team3.size());

        ArrayList<Athlete> team4 = arena.generate_AvailableTeamAthletes(1, "weird");
        assertEquals(5, team4.size());
    }

    @Test
    public void testAddAndRemoveOpponent() {
        Team opponent = new Team("Test Opponent");

        assertEquals(0, arena.getAvailableOpponents().size());
        arena.addOpponent(opponent);
        assertEquals(1, arena.getAvailableOpponents().size());
        assertEquals(opponent, arena.getAvailableOpponents().get(0));

        arena.removeOpponent(opponent);
        assertEquals(0, arena.getAvailableOpponents().size());
    }
    public static void main(String[] args) {
        ArenaTest test = new ArenaTest();
        test.setUp();
        test.testAddAndRemoveOpponent();

        test.testInitAvailableOpponents();
        test.testGenerate_AvailableTeamAthletes();
        test.arena.InitAvailableOpponents(1);
        test.arena.displayAvailableOpponents_cmd();
    }
}


