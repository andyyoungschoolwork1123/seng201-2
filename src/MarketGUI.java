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

        // Set up layout
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(new JScrollPane(athleteList));
        panel.add(new JScrollPane(itemList));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(removeAthleteButton);
        buttonPanel.add(removeItemButton);

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
    }

    private void updateAthleteList() {
        ArrayList<Athlete> athletes = market.getAthletes();
        athleteListModel.removeAllElements();
        for (Athlete athlete : athletes) {
            athleteListModel.addElement(athlete);
        }
    }

    private void updateItemList() {
        ArrayList<Item> items = market.getItems();
        itemListModel.removeAllElements();
        for (Item item : items) {
            itemListModel.addElement(item);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MarketGUI::new);
    }

    // Sample Athlete class
    private class Athlete {
        private String name;

        public Athlete(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Sample Item class
    private class Item {
        private String name;

        public Item(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Sample Market class
    private class Market {
        private ArrayList<Athlete> athletes;
        private ArrayList<Item> items;

        public Market() {
            athletes = new ArrayList<>();
            items = new ArrayList<>();
            athletes.add(new Athlete("John"));
            athletes.add(new Athlete("Mary"));
            items.add(new Item("Football"));
            items.add(new Item("Basketball"));
        }

        public ArrayList<Athlete> getAthletes() {
            return athletes;
        }

        public ArrayList<Item> getItems() {
            return items;
        }

        public void removeAthlete(Athlete athlete) {
            athletes.remove(athlete);
        }

        public void removeItem(Item item) {
            items.remove(item);
        }
    }
}




