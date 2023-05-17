import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AthleteSelectionWindow extends JFrame {

    private String playerName;
    private String difficulty;

    public AthleteSelectionWindow(String playerName, String difficulty) {
        this.playerName = playerName;
        this.difficulty = difficulty;
        initialize();
    }

    private void initialize() {
        setTitle("Athlete Selection");
        setBounds(100, 100, 450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel athletePanel = new JPanel();
        athletePanel.setBounds(50, 50, 350, 150);
        getContentPane().add(athletePanel);
        athletePanel.setLayout(null);

        JLabel lblAthleteSelection = new JLabel("Select 5 athletes:");
        lblAthleteSelection.setBounds(10, 10, 150, 20);
        athletePanel..add(lblAthleteSelection);

        JButton[] athleteButtons = new JButton[6];
        for (int i = 0; i < 6; i++) {
            String role;
            if (i == 0) {
                role = "Forward";
            } else if (i == 1) {
                role = "Midfielder";
            } else if (i == 2) {
                role = "Defender";
            } else {
                role = "Goalkeeper";
            }
            athleteButtons[i] = new JButton("Select " + role);
            athleteButtons[i].setBounds(10 + (i % 2) * 160, 40 + (i / 2) * 50, 150, 30);
            athletePanel.add(athleteButtons[i]);
        }
        for (int i = 0; i < 6; i++) {
            int athleteIndex = i;
            athleteButtons[i].addActionListener(e -> selectAthlete(athleteIndex));
        }
    }
    private void selectAthlete(int athleteIndex) {
        String role;
        switch (athleteIndex) {
            case 0:
                role = "Forward";
                break;
            case 1:
                role = "Midfielder";
                break;
            case 2:
                role = "Defender";
                break;
            case 3:
                role = "Goalkeeper";
                break;
            default:
                role = ""; // Invalid selection
                break;
        }

        if (!role.isEmpty()) {
            Athlete athlete = Athlete.generateAthlete(1, role);
            // Add the selected athlete to the player's team
            player.getTeam().add(athlete);

            // Disable the selected button
            JButton selectedButton = (JButton) athletePanel.getComponent(athleteIndex);
            selectedButton.setEnabled(false);

            // Check if 5 athletes have been selected
            if (player.getTeam().size() == 5) {
                // Perform any actions required after all athletes have been selected
                // For example, you can save the player's team and proceed to the next stage of the game
            }
        }
    }

    
    
