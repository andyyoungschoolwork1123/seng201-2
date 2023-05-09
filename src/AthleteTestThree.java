public class AthleteTestThree {
    public static void main(String[] args) {
        // Create an athlete object with constructor 1
        Athlete athlete1 = new Athlete("John", 80, 70, 60, "Forward", 200, 160, 2);

        // Test all methods in Athlete class
        System.out.println("Name: " + athlete1.getName());
        System.out.println("Stamina: " + athlete1.getStamina());
        System.out.println("Injury: " + athlete1.getInjury());
        System.out.println("Offence: " + athlete1.getOffence());
        System.out.println("Defence: " + athlete1.getDefence());
        System.out.println("Role: " + athlete1.getRole());
        System.out.println("Store Value: " + athlete1.getStoreValue());
        System.out.println("Sellback Price: " + athlete1.getSellbackPrice());
        System.out.println("Amount: " + athlete1.getAmount());
        athlete1.increaseStamina(10);
        System.out.println("New Stamina: " + athlete1.getStamina());
        athlete1.increaseDefense(5);
        System.out.println("New Defence: " + athlete1.getDefence());
        athlete1.increaseOffense(5);
        System.out.println("New Offence: " + athlete1.getOffence());
        System.out.println("Estimated Power: " + athlete1.esimatepower());
        athlete1.setStoreValue(250);
        System.out.println("New Store Value: " + athlete1.getStoreValue());
        athlete1.setSellbackPrice(200);
        System.out.println("New Sellback Price: " + athlete1.getSellbackPrice());
        athlete1.increaseAmount(1);
        System.out.println("New Amount: " + athlete1.getAmount());
        athlete1.decreaseAmount(2);
        System.out.println("New Amount: " + athlete1.getAmount());

        // Create an athlete object with constructor 2
        Athlete athlete2 = new Athlete("Mike", 70, 50, 40, "Midfielder");

        // Test all methods in Athlete class
        System.out.println("Name: " + athlete2.getName());
        System.out.println("Stamina: " + athlete2.getStamina());
        System.out.println("Injury: " + athlete2.getInjury());
        System.out.println("Offence: " + athlete2.getOffence());
        System.out.println("Defence: " + athlete2.getDefence());
        System.out.println("Role: " + athlete2.getRole());
        System.out.println("Store Value: " + athlete2.getStoreValue());
        System.out.println("Sellback Price: " + athlete2.getSellbackPrice());
        System.out.println("Amount: " + athlete2.getAmount());
        athlete2.increaseStamina(10);
        System.out.println("New Stamina: " + athlete2.getStamina());
        athlete2.increaseDefense(5);
        System.out.println("New Defence: " + athlete2.getDefence());
        athlete2.increaseOffense(5);
        System.out.println("New Offence: " + athlete2.getOffence());
        System.out.println("Estimated Power: " + athlete2.esimatepower());
        athlete2.setStoreValue();
        System.out.println("New Store Value: " + athlete2.getStoreValue());
        athlete2.setSellbackPrice();
        System.out.println("New Sellback Price: " + athlete2.getSellbackPrice());
    }
}

