import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.util.ArrayList;

import javax.swing.JButton;


public class AthleteSelectionWindow extends JFrame {

    private Player player;
    private ArrayList<Athlete> team = new ArrayList<Athlete>();
    
    public AthleteSelectionWindow(Player player) {
        this.player = player;
        initialize();
        JButton viewAthletesButton = new JButton("View Selected Athletes");
    viewAthletesButton.setBounds(450, 500, 160, 30);
    getContentPane().add(viewAthletesButton);
    viewAthletesButton.addActionListener(e -> openSelectedAthletesWindow());
     }
    

     private void openSelectedAthletesWindow() {
        SelectedAthletesWindow selectedAthletesWindow = new SelectedAthletesWindow(team);
        selectedAthletesWindow.setVisible(true);
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
        ArrayList<Athlete> ListAthlete = player .init_team();
        for (int i = 0; i < 10; i++) {
            Athlete athleteOnSelect = ListAthlete.get(i);
    
            athleteButtons[i] = new JButton("Select " + athleteOnSelect.getName());
            athleteButtons[i].setBounds(10 + (i % 2) * 160, 40 + (i / 2) * 50, 150, 30);
            athleteButtons[i].setToolTipText(athleteOnSelect.getName() + " (" + athleteOnSelect.getRole() + ")\n"
                    + "Stamina: " + athleteOnSelect.getStamina() + "\n"
                    + "Offense: " + athleteOnSelect.getOffence() + "\n"
                    + "Defense: " + athleteOnSelect.getDefence());
            athletePanel.add(athleteButtons[i]);
        }
        for (int i = 0; i < 10; i++) {
            int athleteIndex = i;
            athleteButtons[i].addActionListener(e -> selectAthlete(athleteIndex,ListAthlete));
        }
        
    
    }

    private void selectAthlete(int athleteIndex,ArrayList<Athlete> ListAthlete) {
        team.add(ListAthlete.get(athleteIndex));
    }
    
    }

    
    
