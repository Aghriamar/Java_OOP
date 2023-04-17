package seminar1;

public class BottleOfWater extends Product {

    private int volume; // объем

    public int getVolume() {
        return volume;
    }

    /**
     *
     * @param name Название товара
     * @param price Цена товара
     * @param volume Мерность товара
     */
    public BottleOfWater(String name, double price, int volume) {
        super(name, price);
        this.volume = volume;
    }

    public BottleOfWater(String name, String brand, double price, int volume) {
        super(name, brand, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        //return super.displayInfo();
        return String.format("%s - %s - %f - объем: %d", name, brand, price, volume);
    }
}
