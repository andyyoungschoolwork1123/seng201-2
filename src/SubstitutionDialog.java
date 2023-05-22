import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * A dialog for performing player substitutions in a team.
 */
public class SubstitutionDialog extends JDialog {
    private Team team;
    private JComboBox<Athlete> teamCombo;
    private JComboBox<Athlete> subCombo;
     /**
     * Constructs a SubstitutionDialog with the specified parent frame and team.
     * 
     * @param parent The parent frame of the dialog.
     * @param team   The team for which the substitutions are performed.
     */
    public SubstitutionDialog(JFrame parent, Team team) {
        super(parent, "Substitute Player", true);
        this.team = team;
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        teamCombo = new JComboBox<>(team.getteam().toArray(new Athlete[0]));
        subCombo = new JComboBox<>(team.getsubs().toArray(new Athlete[0]));
        
        JButton confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Athlete subOn = (Athlete)subCombo.getSelectedItem();
                Athlete subOff = (Athlete)teamCombo.getSelectedItem();

                // Perform the substitution
                team.subtite(subOn, subOff);

                // Close the dialog
                setVisible(false);
                dispose();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Sub on:"), gbc);
        gbc.gridx++;
        add(subCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Sub off:"), gbc);
        gbc.gridx++;
        add(teamCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(confirmButton, gbc);

        pack();
    }
}


