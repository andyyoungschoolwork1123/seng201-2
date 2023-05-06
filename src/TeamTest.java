import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TeamTest {
    private Athlete athlete1;
    private Athlete athlete2;
    private Team team;

    @Before
    public void setUp() {
        athlete1 = new Athlete("John Smith", 100, 50, 50, "Forward");
        athlete2 = new Athlete("Jane Doe", 100, 40, 60, "Defender");
        team = new Team("Test Team");
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        this.team.printteam();
    }

    @Test
    public void testAddAthlete() {
        Athlete athlete3 = new Athlete("Alice Johnson", 100, 60, 40, "Midfielder");
        team.addAthlete(athlete3);
        this.team.printteam();

        assertEquals(3, team.size());
    }

    @Test
    public void testRemoveAthlete() {
        team.removeAthlete(athlete1);
        assertEquals(2, team.size());
    }

    @Test
    public void testAddScore() {
        team.addScore(3);
        assertEquals(3, team.getscore());
    }

    

    public static void main(String[] args) {
        TeamTest test = new TeamTest();
        test.setUp();
        test.testAddAthlete();
        test.testRemoveAthlete();
        test.testAddScore();
    }
}


