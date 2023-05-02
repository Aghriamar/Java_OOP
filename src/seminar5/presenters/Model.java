package seminar5.presenters;
import seminar5.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс Model - модель для работы с бронированием столиков
 */
public interface Model {
    /**
     * Загрузка списка всех столиков
     * @return коллекция столиков
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return идентификатор бронирования
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение бронирования столика
     * @param oldReservation идентификатор старого бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return идентификатор нового бронирования или -1, если изменить не удалось
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}