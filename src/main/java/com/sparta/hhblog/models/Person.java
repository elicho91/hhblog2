package com.sparta.hhblog.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor
public class Person {
    @Id
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String job;

    public Person (PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.address = personRequestDto.getAddress();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }

    public void update(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.address = personRequestDto.getAddress();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }

}
