public class AthleteTest {

    public static void main(String[] args) {
        Athlete athlete = new Athlete("John Doe", 100, 70, 60, "Forward", 200, 100, 1);
        
        // Test getter methods
        System.out.println(athlete.getName()); // "John Doe"
        System.out.println(athlete.getStamina()); // 100
        System.out.println(athlete.getInjury()); // false
        System.out.println(athlete.getOffence()); // 70
        System.out.println(athlete.getDefence()); // 60
        System.out.println(athlete.getRole()); // "Forward"
        System.out.println(athlete.getStoreValue()); // 530
        System.out.println(athlete.getSellbackPrice()); // 265
        System.out.println(athlete.getAmount()); // 1
        
        // Test setter methods
        athlete.setStoreValue(300);
        System.out.println(athlete.getStoreValue()); // 300
        
        athlete.setSellbackPrice(150);
        System.out.println(athlete.getSellbackPrice()); // 150
        
        athlete.increaseAmount(2);
        System.out.println(athlete.getAmount()); // 3
        
        athlete.decreaseAmount(1);
        System.out.println(athlete.getAmount()); // 2
        
        athlete.increaseStamina(10);
        System.out.println(athlete.getStamina()); // 110
        
        athlete.increaseDefense(5);
        System.out.println(athlete.getDefence()); // 65
        
        athlete.increaseOffense(8);
        System.out.println(athlete.getOffence()); // 78
        
        athlete.setStoreValue();
        System.out.println(athlete.getStoreValue()); // 590
        
        
    }

}
