import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MarketGUI extends JFrame {

    private Market market;
    private Player player;
    private DefaultListModel<Athlete> athleteListModel;
    private DefaultListModel<Item> itemListModel;
    private JList<Athlete> athleteList;
    private JList<Item> itemList;
    private JButton showAthletesButton;
    private JButton showItemsButton;
    private JButton addButton;
    private JButton playerStatsButton;
    private JButton inventoryTextArea;
    private AbstractButton statsLabel;
    


    public MarketGUI() {
        // Create the market
        this.market = new Market();
        
        
        market.init_market();

        // Create UI controls
        this.athleteListModel = new DefaultListModel<>();
        this.itemListModel = new DefaultListModel<>();
        this.athleteList = new JList<>(athleteListModel);
        this.itemList = new JList<>(itemListModel);
        this.showAthletesButton = new JButton("Show Athletes");
        this.showItemsButton = new JButton("Show Items");
        this.addButton = new JButton("Add");
        this.playerStatsButton = new JButton("Player Stats");

        // Set up layout
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(athleteList));
        panel.add(new JScrollPane(itemList));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAthletesButton);
        buttonPanel.add(showItemsButton);
        buttonPanel.add(addButton);
        buttonPanel.add(playerStatsButton);

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
        showAthletesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAthletes();
            }
        });

        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayItems();
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (athleteList.isSelectionEmpty() && itemList.isSelectionEmpty()) {
                    // Neither athlete nor item is selected
                    JOptionPane.showMessageDialog(MarketGUI.this, "Please select an athlete or an item to purchase.", "Selection Required", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                if (!athleteList.isSelectionEmpty()) {
                    // Buy athlete
                    Athlete selectedAthlete = athleteList.getSelectedValue();
                    boolean athleteSuccess = market.buyAthlete(player, selectedAthlete);
                    
                    if (athleteSuccess) {
                        player.addsubs(selectedAthlete);
                        player.setGold(player.getGold() - selectedAthlete.getStoreValue());
                        JOptionPane.showMessageDialog(MarketGUI.this, "You bought " + selectedAthlete.getName() + " for " + selectedAthlete.getStoreValue() + " gold!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(MarketGUI.this, "Purchase failed.", "Purchase Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                if (!itemList.isSelectionEmpty()) {
                    // Buy item
                    Item selectedItem = itemList.getSelectedValue();
                    boolean itemSuccess = market.buyItem(player, selectedItem);
                    
                    if (itemSuccess) {
                        player.addInventory(selectedItem);
                        player.setGold(player.getGold() - selectedItem.getStoreValue());
                        JOptionPane.showMessageDialog(MarketGUI.this, "You bought " + selectedItem.getName() + " for " + selectedItem.getStoreValue() + " gold!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(MarketGUI.this, "Purchase failed.", "Purchase Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }

                
                
            
            }
        });

        playerStatsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display player's inventory and gold
                StringBuilder inventoryInfo = new StringBuilder();
                inventoryInfo.append("Gold: ").append(player.getGold()).append("\n\n");
                inventoryInfo.append("Inventory:\n").append(player.getInventory().toString());
                
                // Update the inventoryTextArea and statsLabel
                inventoryTextArea.setText(inventoryInfo.toString());
                statsLabel.setText("Gold: " + player.getGold());
                
                // Show a message dialog with player's stats
                JOptionPane.showMessageDialog(MarketGUI.this, "Gold: " + player.getGold() + "\n\nInventory:\n" + player.getInventory().toString(), "Player Stats", JOptionPane.INFORMATION_MESSAGE);
                
                // Display player's statistics in the console
                System.out.println("Now your stats are " + player.getpoints() + " points " + player.getGold() + " gold");
                System.out.println("Your inventory is: ");
                player.displayinventory();
            }
        });
        
        
    }

    private void updateAthleteList() {
        athleteListModel.clear();
        ArrayList<Athlete> athletes = market.getAthletes();
        for (Athlete athlete : athletes) {
            athleteListModel.addElement(athlete);
        }
    }

    private void updateItemList() {
        itemListModel.clear();
        ArrayList<Item> items = market.getItems();
        for (Item item : items) {
            itemListModel.addElement(item);
        }
    }

    private void displayAthletes() {
        StringBuilder athleteInfo = new StringBuilder();
        ArrayList<Athlete> athletes = market.getAthletes();
        for (Athlete athlete : athletes) {
            athleteInfo.append("Name: ").append(athlete.getName()).append("\n")
                    .append("Stamina: ").append(athlete.getStamina()).append("\n")
                    .append("Offence: ").append(athlete.getOffence()).append("\n")
                    .append("Defence: ").append(athlete.getDefence()).append("\n")
                    .append("Role: ").append(athlete.getRole()).append("\n")
                    .append("Store Value: ").append(athlete.getStoreValue()).append("\n")
                    .append("Sellback Price: ").append(athlete.getSellbackPrice()).append("\n")
                    .append("Amount: ").append(athlete.getAmount()).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, athleteInfo.toString(), "Athletes Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void displayItems() {
        StringBuilder itemInfo = new StringBuilder();
        ArrayList<Item> items = market.getItems();
        for (Item item : items) {
            itemInfo.append("Name: ").append(item.getName()).append("\n")
                    .append("Type: ").append(item.getType()).append("\n")
                    .append("Buy Price: ").append(item.getStoreValue()).append("\n")
                    .append("Sell Price: ").append(item.getSellbackPrice()).append("\n")
                    .append("Stock: ").append(item.getAmount()).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, itemInfo.toString(), "Items Information", JOptionPane.INFORMATION_MESSAGE);
    }



    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MarketGUI();
            }
        });
    }
}







    







    





