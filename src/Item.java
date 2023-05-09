public class Item implements purchaseable{
    //item class
    private String name;
    private String type;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
   
    public Item(String name, String type, int storeValue, int sellbackPrice, int amount) {
        this.name = name;
        this.type = type;
        this.storeValue = storeValue;
        this.sellbackPrice = sellbackPrice;
        this.amount = amount;
    }
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
        this.storeValue = 0;
        this.sellbackPrice = 0;
        this.amount = 0;
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
    public String getName() {
        return name;
    }
   
    public String getType() {
        return type;
    }
   
    public void applyToAthlete(Athlete athlete) {
        if (this instanceof EffectItem) {
            EffectItem effectItem = (EffectItem) this;
            athlete.increaseStamina(effectItem.getStaminaBoost());
            athlete.increaseOffense(effectItem.getOffenseBoost());
            athlete.increaseDefense(effectItem.getDefenseBoost());
        }
    }
    @Override
    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }

    @Override
    public void setSellbackPrice(int sellbackPrice) {
        
        this.sellbackPrice = sellbackPrice;    }

    public void setAmount(int amount) {
        this.amount = amount;    }
}
