import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * A window that displays the information of selected athletes.
 */
public class SelectedAthletesWindow extends JFrame {

    private ArrayList<Athlete> team;

     /**
     * Constructs a SelectedAthletesWindow with the specified team of athletes.
     * 
     * @param team The team of athletes to display in the window.
     */

    public SelectedAthletesWindow(ArrayList<Athlete> team) {
        this.team = team;
        initialize();
    }
    /**
     * Initializes the components and settings of the SelectedAthletesWindow.
     */
    private void initialize() {
        setTitle("Selected Athletes");
        setBounds(100, 100, 300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel athletePanel = new JPanel();
        athletePanel.setBounds(20, 20, 250, 320);
        getContentPane().add(athletePanel);
        athletePanel.setLayout(null);

        JTextArea athletesTextArea = new JTextArea();
        athletesTextArea.setEditable(false);

        // Generate the text to display the selected athletes' information
        StringBuilder athletesInfo = new StringBuilder();
        for (Athlete athlete : team) {
            athletesInfo.append(athlete.getName()).append(" (").append(athlete.getRole()).append(")\n");
            athletesInfo.append("Stamina: ").append(athlete.getStamina()).append("\n");
            athletesInfo.append("Offense: ").append(athlete.getOffence()).append("\n");
            athletesInfo.append("Defense: ").append(athlete.getDefence()).append("\n\n");
        }
        athletesTextArea.setText(athletesInfo.toString());

        JScrollPane scrollPane = new JScrollPane(athletesTextArea);
        scrollPane.setBounds(10, 10, 230, 300);
        athletePanel.add(scrollPane);
    }

}
