public class EffectItem extends Item  {
    private int staminaBoost;
    private int offenseBoost;
    private int defenseBoost;
    
   
    public EffectItem(String name, String type, int staminaBoost, int offenseBoost, int defenseBoost) {
        super(name, type);
        this.staminaBoost = staminaBoost;
        this.offenseBoost = offenseBoost;
        this.defenseBoost = defenseBoost;
        
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

