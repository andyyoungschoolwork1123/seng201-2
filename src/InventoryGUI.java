import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InventoryGUI {
    private ArrayList<Item> inventory;
    private ArrayList<Athlete> allAthletes;
    private JFrame frame;

    public InventoryGUI(ArrayList<Item> inventory, ArrayList<Athlete> allAthletes) {
        this.inventory = inventory;
        this.allAthletes = allAthletes;
    }

    public void viewInventory() {
        frame = new JFrame("Inventory");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));

        for (Item item : inventory) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            JButton itemButton = new JButton(item.toString());
            JButton useButton = new JButton("Use");

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

            itemPanel.add(itemButton);
            itemPanel.add(useButton);
            inventoryPanel.add(itemPanel);
        }

        JScrollPane scrollPane = new JScrollPane(inventoryPanel);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void selectAthlete(Item item) {
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

    
    public static void main(String[] args) {
        ArrayList<Item> inventory = new ArrayList<>();
        inventory.add(new Item("Sword", "Weapon", 100, 10, 0));
        inventory.add(new Item("Shield", "Armor", 100, 0, 10));
        inventory.add(new Item("Potion", "Potion", 50, 0, 0));
        ArrayList<Athlete> allAthletes = new ArrayList<>();
        allAthletes.add(new Athlete("Athlete 1", 10, 10, 10,"Runner"));
        allAthletes.add(new Athlete("Athlete 2", 10, 10, 10, "Cyclist"));
        allAthletes.add(new Athlete("Athlete 3", 10, 10, 10, "Sprinter"));
        allAthletes.add(new Athlete("Athlete 4", 10, 10, 10, "SuperAthlete"));
        InventoryGUI inventoryGUI = new InventoryGUI(inventory, allAthletes);
        inventoryGUI.viewInventory();
    }
}
