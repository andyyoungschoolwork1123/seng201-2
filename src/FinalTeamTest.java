import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class FinalTeamTest {
    private Team team;

    @Before
    public void setup() {
        // Create a new Team instance for each test
        ArrayList<Athlete> teamMembers = new ArrayList<>();
        teamMembers.add(new Athlete("Player 1", 0, 0, 0, "Forward", 0, 0, 0));
        teamMembers.add(new Athlete("Player 2", 0, 0, 0, "Midfielder", 0, 0, 0));
        teamMembers.add(new Athlete("Player 3", 0, 0, 0, "Defender", 0, 0, 0));
        ArrayList<Athlete> subs = new ArrayList<>();
        subs.add(new Athlete("Substitute 1", 0, 0, 0, "Midfielder", 0, 0, 0));
        subs.add(new Athlete("Substitute 2", 0, 0, 0, "Defender", 0, 0, 0));

        team = new Team("Team 1", teamMembers, subs);
    }

    @Test
    public void testGetPos() {
        int expectedPos = 0;
        int actualPos = team.getpos();
        Assert.assertEquals(expectedPos, actualPos);
    }

    @Test
    public void testSetPos() {
        int newPos = 1;
        team.setpos(newPos);
        Assert.assertEquals(newPos, team.getpos());
    }

    @Test
    public void testGetSubs() {
        ArrayList<Athlete> expectedSubs = new ArrayList<>();
        expectedSubs.add(new Athlete("Substitute 1", 0, 0, 0, "Midfielder", 0, 0, 0));
        expectedSubs.add(new Athlete("Substitute 2", 0, 0, 0, "Defender", 0, 0, 0));

        ArrayList<Athlete> actualSubs = team.getsubs();
        Assert.assertEquals(expectedSubs, actualSubs);
    }

    @Test
    public void testSetSubs() {
        ArrayList<Athlete> newSubs = new ArrayList<>();
        newSubs.add(new Athlete("New Substitute 1", 0, 0, 0, "Midfielder", 0, 0, 0));
        newSubs.add(new Athlete("New Substitute 2", 0, 0, 0, "Defender", 0, 0, 0));

        team.setsubs(newSubs);
        Assert.assertEquals(newSubs, team.getsubs());
    }
}