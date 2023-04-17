package seminar1;

import java.util.ArrayList;
import java.util.List;

/*
 * Создать новый продукт на основе Product, сделать ему хотя одно свойства (например, шоколад и каллории)
 * и включить в список продуктов в вендинг машину.
 * Продемонстрировать работу класса по продаже товаров (как мы это делали на уроке).
 */

public class Main {
    public static void main(String[] args) {
//         Product product1 = new Product();

//        System.out.println(product1.displayInfo());
//
//        Product product2 = new Product("Бутылка с молоком", 120.25);
//        product2.param2 = "..";
//        System.out.println(product2.displayInfo());
//
//        System.out.println(product2.displayInfo());
//
//        Product product3 = new Product("ss", "__", 100);
//        System.out.println(product3.displayInfo());
//        product3.setPrice(10);

        Product bottleOfWater1 = new BottleOfWater("Минералка","Bonaqua", 100, 2);
        Product bottleOfMilk1 = new BottleOfMilk("Молоко", 200, 1, 10);
        Product bottleOfWater2 = new BottleOfWater("Минералка", 100, 1);
        Product bottleOfWater3 = new BottleOfWater("Святой источник", 100, 3);
        Product bottleOfWater4 = new BottleOfWater("Бутылка3", 100, 2);
        Product chocolate1 = new Chocolate("Alpen Gold", "Nestle", 50, 200);
        Product chocolate2 = new Chocolate("Extra Nut", "Ritter Sport", 50, 300);

        List<Product> products = new ArrayList<>();
        products.add(chocolate1);
        products.add(bottleOfWater1);
        products.add(bottleOfWater3);
        products.add(chocolate2);
        products.add(bottleOfMilk1);
        products.add(bottleOfWater2);
        products.add(bottleOfWater4);

          VendingMachine vendingMachine = new VendingMachine(products);
//        BottleOfWater bottleOfWaterRes = vendingMachine.getBottleOfWater("Bonaqua", 1);
//        Chocolate chocolate = vendingMachine.getChocolate("Alpen Gold");
//        if (bottleOfWaterRes != null) {
//            System.out.println("Вы купили: ");
//            System.out.println(bottleOfWaterRes.displayInfo());
//        }
//        else if (chocolate != null) {
//            System.out.println("Вы купили шоколад Alpen Gold");
//            System.out.println(chocolate.displayInfo());
//        } else {
//            System.out.println("Такого товара нет в автомате.");
//        }

        //vendingMachine.sellProduct("Bonaqua", 1);
        vendingMachine.sellProduct("Alpen Gold", 200);
        vendingMachine.sellProduct("Святой источник", 3);
        vendingMachine.sellProduct("Extra Nut", 250);
        vendingMachine.sellProduct("Минералка", "Bonaqua", 2);
        vendingMachine.sellProduct("Extra Nut", "Ritter Sport", 300);
    }
}