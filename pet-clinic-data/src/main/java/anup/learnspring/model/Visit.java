package anup.learnspring.model;

import java.time.LocalDate;

public class Visit extends BaseEntity{

    private LocalDate localDate;
    private String description;
    private Pet pet;

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
