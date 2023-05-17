import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

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

        JButton btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(150, 150, 100, 30);
        frame.getContentPane().add(btnStartGame);

        btnStartGame.addActionListener(e -> openAthleteSelectionWindow());
    }

    private void openAthleteSelectionWindow() {
        String playerName = playerNameField.getText();
        String difficulty = (String) difficultyComboBox.getSelectedItem();

        // Close the player setup window
        frame.dispose();

        // Open the athlete selection window
        AthleteSelectionWindow selectionWindow = new AthleteSelectionWindow(playerName, difficulty);
        selectionWindow.setVisible(true);
    }

}

