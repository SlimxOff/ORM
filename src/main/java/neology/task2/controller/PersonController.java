package neology.task2.controller;

import neology.task2.domain.Person;
import neology.task2.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    private final PersonRepository personRepository;

    // Единственный конструктор для внедрения зависимости
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/persons/by-city")
    public List<String> getPersonsByCity(@RequestParam String city) {
        return personRepository.findByCityOfLiving(city).stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/by-age")
    public List<String> getPersonsByAgeLessThan(@RequestParam int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age).stream()
                .map(Person::getName)
                .collect(Collectors.toList());
    }

    @GetMapping("/persons/by-name-surname")
    public Optional<String> getPersonByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personRepository.findByNameAndSurname(name, surname).map(Person::getName);
    }
}