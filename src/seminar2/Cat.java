package seminar2;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }
}

