package seminar1;

public class Chocolate extends Product {
    private int calories;

    /**
     *
     * @param name Название товара
     * @param brand Бренд товара
     * @param price Цена товара
     * @param calories Калории товара
     */
    public Chocolate(String name, String brand, double price, int calories) {
        super(name, brand, price);
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    /**
     *
     * @param calories Калории
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String displayInfo() {
        return String.format("%s - %s - %f - калории: %d", name, brand, price, calories);
    }
}
