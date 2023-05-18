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
        teamMembers.add(new Athlete("Alex", 0, 0, 0, "Forward", 0, 0, 0));
        teamMembers.add(new Athlete("Dee", 0, 0, 0, "Midfielder", 0, 0, 0));
        teamMembers.add(new Athlete("Mike", 0, 0, 0, "Defender", 0, 0, 0));
        ArrayList<Athlete> subs = new ArrayList<>();
        subs.add(new Athlete("Jack", 0, 0, 0, "Midfielder", 0, 0, 0));
        subs.add(new Athlete("Mary", 0, 0, 0, "Defender", 0, 0, 0));

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
        expectedSubs.add(new Athlete("Jack", 0, 0, 0, "Midfielder", 0, 0, 0));
        expectedSubs.add(new Athlete("Mary", 0, 0, 0, "Defender", 0, 0, 0));
        team.setsubs(expectedSubs);
    
        ArrayList<Athlete> actualSubs = team.getsubs();
        Assert.assertEquals(expectedSubs, actualSubs);
        
        System.out.println("Actual Subs:");
        for (Athlete athlete : actualSubs) {
            System.out.println(athlete.getName());
        }
    }
    

    @Test
    public void testSetSubs() {
        ArrayList<Athlete> newSubs = new ArrayList<>();
        newSubs.add(new Athlete("New Substitute 1", 0, 0, 0, "Midfielder", 0, 0, 0));
        newSubs.add(new Athlete("New Substitute 2", 0, 0, 0, "Defender", 0, 0, 0));

        team.setsubs(newSubs);
        Assert.assertEquals(newSubs, team.getsubs());
    }


    @Test
    public void testGetSubs() {
        ArrayList<Athlete> expectedSubs = new ArrayList<>();
        expectedSubs.add(new Athlete("Jack", 0, 0, 0, "Midfielder", 0, 0, 0));
        expectedSubs.add(new Athlete("Mary", 0, 0, 0, "Defender", 0, 0, 0));

        team.setsubs(expectedSubs);
        ArrayList<Athlete> actualSubs = team.getsubs();

        Assert.assertEquals(expectedSubs, actualSubs);
    }

    @Test
    public void testAddSubs() {
        team = new Team("Team A");
        athlete1 = new Athlete("John", 0, 0, 0, "Forward", 0, 0, 0);
        athlete2 = new Athlete("Mary", 0, 0, 0, "Midfielder", 0, 0, 0);
        team.addSubs(athlete1);
        Assert.assertTrue(team.getsubs().contains(athlete1));
    }

    @Test
    public void testRemoveSubs() {
        team.addSubs(athlete1);
        team.addSubs(athlete2);
        team.removesubs(athlete1);
        Assert.assertFalse(team.getsubs().contains(athlete1));
        Assert.assertTrue(team.getsubs().contains(athlete2));
    }

    @Test
    public void testSubstituteByPosition() {
        team.addSubs(athlete1);
        team.addAthlete(athlete2);
        team.subtite(athlete1, 0);
        Assert.assertEquals(athlete1, team.getTeam().get(0));
        Assert.assertEquals(athlete2, team.getsubs().get(0));
    }

    @Test
    public void testSubstituteByAthlete() {
        team.addSubs(athlete1);
        team.addAthlete(athlete2);
        team.subtite(athlete1, athlete2);
        Assert.assertEquals(athlete1, team.getTeam().get(0));
        Assert.assertEquals(athlete2, team.getsubs().get(0));
    }
}

