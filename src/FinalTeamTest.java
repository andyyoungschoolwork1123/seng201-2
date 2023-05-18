import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;


public class FinalTeamTest {
    private Team team;
    private Athlete athlete1;
    private Athlete athlete2;

    @Before
    public void setup() {
        // Create a new Team instance for each test
        ArrayList<Athlete> teamMembers = new ArrayList<>();
        teamMembers.add(new Athlete("Alex", 100, 90, 92, "Forward", 800, 700, 1));
        teamMembers.add(new Athlete("Dee", 100, 98, 93, "Midfielder", 950, 800, 1));
        teamMembers.add(new Athlete("Mike", 100, 97, 94, "Defender", 780, 890, 1));
        ArrayList<Athlete> subs = new ArrayList<>();
        subs.add(new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1));
        subs.add(new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1));

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
        expectedSubs.add(new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1));
        expectedSubs.add(new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1));
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
        newSubs.add(new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1));
        newSubs.add(new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1));

        team.setsubs(newSubs);
        Assert.assertEquals(newSubs, team.getsubs());
    }



    @Test
    public void testAddSubs() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addSubs(athlete1);
        Assert.assertTrue(team.getsubs().contains(athlete1));
    }

    @Test
    public void testRemoveSubs() {
        team.addSubs(athlete1);
        team.addSubs(athlete2);
        team.removesubs(athlete1);
       
        Assert.assertTrue(team.getsubs().contains(athlete2));
    }

    @Test
    public void testInjuryRemove_InjuredAthlete() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
    
        athlete1.getInjury();
        team.addAthlete(athlete1);
        team.injuryremove(athlete1);
        Assert.assertFalse(team.getteam().contains(athlete1));
    }

    @Test
    public void testInjuryRemove_NonInjuredAthlete() {
        team = new Team("Team A");
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
    
        Athlete athlete3 = new Athlete("Tom", 100, 80, 89, "Defender", 800, 807, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        team.addAthlete(athlete3);
        
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.injuryremove(athlete1);
        Assert.assertFalse(team.getteam().contains(athlete1));
    }

    public void testSubtite_ByPosition() {
        Athlete onAthlete =  new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        int offPos = 1;

        team.subtite(onAthlete, offPos);

        Assert.assertEquals(onAthlete, team.getteam().get(offPos));
        Assert.assertTrue(team.getsubs().contains(athlete2));
    }

    @Test
    public void testSubtite_ByAthlete() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        Athlete onAthlete = new Athlete("Jack", 0, 0, 0, "Forward", 0, 0, 0);

        team.subtite(onAthlete, athlete2);

        Assert.assertEquals(onAthlete, team.getteam().get(1));
        Assert.assertTrue(team.getsubs().contains(athlete2));
    }

    @Test
    public void testSubtite_Confirmation() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        Athlete onAthlete = new Athlete("Jack", 0, 0, 0, "Forward", 0, 0, 0);
        int offPos = 0;  // Swap the values of offPos and onPos
         
        String confirmation = "y";
    
        // Mocking user input
        System.setIn(new java.io.ByteArrayInputStream(confirmation.getBytes()));
    
        team.subtite(onAthlete, offPos);
    
        Assert.assertEquals(onAthlete, team.getteam().get(offPos));
       
    }
    
    @Test
    public void testSubtite_Cancelled() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
       
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        int offPos = 0;
    
        String confirmation = "n";
    
        // Mocking user input
        System.setIn(new java.io.ByteArrayInputStream(confirmation.getBytes()));
    
        team.subtite(athlete2, offPos);
    
        Assert.assertEquals(athlete2, team.getteam().get(offPos));
        Assert.assertFalse(team.getsubs().contains(athlete2));
    }

    @Test
    public void testSetTeam() {
        ArrayList<Athlete> newTeam = new ArrayList<>();
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);

        team.setteam(newTeam);

        Assert.assertEquals(newTeam, team.getteam());
    }

    @Test
    public void testGetScore() {
        int expectedScore = 0;
        int actualScore = team.getscore();

        Assert.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void testSetScore() {
        int newScore = 100;

        team.setscore(newScore);

        Assert.assertEquals(newScore, team.getscore());
    }

    @Test
    public void testGetName() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        String expectedName = "Team A";
        String actualName = team.getname();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void testSetName() {
        String newName = "Team B";

        team.setname(newName);

        Assert.assertEquals(newName, team.getname());
    }

    @Test
    public void testRemoveAthlete() {
        team.removeAthlete(athlete1);

        Assert.assertFalse(team.getteam().contains(athlete1));
    }

    @Test
    public void testAddScore() {
        int scoreToAdd = 50;
        int expectedScore = team.getscore() + scoreToAdd;

        team.addScore(scoreToAdd);

        Assert.assertEquals(expectedScore, team.getscore());
    }

    @Test
    public void testGetTotalEstPower() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        int expectedTotalEstPower = athlete1.esimatepower() + athlete2.esimatepower();
        int actualTotalEstPower = team.gettotalestpower();

        Assert.assertEquals(expectedTotalEstPower, actualTotalEstPower);
    }

    @Test
    public void testSize() {
        team = new Team("Team A");
        athlete1 = new Athlete("Jack", 100, 96, 95, "Midfielder", 680, 500, 1);
        athlete2 = new Athlete("Mary", 100, 95, 96, "Defender", 876, 700, 1);
        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        int expectedSize = 2;
        int actualSize = team.size();

        Assert.assertEquals(expectedSize, actualSize);
    }
}





    







