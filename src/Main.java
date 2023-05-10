import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! Please enter your name:");
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.nextLine();
            System.out.println("Hello " + name + "! Welcome to the game!");
            System.out.println("Now please select your difficulty level:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            int difficulty = scanner.nextInt();
            String difficultys = "";
            if (difficulty == 1) {
                System.out.println("You have selected Easy difficulty.");
                difficultys = "Easy";
            } else if (difficulty == 2) {
                System.out.println("You have selected Medium difficulty.");
                difficultys = "Medium";
                
            } else if (difficulty == 3) {
                System.out.println("You have selected Hard difficulty.");
                difficultys = "Hard";
            } else {
                System.out.println("Invalid input. Please try again.");

            }

            Player player = new Player(difficultys, name);
            player.init_team_commandline();
            System.out.println("You have selected the following athletes:");
            player.displayteam();
            
            System.out.println("You have finished selecting your team. Now you cann battle against the computer, or view market place.");
            System.out.println("Please select an option:");
            System.out.println("1. Battle");
            System.out.println("2. View market place");
            int option = scanner.nextInt();
            if (option == 1){
                Arena arena = new Arena();
                arena.InitAvailableOpponents(1);
                player.printteam();
                arena.pre_battle(player);

            }
            else if (option == 2){
                MarketTwo market = new MarketTwo();
                //market.init_market();
                //tongs's :)
                player.displayinventory();
                System.out.println("The Arena is now calling! ");
                Arena arena = new Arena();
                arena.InitAvailableOpponents(1);
                player.printteam();
                arena.pre_battle(player);
            }
            else{
                System.out.println("Invalid input. Please try again.");
            }
            System.out.println("Thank you for playing! Now your stat are" + player.getpoints() + "points" + player.getGold() + "gold");
            System.out.println("Your inventory is: ");
            player.displayinventory();
            while (true){
                System.out.println("You can now train the athletes in your team,or use item on them. Please select from inventory:");
                player.applyfrominventory();
                System.out.println("Do you want to continue? (Y/N)");
                String cont = scanner.nextLine();
                if (cont.equals("N") | (player.getInventory().size()) == 0){
                    break;
                }
            }
            System.out.println("Turn ends,next turn coming!");
            while (player.getTurn() < 15){
                player.inc_trun();
                System.out.println("Turn " + player.getTurn() + " begins!");
                System.out.println("Market time!");
                //MarketTwo market = new MarketTwo();
                //market.init_market();
                //tongs's :)
                
                //System.out.println("You can now use item on athlete. Please select from inventory:");
                player.applyfrominventory();
                System.out.println("Do you want to continue? (Y/N)");
                String cont = scanner.nextLine();
                if (cont.equals("N") | (player.getInventory().size()) == 0){
                    break;
                }
                System.out.println("The Arena is now calling! ");
                Arena arena = new Arena();
                arena.InitAvailableOpponents(player.getTurn());
                player.printteam();
                //System.out.println("You can now change the athletes in your team");
                //System.out.println("your subs are:");
                //player.printsubs();
                //player.displayteam();
                //System.out.println("Do you want to change your team? (Y/N)");
                //String cont = scanner.nextLine();
                //if (cont.equals("Y")){
                    //System.out.println("Please select the athlete you want to change:");
                    //int num = scanner.nextInt();
                    //System.out.println("Please select the athlete you want to change to:");
                    //int num2 = scanner.nextInt();
                    //player.changeteam(num, num2);
                //}
                arena.pre_battle(player);
                //market again?
                //training
                //end of turn

            }
            System.out.println("Game ends! Your stat are" + player.getpoints() + "points" + player.getGold() + "gold");
            

        }
    }
}
