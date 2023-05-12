public class AthleteFinalTest {

    public static void main(String[] args) {
        Athlete athlete1 = new Athlete("John", 100, 80, 70, "Forward", 100, 80, 1);
        
        // test the getter methods
        System.out.println("Name: " + athlete1.getName());
        System.out.println("Stamina: " + athlete1.getStamina());
        System.out.println("Offence: " + athlete1.getOffence());
        System.out.println("Defence: " + athlete1.getDefence());
        System.out.println("Role: " + athlete1.getRole());
        System.out.println("Store Value: " + athlete1.getStoreValue());
        System.out.println("Sellback Price: " + athlete1.getSellbackPrice());
        System.out.println("Amount: " + athlete1.getAmount());
        
        // test the setter methods
        athlete1.setStamina(90);
        System.out.println("New Stamina: " + athlete1.getStamina());
        athlete1.setStoreValue();
        System.out.println("New Store Value: " + athlete1.getStoreValue());
        athlete1.setSellbackPrice();
        System.out.println("New Sellback Price: " + athlete1.getSellbackPrice());
        athlete1.setAmount(2);
        System.out.println("New Amount: " + athlete1.getAmount());
        
        // test the increase and decrease amount methods
        athlete1.increaseAmount(1);
        System.out.println("Increased Amount: " + athlete1.getAmount());
        athlete1.decreaseAmount(2);
        System.out.println("Decreased Amount: " + athlete1.getAmount());
        
        // test the increase stamina, defence and offence methods
        athlete1.increaseStamina(10);
        System.out.println("Increased Stamina: " + athlete1.getStamina());
        athlete1.increaseDefense(5);
        System.out.println("Increased Defence: " + athlete1.getDefence());
        athlete1.increaseOffense(10);
        System.out.println("Increased Offence: " + athlete1.getOffence());
        
        // test the generateAthlete method
        Athlete athlete2 = Athlete.generateAthlete(2, "Midfielder");
        System.out.println("Generated Athlete Name: " + athlete2.getName());
        System.out.println("Generated Athlete Stamina: " + athlete2.getStamina());
        System.out.println("Generated Athlete Offence: " + athlete2.getOffence());
        System.out.println("Generated Athlete Defence: " + athlete2.getDefence());
        System.out.println("Generated Athlete Role: " + athlete2.getRole());
        System.out.println("Generated Athlete Store Value: " + athlete2.getStoreValue());
        System.out.println("Generated Athlete Sellback Price: " + athlete2.getSellbackPrice());
        System.out.println("Generated Athlete Amount: " + athlete2.getAmount());
    }

}

