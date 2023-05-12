public class Athlete{
    private String name;
    private int stamina;
    private boolean injury;
    private int offence;
    private int defence;
    private String role;
    private int storeValue;
    private int sellbackPrice;
    private int amount;
    private int injury_time = 0;

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
        this.sellbackPrice = (int) (storeValue *0.8);
        this.amount = 1;
    }
    
    public Athlete(String string, String string2, int i, int j, int k, int l) {
    }

    public String getName() {
        return name;
    }

    public int getStamina() {
        return stamina;
    }

    public boolean getInjury() {
        if (this.stamina <= 20){
            this.injury = true;
        }
        return injury;
    }

    public void changeInjury() {
        this.injury =  !this.injury;
    }

    public int getOffence() {
        return offence;
    }
    public void setStamina(int i) {
            this.stamina = i;
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
    public int esimatepower(){
        return (int) (this.stamina  + this.offence *2 + this.defence * 2);
    }
    
    public int getStoreValue() {
        
        
        return this.storeValue;
    }

   
    public void setStoreValue(int storeValue) {
        this.storeValue = storeValue;
    }
    
    public void setStoreValue() {
        this.storeValue = (int) (this.stamina * 2 + this.offence * 5 + this.defence * 5);
    }
    
    
    public int getSellbackPrice() {
        return this.sellbackPrice;
    }

    
    public void setSellbackPrice(int sellbackPrice) {
        this.sellbackPrice = sellbackPrice;
    }
    public void setSellbackPrice() {
        this.sellbackPrice = (int) (this.storeValue * 0.8);
    }
    public int getAmount() {
        return this.amount;    }

    
    public void setAmount(int amount) {
        this.amount = amount;    }

    
    public void increaseAmount(int amount) {
        this.amount += amount ;
    }

    
    public void decreaseAmount(int amount) {
        this.amount -= amount;
        if (this.amount < 0){
            this.amount = 0;
        }
    }

    public static Athlete generateAthlete(int turn, String role) {
        int stamina = 100;
        int offence = calculateOffence(role, turn);
        int defence = calculateDefence(role, turn);
        String name = generateName();
        int value = generateValue(offence, defence);
        int sellBackValue = generateSellBackValue(value);
        
        return new Athlete(name, stamina, offence, defence, role, value, sellBackValue,1);
    }
    
    private static int generateSellBackValue(int value) {
        return (int) (value * 0.8);
    }

    private static int generateValue(int offence, int defence) {
        return (int) (offence * 2 + defence * 2);
    }

    private static int calculateOffence(String role, int turn) {
        int offence = 50;
        if (role.equals("Forward")) {
            offence = 30+ (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Midfielder")) {
            offence = 20+ (int)(Math.random()*25) + (turn * 2);
        } else if (role.equals("Defender")) {
            offence = (int)(Math.random()*40) + (turn * 2);
        } else if (role.equals("Goalkeeper")) {
            offence = 20 + (turn * 2);
        }
        return offence;
    }

    private static int calculateDefence(String role, int turn) {
        int defence = 50;
        if (role.equals("Forward")) {
            defence = (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Midfielder")) {
            defence = 25 + (int)(Math.random()*25) + (turn * 2);
        } else if (role.equals("Defender")) {
            defence = 30+ (int)(Math.random()*30) + (turn * 2);
        } else if (role.equals("Goalkeeper")) {
            defence = 60 + (turn * 2);
        }
        return defence;
    }
    private boolean injury_check(){
        if (this.stamina <= 0){
            this.injury = true;
            injury_time = 2;
        }
        return this.injury;
    }
    private boolean heal_check(){
        if (this.injury_time == 0){
            this.injury = false;
        }
        return this.injury;
        
    }
    
    public boolean personal_duel( Athlete j,int round){
        double attackerluck = Math.random()*15;
        double temp_attack = this.getOffence() *round*attackerluck;
        double temp_def = j.getDefence() *j.getStamina()/100;
        double temp = temp_attack - temp_def;
        double chance_success = (temp)/100 +33;
        if (chance_success > 100){
            chance_success = 100;
        }
        System.out.println(chance_success);
        if (Math.random()*100 > chance_success){
            this.increaseStamina(-3);
            j.increaseStamina(-7);
            injury_check(this);
            injury_check(j);
            return false;
        }
        else{
            this.increaseStamina(-4);
            j.increaseStamina(-10);
            injury_check(this);
            injury_check(j);
        return true;

        }
    }
    private static String generateName() {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Chris", "David", "Emily", "Frank", "Grace", "Henry"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Jones", "Davis", "Wilson", "Moore", "Taylor", "Anderson", "Thomas"};
        String firstName = firstNames[(int) (Math.random() * firstNames.length)];
        String lastName = lastNames[(int) (Math.random() * lastNames.length)];
        return firstName + " " + lastName;
    }
    

    
}
