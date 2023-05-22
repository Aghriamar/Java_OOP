package seminar6.srp2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

    /**
     * TODO: Доработать приложения, которые были продемонстрированы на уроке в рамках понимания работы принципов SOLID:
     */

    /**
     * Класс Order
     */
public class Order {
    private String clientName;
    private String product;
    private int qnt;
    private int price;

    /**
     * Конструктор класса Order
     * 
     * @param clientName имя клиента
     * @param product наименование товара
     * @param qnt количество товара
     * @param price цена товара
     */
    public Order(String clientName, String product, int qnt, int price) {
        this.clientName = clientName;
        this.product = product;
        this.qnt = qnt;
        this.price = price;
    }

    /**
     * Публичный метод для получения имени клиента
     * @return возвращает имя клиента
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Публичный метод для получения наименование товара
     * @return возвращает наименование товара
     */
    public String getProduct() {
        return product;
    }

    /**
     * Публичный метод для получения количество товара
     * @return возвращает количество товара
     */
    public int getQnt() {
        return qnt;
    }

    /**
     * Публичный метод для получения цену товара
     * @return возвращает цену товара
     */
    public double getPrice() {
        return price;
    }

}
