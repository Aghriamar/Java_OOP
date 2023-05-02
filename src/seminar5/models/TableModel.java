package seminar5.models;
import seminar5.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Класс TableModel реализует интерфейс Model и представляет модель данных для таблицы.
 */
public class TableModel implements Model {
    /**
     * Коллекция столиков
     */
    private Collection<Table> tables;

    /**
     * Получение списка всех столиков
     * @return столики
     */
    public Collection<Table> loadTables(){
        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     * @return номер брони
     */
    public int reservationTable(Date reservationDate, int tableNo, String name){
        for (Table table : tables){
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        return -1;
    }

    //TODO: Разработать самостоятельно в рамках домашней работы
    /**
     * Изменение бронирование столика.
     * @param oldReservation Номер старого бронирования
     * @param reservationDate Дата нового бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     * @return Номер нового бронирования, если старое бронирование найдено и изменено, иначе -1
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){
        for (Table table : tables){
            for (Reservation reservation : table.getReservations()){
                if (reservation.getId() == oldReservation){
                    table.getReservations().remove(reservation);
                    Reservation newReservation = new Reservation(reservationDate, name);
                    table.getReservations().add(newReservation);
                    return newReservation.getId();
                }
            }
        }
        return -1;
    }
}
