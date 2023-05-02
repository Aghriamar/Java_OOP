package seminar5.views;
import seminar5.models.Table;
import seminar5.presenters.View;
import seminar5.presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

/**
 * Класс, отвечающий за отображение бронирования столиков
 */
public class BookingView implements View {
    private ViewObserver observer; // наблюдатель

    /**
     * Установить наблюдателя, отслеживающего действия пользователя
     * @param observer наблюдатель
     */
    public void setObserver(ViewObserver observer){
        this.observer = observer;
    }

    /**
     * Отобразить список всех столиков
     * @param tables столики
     */
    public void showTables(Collection<Table> tables){
        for (Table table: tables) {
            System.out.println(table);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование
     * столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    public void reservationTable(Date reservationDate, int tableNo, String name){
        observer.onReservationTable(reservationDate, tableNo, name);
    }

    /**
     * TODO: Доработать метод в рамках домашней работы
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирования столика
     * @param oldReservation старый номер бронирования
     * @param reservationDate новая дата бронирования
     * @param tableNo номер столика
     * @param name имя клиета
     */
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name);
    }

    /**
     * Отобразить результат бронирования столика
     * @param reservationId номер брони
     * @param isReserved статус бронирования
     */
    public void showReservationTableStatus(int reservationId, boolean isReserved){
        if (reservationId > 0){
            if(!isReserved) {
                System.out.printf("Столик успешно забронирован.\nНомер брони: #%d\n", reservationId);
            }
            else {
                System.out.printf("Столик успешно перезабронирован.\nНомер брони: #%d\n", reservationId);
            }
        }
        else {
            System.out.println("Ошибка бронирования столика.\nПовторите попытку позже.");
        }
    }
}