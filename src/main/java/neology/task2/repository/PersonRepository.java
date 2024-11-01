package neology.task2.repository;

import neology.task2.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonRepository {

    // Метод для поиска по городу
    List<Person> findByCityOfLiving(String city);

    // Метод для поиска по возрасту, отсортированный по возрастанию
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Метод для поиска по имени и фамилии, возвращающий Optional
    Optional<Person> findByNameAndSurname(String name, String surname);
}