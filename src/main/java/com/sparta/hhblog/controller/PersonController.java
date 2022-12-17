package com.sparta.hhblog.controller;

import com.sparta.hhblog.models.Person;
import com.sparta.hhblog.models.PersonRepository;
import com.sparta.hhblog.models.PersonRequestDto;
import com.sparta.hhblog.service.PersonService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RestController
@RequiredArgsConstructor
public class PersonController {

    public final PersonRepository personRepository;
    public final PersonService personService;

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto personRequestDto){
        Person person = new Person();
        return personRepository.save(person);
    }

    @GetMapping("/api/persons")
    public List<Person> readPerson(){
        return personRepository.findAll();
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto){
        return personService.update(id, personRequestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }
}
