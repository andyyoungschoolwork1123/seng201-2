import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The MarketGUI class represents a graphical user interface for a market where players can buy athletes and items.
 */

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
    private JButton playerInventoryButton;
    private JLabel playegold;
    private AbstractButton statsLabel;
    

    /**
     * Constructs a new MarketGUI object with the specified player.
     *
     * @param player the player interacting with the market
     */
    public MarketGUI(Player player) {
        // Create the market
        this.market = new Market();
        this.player = player;
        
        
        //Andy : update the market
        updateMarket(player);
        // Create UI controls
        this.athleteListModel = new DefaultListModel<>();

        this.itemListModel = new DefaultListModel<>();
        this.athleteList = new JList<>(athleteListModel);
        this.itemList = new JList<>(itemListModel);
        this.showAthletesButton = new JButton("Show Athletes");
        this.showItemsButton = new JButton("Show Items");
        this.addButton = new JButton("Add");
        this.playerInventoryButton = new JButton("Player Inventory");

        // Set up layout
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(athleteList));
        panel.add(new JScrollPane(itemList));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showAthletesButton);
        buttonPanel.add(showItemsButton);
        buttonPanel.add(addButton);
        buttonPanel.add(playerInventoryButton);
        //show player gold 
        playegold = new JLabel("Player Gold: " + player.getGold());
        buttonPanel.add(playegold);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up the frame
        setTitle("Market");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
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
                        playegold.setText("Player Gold: " + player.getGold());
                        JOptionPane.showMessageDialog(MarketGUI.this, "You bought " + selectedAthlete.getName() + " for " + selectedAthlete.getStoreValue() + " gold!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
                        market.removeAthlete(selectedAthlete);
                        updateAthleteList();
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
                        playegold.setText("Player Gold: " + player.getGold());
                        JOptionPane.showMessageDialog(MarketGUI.this, "You bought " + selectedItem.getName() + " for " + selectedItem.getStoreValue() + " gold!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
                        market.removeItem(selectedItem);
                        updateItemList();
                    } else {
                        JOptionPane.showMessageDialog(MarketGUI.this, "Purchase failed.", "Purchase Failed", JOptionPane.ERROR_MESSAGE);
                    }
                }

                
                
            
            }
        });

        
        playerInventoryButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                InventoryGUI inventoryGUI = new InventoryGUI(player.getInventory(), player.getTeam());
                inventoryGUI.viewInventory();
            }
        });
        
        
    }

/**
 * Updates the athlete list by retrieving the latest list of athletes from the market
 * and updating the athlete list model.
 * 
 * The method clears the existing athlete list model, retrieves the list of athletes from the market,
 * and adds each athlete to the athlete list model. Additionally, it sets a custom cell renderer
 * for the athlete list to ensure proper rendering of athlete items.
 */
    private void updateAthleteList() {
        athleteListModel.clear();
        ArrayList<Athlete> athletes = market.getAthletes();
        for (Athlete athlete : athletes) {

            athleteListModel.addElement(athlete);
            athleteList.setCellRenderer(new AthleteListCellRenderer());

        } 

    }

/**
 * Updates the item list by retrieving the latest list of items from the market
 * and updating the item list model.
 * 
 * The method clears the existing item list model, retrieves the list of items from the market,
 * and adds each item to the item list model.
 */
    private void updateItemList() {
        itemListModel.clear();
        ArrayList<Item> items = market.getItems();
        for (Item item : items) {
            itemListModel.addElement(item);
        }
    }
/**
 * Updates the market by generating a new market based on the specified player's turn.
 * 
 * This method ensures that the market is updated based on the player's turn. It calls
 * the market's "generatemarket" method, passing the player's turn as a parameter to generate
 * a new market state.
 * 
 * @param player The player whose turn is used to update the market.
 */
    //Andy : make sure the market is updated by turn
    private void updateMarket(Player player) {
        market.generatemarket(player.getTurn());
    }
/**
 * Displays the information of athletes in a dialog box.
 * 
 * Retrieves the list of athletes from the market and generates a formatted string
 * containing the athlete information. The method then displays the athlete information
 * in a dialog box using JOptionPane.
 */
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
                    .append("Sellback Price: ").append(athlete.getSellbackPrice()).append("\n\n")
                    ;
        }
        JOptionPane.showMessageDialog(this, athleteInfo.toString(), "Athletes Information", JOptionPane.INFORMATION_MESSAGE);
    }

/**
 * Displays the information of items in a dialog box.
 * 
 * Retrieves the list of items from the market and generates a formatted string
 * containing the item information. The method then displays the item information
 * in a dialog box using JOptionPane.
 */
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
    
   


  /** test and run */  
    public static void main(String[] args) {
        Player player = new Player("Easy", "sss");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MarketGUI( player);
            }
        });
    }
}







    







    





