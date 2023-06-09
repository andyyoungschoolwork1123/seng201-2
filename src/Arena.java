import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * The Arena class represents an arena where teams can compete against available opponents.
 */
public class Arena {
    private ArrayList<Team> availableOpponents;
    private ArrayList<String> availableOpponentsNames;
 /**
     * Constructs an Arena object with a list of available opponents.
     * The available opponents are initialized with predefined names.
     */
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


    /**
     * Returns the list of available opponents.
     *
     * @return the list of available opponents
     */

    public ArrayList<Team> getAvailableOpponents() {
        return availableOpponents;
    }


/**
     * Returns the list of available opponents' names.
     *
     * @return the list of available opponents' names
     */

    public ArrayList<String> getAvailableOpponentsNames() {
        return availableOpponentsNames;
    }

    /**
     * Initializes the list of available opponents for a given turn.
     * Clears the current list of available opponents and generates new teams with athletes based on the turn and strategy types.
     *
     * @param turn the current turn
     */

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
    /**
     * Adds an opponent team to the list of available opponents.
     *
     * @param t the team to add
     */

    public void addOpponent(Team t) {
        availableOpponents.add(t);
    }
    /**
     * Removes an opponent team from the list of available opponents.
     *
     * @param t the team to remove
     */
    public void removeOpponent(Team t) {
        availableOpponents.remove(t);
    }
    /**
     * Displays the available opponents in the command-line interface.
     * Prints the name and total estimated power of each available opponent.
     */

    public void displayAvailableOpponents_cmd() {
        System.out.println("Available opponents:");
        for (int i = 0; i < availableOpponents.size(); i++) {
            System.out.println((i+1) + ". " + availableOpponents.get(i).getname()+ " (" + availableOpponents.get(i).gettotalestpower() + ")");
            }
            //System.out.println((i+1) + ". " + opponent.getName() + " (" + opponent.getRole() + ")");
        
    }

 /**
     * Generates a list of available athletes for a team based on the specified type.
     *
     * @param turn the current turn or round
     * @param type the type of team (e.g., "balance", "offense", "defense")
     * @return the list of available athletes for the team
     */

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

    /**
     * Creates a team for the player based on their selected players and substitutes.
     *
     * @param player the player object representing the player
     * @return the team object representing the player's team
     */
    public Team createPlayerTeam(Player player){
        Team Team_player = new Team(player.getName(),player.getTeam(),player.getsubs());
        return Team_player;

    }
    
    /**
     * Performs the pre-battle setup for the player, including team selection and opponent selection.
     *
     * @param player the player object representing the player
     */
    public void pre_battle(Player player) {
        if (player.getTeam().size() < 5) {
            System.out.println("You need to have 5 players in your team to battle");
            return;
        }
        Team playerTeam = createPlayerTeam( player);
        System.out.println("Do you want to change your team? (Y/N)");
                String decision_t = System.console().readLine();
                if (decision_t.equals("Y")){
                    subplayer(playerTeam);
                }
        int turn = player.getTurn();
        this.InitAvailableOpponents(turn);
        this.displayAvailableOpponents_cmd();
        System.out.println("Please select an opponent to battle");
        int selection = Integer.parseInt(System.console().readLine());
        Team opponent = availableOpponents.get(selection - 1);
        opponent.printteam();
        battle_easy(playerTeam,opponent,player);
    }
    
/**Simulates a battle between two teams.
 * @param Team_player the team controlled by the player
 * @param opponent the opposing team
 * @param player the player object
 * */
    public void battle_easy(Team Team_player,Team opponent,Player player) {
        Team Team2 = opponent;
        
        int duration =0;
        
        Team attacker = Team_player;
        Team defender = Team2;
        while (duration <= 20) {
            System.out.println("Turn " + (duration + 1));
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
                    System.out.println(attacker.getname() + " score!");
                    attacker.setpos(0);
                    defender.setpos(0);
                } 
                else {
                    defender.setpos(defender.getpos() + 1);
                    System.out.println(attacker.team.get(attacker.getpos()).getName() + " go past " + defender.team.get(defender.getpos()).getName());
                }
            }
                
