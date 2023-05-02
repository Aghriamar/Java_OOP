package seminar5.models;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс представляет столик в ресторане.
 */
public class Table {
    /**
     * Счетчик столиков, используется для генерации уникального номера столика.
     */
    private  static int counter;
    /**
     * Уникальный номер столика.
     */
    private final int no;

    /**
     * Коллекция бронирований для данного столика.
     */
    private final Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Возвращает коллекцию бронирований для данного столика.
     * @return коллекцию бронирований
     */
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Возвращает уникальный номер столика.
     * @return уникальный номер столика
     */
    public int getNo() {
        return no;
    }

    /**
     * Инициализирует объект, устанавливая уникальный номер столика.
     */
    {
        no = ++counter;
    }

    /**
     * Возвращает строковое представление объекта в виде "Столик #номер_столика".
     * @return строковое представление объекта
     */
    @Override
    public String toString() {
        return String.format("Столик #%d", no);
    }
}
