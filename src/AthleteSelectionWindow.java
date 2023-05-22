import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/**
 * Represents a window for selecting athletes.
 */

public class AthleteSelectionWindow extends JFrame {

    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_HEIGHT = 600;

    private Player player;
    private ArrayList<Athlete> team = new ArrayList<>();
    private JButton[] athleteButtons;
    /**
     * Creates an instance of AthleteSelectionWindow.
     *
     * @param player the player object
     */
    public AthleteSelectionWindow(Player player) {
        this.player = player;
        initializeWindow();
        initializeComponents();
    }
    /**
     * Initializes the window settings.
     */
    private void initializeWindow() {
        setTitle("Athlete Selection");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Initializes the components of the window.
     */
    private void initializeComponents() {
        JPanel athletePanel = new JPanel();
        athletePanel.setLayout(new GridLayout(5, 2));
        add(athletePanel, BorderLayout.CENTER);
        // Add a label for the athlete selection
        JLabel lblAthleteSelection = new JLabel("Select 5 athletes to form your initial team:", SwingConstants.CENTER);
        add(lblAthleteSelection, BorderLayout.NORTH);
        // Add a button for each athlete
        ArrayList<Athlete> listAthlete = player.init_team();
        athleteButtons = new JButton[listAthlete.size()];
        for (int i = 0; i < listAthlete.size(); i++) {
            Athlete athlete = listAthlete.get(i);
            JButton athleteButton = createAthleteButton(athlete);
            athletePanel.add(athleteButton);
            athleteButtons[i] = athleteButton;
        }
        // Add a panel for the buttons at the bottom
        JPanel southPanel = new JPanel();
        JButton viewAthletesButton = new JButton("View Selected Athletes");
        viewAthletesButton.addActionListener(e -> openSelectedAthletesWindow());
        southPanel.add(viewAthletesButton);
        // Add a button for checking the selection
        JButton checkButton = new JButton("Check Selection");
        checkButton.addActionListener(e -> checkSelection());
        southPanel.add(checkButton);

        add(southPanel, BorderLayout.SOUTH);
    }
    /*
     * Creates a button for selecting an athlete. 
     * @param athlete the athlete to be selected
     * @return the button for selecting the athlete
     */
    private JButton createAthleteButton(Athlete athlete) {
        
        JButton athleteButton = new JButton("Select " + athlete.getName());
        athleteButton.setToolTipText(athlete.getName() + " (" + athlete.getRole() + ")\n"
                + "Stamina: " + athlete.getStamina() + "\n"
                + "Offense: " + athlete.getOffence() + "\n"
                + "Defense: " + athlete.getDefence());
        athleteButton.addActionListener(e -> toggleSelection(athleteButton, athlete));
        return athleteButton;
    }
    /*
     * Toggles the selection of an athlete.
     * @param athleteButton the button for selecting the athlete
     * @param  the athlete to be selected
     */
    private void toggleSelection(JButton athleteButton, Athlete athlete) {
        if (athleteButton.getText().startsWith("Select")) {
            athleteButton.setText("Deselect " + athlete.getName());
            team.add(athlete);
        } else {
            athleteButton.setText("Select " + athlete.getName());
            team.remove(athlete);
        }
    }
    /*
     * Opens a window to display the selected athletes.
     */
    private void openSelectedAthletesWindow() {
        SelectedAthletesWindow selectedAthletesWindow = new SelectedAthletesWindow(team);
        selectedAthletesWindow.setVisible(true);
    }
    /*
     * Checks if the player has selected exactly 5 athletes.
     */
    private void checkSelection() {
        if (team.size() == 5) {
            proceedToNextWindow();
        } else {
            JOptionPane.showMessageDialog(this, "Please select exactly 5 athletes.", "Selection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /*
     * Proceeds to the next window.
     */
    private void proceedToNextWindow() {
        player.setTeam(team);
        GameGUI gameGUI = new GameGUI(player);
        dispose();
    }
}


