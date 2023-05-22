import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The GameGUI class represents the graphical user interface for the game.
 * It provides buttons and panels for player statistics, team information, inventory, and game actions.
 */
public class GameGUI {
    private boolean isArenaClicked = false;
    private JComboBox<Athlete> athleteSelect;  // to select the athlete
    private JButton trainButton;  // to train the selected athlete
    private JFrame frame;
    private JPanel leftPanel, centerPanel, rightPanel;
    private JTextArea infoText, outputText;
    private JButton teamButton, inventoryButton, marketButton, arenaButton,subButton;
    
    /**
     * Constructs a new GameGUI object with the specified player.
     *
     * @param player the player object for the game
     */
    public GameGUI(Player player) {
        frame = new JFrame("Game GUI");
        frame.setLayout(new BorderLayout());

        // Left panel for player statistics and information
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        infoText = new JTextArea(8, 20);
        infoText.setText("Player statistics and information here...");
        Dimension buttonDimension = new Dimension(150, 25);
        teamButton = new JButton("View Team");
        teamButton.addActionListener(e -> viewTeam(player.getTeam()));
        teamButton.setMaximumSize(buttonDimension);
        subButton = new JButton("View Subs");
        subButton.addActionListener(e -> viewsub(player.getsubs()));
        subButton.setMaximumSize(buttonDimension);

        inventoryButton = new JButton("View Inventory");
        inventoryButton.setMaximumSize(buttonDimension);
        inventoryButton.addActionListener(e -> viewInventory(player));
        leftPanel.add(infoText);
        leftPanel.add(teamButton);
        leftPanel.add(subButton);

        
        leftPanel.add(inventoryButton);
        frame.add(leftPanel, BorderLayout.WEST);

        // Center panel for text output
        centerPanel = new JPanel();
        outputText = new JTextArea(20, 30); // 20 rows, 30 columns
        outputText.setText("Text output here...");
        outputText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputText);
        scrollPane.setPreferredSize(new Dimension(400, 400)); // Width, Height

        centerPanel.add(new JScrollPane(outputText));
        centerPanel.setPreferredSize(new Dimension(400, 400));
        frame.add(centerPanel, BorderLayout.CENTER);
        JButton endTurnButton = new JButton("End Turn");
        
        endTurnButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {

        /**
         * This method is called when the "End Turn" button is clicked.
         * It performs the following actions:
         * - Enables the arena button.
         * - Restores the athletes' stamina.
         * - Handles random events.
         * - Updates the output text area.
         * - Increments the turn counter.
         * - Checks if the maximum turn limit is reached and displays a game over message if so.
         * - Updates the information text area with the player's information.
         *
         * @param e the action event
         */
        // enable arena button
                // enable arena button
                arenaButton.setEnabled(true);
                isArenaClicked = false;
                // restore athletes stamina
                player.restoreStamina();
                // Handle random events
                String endTurnText = player.handleRandomEvents();
                updateOutputText(endTurnText);
                
                // Other actions as needed...
                player.inc_trun();
                if (player.getTurn() >= player.maxturn){
                    JDialog dialog = new JDialog();
                    dialog.setAlwaysOnTop(true);
                    JOptionPane.showMessageDialog(dialog, "Game Over! You have reached the maximum turn!\n "+player.toString()+"\n Thanks for playing!");


                }
                updateInfoText(player);
            }
        });
        
        
        
        
        
        
        
        
        endTurnButton.setMaximumSize(buttonDimension);
        centerPanel.add(endTurnButton);
        // Right panel for market place or arena selection
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        marketButton = new JButton("Market Place");
        marketButton.setMaximumSize(buttonDimension);
        arenaButton = new JButton("Arena");
        arenaButton.setMaximumSize(buttonDimension);
        arenaButton.addActionListener(e -> arenaButton.addActionListener(f -> {
    /**
     * This method is called when the "Arena" button is clicked.
     * It creates and shows the ArenaGUI, updates the opponents, and disables the arena button.
     *
     * 
     */
            if (!isArenaClicked) {
                ArenaGUI arenaGUI = new ArenaGUI(player);
                arenaGUI.createAndShowGUI();
                arenaGUI.updateOpponents();
                isArenaClicked = true;
                arenaButton.setEnabled(false);
            }
        }));
        marketButton.addActionListener(e -> openMarket(player));
        rightPanel.add(marketButton);
        rightPanel.add(arenaButton);
        frame.add(rightPanel, BorderLayout.EAST);
        updateInfoText(player);


        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
/**
 * Updates the information text area with the provided text.
 *
 * @param text the text to be displayed in the information area
 */
    public void updateInfoText(String text) {
        infoText.setText(text);

    }
