import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGUI {
    private JFrame frame;
    private JPanel leftPanel, centerPanel, rightPanel;
    private JTextArea infoText, outputText;
    private JButton teamButton, inventoryButton, marketButton, arenaButton,subButton;
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
        teamButton.addActionListener(e -> viewTeam(player.getTeam(), player.getsubs()));
        teamButton.setMaximumSize(buttonDimension);
        subButton = new JButton("View Subs");
        subButton.addActionListener(e -> viewsub(player.getsubs()));
        subButton.setMaximumSize(buttonDimension);

        inventoryButton = new JButton("View Inventory");
        inventoryButton.setMaximumSize(buttonDimension);
        inventoryButton.addActionListener(e -> viewinventory(player.getInventory()));
        leftPanel.add(infoText);
        leftPanel.add(teamButton);
        leftPanel.add(subButton);

        
        leftPanel.add(inventoryButton);
        frame.add(leftPanel, BorderLayout.WEST);

        // Center panel for text output
        centerPanel = new JPanel();
        outputText = new JTextArea("Textual output here...");
        centerPanel.add(new JScrollPane(outputText));
        centerPanel.setFocusable(false);
        centerPanel.setPreferredSize(new Dimension(400, 400));
        frame.add(centerPanel, BorderLayout.CENTER);

        // Right panel for market place or arena selection
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        marketButton = new JButton("Market Place");
        marketButton.setMaximumSize(buttonDimension);
        arenaButton = new JButton("Arena");
        arenaButton.setMaximumSize(buttonDimension);
        arenaButton.addActionListener(e -> openArena(player));
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
    public void updateInfoText(String text) {
        infoText.setText(text);
    }
    public void updateOutputText(String text) {
        outputText.setText(text);
    }   
    public void updateInfoText(Player player) {
        StringBuilder playerInfo = new StringBuilder();
        playerInfo.append("Name: ").append(player.getName()).append("\n");
        playerInfo.append("Difficulty: ").append(player.getDifficulty()).append("\n");
        playerInfo.append("Gold: ").append(player.getGold()).append("\n");
        playerInfo.append("Points: ").append(player.getpoints()).append("\n");
        playerInfo.append("Turn: ").append(player.getTurn()).append("\n");
        infoText.setText(playerInfo.toString());
    }
    //private void 
    private void viewTeam(ArrayList<Athlete> team1, ArrayList<Athlete> team2) {
        JFrame teamFrame = new JFrame("Team View");
        teamFrame.setLayout(new BorderLayout());
    
        JTextArea team1Area = new JTextArea();
        for (Athlete athlete : team1) {
            team1Area.append(athlete.toString());
        }
        teamFrame.add(new JScrollPane(team1Area), BorderLayout.CENTER);
    
        JTextArea team2Area = new JTextArea();
        for (Athlete athlete : team2) {
            team2Area.append(athlete.toString());
        }
        teamFrame.add(new JScrollPane(team2Area), BorderLayout.SOUTH);
    
        teamFrame.setSize(500, 400); 
        teamFrame.setLocationRelativeTo(null); // center the frame
        teamFrame.setVisible(true);
    }

    
    
    private void viewinventory(ArrayList<Item> inventory) {
        JFrame inventoryFrame = new JFrame("Inventory View");
        inventoryFrame.setLayout(new BorderLayout());
    
        JTextArea inventoryArea = new JTextArea();
        for (Item item : inventory) {
            inventoryArea.append(item.toString());
        }
        inventoryFrame.add(new JScrollPane(inventoryArea), BorderLayout.CENTER);
    
        inventoryFrame.setSize(500, 400); 
        inventoryFrame.setLocationRelativeTo(null); // center the frame
        inventoryFrame.setVisible(true);
    }
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
    private void openMarket(Player player) {
        //MarketGUI marketGUI = new MarketGUI(player);
    }
    private void openArena(Player player) {
       ArenaGUI arenaGUI = new ArenaGUI(player);
       arenaGUI.createAndShowGUI();
        arenaGUI.updateOpponents();
    }
    

    public static void main(String[] args) {
        Player player = new Player("Easy", "testing");
        //player.init_team()
        new GameGUI(player);


    }
}

