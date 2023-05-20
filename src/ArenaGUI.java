import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class ArenaGUI {

    private Arena arena;
    private Player player;
    private Team playerTeam;
    private JComboBox<Team> opponentSelect; 
    private JButton subButton;
    private JButton startBattleButton;
    private JFrame frame;
    public ArenaGUI(Player player) {
        this.arena =new Arena();
        this.player = player;
        this.playerTeam = arena.createPlayerTeam(player);
    }

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Arena Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosed(WindowEvent e) {
            updateplayerTeams();
            // your additional code here, e.g., reopening the GameGUI
            GameGUI gameGUI = new GameGUI(player);
            //...
        }
    });
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Create the substitute player button
        subButton = new JButton("Substitute Player");
        subButton.setBounds(10, 10, 150, 25);
        subButton.addActionListener(e -> {
            if (playerTeam.getsubs().size() == 0) {
                subButton.setEnabled(false);
            }
            else{
                subButton(frame);}
            });
            
        
        panel.add(subButton);

        //hint
        JLabel LBlhintsub = new JLabel("Hint: You can sub only before match start");
        LBlhintsub.setBounds(550, 10, 300, 25);
        panel.add(LBlhintsub);
        JLabel LBLhintBattle = new JLabel("Hint: Battle against the opponent team");
        LBLhintBattle.setBounds(550, 40, 300, 25);
        panel.add(LBLhintBattle);
        JLabel LBLhintBattle2 = new JLabel("Hint: esitmate strength of opponent team only work as a reference");
        LBLhintBattle2.setBounds(550, 70, 400, 25);
        panel.add(LBLhintBattle2);
        JLabel LBLhintBattle3 = new JLabel("Hint: You can only battle against one team per turn");
        LBLhintBattle3.setBounds(550, 100, 400, 25);
        panel.add(LBLhintBattle3);

        //text area for main battle
        panel.add(subButton);
        JTextArea textArea = new JTextArea();
        textArea.setBounds(10, 40, 500, 500);
        panel.add(textArea);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 40, 500, 500);
        panel.add(scrollPane);

        // Create the opponent selection dropdown
        opponentSelect = new JComboBox<>();
        opponentSelect.setBounds(170, 10, 200, 25);
        panel.add(opponentSelect);

        // Create the start battle button
        startBattleButton = new JButton("Start Battle");
        startBattleButton.setBounds(380, 10, 150, 25);
        startBattleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Team selectedOpponent = (Team) opponentSelect.getSelectedItem();
                if (selectedOpponent != null) {
                    //arena.battle(playerTeam,selectedOpponent,player);
                    String battleResult = arena.battle(playerTeam, selectedOpponent, player); // call the function
                    textArea.setText(battleResult); // set the text

                    // Update the UI to reflect the new game state
                }
            }
        });
        panel.add(startBattleButton);
        JButton btnUseitemButton = new JButton("Use Item from inventory");
        btnUseitemButton.setBounds(550, 130, 200, 25);
        btnUseitemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //arena.battle(playerTeam,selectedOpponent,player);
                //String battleResult = playerTeam.su(playerTeam, player); // call the function
                //textArea.setText(battleResult); // set the text

                // Update the UI to reflect the new game state
            }
        });
    }
    public void subButton(JFrame frame) {
        SubstitutionDialog dialog = new SubstitutionDialog(frame, playerTeam);
                    dialog.pack();
                    dialog.setVisible(true);        // Update the UI to reflect the new player state

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
    public void updateplayerTeams(){
        //update player result
        player.setTeam(playerTeam.getteam());
        player.setsubs(playerTeam.getsubs());

    }
    public Player getPlayer() {
        updateplayerTeams();
        return this.player;
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
    