/**
 * Updates the output text area with the provided text.
 *
 * @param text the text to be displayed in the output area
 */
    public void updateOutputText(String text) {
        SwingUtilities.invokeLater(() -> {
            outputText.setText(text);
            if (text.isEmpty()){
                outputText.setText("nothing happened");
            }
        });
    }
 /**
 * Updates the information text area with the player's information.
 *
 * @param player the player object containing the information
 */   
    public void updateInfoText(Player player) {
        StringBuilder playerInfo = new StringBuilder();
        playerInfo.append("Name: ").append(player.getName()).append("\n");
        playerInfo.append("Difficulty: ").append(player.getDifficulty()).append("\n");
        playerInfo.append("Gold: ").append(player.getGold()).append("\n");
        playerInfo.append("Points: ").append(player.getpoints()).append("\n");
        playerInfo.append("Turn: ").append(player.getTurn()).append("\n");
        infoText.setText(playerInfo.toString());
    }
    /**
     * Opens the window to view the player's team.
     *
     * @param team the team object to be viewed
     */
    //private void 
    private void viewTeam(ArrayList<Athlete> team1) {
        JFrame teamFrame = new JFrame("Team View");
        JPanel panel = new JPanel();
        teamFrame.add(panel,BorderLayout.SOUTH);
        JTextArea team1Area = new JTextArea();
        for (Athlete athlete : team1) {
            team1Area.append(athlete.toString());
        }
        athleteSelect = new JComboBox<>();
        athleteSelect.setBounds(10, 50, 200, 25);
        panel.add(athleteSelect);
    
        // Add athletes to the JComboBox
        for (Athlete athlete : team1) {
            
            
            athleteSelect.addItem(athlete);
        }
        athleteSelect.setRenderer(new AthleteListCellRenderer());

        // Create the train button
        trainButton = new JButton("Train Athlete");
        trainButton.setBounds(220, 400, 150, 25);
        trainButton.addActionListener(new ActionListener() {
            @Override
/**
 * Performs the action when the train button is clicked.
 * Trains the selected athlete and displays a dialog box with the result.
 * Updates the team1Area with the updated team information.
 *
 * @param e the action event
 */
            public void actionPerformed(ActionEvent e) {
                Athlete selectedAthlete = (Athlete) athleteSelect.getSelectedItem();
                if (selectedAthlete != null) {
                    selectedAthlete.train();  // call the train() function on selected athlete
                }
                JDialog dialog = new JDialog();
                dialog.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(dialog, "Athlete trained!" + selectedAthlete.toString());
                team1Area.setText("");
                for (Athlete athlete : team1) {
                    team1Area.append(athlete.toString());
                }
            }
        });
        panel.add(trainButton);
        
        teamFrame.add(new JScrollPane(team1Area), BorderLayout.NORTH);
    
        teamFrame.setSize(500, 400); 
        teamFrame.setLocationRelativeTo(null); // center the frame
        teamFrame.setVisible(true);
    }
    

    
/**
 * Opens the inventory GUI to view the player's inventory and team.
 *
 * @param player the player whose inventory and team to view
 */
    private void viewInventory(Player player) {
             
        InventoryGUI inventoryGUI = new InventoryGUI(player, player.getTeam());
        inventoryGUI.viewInventory();

    }
        
    
    
  /**
 * Displays a frame to view the list of substitute athletes.
 *
 * @param subs the list of substitute athletes to display
 */  
    private void viewsub(ArrayList<Athlete> subs) {
        JFrame subFrame = new JFrame("Sub View");
        subFrame.setLayout(new BorderLayout());
    
        JTextArea subArea = new JTextArea();
        for (Athlete athlete : subs) {
            subArea.append(athlete.toString());
        }
        subFrame.add(new JScrollPane(subArea), BorderLayout.CENTER);
    
        subFrame.setSize(500, 400); 
        subFrame.setLocationRelativeTo(null); // center the frame
        subFrame.setVisible(true);
    }
/**
 * Opens the market GUI to access the market options for the player.
 *
 * @param player the player accessing the market
 */
    private void openMarket(Player player) {
        MarketGUI marketGUI = new MarketGUI(player);
        
    }
    
    

    public static void main(String[] args) {
        Player player = new Player("Easy", "testing");
        Item item = new Item("Potion", "Consumable", 50, 0, 0);
        Team team = new Team();
        player.setTeam(team.getteam());
        player.setsubs(team.getsubs());
        player.addInventory(item);
        //player.init_team()
        new GameGUI(player);


    }
}

