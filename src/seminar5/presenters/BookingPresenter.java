package seminar5.presenters;
import seminar5.models.Table;

import java.util.Collection;
import java.util.Date;

/**
 * Класс BookingPresenter - презентер для работы с бронированием столиков
 */
public class BookingPresenter implements ViewObserver {
    /**
     * Коллекция столиков
     */
    private Collection<Table> tables;

    /**
     * Интерфейс модели
     */
    private final Model model;

    /**
     * Интерфейс представления
     */
    private final View view;

    /**
     * Конструктор класса BookingPresenter
     * @param model Интерфейс модель
     * @param view Интерфейс представление
     */
    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        this.view.setObserver(this);
    }

    /**
     * Получение списка всех столиков
     */
    public void loadTables(){
        tables = model.loadTables();
    }

    /**
     * Отобразить список всех столиков
     */
    public void updateView(){
        view.showTables(tables);
    }

    /**
     * Обновление статуса бронирования столика
     * @param reservationId идентификатор бронирования
     * @param isReserved статус бронирования
     */
    public void updateReservationTableStatus(int reservationId, boolean isReserved){
        view.showReservationTableStatus(reservationId, isReserved);
    }

    /**
     * Обработчик события бронирования столика
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        int reservationId = model.reservationTable(reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId, false);
    }

    /**
     * Обработчик события изменения бронирования столика
     * @param oldReservation идентификатор старого бронирования
     * @param reservationDate дата бронирования
     * @param tableNo номер столика
     * @param name имя клиента
     */
    @Override
    public void onChangeReservationTable(int oldReservation,Date reservationDate, int tableNo, String name) {
        int reservationId = model.changeReservationTable(oldReservation, reservationDate, tableNo, name);
        updateReservationTableStatus(reservationId, reservationId != -1);
    }
}