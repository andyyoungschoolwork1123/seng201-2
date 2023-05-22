import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
/**
 * GUI class for displaying and interacting with the player's inventory.
 */
public class InventoryGUI {
    private ArrayList<Item> inventory;
    private ArrayList<Athlete> allAthletes;
    private JFrame frame;
    private Player player;
    /**
     * Constructs a new InventoryGUI object with the given inventory and athlete list.
     *
     * @param inventory    the player's inventory
     * @param allAthletes  the list of all available athletes
     * @param player       the player object frim gamegui
     */
    public InventoryGUI(Player player, ArrayList<Athlete> allAthletes) {
        this.inventory = player.getInventory();
        this.allAthletes = allAthletes;
        this.player = player;
    }
    /**
     * Displays the inventory GUI.
     */
    public void viewInventory() {
        frame = new JFrame("Inventory");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        for (Item item : inventory) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel itemLabel = new JLabel(item.getName());
            JButton itemButton = new JButton("view item");
            JButton useButton = new JButton("Use");
            JButton sellButton = new JButton("Sell");
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle button click
                    JOptionPane.showMessageDialog(null, item.displayitem(item));
                }
            });

            useButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle "Use" button click
                    // Trigger athlete selection process
                    selectAthlete(item);
                }
            });
            sellButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle "Sell" button click
                    inventory.remove(item);
                    player.addgold(item.getSellbackPrice());
                    JOptionPane.showMessageDialog(null, "Item sold for " + item.getSellbackPrice() + " gold");
                    viewInventory();
                }
            });

            
            itemPanel.add(itemLabel);
            itemPanel.add(itemButton);
            itemPanel.add(useButton);
            itemPanel.add(sellButton);
            inventoryPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(inventoryPanel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Opens the athlete selection window for applying the selected item to an athlete.
     *
     * @param item the item to be applied
     */   private void selectAthlete(Item item) {
        // Create a new frame for athlete selection
        JFrame athleteFrame = new JFrame("Select an athlete");
        athleteFrame.setLayout(new BorderLayout());

        // Create a panel with a button for each athlete
        JPanel athletePanel = new JPanel();
        athletePanel.setLayout(new BoxLayout(athletePanel, BoxLayout.Y_AXIS));
        for (Athlete athlete : allAthletes) {
            JButton athleteButton = new JButton(athlete.toString());
            athleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Apply the item to the selected athlete
                    item.applyToAthlete(athlete);
                    JOptionPane.showMessageDialog(null, "Item applied to " + athlete.getName());
                    inventory.remove(item);
                    athleteFrame.dispose();
                    frame.dispose();
                    viewInventory();
                }
            });
            athletePanel.add(athleteButton);
        }

        // Add the panel to a JScrollPane and add the scroll pane to the frame
        JScrollPane scrollPane = new JScrollPane(athletePanel);
        athleteFrame.add(scrollPane, BorderLayout.CENTER);

        // Display the frame
        athleteFrame.setSize(500, 400); 
        athleteFrame.setLocationRelativeTo(null); // center the frame
        athleteFrame.setVisible(true);
    }

    /**
     * The main method for testing the InventoryGUI class.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player = new Player("Easy", "ddd");
        player.addInventory(new Item("Sword", "Weapon", 100, 10, 0));
        player.addInventory(new Item("Shield", "Armor", 100, 0, 10));
        player.addInventory(new Item("Potion", "Potion", 50, 0, 0));
        ArrayList<Athlete> allAthletes = new ArrayList<>();
        allAthletes.add(new Athlete("Athlete 1", 10, 10, 10,"Runner"));
        allAthletes.add(new Athlete("Athlete 2", 10, 10, 10, "Cyclist"));
        allAthletes.add(new Athlete("Athlete 3", 10, 10, 10, "Sprinter"));
        allAthletes.add(new Athlete("Athlete 4", 10, 10, 10, "SuperAthlete"));
        InventoryGUI inventoryGUI = new InventoryGUI(player, allAthletes);
        inventoryGUI.viewInventory();
    }
}
