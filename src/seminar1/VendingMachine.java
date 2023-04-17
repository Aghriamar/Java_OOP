package seminar1;

import java.util.List;

public class VendingMachine {

    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    /**
     * Продажа товара
     * @param name Имя товара
     * @param brand Бренд товара
     * @param productDetail Жирность, Объем или Калории
     * @return
     */
    public Product sellProduct(String name, String brand, int productDetail){
        for (Product product : products) {
            if (product.getName().equals(name) && product.getBrand().equals(brand)) {
                if (product instanceof BottleOfWater) {
                    BottleOfWater water = (BottleOfWater) product;
                    if (water.getVolume() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили бутылку " + name + " с брендом " + brand + " и с объемом " + productDetail);
                        return water;
                    }
                } else if (product instanceof BottleOfMilk) {
                    BottleOfMilk milk = (BottleOfMilk) product;
                    if (milk.getVolume() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили молоко " + name + " с брендом " + brand +  " и с жирностью " + productDetail);
                        return milk;
                    }
                } else if (product instanceof Chocolate) {
                    Chocolate chocolate = (Chocolate) product;
                    if (chocolate.getCalories() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили шоколад " + name + " с брендом " + brand +  " и с калорийностью " + productDetail);
                        return chocolate;
                    }
                }
            }
        }
        System.out.println("Товар не найден.");
        return null;
    }

    /**
     * Продажа товара
     * @param name Имя товара
     * @param productDetail Жирность, Объем или Калории
     * @return
     */
    public Product sellProduct(String name, int productDetail){
        for (Product product : products) {
            if (product.getName().equals(name)) {
                if (product instanceof BottleOfWater) {
                    BottleOfWater water = (BottleOfWater) product;
                    if (water.getVolume() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили бутылку " + name + " с объемом " + productDetail);
                        return water;
                    }
                } else if (product instanceof BottleOfMilk) {
                    BottleOfMilk milk = (BottleOfMilk) product;
                    if (milk.getVolume() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили молоко " + name + " с жирностью " + productDetail);
                        return milk;
                    }
                } else if (product instanceof Chocolate) {
                    Chocolate chocolate = (Chocolate) product;
                    if (chocolate.getCalories() == productDetail) {
                        products.remove(product);
                        System.out.println("Вы купили шоколад " + name + " с калорийностью " + productDetail);
                        return chocolate;
                    }
                }
            }
        }
        System.out.println("Товар не найден.");
        return null;
    }

    public BottleOfWater getBottleOfWater(String name, int volume) {
        for (Product product : products) {
            if (product instanceof BottleOfWater) {
                BottleOfWater bottle = ((BottleOfWater) product);
                if (bottle.name.equals(name) && bottle.getVolume() == volume)
                    return bottle;
            }
        }
        return null;
    }

    public Chocolate getChocolate(String name) {
        for (Product product : products) {
            if (product instanceof Chocolate) {
                Chocolate chocolate = (Chocolate) product;
                if (chocolate.getName().equals(name)) {
                    return chocolate;
                }
            }
        }
        return null;
    }
}
