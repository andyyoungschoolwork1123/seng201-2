import javax.swing.*;
import java.awt.*;

public class GameEnvSetting extends JFrame {

    private static final int WINDOW_WIDTH = 550;
    private static final int WINDOW_HEIGHT = 350;

    private JTextField playerNameField;
    private JComboBox<String> difficultyComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GameEnvSetting window = new GameEnvSetting();
                window.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public GameEnvSetting() {
        initializeWindow();
        initializeComponents();
    }

    private void initializeWindow() {
        setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Setting");
        setLayout(new GridLayout(6, 2));
    }

    private void initializeComponents() {
        add(new JLabel("Player Name:"));
        playerNameField = new JTextField();
        playerNameField.setColumns(10);
        add(playerNameField);

        add(new JLabel("Difficulty:"));
        difficultyComboBox = new JComboBox<>(new String[] { "Easy", "Medium", "Hard" });
        add(difficultyComboBox);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(new JLabel("Difficulty Description:"));
        add(panel);
        panel.add(new JLabel("Easy - More starting gold, fewer turns"));
        panel.add(new JLabel("Medium - Moderate starting gold, average turns"));
        panel.add(new JLabel("Hard - Less starting gold, more turns"));

        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.addActionListener(e -> openAthleteSelectionWindow());
        add(btnStartGame);
    }

    private void openAthleteSelectionWindow() {
        String playerName = playerNameField.getText();
        String difficulty = (String) difficultyComboBox.getSelectedItem();

        if (playerName.length() < 3 || playerName.length() > 15 || playerName.matches("[^a-zA-Z0-9 ]")) {
            JOptionPane.showMessageDialog(this, "Invalid player name. Player name must be between 3 and 15 characters and should not contain special characters.", "Invalid Player Name", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dispose();

        Player player = new Player(difficulty, playerName);
        AthleteSelectionWindow selectionWindow = new AthleteSelectionWindow(player);
        selectionWindow.setVisible(true);
    }
}

