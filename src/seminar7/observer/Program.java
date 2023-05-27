package seminar7.observer;

import java.util.Arrays;
import java.util.List;

public class Program {

    /**
     * TODO: 1.Доработать приложение, поработать с шаблоном проектирования Observer
     *   добавить новый тип соискателя.
     *   **.2 Добавить новую сущность "Вакансия", компания должна рассылать вакансии.
     *   **.3 Предусмотреть тип вакансии (enum)
     * @param args
     */
    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();
        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 120000, jobAgency);

        Vacancy geekBrainsVacancy = new Vacancy("Программист C#", JobType.IT, "Описание вакансии");
        Vacancy geekBrainsVacancy2 = new Vacancy("Программист Java", JobType.IT, "Описание вакансии");
        Vacancy googleVacancy = new Vacancy("Разнорабочий", JobType.HANDYMAN, "Описание вакансии");
        Vacancy yandexVacancy = new Vacancy("Специалист по продажам", JobType.SALES, "Описание вакансии");

        Master ivanov = new Master("Ivanov", jobAgency);
        Master petrov = new Master("Petrov", jobAgency);
        Student sidorov = new Student("Sidorov", jobAgency);
        Programmer anna = new Programmer("Анна", jobAgency);

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(sidorov);
        jobAgency.registerObserver(anna);

        for(int i = 0; i < 10; i++){
            geekBrains.needEmployee(geekBrainsVacancy);
            geekBrains.needEmployee(geekBrainsVacancy2);
            google.needEmployee(googleVacancy);
            yandex.needEmployee(yandexVacancy);
        }

    }

}
