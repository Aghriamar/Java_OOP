package seminar7.observer;

import java.util.ArrayList;
import java.util.List;

public class Vacancy {
    private String name;
    private JobType type;
    private String description;

    public Vacancy(String name, JobType type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public JobType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
