package neology.task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam String city) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList().stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/by-age")
    public List<String> getPersonsByAgeLessThan(@RequestParam int age) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC", Person.class);
        query.setParameter("age", age);
        return query.getResultList().stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<String> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname", Person.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList().stream()
                .map(Person::getName)
                .findFirst();
    }
}