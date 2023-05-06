import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Arena{
    private ArrayList<Team> availableOpponents;
    private ArrayList<String> availableOpponentsNames;

    public Arena() {
        this.availableOpponents = new ArrayList<Team>();
        this.availableOpponentsNames = new ArrayList<String>();
        availableOpponentsNames.add("Dragon");
        availableOpponentsNames.add("Phoenix");
        availableOpponentsNames.add("Kraken");
        availableOpponentsNames.add("Sphinx");
        availableOpponentsNames.add("Minotaur");
        availableOpponentsNames.add("Cerberus");
        availableOpponentsNames.add("Chimera");
        availableOpponentsNames.add("Unicorn");
        availableOpponentsNames.add("Basilisk");
        availableOpponentsNames.add("Gorgon");
    }

    public ArrayList<Team> getAvailableOpponents() {
        return availableOpponents;
    }
    public ArrayList<String> getAvailableOpponentsNames() {
        return availableOpponentsNames;
    }
    public void InitAvailableOpponents(int turn) {
        this.availableOpponents.clear();
        ArrayList<Athlete> team1 = generate_AvailableTeamAthletes(turn,"balance");
        ArrayList<Athlete> team2 = generate_AvailableTeamAthletes(turn,"offense");
        ArrayList<Athlete> team3 = generate_AvailableTeamAthletes(turn,"defense");
        ArrayList<Athlete> team4 = generate_AvailableTeamAthletes(turn,"weird");
        
        Team opponent1 = new Team(availableOpponentsNames.get(ThreadLocalRandom.current().nextInt(0, 10)
        ), team1);
        Team opponent2 = new Team(availableOpponentsNames.get(ThreadLocalRandom.current().nextInt(0, 10)
        ), team2);
        Team opponent3 = new Team(availableOpponentsNames.get(ThreadLocalRandom.current().nextInt(0, 10)
        ), team3);
        Team opponent4 = new Team(availableOpponentsNames.get(ThreadLocalRandom.current().nextInt(0, 10)
        ), team4);
        availableOpponents.add(opponent1);
        availableOpponents.add(opponent2);
        availableOpponents.add(opponent3);
        availableOpponents.add(opponent4);

    }

    public void addOpponent(Team t) {
        availableOpponents.add(t);
    }

    public void removeOpponent(Team t) {
        availableOpponents.remove(t);
    }

    public void displayAvailableOpponents_cmd() {
        System.out.println("Available opponents:");
        for (int i = 0; i < availableOpponents.size(); i++) {
            Team opponent = availableOpponents.get(i);
            for (int j = 0; j < opponent.size(); j++) {
                System.out.println((j+1) + ". " + opponent.team.get(j).getName() + " (" + opponent.team.get(j).getRole() + ")");
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
        InitAvailableOpponents(turn);
        displayAvailableOpponents_cmd();
        System.out.println("Please select an opponent to battle");
        int selection = Integer.parseInt(System.console().readLine());
        Team opponent = availableOpponents.get(selection - 1);
        
        battle_easy(player,opponent);
    }
    
    public void battle_easy(Player player,Team opponent) {
        // TODO: implement battle mechanism
        Team Team_player = new Team(player.getname(),player.getTeam());
        Team Team2 = opponent;
        
        int duration =0;
        
        Team attacker = Team_player;
        Team defender = Team2;
        while (duration <= 20){
        
            duration += 1;
            if (attacker.team.get(attacker.getpos()).personal_duel(defender.team.get(defender.getpos()), duration)){
                defender.setpos(defender.getpos()+1);
                if (defender.getpos() == 5){
                    attacker.addScore(1);  
                    System.out.println("Team1 score");                
                }
                System.out.println(attacker.team.get(attacker.getpos()).getName() + "go pass"  + defender.team.get(defender.getpos()).getName());
            }
            else {
                
                attacker.setpos(attacker.getpos()+1);
                if (attacker.getpos() == 5){
                    defender.addScore(1);
                    System.out.println("Team2 score");
                }
                attacker = Team2;
                defender = Team_player;
                System.out.println(attacker.team.get(attacker.getpos()).getName() + "give away the ball to"  + defender.team.get(defender.getpos()).getName());

            }    
        }
        
        
        if (Team_player.getscore() > Team2.getscore()){
            System.out.println("You win");
            player.increasepoints(3);
        }
        else if (Team_player.getscore() < Team2.getscore()){
            System.out.println("You lose");
        }
        else {
            System.out.println("Draw");
            player.increasepoints(1);
        }
    }

    
}
