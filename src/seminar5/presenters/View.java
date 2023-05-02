package seminar5.presenters;
import seminar5.models.Table;

import java.util.Collection;

/**
 * Интерфейс ViewObserver - наблюдатель за действиями пользователя
 */
public interface View {

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    void showTables(Collection<Table> tables);

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     * @param isReserved статус бронирования
     */
    void showReservationTableStatus(int reservationId, boolean isReserved);

    //void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}