public class Athlete implements purchaseable{
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

    public Athlete(String name, int stamina,  int offence, int defence, String role) {
        this.name = name;
        this.stamina = stamina;
        
        this.offence = offence;
        this.defence = defence;
        this.role = role;
        this.injury = false;

        this.storeValue = (int) (stamina * 2 + offence * 5 + defence * 5);
        this.sellbackPrice = storeValue / 2;
        this.amount = 1;
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean getInjury() {
        return injury;
    }

    public void changeInjury() {
        this.injury =  !this.injury;
    }

    public int getOffence() {
        return offence;
    }

    public int getDefence() {
        return defence;
    }

    public String getRole() {
        return role;
    }

	public void increaseStamina(int staminaBoost) {
		
		this.stamina += staminaBoost;
	}

	public void increaseDefense(int defenseBoost) {
		
		this.defence += defenseBoost ;
	}

	public void increaseOffense(int offenseBoost) {
		
		this.offence += offenseBoost ;
	}

    @Override
    public int getStoreValue() {
        
        
        return this.storeValue;
    }

    @Override
    public void setStoreValue(int storeValue) {
        // TODO Auto-generated method stub
        this.storeValue = storeValue;
    }
    
    public void setStoreValue() {
        // TODO Auto-generated method stub
        this.storeValue = (int) (this.stamina * 2 + this.offence * 5 + this.defence * 5);
    }
    
    @Override
    public int getSellbackPrice() {
        // TODO Auto-generated method stub
        return this.sellbackPrice;
    }

    @Override
    public void setSellbackPrice(int sellbackPrice) {
        // TODO Auto-generated method stub
        this.sellbackPrice = sellbackPrice;
    }
    public void setSellbackPrice() {
        // TODO Auto-generated method stub
        this.sellbackPrice = (int) (this.storeValue * 0.8);
    }
    public int getAmount() {
        // TODO Auto-generated method stub
        return this.amount;    }

    
    public void setAmount(int amount) {
        // TODO Auto-generated method stub
        this.amount = amount;    }

    @Override
    public void increaseAmount(int amount) {
        // TODO Auto-generated method stub
        this.amount += amount ;
    }

    @Override
    public void decreaseAmount(int amount) {
        // TODO Auto-generated method stub
        this.amount -= amount;
        if (this.amount < 0){
            this.amount = 0;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Athlete j = new Athlete("jack", 100, 50, 50, "defender", 1000, 500, 1);
        System.out.println(j.getStoreValue());
        j.increaseStamina(10);
        System.out.println(j.getStamina());
    }
}
