package seminar7.observer;

import java.util.List;

public class Student implements Observer {

    private String name;
    private double salary;
    private Publisher jobAgency;

    public Student(String name, Publisher jobAgency) {
        this.name = name;
        salary = 5000;
        this.jobAgency = jobAgency;
    }

    @Override
    public void receiveOffer(String nameCompany, Vacancy vacancy, double salary) {
        JobType specialization = JobType.HANDYMAN;
        if (vacancy.getType() == specialization) {
            if (this.salary < salary) {
                System.out.printf("Студент %s >>> Мне нужна эта работа! [%s - %s - %f]\n",
                        name, vacancy.getName(), nameCompany, salary);
                this.salary = salary;
            } else {
                System.out.printf("Студент %s >>> Я найду работу получше! [%s - %s - %f]\n",
                        name, vacancy.getName(), nameCompany, salary);
            }
        }
    }
}

