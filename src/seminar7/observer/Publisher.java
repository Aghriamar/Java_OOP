package seminar7.observer;

public interface Publisher {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void sendOffer(String nameCompany, Vacancy vacancy, double salary);

}
