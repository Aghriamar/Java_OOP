package seminar1;

public class BottleOfMilk extends Product {

    private int volume;
    private int fat;

    public int getVolume() {
        return volume;
    }

    public int getFat() {
        return fat;
    }

    /**
     * @param name   Название товара
     * @param price  Цена товара
     * @param volume Мерность товара
     * @param fat    Жирность
     */
    public BottleOfMilk(String name, double price, int volume, int fat) {
        super(name, price);
        this.volume = volume;
        this.fat = fat;
    }

    @Override
    public String displayInfo() {
        //return super.displayInfo();
        return String.format("%s - %s - %f - объем: %d - жирность: %d", name, brand, price, volume, fat);

    }

}
