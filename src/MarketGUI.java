import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MarketGUI extends JFrame {

    private Market market;
    private DefaultListModel<Athlete> athleteListModel;
    private DefaultListModel<Item> itemListModel;
    private JList<Athlete> athleteList;
    private JList<Item> itemList;
    private JButton removeAthleteButton;
    private JButton removeItemButton;
    private JButton addAthleteButton;
    private JButton addItemButton;
    private JButton showAthleteAttributionButton;
    private JButton showItemAttributionButton;

    public MarketGUI() {
        // Create the market
        market = new Market();

        // Create UI controls
        athleteListModel = new DefaultListModel<>();
        itemListModel = new DefaultListModel<>();
        athleteList = new JList<>(athleteListModel);
        itemList = new JList<>(itemListModel);
        removeAthleteButton = new JButton("Remove Athlete");
        removeItemButton = new JButton("Remove Item");
        addAthleteButton = new JButton("Add Athlete");
        addItemButton = new JButton("Add Item");
        showAthleteAttributionButton = new JButton("Show Athlete");
        showItemAttributionButton = new JButton("Show Item");

        // Set up layout
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(athleteList));
        panel.add(new JScrollPane(itemList));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeAthleteButton);
        buttonPanel.add(removeItemButton);
        buttonPanel.add(addAthleteButton);
        buttonPanel.add(addItemButton);
        buttonPanel.add(showAthleteAttributionButton);
        buttonPanel.add(showItemAttributionButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("Market");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Update the lists
        updateAthleteList();
        updateItemList();

        // Register button listeners
        removeAthleteButton.addActionListener(e -> {
            Athlete selectedAthlete = athleteList.getSelectedValue();
            if (selectedAthlete != null) {
                market.removeAthlete(selectedAthlete);
                updateAthleteList();
            }
        });

        removeItemButton.addActionListener(e -> {
            Item selectedItem = itemList.getSelectedValue();
            if (selectedItem != null) {
                market.removeItem(selectedItem);
                updateItemList();
            }
        });

        addAthleteButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter the athlete's name:", "Add Athlete", JOptionPane.PLAIN_MESSAGE);
            if (name != null && !name.isEmpty()) {
                int stamina = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the athlete's stamina:", "Add Athlete", JOptionPane.PLAIN_MESSAGE));
                int offence = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the athlete's offence:", "Add Athlete", JOptionPane.PLAIN_MESSAGE));
                int defence = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the athlete's defence:", "Add Athlete", JOptionPane.PLAIN_MESSAGE));
                String role = JOptionPane.showInputDialog(this, "Enter the athlete's role:", "Add Athlete", JOptionPane.PLAIN_MESSAGE);
        
                int storeValue = stamina * 2 + offence * 5 + defence * 5;
                int sellbackPrice = (int) (storeValue * 0.8);
                int amount = 1;
        
                Athlete newAthlete = new Athlete(name, stamina, offence, defence, role, storeValue, sellbackPrice, amount);
                market.addAthlete(newAthlete);
                updateAthleteList();
            }
        });

        addItemButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "Enter the item's name:", "Add Item", JOptionPane.PLAIN_MESSAGE);
            if (name != null && !name.isEmpty()) {
                String type = JOptionPane.showInputDialog(this, "Enter the item's type:", "Add Item", JOptionPane.PLAIN_MESSAGE);
                int storeValue = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's store value:", "Add Item", JOptionPane.PLAIN_MESSAGE));
                int sellbackPrice = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's sellback price:", "Add Item", JOptionPane.PLAIN_MESSAGE));
                int amount = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's amount:", "Add Item", JOptionPane.PLAIN_MESSAGE));
                int staminaBoost = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's stamina boost:", "Add Item", JOptionPane.PLAIN_MESSAGE));
                int offenseBoost = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's offense boost:", "Add Item", JOptionPane.PLAIN_MESSAGE));
                int defenseBoost = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter the item's defense boost:", "Add Item", JOptionPane.PLAIN_MESSAGE));
        
                Item newItem = new Item(name, type, storeValue, sellbackPrice, amount, staminaBoost, offenseBoost, defenseBoost);
                market.addItem(newItem);
                updateItemList();
            }
        });

        showAthleteAttributionButton.addActionListener(e -> {
            Athlete selectedAthlete = athleteList.getSelectedValue();
            if (selectedAthlete != null) {
                String athleteInfo = "Name: " + selectedAthlete.getName() + "\n"
                        + "Stamina: " + selectedAthlete.getStamina() + "\n"
                        + "Offence: " + selectedAthlete.getOffence() + "\n"
                        + "Defence: " + selectedAthlete.getDefence() + "\n"
                        + "Role: " + selectedAthlete.getRole() + "\n"
                        + "Store Value: " + selectedAthlete.getStoreValue() + "\n"
                        + "Sellback Price: " + selectedAthlete.getSellbackPrice() + "\n"
                        + "Amount: " + selectedAthlete.getAmount();
                JOptionPane.showMessageDialog(this, athleteInfo, "Athlete Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        showItemAttributionButton.addActionListener(e -> {
            Item selectedItem = itemList.getSelectedValue();
            if (selectedItem != null) {
                String itemInfo = "Name: " + selectedItem.getName() + "\n"
                        + "Type: " + selectedItem.getType() + "\n"
                        + "Store Value: " + selectedItem.getStoreValue() + "\n"
                        + "Sellback Price: " + selectedItem.getSellbackPrice() + "\n"
                        + "Amount: " + selectedItem.getAmount() + "\n"
                        + "Stamina Boost: " + selectedItem.getStaminaBoost() + "\n"
                        + "Offense Boost: " + selectedItem.getOffenseBoost() + "\n"
                        + "Defense Boost: " + selectedItem.getDefenseBoost();
                JOptionPane.showMessageDialog(this, itemInfo, "Item Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MarketGUI());
    }
}




    







    





