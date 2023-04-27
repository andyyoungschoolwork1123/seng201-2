public class Athlete {
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
		// TODO Auto-generated method stub
		this.stamina += staminaBoost;
	}

	public void increaseDefense(int defenseBoost) {
		// TODO Auto-generated method stub
		this.defence += defenseBoost ;
	}

	public void increaseOffense(int offenseBoost) {
		// TODO Auto-generated method stub
		this.offence += offenseBoost ;
	}
}