             else {
    
                if (attacker.getpos() == 4) {
                    defender.addScore(1);
                    System.out.println(defender.getname() +" score");
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
            if (attacker.team.get(attacker.getpos()).injury_check()== true) {
                
                System.out.println(attacker.team.get(attacker.getpos()).getName() + " is injured");
                attacker.team.remove(attacker.team.get(attacker.getpos()));
                if (attacker.getpos() == 0){
                }
                else{
                    attacker.setpos(attacker.getpos()-1);
                    
                }
            }
            if (defender.team.get(defender.getpos()).injury_check()== true) {
                System.out.println(defender.team.get(defender.getpos()).getName() + " is injured");
                defender.team.remove(defender.team.get(defender.getpos()));
                if (defender.getpos() == 4){
                    System.out.println("Goal is Empty!!");
                    attacker.addScore(1);
                    System.out.println(attacker.getname() + " score!");
                    attacker.setpos(0);
                    defender.setpos(0);
                }
                else{
                    defender.setpos(defender.getpos()-1);

                }
            }
            if (attacker.team.get(attacker.getpos()).getStamina() <= 30 && attacker.equals(Team_player)) {
                System.out.println(attacker.team.get(attacker.getpos()).getName() + " is exhausted");
                System.out.println("1 use a potion?/2 continue");
                int selection = Integer.parseInt(System.console().readLine());
                if (selection == 1) {
                    player.applyfrominventory();
                    System.out.println("Stamina of " + attacker.team.get(attacker.getpos()).getName() + " is restored to" + attacker.team.get(attacker.getpos()).getStamina());
                } else {
                    System.out.println("Continue");
                }
                
            }
            if (defender.team.get(defender.getpos()).getStamina() <= 30 && defender.equals(Team_player)) {
                System.out.println(defender.team.get(defender.getpos()).getName() + " is exhausted");
                System.out.println("1 use a potion?/2 continue");
                int selection = Integer.parseInt(System.console().readLine());
                if (selection == 1) {
                    player.applyfrominventory();
                    System.out.println("Stamina of " + defender.team.get(defender.getpos()).getName() + " is restored to" + defender.team.get(attacker.getpos()).getStamina());
                } else {
                    System.out.println("Continue");
                }
            
            if (duration == player.getmaxTurns()) {
                System.out.println("Match over");
                break;}
            }    
        }
        
        int getgold = 0;
        System.out.println("Team1 score: " + Team_player.getscore());
        System.out.println("Team2 score: " + Team2.getscore());
        if (Team_player.getscore() > Team2.getscore()){
            System.out.println("You win");
            player.increasepoints(3);
             getgold = (int)(Team2.gettotalestpower()/5);

        }
        else if (Team_player.getscore() < Team2.getscore()){
            System.out.println("You lose");
             getgold = (int)(Team2.gettotalestpower()/10);
        }
        else {
            System.out.println("Draw");
            player.increasepoints(1);
             getgold = (int)(Team2.gettotalestpower()/8);


        }
        player.addgold(getgold);
        System.out.println("You get " + (int)(Team2.gettotalestpower()/10) + " gold");
        return;


    }

/**
 * Simulates a soccer match between two teams.
 *
 * @param Team_player The team controlled by the player.
 * @param opponent The opposing team.
 * @param player The player participating in the match.
 * @return A String containing the details of the match.
 */

