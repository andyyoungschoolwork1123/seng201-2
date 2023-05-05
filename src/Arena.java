import java.util.ArrayList;

public class Arena {
    private ArrayList<ArrayList<Athlete>> availableOpponents;
    
    public Arena() {
        this.availableOpponents = new ArrayList<ArrayList<Athlete>>();

    }

    public ArrayList<ArrayList<Athlete>> getAvailableOpponents() {
        return availableOpponents;
    }

    public void InitAvailableOpponents(ArrayList<Athlete> availableOpponents,int turn) {
        ArrayList<Athlete> team1 = generate_AvailableTeamAthletes(turn);
        ArrayList<Athlete> team2 = generate_AvailableTeamAthletes(turn);
        ArrayList<Athlete> team3 = generate_AvailableTeamAthletes(turn);
        ArrayList<Athlete> team4 = generate_AvailableTeamAthletes(turn);
        this.availableOpponents.add(team1);
        this.availableOpponents.add(team2);
        this.availableOpponents.add(team3);
        this.availableOpponents.add(team4);
    }

    public void addOpponent(ArrayList<Athlete>t) {
        availableOpponents.add(t);
    }

    public void removeOpponent(ArrayList<Athlete>t) {
        availableOpponents.remove(t);
    }

    public void displayAvailableOpponents_cmd() {
        System.out.println("Available opponents:");
        for (int i = 0; i < availableOpponents.size(); i++) {
            ArrayList<Athlete> opponent = availableOpponents.get(j);
            for (int j = 0; j < opponent.size(); j++) {
                System.out.println((j+1) + ". " + opponent.get(j).getName() + " (" + opponent.get(j).getRole() + ")");
            }
            //System.out.println((i+1) + ". " + opponent.getName() + " (" + opponent.getRole() + ")");
        }
    }
    public ArrayList<Athlete> generate_AvailableTeamAthletes(int turn) {
        Athlete opponent1 = Athlete.generateAthlete(turn,"Forward");
        Athlete opponent2 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent3 = Athlete.generateAthlete(turn,"Midfielder");

        Athlete opponent4 = Athlete.generateAthlete(turn,"Defender");
        Athlete opponent5 = Athlete.generateAthlete(turn,"Goalkeeper");
        ArrayList<Athlete> ava = new ArrayList<Athlete>();
        ava.add(opponent1);
        ava.add(opponent2);
        ava.add(opponent3);
        ava.add(opponent4);
        ava.add(opponent5);
        return ava;
    }
    public void battle(Player player) {
        // TODO: implement battle mechanism
    }
}
