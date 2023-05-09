import java.util.ArrayList;

public class MarketTwo {
    private ArrayList<Athlete> athletes;
    private ArrayList<Item> items;
    
    public MarketTwo() {
        this.athletes = new ArrayList<Athlete>();
        this.items = new ArrayList<Item>();
    }
    
    public void addAthlete(Athlete athlete) {
        athletes.add(athlete);
    }
    
    public void addItem(Item item) {
        items.add(item);
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
    
    public Athlete getAthleteByName(String name) {
        for (Athlete athlete : athletes) {
            if (athlete.getName().equals(name)) {
                return athlete;
            }
        }
        return null;
    }
    
    public Athlete getAthleteByStamina(int stamina) {
        for (Athlete athlete : athletes) {
            if (athlete.getStamina() == stamina) {
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByoffence(int offence) {
        for (Athlete athlete : athletes) {
            if (athlete.getOffence() == offence) {
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByDefence(int defence){
        for (Athlete athlete : athletes){
            if (athlete.getDefence()==defence){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByRole(String role){
        for(Athlete athlete : athletes){
            if(athlete.getRole()==role){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteByStoreValue(int storeValue){
        for(Athlete athlete : athletes){
            if(athlete.getStoreValue()==storeValue){
                return athlete;
            }
        }
        return null;
    }

    public Athlete getAthleteBySellbackprice(int sellbackPrice){
        for(Athlete athlete : athletes){
            if(athlete.getSellbackPrice()==sellbackPrice){
                return athlete;
            }
        }
        return null;
    }

    public int getAthleteAmount() {
        int totalAmount = 0;
        for (Athlete athlete : athletes) {
            totalAmount += athlete.getAmount();
        }
        return totalAmount;
    }
    

    
    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemByType(String type) {
        for (Item item : items) {
            if (item.getType().equals(type)) {
                return item;
            }
        }
        return null;
    }

    public Item getItemByStoreValue(int storeValue){
        for(Item item:items){
            if(item.getStoreValue()==(storeValue)){
                return item;
            }
        }
        return null;
    }

    public Item getItemBySellbackPrice(int sellbackPrice){
        for(Item item:items){
            if(item.getSellbackPrice()==(sellbackPrice)){
                return item;
            }
        }
        return null;
    }

    public int getItemAmount(String itemName) {
        int totalAmount = 0;
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                totalAmount += item.getAmount();
            }
        }
        return totalAmount;
    }
    

 
}

