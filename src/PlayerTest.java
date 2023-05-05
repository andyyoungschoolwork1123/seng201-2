import java.util.ArrayList;

public class PlayerTest {
    public static void main(String[] args) {
        // Create a Player object with difficulty level "Easy"
        Player player = new Player("Easy");

        // Get the difficulty level and print it
        String difficulty = player.getDifficulty();
        System.out.println("Difficulty level: " + difficulty);

        // Get the starting gold and print it
        int gold = player.getGold();
        System.out.println("Starting gold: " + gold);

        // Add an athlete to the team
        Athlete athlete = new Athlete("John Doe", 100, 70, 60, "Forward", 200, 100, 1);
        ArrayList<Athlete> team = player.getTeam();
        team.add(athlete);
        player.setTeam(team);

        // Get the names of the athletes on the team and print them
        System.out.println("Athletes on team:");
        player.getTeamanmes();

        // Increase the player's points by 10
        player.increasepoints(10);
        int points = player.getpoints();
        System.out.println("Points: " + points);
    }
}

