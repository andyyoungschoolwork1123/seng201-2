public class EffectItemTest {
    public static void main(String[] args) {
        // create an instance of the Athlete class
        Athlete athlete = new Athlete("John", 100, 50, 50, "Forward", 500, 400, 1);

        // create an instance of the EffectItem class
        EffectItem item = new EffectItem("Super Drink", "Consumable", 10, 5, 2);

        // test the getter methods in the EffectItem class
        System.out.println("Effect item name: " + item.getName());
        System.out.println("Effect item type: " + item.getType());
        System.out.println("Effect item stamina boost: " + item.getStaminaBoost());
        System.out.println("Effect item offense boost: " + item.getOffenseBoost());
        System.out.println("Effect item defense boost: " + item.getDefenseBoost());

        // apply the effect item to the athlete
        item.applyToAthlete(athlete);

        // test the applyToAthlete method in the EffectItem class
        System.out.println("Athlete's stamina after using the effect item: " + athlete.getStamina());
        System.out.println("Athlete's offense after using the effect item: " + athlete.getOffence());
        System.out.println("Athlete's defense after using the effect item: " + athlete.getDefence());
    }
}



