package neology.task2.domain;

import java.io.Serializable;
import java.util.Objects;

public class PersonID implements Serializable {
    private String name;
    private String surname;
    private int age;

    // Конструкторы, геттеры и сеттеры

    public PersonID() {
    }

    public PersonID(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    // Геттеры и сеттеры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonID personId = (PersonID) o;
        return age == personId.age &&
                Objects.equals(name, personId.name) &&
                Objects.equals(surname, personId.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }
}