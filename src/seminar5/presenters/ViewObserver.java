package seminar5.presenters;
import java.util.Date;

/**
 * Интерфейс ViewObserver представляет собой наблюдателя, который отслеживает действия
 * пользователя в пользовательском интерфейсе для бронирования столиков в ресторане.
 */
public interface ViewObserver {
    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    void onReservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Обработчик события изменения бронирования столика
     * @param oldReservation идентификатор старого бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}