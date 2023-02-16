package com.juaracoding.duspringbootjpa.service;/*
Created By IntelliJ IDEA 2022.3.2 (Community Edition)
Build #IC-223.8617.56, built on January 26, 2023
@Author user a.k.a. Deby Utari
Java Developer
Created on 14/02/2023 18.40
@Last Modified 14/02/2023 18.40
Version 1.0
*/

import com.juaracoding.duspringbootjpa.model.Person;
import com.juaracoding.duspringbootjpa.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
@Transactional
public class PersonService  {

    private PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public void savePerson(Person person){

        List<Person> l = new ArrayList<>();
        List<Person> ll = new LinkedList<>();
        List<Person> lll = new Vector<>();

        Pageable p = null;
        personRepo.save(person);
        personRepo.findAll();
        personRepo.findByFirstName(person.getFirstName());

    }

    public List<Person> findByName(Person person){
        return personRepo.findByFirstName(person.getFirstName());

    }
}
