import java.util.ArrayList;
import java.util.List;

public class Market<Purchaseable> {
    private List<Purchaseable> items;

    public Market() {
        this.items = new ArrayList<>();
    }

    public void addPurchaseable(Item item) {
        items.add(item);
    }

    public void removePurchaseable(Purchaseable purchaseable) {
        items.remove(purchaseable);
    }

    public void generateItems() {
        String[] offenseNames = {"Sword", "Axe", "Mace", "Dagger", "Bow"};
        String[] defenseNames = {"Shield", "Helmet", "Armor", "Gauntlets", "Boots"};

        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.33) {
                String name = offenseNames[(int) (Math.random() * offenseNames.length)];
                int value = (int) (Math.random() * 50) + 50;
                int amount = (int) (Math.random() * 5) + 1;
                Item item = new Item(name, "offense", value, value / 2, amount);
                addPurchaseable(item);
            } else if (Math.random() < 0.66) {
                String name = defenseNames[(int) (Math.random() * defenseNames.length)];
                int value = (int) (Math.random() * 100) + 100;
                int amount = (int) (Math.random() * 3) + 1;
                Item item = new Item(name, "defense", value, value / 2, amount);
                addPurchaseable(item);
            } else {
                // generate a random item
                String name = "Random Item " + i;
                int value = (int) (Math.random() * 50) + 50;
                int amount = (int) (Math.random() * 5) + 1;
                Item item = new Item(name, "random", value, value / 2, amount);
                addPurchaseable(item);
            }
        }
    }

    public void generateEffectItems() {
        String[] effectNames = {"Elixir", "Potion", "Tonic", "Serum", "Ointment"};
        for (int i = 0; i < 10; i++) {
            String name = effectNames[(int) (Math.random() * effectNames.length)];
            int staminaBoost = (int) (Math.random() * 20) + 10;
            int offenseBoost = (int) (Math.random() * 5) + 1;
            int defenseBoost = (int) (Math.random() * 5) + 1;
            EffectItem effectItem = new EffectItem(name, "effect", staminaBoost, offenseBoost, defenseBoost);
            addPurchaseable(effectItem);
        }
    }
        
    
        String[] athleteNames = {"John", "Jane", "Bob", "Alice", "Tom", "Jerry", "Mike", "Sarah"};
        String[] roles = {"Forward", "Midfielder", "Defender", "Goalkeeper"};
    
        for (int i = 0; i < 5; i++) {
            String name = athleteNames[(int) (Math.random() * athleteNames.length)];
            int stamina = (int) (Math.random() * 50) + 50;
            int offense = (int) (Math.random() * 10) + 10;
            int defence = (int) (Math.random() * 10) + 10;
            String role = roles[(int) (Math.random() * roles.length)];
            int value = (int) (Math.random() * 500) + 500;
            int amount = (int) (Math.random() * 2) + 1;
            Athlete athlete = new Athlete(name, stamina, offense, defence, role, value, value / 2, amount);
            items.addAll(athlete);
        }
    }
    

    public void addpurchaseable(purchaseable purchaseable) {
        items.add(purchaseable);
    }

    public void buy(purchaseable purchaseable) {
        if (items.contains(purchaseable)) {
            purchaseable.increaseAmount(1);
        } else {
            items.add(purchaseable);
        }
    }

    public void sell(purchaseable purchaseable) {
        if (items.contains(purchaseable)) {
            if (purchaseable.getAmount() > 1) {
                purchaseable.decreaseAmount(1);
            } else {
                items.remove(purchaseable);
            }
        }
    }

    public List<purchaseable> getItems() {
        return items;
    }

    
    
}

