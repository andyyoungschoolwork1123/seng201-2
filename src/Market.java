import java.util.List;

public class Market {
    private List<purchaseable> items;

    public Market() {
        this.items = new ArrayList<purchaseable>();
        String[] offenseNames = {"Sword", "Hammer", "Shiv"};
        String[] defenseNames = {"Shield", "Chainmail", "Platemail"};
    
        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.5) {
                String name = offenseNames[(int) (Math.random() * offenseNames.length)];
                int value = (int) (Math.random() * 50) + 50;
                int amount = (int) (Math.random() * 5) + 1;
                EffectItem item = new EffectItem(name, "offense", 0, value, 0, value, value / 2, amount);
                items.add(item);
            } else {
                String name = defenseNames[(int) (Math.random() * defenseNames.length)];
                int value = (int) (Math.random() * 100) + 100;
                int amount = (int) (Math.random() * 3) + 1;
                EffectItem item = new EffectItem(name, "defense", 0, 0, value, value, value / 2, amount);
                items.add(item);
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
            items.add(athlete);
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

