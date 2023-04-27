import EffectItem.java;
public class Item {
    private String name;
    private String type;
   
    public Item(String name, String type) {
        this.name = name;
        this.type = type;
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
}
