import javax.swing.*;
import java.awt.*;

public class GameGUI {
    private JFrame frame;
    private JPanel leftPanel, centerPanel, rightPanel;
    private JTextArea infoText, outputText;
    private JButton teamButton, changeTeamButton, inventoryButton, marketButton, arenaButton;

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
        teamButton.setMaximumSize(buttonDimension);
        changeTeamButton = new JButton("Change Team");
        changeTeamButton.setMaximumSize(buttonDimension);
        inventoryButton = new JButton("View Inventory");
        inventoryButton.setMaximumSize(buttonDimension);
        leftPanel.add(infoText);
        leftPanel.add(teamButton);
        leftPanel.add(changeTeamButton);
        leftPanel.add(inventoryButton);
        frame.add(leftPanel, BorderLayout.WEST);

        // Center panel for text output
        centerPanel = new JPanel();
        outputText = new JTextArea("Textual output here...");
        centerPanel.add(new JScrollPane(outputText));
        centerPanel.setFocusable(false);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Right panel for market place or arena selection
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        marketButton = new JButton("Market Place");
        marketButton.setMaximumSize(buttonDimension);
        arenaButton = new JButton("Arena");
        arenaButton.setMaximumSize(buttonDimension);
        rightPanel.add(marketButton);
        rightPanel.add(arenaButton);
        frame.add(rightPanel, BorderLayout.EAST);

        // Frame settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Player player = new Player("Easy", "testing");
        //player.init_team()
        new GameGUI(player);

    }
}

