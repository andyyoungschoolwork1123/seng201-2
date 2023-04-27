public class EffectItem extends Item implements Purchaseable {
    private int staminaBoost;
    private int offenseBoost;
    private int defenseBoost;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
   
    public EffectItem(String name, String type, int staminaBoost, int offenseBoost, int defenseBoost, int storeValue, int sellbackPrice, int amount) {
        super(name, type);
        this.staminaBoost = staminaBoost;
        this.offenseBoost = offenseBoost;
        this.defenseBoost = defenseBoost;
        this.storeValue = storeValue;
        this.sellbackPrice = sellbackPrice;
        this.amount = amount;
    }
   
    public int getStoreValue() {
        return storeValue;
    }

    public int getSellbackPrice() {
        return sellbackPrice;
    }

    public int getAmount() {
        return amount;
    }

    public void increaseAmount(int amount) {
        this.amount += amount;
    }

    public void decreaseAmount(int amount) {
        this.amount -= amount;
    }

    public int getStaminaBoost() {
        return staminaBoost;
    }
   
    public int getOffenseBoost() {
        return offenseBoost;
    }
   
    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void applyToAthlete(Athlete athlete) {
        if (this instanceof EffectItem) {
            EffectItem effectItem = (EffectItem) this;
            athlete.increaseStamina(effectItem.getStaminaBoost());
            athlete.increaseOffense(effectItem.getOffenseBoost());
            athlete.increaseDefense(effectItem.getDefenseBoost());
        }
    }
}

public class Athlete implements Purchaseable {
    private String name;
    private int stamina;
    private boolean injury;
    private int offence;
    private int defence;
    private String role;
    private int storeValue;
    private int sellbackPrice;
    private int amount;

    public Athlete(String name, int stamina,  int offence, int defence, String role, int storeValue, int sellbackPrice, int amount) {
        this.name = name;
        this.stamina = stamina;
        this.offence = offence;
        this.defence = defence;
        this.role = role;
        this.injury = false;
        this.storeValue = storeValue;
        this.sellbackPrice = sellbackPrice;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getStamina()
}