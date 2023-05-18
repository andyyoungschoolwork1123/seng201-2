import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
public class GameWindow {

    private JFrame frame;
    private JTextField playerNameField;
    private JComboBox<String> difficultyComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameWindow window = new GameWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GameWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblPlayerName = new JLabel("Player Name:");
        lblPlayerName.setBounds(50, 50, 100, 20);
        frame.getContentPane().add(lblPlayerName);

        playerNameField = new JTextField();
        playerNameField.setBounds(150, 50, 200, 20);
        frame.getContentPane().add(playerNameField);
        playerNameField.setColumns(10);

        JLabel lblDifficulty = new JLabel("Difficulty:");
        lblDifficulty.setBounds(50, 100, 100, 20);
        frame.getContentPane().add(lblDifficulty);

        difficultyComboBox = new JComboBox<String>();
        difficultyComboBox.setBounds(150, 100, 200, 20);
        difficultyComboBox.addItem("Easy");
        difficultyComboBox.addItem("Medium");
        difficultyComboBox.addItem("Hard");
        frame.getContentPane().add(difficultyComboBox);

        // Add description labels
        JLabel lblEasyDescription = new JLabel("Easy - More starting gold, fewer turns");
        lblEasyDescription.setBounds(150, 130, 250, 20);
        frame.getContentPane().add(lblEasyDescription);

        JLabel lblMediumDescription = new JLabel("Medium - Moderate starting gold, average turns");
        lblMediumDescription.setBounds(150, 155, 300, 20);
        frame.getContentPane().add(lblMediumDescription);

        JLabel lblHardDescription = new JLabel("Hard - Less starting gold, more turns");
        lblHardDescription.setBounds(150, 180, 250, 20);
        frame.getContentPane().add(lblHardDescription);

        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(150, 220, 100, 30);
        frame.getContentPane().add(btnStartGame);

        btnStartGame.addActionListener(e -> openAthleteSelectionWindow());
    }


    private void openAthleteSelectionWindow() {
        String playerName = playerNameField.getText();
        String difficulty = (String) difficultyComboBox.getSelectedItem();

        // Validate player name
        if (playerName.length() < 3 || playerName.length() > 15 || playerName.contains("[^a-zA-Z0-9 ]")) {
            JOptionPane.showMessageDialog(frame, "Invalid player name. Player name must be between 3 and 15 characters and should not contain special characters.", "Invalid Player Name", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Close the player setup window
        frame.dispose();

        // Create the Player object
        Player player = new Player(difficulty, playerName);

        // Open the athlete selection window and pass the Player object
        AthleteSelectionWindow selectionWindow = new AthleteSelectionWindow(player);
        selectionWindow.setVisible(true);
    }

}


