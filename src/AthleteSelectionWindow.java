import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.util.ArrayList;

public class AthleteSelectionWindow extends JFrame {

    private Player player;
    private ArrayList<Athlete> team = new ArrayList<Athlete>();

    public AthleteSelectionWindow(Player player) {
        this.player = player;
        initialize();
    }

    private void initialize() {
        setTitle("Athlete Selection");
        setBounds(100, 100, 720, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel athletePanel = new JPanel();
        athletePanel.setBounds(50, 50, 750, 450);
        getContentPane().add(athletePanel);
        athletePanel.setLayout(null);

        JLabel lblAthleteSelection = new JLabel("Select 5 athletes:");
        lblAthleteSelection.setBounds(10, 10, 150, 20);
        athletePanel.add(lblAthleteSelection);

        JButton[] athleteButtons = new JButton[10];
        ArrayList<Athlete> listAthlete = player.init_team();
        for (int i = 0; i < 10; i++) {
            Athlete athleteOnSelect = listAthlete.get(i);

            JButton athleteButton = new JButton("Select " + athleteOnSelect.getName());
            athleteButton.setBounds(10 + (i % 2) * 160, 40 + (i / 2) * 50, 150, 30);
            athleteButton.setToolTipText(athleteOnSelect.getName() + " (" + athleteOnSelect.getRole() + ")\n"
                    + "Stamina: " + athleteOnSelect.getStamina() + "\n"
                    + "Offense: " + athleteOnSelect.getOffence() + "\n"
                    + "Defense: " + athleteOnSelect.getDefence());
            athletePanel.add(athleteButton);

            athleteButton.addActionListener(e -> {
                if (athleteButton.getText().startsWith("Select")) {
                    athleteButton.setText("Deselect " + athleteOnSelect.getName());
                    team.add(athleteOnSelect);
                } else {
                    athleteButton.setText("Select " + athleteOnSelect.getName());
                    team.remove(athleteOnSelect);
                }
            });

            athleteButtons[i] = athleteButton; // Assign the button to the array
        }

        JButton viewAthletesButton = new JButton("View Selected Athletes");
        viewAthletesButton.setBounds(450, 500, 160, 30);
        getContentPane().add(viewAthletesButton);
        viewAthletesButton.addActionListener(e -> openSelectedAthletesWindow());

        setVisible(true);
    }

    private void openSelectedAthletesWindow() {
        SelectedAthletesWindow selectedAthletesWindow = new SelectedAthletesWindow(team);
        selectedAthletesWindow.setVisible(true);
    }

    
}


