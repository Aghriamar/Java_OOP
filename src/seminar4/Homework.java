package seminar4;

import java.util.ArrayList;

/**
 Домашняя работа, задача:
 ========================

 a. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
 b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
 поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 c. Для хранения фруктов внутри коробки можно использовать ArrayList;
 d. Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую
 подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 Можно сравнивать коробки с яблоками и апельсинами;
 f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
 Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
 Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
 g. Не забываем про метод добавления фрукта в коробку.
 */

public class Homework {
    public static void main(String[] args) {
        Box<Apple> apples = new Box<>();
        Box<Orange> orange = new Box<>();
        Box<Apple> anotherBoxWithApples = new Box<>();
        Box<Orange> anotherBoxWithOrange = new Box<>();
        Box<Apple> anotherBox = new Box<>();

        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        apples.addFruit(new Apple());
        orange.addFruit(new Orange());
        orange.addFruit(new Orange());

        System.out.println("Box with apples weight: " + apples.getWeight());
        System.out.println("Box with oranges weight: " + orange.getWeight());
        System.out.println("Is boxes weight equal: " + apples.compare(orange));
        orange.addFruit(new Orange());
        System.out.println("Box with oranges weight: " + orange.getWeight());
        System.out.println("Is boxes weight equal: " + apples.compare(orange));
        apples.pourTo(anotherBoxWithApples);
        System.out.println("Box with apples weight after pouring: " + apples.getWeight());
        System.out.println("Another box with apples weight after pouring: " + anotherBoxWithApples.getWeight());
        orange.pourTo(anotherBoxWithOrange);
        System.out.println("Box with orange weight after pouring: " + orange.getWeight());
        System.out.println("Another box with orange weight after pouring: " + anotherBoxWithOrange.getWeight());
        anotherBoxWithOrange.pourTo(orange);
        System.out.println("Box with orange weight after pouring: " + orange.getWeight());
        System.out.println("Another box with orange weight after pouring: " + anotherBoxWithOrange.getWeight());

        /** Компилятор не позволяет так сделать, что соблюдено по задаче
        ↓                                                                **/
        //anotherBoxWithOrange.pourTo(anotherBox);

    }
}

/**
 * Абстрактный класс фруктов
 */
abstract class Fruit{
    /**
     * Вес фрукта.
     */
    private final float weight;

    /**
     * Получает вес фрукта
     * @return вес фрукта в единицах измерения, определенных классом.
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Конструктор класса фрукт
     * @param weight Вес фрукта
     */
    public Fruit(float weight) {
        this.weight = weight;
    }

}

/**
 * Класс яблока
 */
class Apple extends Fruit {
    /**
     * Создает яблоко
     */
    public Apple() {
        super(1.0f);
    }
}

/**
 * Класс апельсина
 */
class Orange extends Fruit {
    /**
     * Создает апельсин
     */
    public Orange() {
        super(1.5f);
    }
}

/**
 * Класс, представляющий ящик для хранения фруктов. В ящик можно положить только фрукты
 * одного типа, задаваемого параметром типа T.
 * @param <T> тип фруктов, которые могут храниться в ящике
 */
class Box<T extends Fruit>{
    /**
     * Список фруктов
     */
    private ArrayList<T> fruits;

    /**
     * Создает пустую коробку для фруктов
     */
    public Box() {
        fruits = new ArrayList<>();
    }

    /**
     * Возвращает вес коробки с фруктами.
     * @return Вес коробки с фруктами.
     */
    public float getWeight() {
        float totalWeight = 0.0f;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    /**
     * Сравнивает текущую коробку с другой коробкой по весу.
     * @param anotherBox коробка, с которой нужно сравнить текущую коробку
     * @return true, если веса коробок равны, false - в противном случае
     */
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    /**
     * Пересыпает фрукты из текущего ящика в другой.
     * @param anotherBox ящик, в который пересыпает фрукты
     */
    public void pourTo(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        for (T fruit : fruits) {
            anotherBox.addFruit(fruit);
        }
        fruits.clear();
    }

    /**
     * Добавляет фрукт в ящик
     * @param fruit тип фрукта, который нужно добавить
     */
    public void addFruit(T fruit) {
        fruits.add(fruit);
    }
}
