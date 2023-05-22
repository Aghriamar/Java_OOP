package seminar6.srp2;

import java.util.Scanner;

/**
 * Класс обработчик ввода
 */
public class InputHandler {

    /**
     * Ожидает ввода строки с клавиатуры и преобразует ее в соответствующие типы данных.
     * @return возвращает объект класса Order
     */
    public Order inputFromConsole() {
        String clientName = prompt("Client name: ");
        String product = prompt("Product: ");
        int qnt = Integer.parseInt(prompt("Quantity: "));
        int price = Integer.parseInt(prompt("Price: "));
        return new Order(clientName, product, qnt, price);
    }

    /**
     * Выводит сообщение на консоль и считывает введенную пользователем строку.
     * @param message пользовательское сообщение
     * @return возвращает введенную пользователем строку.
     */
    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
