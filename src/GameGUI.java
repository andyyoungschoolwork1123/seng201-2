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
    private JButton  arenaButton;
    
    /**
     * Constructs a new GameGUI object with the specified player.
     *
     * @param player the player object for the game
     */
    public GameGUI(Player player) {
        frame = createFrame("Sport management");

        // Creating panels
        leftPanel = createLeftPanel(player);
        centerPanel = createCenterPanel(player);
        rightPanel = createRightPanel(player);

        // Adding panels to frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        updateInfoText(player);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(700, 470);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JFrame createFrame(String title) {
        JFrame frame = new JFrame(title);
        frame.setLayout(new BorderLayout());
        return frame;
    }

    private JPanel createLeftPanel(Player player) {
        // Left panel for player statistics and information
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        infoText = new JTextArea(8, 20);
        infoText.setText("Player statistics and information here...");
        infoText.setEditable(false);

        Dimension buttonDimension = new Dimension(150, 25);
        JButton teamButton = createButton("View Team", buttonDimension, e -> viewTeam(player.getTeam()));
        JButton subButton = createButton("View Subs", buttonDimension, e -> viewsub(player.getsubs()));
        JButton inventoryButton = createButton("View Inventory", buttonDimension, e -> viewInventory(player));

        leftPanel.add(infoText);
        leftPanel.add(teamButton);
        leftPanel.add(subButton);
        leftPanel.add(inventoryButton);

        return leftPanel;
    }

    private JPanel createCenterPanel(Player player) {
        // Center panel for text output
        JPanel centerPanel = new JPanel();
        outputText = new JTextArea(20, 30); // 20 rows, 30 columns
        outputText.setText("Text output here...");
        outputText.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputText);
        scrollPane.setPreferredSize(new Dimension(400, 400)); // Width, Height

        centerPanel.add(new JScrollPane(outputText));
        centerPanel.setPreferredSize(new Dimension(400, 400));

        Dimension buttonDimension = new Dimension(150, 25);
        JButton endTurnButton = createButton("End Turn", buttonDimension, e -> endTurnAction(e, player));
        centerPanel.add(endTurnButton);

        return centerPanel;
    }

    private JPanel createRightPanel(Player player) {
        // Right panel for market place or arena selection
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        Dimension buttonDimension = new Dimension(150, 25);
        JButton marketButton = createButton("Market Place", buttonDimension, e -> openMarket(player));
        JButton arenaButton = createButton("Arena", buttonDimension, e -> arenaAction(e, player));
        this.arenaButton = arenaButton;
        rightPanel.add(marketButton);
        rightPanel.add(arenaButton);

        return rightPanel;
    }
    /**
     * This method is called when the "Arena" button is clicked.
     * It creates and shows the ArenaGUI, updates the opponents, and disables the arena button.
     *
     * 
     */

    private void arenaAction(ActionEvent e, Player player) {
        
    if (!isArenaClicked) {
        ArenaGUI arenaGUI = new ArenaGUI(player);
        arenaGUI.createAndShowGUI();
        arenaGUI.updateOpponents();
        isArenaClicked = true;
        arenaButton.setEnabled(false);
    }
    if (arenaButton.isEnabled() == false){
        updateOutputText("You have already enter the arena once");
    }
}
        
            
        
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
    private void endTurnAction(ActionEvent e, Player player) {
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

    private JButton createButton(String text, Dimension dimension, ActionListener listener) {
        JButton button = new JButton(text);
        button.setMaximumSize(dimension);
        button.addActionListener(listener);
        return button;
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
        team1Area.setEditable(false);
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

