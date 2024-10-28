package neology.task2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "PERSONS")
public class Person {

    @Id
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String cityOfLiving;

    // Конструкторы, геттеры и сеттеры

    public Person() {
    }

    public Person(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    // Геттеры и сеттеры

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(phoneNumber, person.phoneNumber) &&
                Objects.equals(cityOfLiving, person.cityOfLiving);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, phoneNumber, cityOfLiving);
    }
}