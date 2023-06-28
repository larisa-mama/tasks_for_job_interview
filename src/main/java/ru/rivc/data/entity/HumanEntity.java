package ru.rivc.data.entity;

import org.springframework.context.annotation.Primary;
import ru.rivc.pojo.Nationality;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Human")
public class HumanEntity {
    @Id
    @GeneratedValue()
    private int id;
    @Column
    private String name;
    private LocalDate birthday;
    private Nationality nationality;

    public HumanEntity(int id, String name, LocalDate birthday, Nationality nationality) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public HumanEntity() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Nationality getNationality() {
        return nationality;
    }
//TODO

}
