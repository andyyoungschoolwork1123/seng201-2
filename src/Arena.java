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
            System.out.println((i+1) + ". " + availableOpponents.get(i).getname()+ " (" + availableOpponents.get(i).gettotalestpower() + ")");
            }
            //System.out.println((i+1) + ". " + opponent.getName() + " (" + opponent.getRole() + ")");
        
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
        //Collection.shuffle(ava); to do
        return ava;
        
    }

    public void pre_battle(Player player) {
        if (player.getTeam().size() < 5) {
            System.out.println("You need to have 5 players in your team to battle");
            return;
        }

        int turn = player.getTurn();
        this.InitAvailableOpponents(turn);
        this.displayAvailableOpponents_cmd();
        System.out.println("Please select an opponent to battle");
        int selection = Integer.parseInt(System.console().readLine());
        Team opponent = availableOpponents.get(selection - 1);
        opponent.printteam();
        battle_easy(player,opponent);
    }
    
    public void battle_easy(Player player,Team opponent) {
        Team Team_player = new Team(player.getName(),player.getTeam());
        Team Team2 = opponent;
        
        int duration =0;
        
        Team attacker = Team_player;
        Team defender = Team2;
        while (duration <= 20) {

            duration += 1;
            if (attacker.team.get(attacker.getpos()).personal_duel(defender.team.get(defender.getpos()), duration)) {
                if (attacker.getpos() !=0){
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " passes to " + attacker.team.get(attacker.getpos()-1).getName());
                    attacker.setpos(attacker.getpos()-1);
                    attacker.team.get(attacker.getpos()).setStamina(attacker.team.get(attacker.getpos()).getStamina()-1);
                    defender.setpos(defender.getpos() + 1);
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " pass though " + defender.team.get(defender.getpos()).getName());
                }
                if (defender.getpos() == 4) {
                    attacker.addScore(1);
                    System.out.println("Team1 score");
                    attacker.setpos(0);
                    defender.setpos(0);
                } else {
                    defender.setpos(defender.getpos() + 1);
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " go past " + defender.team.get(defender.getpos()).getName());
                }
                if (attacker.team.get(attacker.getpos()).getStamina() <= 20) {
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " is exhausted");
                    System.out.println("1 use a sub?/2 use a stamina potion?/3 continue");
                    int selection = Integer.parseInt(System.console().readLine());
                    if (selection == 1) {
                        //attacker.team.get(attacker.getpos()).setStamina(attacker.team.get(attacker.getpos()).getStamina() + 20);
                        //attacker.team.get(attacker.getpos()).setStamina(attacker.team.get(attacker.getpos()).getStamina() - 20);
                        System.out.println("Sub used");
                    } else if (selection == 2) {
                        attacker.team.get(attacker.getpos()).setStamina(attacker.team.get(attacker.getpos()).getStamina() + 20);
                        System.out.println("Stamina potion used");
                    }
                    
                }
            } else {
    
                if (attacker.getpos() == 4) {
                    defender.addScore(1);
                    System.out.println("Team2 score");
                    attacker.setpos(0);
                    defender.setpos(0);
                } else {
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " loses the ball to " + defender.team.get(defender.getpos()).getName());
                    Team temp = attacker;
                    attacker = defender;
                    defender = temp;
                    attacker.setpos(defender.getpos());
                    defender.setpos(temp.getpos());
                }
            }
            if (duration == 20) {
                System.out.println("Game over");
                break;
            }
        }    
        
        
        System.out.println("Team1 score: " + Team_player.getscore());
        System.out.println("Team2 score: " + Team2.getscore());
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

    public static void main(String[] args) {
        Arena arena = new Arena();
        arena.InitAvailableOpponents(1);
        //arena.displayAvailableOpponents_cmd();
        Player player = new Player("Easy","test");
        player.setTeam(arena.generate_AvailableTeamAthletes(1,"balance"));
        player.printteam();
        arena.pre_battle(player);
    }

}
