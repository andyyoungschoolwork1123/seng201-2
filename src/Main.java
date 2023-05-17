
import java.util.ArrayList;
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
                market.displaymarket();
                System.out.println("Do you want to buy an item or Athletes? (1 for item, 2 for Athletes)");
                int choice = scanner.nextInt();
                if (choice == 1){
                    System.out.println("Enter the item you want to buy:");
                    String itemName = scanner.nextLine();
                    scanner.nextLine(); // Consume the newline character
                    Item item=market.getItemByName(itemName);
                    if(item != null){
                        boolean success = market.buyItem(player, item);
                        if(success){
                            System.out.println("You have successfully bought the item: " + item.getName());
                        }
                        else{System.out.println("You do not have enough resources to buy this item.");}

                    }
                    else{
                        System.out.println("The item you requested is not available.");
                    }
                }
                    else if (choice ==2){
                        System.out.println("Enter the ID of the athlete you want to buy:");
                        String athleteName = scanner.nextLine();
                        scanner.nextLine(); // Consume the newline character
                        // Call the getAthlete method in the MarketTwo class to get the athlete
                        Athlete athlete = market.getAthleteByName(athleteName);

                        if(athlete !=null){
                            boolean success = market.buyAthlete(player, athlete);
                            if (success){
                                System.out.println("You have successfully bought the athlete: " + athlete.getName());
                            }
                            else{System.out.println("You do not have enough resources to buy this athlete.");}}
                            else{System.out.println("The athlete you requested is not available.");}}
                            else{System.out.println("Invalid choice.");}}

                scanner.nextLine(); // Consume the newline character
                //5.17By Tong
                System.out.println("The Arena is now calling! ");
                Arena arena = new Arena();
                arena.InitAvailableOpponents(1);
                player.printteam();
                arena.pre_battle(player);
            
            else{
                System.out.println("Invalid input. Please try again.");
            }
            System.out.println(" Now your stat are" + player.getpoints() + " point " + player.getGold() + " gold ");
            System.out.println("Your inventory is: ");
            player.displayinventory();
                System.out.println("You can now train the athletes in your team,or use item on them. Please select from inventory:");
                player.applyfrominventory();
                player.train_athletes();
                       
            System.out.println("Turn ends,next turn coming!");

            while (player.getTurn() <= player.getmaxTurns()){
                player.inc_trun();
                System.out.println("Turn " + player.getTurn() + " begins!");
                System.out.println("Market time!");
                MarketTwo market1 = new MarketTwo();
                market1.init_market();

                market1.displaymarket();//5.17 By Tong
                System.out.println("Do you want to buy an item? (y/n)");
                String cont0 = scanner.nextLine();
        
                if (cont0.equals("y")) {
                    // Ask the player which item they want to buy
                    System.out.println("Which item do you want to buy? (enter the name)");
                    String itemName = scanner.nextLine();
                    Item item = market1.getItemByName(itemName);
                
                    if (item != null) {
                        // Attempt to buy the item
                        boolean success = market1.buyItem(player, item);
                        if (success) {
                            // If the purchase is successful, add the item to the player's inventory
                            player.addInventory(item);
                        }
                    } else {
                        System.out.println("Item not found!");
                    }
                } else if (cont0.equals("n")) {
                    System.out.println("No problem! Have a great day!");
                } else {
                    System.out.println("Invalid input!");
                }//5.17 TONG
                
                
            
        
                // Display current inventory and ask if the player wants to use any items
                
                System.out.println("You can now use item on athlete. Please select from inventory:");
                player.InitInventory();
                //player.displayinventory();//5.17By Tong
                System.out.println("Do you want to continue? (Y/N)");
                String cont1 = scanner.nextLine();
                if (cont1.equals("N") | (player.getInventory().size()) == 0){
                    System.out.println("skiped");
                }
                else{
                    player.applyfrominventory();
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
                //System.out.println("Do you want to continue? (Y/N)");
                //String cont2 = scanner.nextLine();
                //if (cont2.equals("N") || (player.getInventory().size()) == 0){
                    //break;

                //}
                System.out.println("Training time! ");
                // call method to train athletes
                player.train_athletes();
                System.out.println("End of turn.");
                // call method to generate a random event
                
                int random = (int)(Math.random() * 10);
                if (random == 0) {
                    System.out.println("Oh no! A key player on your team has been injured and will be out for the next 3 games.");
                    
                    // remove player from team and mark as injured
                    //5.15 fixed by TONG
                    ArrayList<Athlete> subs = player.getsubs();
                    for (int i=0;i<subs.size();i++){
                        Athlete athlete = subs.get(i);
                        if(athlete.getInjury()){
                            player.removesubs(athlete);
                        }
                    }
                    


                }
                // call method to display current player stats
                System.out.println(" Now your stats are " + player.getpoints() + "  points, " +  player.getGold() + "  gold. ");
                System.out.println("Your inventory is: ");
                player.displayinventory();

               
                        
            
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
    }