    public String battle(Team Team_player,Team opponent,Player player) {
        StringBuilder output = new StringBuilder();
    
        Team Team2 = opponent;
        int duration =0;
        Team attacker = Team_player;
        Team defender = Team2;
       
        while (duration <= 20) {
            output.append("Turn " + (duration + 1)+"\n");
            duration += 1;
            if (attacker.team.get(attacker.getpos()).personal_duel(defender.team.get(defender.getpos()), duration)) {
                if (attacker.getpos() !=0){
                    output.append(attacker.team.get(attacker.getpos()).getName() + " passes to " + attacker.team.get(attacker.getpos()-1).getName()+"\n");
                    attacker.setpos(attacker.getpos()-1 );
                    attacker.team.get(attacker.getpos()).setStamina(attacker.team.get(attacker.getpos()).getStamina()-1);
                    defender.setpos(defender.getpos() + 1);
                    output.append(attacker.team.get(attacker.getpos()).getName() + " pass though " + defender.team.get(defender.getpos()).getName()+"\n");
                }
                if (defender.getpos() == 4) {
                    attacker.addScore(1);
                    output.append(attacker.getname() + " score!"+"\n");
                    attacker.setpos(0);
                    defender.setpos(0);
                } 
                else {
                    defender.setpos(defender.getpos() + 1);
                    output.append(attacker.team.get(attacker.getpos()).getName() + " go past " + defender.team.get(defender.getpos()).getName()+"\n");
                }
            }
                
             else {
    
                if (attacker.getpos() == 4) {
                    defender.addScore(1);
                    output.append(defender.getname() +" score"+"\n");
                    attacker.setpos(0);
                    defender.setpos(0);
                } else {
                    output.append(attacker.team.get(attacker.getpos()).getName() + " loses the ball to " + defender.team.get(defender.getpos()).getName()+"\n");
                    Team temp = attacker;
                    attacker = defender;
                    defender = temp;
                    attacker.setpos(defender.getpos());
                    defender.setpos(temp.getpos());
                }
            }
            if (attacker.team.get(attacker.getpos()).injury_check()== true) {
                
                output.append(attacker.team.get(attacker.getpos()).getName() + " is injured"+"\n");
                attacker.team.remove(attacker.team.get(attacker.getpos()));
                if (attacker.getpos() == 0){
                }
                else{
                    attacker.setpos(attacker.getpos()-1);
                    
                }
            }
            if (defender.team.get(defender.getpos()).injury_check()== true) {
                output.append(defender.team.get(defender.getpos()).getName() + " is injured"+"\n");
                defender.team.remove(defender.team.get(defender.getpos()));
                if (defender.getpos() == 4){
                    output.append("Goal is Empty!!"+"\n");
                    attacker.addScore(1);
                    output.append(attacker.getname() + " score!"+"\n");
                    attacker.setpos(0);
                    defender.setpos(0);
                }
                else{
                    defender.setpos(defender.getpos()-1);

                }
            }
            if (attacker.team.get(attacker.getpos()).getStamina() <= 30 && attacker.equals(Team_player)) {
                output.append(attacker.team.get(attacker.getpos()).getName() + " is exhausted"+"\n");
                output.append("hint: use a potion"+"\n");
                
                }
                
            }
            if (defender.team.get(defender.getpos()).getStamina() <= 30 && defender.equals(Team_player)) {
                output.append(defender.team.get(defender.getpos()).getName() + " is exhausted"+"\n");
                output.append("hint: use a potion"+"\n");

            
            
        }             
        // Rest of your function with all System.out.println replaced with output.append
    
        output.append("Team1 score: ").append(Team_player.getscore()).append("\n");
        output.append("Team2 score: ").append(Team2.getscore()).append("\n");
        
        int getgold = 0;
        if (Team_player.getscore() > Team2.getscore()){
            output.append("You win\n");
            player.increasepoints(3);
            getgold = (int)(Team2.gettotalestpower()/5);
        }
        else if (Team_player.getscore() < Team2.getscore()){
            output.append("You lose\n");
            getgold = (int)(Team2.gettotalestpower()/10);
        }
        else {
            output.append("Draw\n");
            player.increasepoints(1);
            getgold = (int)(Team2.gettotalestpower()/8);
        }
        
        player.addgold(getgold);
        output.append("You get ").append((int)(Team2.gettotalestpower()/10)).append(" gold\n");
        return output.toString();
    }

/**
 * Allows the substitution of players in a team.
 *
 * @param team The team for which to perform the substitution.
 */

    public void subplayer(Team team){
        if (team.getsubs().size() == 0){
            System.out.println("No subs available");
            return;
        }
        System.out.println("Do you want to sub a player? (y/n)");
        String comfirm = System.console().readLine();
        if (comfirm.equals("n")|comfirm.equals("N")) {
            System.out.println("action cancelled");
            return;       
        }
        
        System.out.println("Select the player you want to sub on:");
        team.printsubs();
        int subon_pos = Integer.parseInt(System.console().readLine());
        System.out.println("Select the player you want to sub off:");
        team.printteam();
        int suboff_pos = Integer.parseInt(System.console().readLine());
        Athlete subon = team.getsubs().get(subon_pos - 1);
        Athlete suboff = team.team.get(suboff_pos - 1);
        team.subtite(subon_pos, suboff_pos);
        
        System.out.println(suboff.getName() + " is subbed off");
        System.out.println(subon.getName() + " is subbed on");
    }

/**run the code  */
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
