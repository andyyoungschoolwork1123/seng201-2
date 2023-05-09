public class AtheleteTestTwo {

    public static void main(String[] args) {

        // Create a new athlete
        Athlete athlete = new Athlete("John", 100, 60, 50, "Forward", 1000, 800, 1);

        // Call all the methods in the Athlete class
        System.out.println("Name: " + athlete.getName());
        System.out.println("Stamina: " + athlete.getStamina());
        System.out.println("Injury: " + athlete.getInjury());
        athlete.changeInjury();
        System.out.println("Injury: " + athlete.getInjury());
        System.out.println("Offence: " + athlete.getOffence());
        System.out.println("Defence: " + athlete.getDefence());
        System.out.println("Role: " + athlete.getRole());
        athlete.increaseStamina(20);
        System.out.println("Stamina after increase: " + athlete.getStamina());
        athlete.increaseDefense(10);
        System.out.println("Defence after increase: " + athlete.getDefence());
        athlete.increaseOffense(5);
        System.out.println("Offence after increase: " + athlete.getOffence());
        System.out.println("Store value: " + athlete.getStoreValue());
        athlete.setStoreValue(1500);
        System.out.println("Store value after set: " + athlete.getStoreValue());
        athlete.setStoreValue();
        System.out.println("Store value after calculate: " + athlete.getStoreValue());
        System.out.println("Sellback price: " + athlete.getSellbackPrice());
        athlete.setSellbackPrice(1200);
        System.out.println("Sellback price after set: " + athlete.getSellbackPrice());
        athlete.setSellbackPrice();
        System.out.println("Sellback price after calculate: " + athlete.getSellbackPrice());
        System.out.println("Amount: " + athlete.getAmount());
        athlete.setAmount(2);
        System.out.println("Amount after set: " + athlete.getAmount());
        athlete.increaseAmount(3);
        System.out.println("Amount after increase: " + athlete.getAmount());
        athlete.decreaseAmount(4);
        System.out.println("Amount after decrease: " + athlete.getAmount());

        // Generate a new athlete
        Athlete newAthlete = Athlete.generateAthlete(2, "Midfielder");
        System.out.println("New athlete: " + newAthlete.getName() + " " + newAthlete.getRole());

    }
}
