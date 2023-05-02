package seminar5.models;
import java.util.Date;

/**
 * Класс, представляющий бронирование.
 */
public class Reservation {

    /**
     * Счетчик для генерации уникальных идентификаторов бронирований.
     */
    private static int counter = 1000;

    /**
     * Дата бронирования.
     */
    private final Date date;

    /**
     * Имя клиента, который сделал бронирование.
     */
    private final String name;

    /**
     * Получает дату бронирования.
     * @return Дата бронирования.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Получает имя клиента, который сделал бронирование.
     * @return Имя клиента.
     */
    public String getName() {
        return name;
    }

    /**
     * Получает уникальный идентификатор бронирования.
     * @return Уникальный идентификатор бронирования.
     */
    public int getId() {
        return id;
    }

    /**
     * Уникальный идентификатор бронирования.
     */
    private final int id;
    {
        id = ++counter;
    }

    /**
     * Создает новое бронирование с заданной датой и именем клиента.
     * @param date Дата бронирования.
     * @param name Имя клиента, который сделал бронирование.
     */
    public Reservation(Date date, String name){
        this.date = date;
        this.name = name;
    }
}
