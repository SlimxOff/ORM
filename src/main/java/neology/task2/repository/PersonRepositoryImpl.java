package neology.task2.repository;

import neology.task2.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> findByCityOfLiving(String city) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public List<Person> findByAgeLessThanOrderByAgeAsc(int age) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.age < :age ORDER BY p.age ASC", Person.class);
        query.setParameter("age", age);
        return query.getResultList();
    }

    @Override
    public Optional<Person> findByNameAndSurname(String name, String surname) {
        TypedQuery<Person> query = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.name = :name AND p.surname = :surname", Person.class);
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList().stream().findFirst();
    }
}