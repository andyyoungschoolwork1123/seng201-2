import java.util.ArrayList;

public class Arena {
    private ArrayList<ArrayList<Athlete>> availableOpponents;
    
    public Arena() {
        this.availableOpponents = new ArrayList<ArrayList<Athlete>>();

    }

    public ArrayList<ArrayList<Athlete>> getAvailableOpponents() {
        return availableOpponents;
    }

    public void InitAvailableOpponents(ArrayList<ArrayList<Athlete>> availableOpponents,int turn) {
        ArrayList<Athlete> team1 = generate_AvailableTeamAthletes(turn,"balance");
        ArrayList<Athlete> team2 = generate_AvailableTeamAthletes(turn,"offense");
        ArrayList<Athlete> team3 = generate_AvailableTeamAthletes(turn,"defense");
        ArrayList<Athlete> team4 = generate_AvailableTeamAthletes(turn,"weird");
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
            ArrayList<Athlete> opponent = availableOpponents.get(i);
            for (int j = 0; j < opponent.size(); j++) {
                System.out.println((j+1) + ". " + opponent.get(j).getName() + " (" + opponent.get(j).getRole() + ")");
            }
            //System.out.println((i+1) + ". " + opponent.getName() + " (" + opponent.getRole() + ")");
        }
    }
    public ArrayList<Athlete> generate_AvailableTeamAthletes(int turn,String type) {
        ArrayList<Athlete> ava = new ArrayList<Athlete>();

        if (type =="balance"){
        Athlete opponent1 = Athlete.generateAthlete(turn,"Forward");
        Athlete opponent2 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent3 = Athlete.generateAthlete(turn,"Midfielder");

        Athlete opponent4 = Athlete.generateAthlete(turn,"Defender");
        Athlete opponent5 = Athlete.generateAthlete(turn,"Goalkeeper");
        ava.add(opponent1);
        ava.add(opponent2);
        ava.add(opponent3);
        ava.add(opponent4);
        ava.add(opponent5);
        }
        else if (type =="offense"){
        Athlete opponent1 = Athlete.generateAthlete(turn,"Forward");
        Athlete opponent2 = Athlete.generateAthlete(turn,"Forward");
        Athlete opponent3 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent4 = Athlete.generateAthlete(turn,"Defender");
        Athlete opponent5 = Athlete.generateAthlete(turn,"Goalkeeper");
        ava.add(opponent1);
        ava.add(opponent2);
        ava.add(opponent3);
        ava.add(opponent4);
        ava.add(opponent5);
        }
        else if (type =="defense"){
        Athlete opponent1 = Athlete.generateAthlete(turn,"Forward");
        Athlete opponent2 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent3 = Athlete.generateAthlete(turn,"Defender");
        Athlete opponent4 = Athlete.generateAthlete(turn,"Defender");
        Athlete opponent5 = Athlete.generateAthlete(turn,"Goalkeeper");
        ava.add(opponent1);
        ava.add(opponent2);
        ava.add(opponent3);
        ava.add(opponent4);
        ava.add(opponent5);
        }
        else {
        Athlete opponent1 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent2 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent3 = Athlete.generateAthlete(turn,"Midfielder");

        Athlete opponent4 = Athlete.generateAthlete(turn,"Midfielder");
        Athlete opponent5 = Athlete.generateAthlete(turn,"Goalkeeper");
        ava.add(opponent1);
        ava.add(opponent2);
        ava.add(opponent3);
        ava.add(opponent4);
        ava.add(opponent5);
        
        }
    
        return ava;
        
    }

    public void pre_battle(Player player) {
        if (player.getTeam().size() < 5) {
            System.out.println("You need to have 5 players in your team to battle");
            return;
        }

        int turn = player.getTurn();
        InitAvailableOpponents(availableOpponents,turn);
        displayAvailableOpponents_cmd();
        System.out.println("Please select an opponent to battle");
        int selection = Integer.parseInt(System.console().readLine());
        ArrayList<Athlete> opponent = availableOpponents.get(selection - 1);
        
        battle_easy(player,opponent);
    }
    
    public void battle_easy(Player player,ArrayList<Athlete> opponent) {
        // TODO: implement battle mechanism
        ArrayList<Athlete> Team1 = player.getTeam();
        ArrayList<Athlete> Team2 = opponent;
        int Team1_score = 0;
        int Team2_score = 0;
        int current_i_pos = 0;
        int current_j_pos = 0;
        int duration =0;
        ArrayList<Athlete> attacker = Team1;
        ArrayList<Athlete> defender = Team2;
        while (duration <= 20){
        
            duration += 1;
            if (attacker.get(current_i_pos).personal_duel(defender.get(current_j_pos), duration)){
                current_j_pos += 1;
                if (current_j_pos == 5){
                    Team1_score  +=1;
                }
            }
            else {
                attacker = Team2;
                defender = Team1;
                current_i_pos += 1;
                if (current_i_pos == 5){
                    Team2_score  +=1;
                }
            }    
        }
        
        
        if (Team1_score > Team2_score){
            System.out.println("You win");
            player.increasepoints(3);
        }
        else if (Team1_score < Team2_score){
            System.out.println("You lose");
        }
        else {
            System.out.println("Draw");
            player.increasepoints(1);
        }
    }
}
