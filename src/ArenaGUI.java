import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArenaGUI {

    private Arena arena;
    private Player player;
    private Team playerTeam;
    private JComboBox<Team> opponentSelect; 
    private JButton subButton;
    private JButton startBattleButton;

    public ArenaGUI(Player player) {
        this.arena =new Arena();
        this.player = player;
        this.playerTeam = arena.createPlayerTeam(player);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Arena Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create the substitute player button
        subButton = new JButton("Substitute Player");
        subButton.setBounds(10, 10, 150, 25);
        subButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arena.subplayer(playerTeam);
                // Update the UI to reflect the new player state
            }
        });
        panel.add(subButton);

        // Create the opponent selection dropdown
        opponentSelect = new JComboBox<>();
        opponentSelect.setBounds(170, 10, 150, 25);
        panel.add(opponentSelect);

        // Create the start battle button
        startBattleButton = new JButton("Start Battle");
        startBattleButton.setBounds(330, 10, 150, 25);
        startBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Team selectedOpponent = (Team) opponentSelect.getSelectedItem();
                if (selectedOpponent != null) {
                    //arena.battle(playerTeam,selectedOpponent,player);
                    String battleResult = arena.battle(playerTeam, selectedOpponent, player); // call the function
                    JTextArea textArea = new JTextArea();
                    textArea.setText(battleResult); // set the text

                    // Update the UI to reflect the new game state
                }
            }
        });
        panel.add(startBattleButton);
    }

    public void updateOpponents() {
        // Clear the current items
        opponentSelect.removeAllItems();
        arena.InitAvailableOpponents(player.getTurn());
        // Add the new items
        ArrayList<Team> opponents = arena.getAvailableOpponents();
        for (Team opponent : opponents) {
            opponentSelect.addItem(opponent);
        }
    }

    public static void main(String[] args) {
        Player player = new Player("Easy", "testing");
        Team team = new Team();
        player.setteam(team);

        ArenaGUI arenaGUI = new ArenaGUI(player);
        arenaGUI.createAndShowGUI();
        arenaGUI.updateOpponents();
    }
}
