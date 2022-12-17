package com.sparta.hhblog.service;

import com.sparta.hhblog.models.Person;
import com.sparta.hhblog.models.PersonRepository;
import com.sparta.hhblog.models.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final Person person;

    @Transactional
    public Long update(Long id, PersonRequestDto personRequestDto) {

        Person person = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        person.update(personRequestDto);
    }
}

}
