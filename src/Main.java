import seminar2.Cat;
import seminar2.Plate;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Barsik", 5);
        cats[1] = new Cat("Murzik", 7);
        cats[2] = new Cat("Vasya", 10);

        Plate plate = new Plate(20);

        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println(cat.getName() + " is satiety: " + cat.isSatiety());
        }

        plate.addFood(10);
        plate.info();
    }
}