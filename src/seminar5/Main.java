package seminar5;
import seminar5.models.TableModel;
import seminar5.presenters.BookingPresenter;
import seminar5.views.BookingView;

import java.util.Date;
public class Main {
    /**
     * TODO: ДОМАШНЯЯ РАБОТА
     * Метод changeReservationTable должен ЗАРАБОТАТЬ!
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        TableModel model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter bookingPresenter = new BookingPresenter(model, view);

        bookingPresenter.loadTables();
        bookingPresenter.updateView();

        view.reservationTable(new Date(), 2, "Станислав");

        view.changeReservationTable(1001, new Date(), 3, "Станислав");
    }
}
