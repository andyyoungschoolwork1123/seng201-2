import java.util.ArrayList;

public class TeamTesttwo {
    public static void main(String[] args) {
        // create a new team
        Team team = new Team("My Team");

        // add some athletes to the team
        Athlete athlete1 = new Athlete("Alice", 10, 5, 3, "Forward", 100, 200, 1);
        Athlete athlete2 = new Athlete("Bob", 7, 3, 8, "Defender", 150, 200, 1);
        Athlete athlete3 = new Athlete("Charlie", 5, 1, 10, "Goalie", 300, 250, 1);

        team.addAthlete(athlete1);
        team.addAthlete(athlete2);
        team.addAthlete(athlete3);

        // test getters and setters
        System.out.println("Team Name: " + team.getname());
        System.out.println("Score: " + team.getscore());
        System.out.println("Position: " + team.getpos());
        team.setname("New Name");
        team.setscore(5);
        team.setpos(3);
        System.out.println("New Team Name: " + team.getname());
        System.out.println("New Score: " + team.getscore());
        System.out.println("New Position: " + team.getpos());

        // test addScore() method
        team.addScore(3);
        System.out.println("New Score: " + team.getscore());

        // test removeAthlete() method
        team.removeAthlete(athlete2);
        System.out.println("Team size: " + team.size());

        // test gettotalestpower() method
        int totalPower = team.gettotalestpower();
        System.out.println("Total estimated power: " + totalPower);

        // test printteam() and displayTeam_cmd() methods
        team.printteam();
        team.displayTeam_cmd();

        // test copy constructor
        Team teamCopy = new Team(team);
        System.out.println("Copied Team Name: " + teamCopy.getname());
        System.out.println("Copied Score: " + teamCopy.getscore());
        System.out.println("Copied Position: " + teamCopy.getpos());
        System.out.println("Copied Team size: " + teamCopy.size());
        teamCopy.printteam();
        teamCopy.displayTeam_cmd();

        // test setteam() method
        ArrayList<Athlete> newTeamList = new ArrayList<>();
        newTeamList.add(athlete1);
        newTeamList.add(athlete3);
        team.setteam(newTeamList);
        System.out.println("New Team size: " + team.size());
        team.printteam();
        team.displayTeam_cmd();
    }
}
