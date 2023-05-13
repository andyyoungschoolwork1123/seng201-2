import java.util.Scanner;

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
                market.init_market();
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
            while (player.getTurn() <= player.getmaxTurns()){
                player.inc_trun();
                System.out.println("Turn " + player.getTurn() + " begins!");
                System.out.println("Market time!");
                MarketTwo market = new MarketTwo();
                market.init_market();
                //tongs's :)
                // Display current inventory and ask if the player wants to use any items
                player.displayinventory();
                System.out.println("You can now use item on athlete. Please select from inventory:");
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
                System.out.println("You can now change the athletes in your team");
                System.out.println("your subs are:");
                player.printsubs();
                player.displayteam();
                
                arena.pre_battle(player);
                //TONG:implement random event in end 
                System.out.println("Do you want to continue? (Y/N)");
                String cont1 = scanner.nextLine();
                if (cont1.equals("N") || (player.getInventory().size()) == 0){
                    break;
                }
                System.out.println("Training time! ");
                // call method to train athletes
                player.train_athletes();
                System.out.println("End of turn.");
                // call method to generate a random event
                int random = (int)(Math.random() * 10);
                if (random == 0) {
                    System.out.println("Oh no! A key player on your team has been injured and will be out for the next 3 games.");
                    // remove player from team and mark as injured
                    player.removesubs(null);
                }
                // call method to display current player stats
                System.out.println("Thank you for playing! Now your stats are " + player.getpoints() + " points, " + player.getGold() + " gold.");
                System.out.println("Your inventory is: ");
                player.displayinventory();
            }
            // call method to display final player stats
            System.out.println("Final stats:");
            System.out.println("Points: " + player.getpoints());
            System.out.println("Gold: " + player.getGold());
            System.out.println("Team:");
            player.printteam();
            // call method to display final inventory
            System.out.println("Inventory:");
            player.displayinventory();
            // call method to display game over message
            System.out.println("Game over!");

            }
            //System.out.println("Game ends! Your stat are" + player.getpoints() + "points" + player.getGold() + "gold");//have error here dontknow why
            System.out.println("Game over!");
            

        }
    }
