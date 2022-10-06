package com.nttdata.bootcamp.webfluxservermicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bootcamp.webfluxservermicro.model.Person;
import com.nttdata.bootcamp.webfluxservermicro.service.PersonService;

import reactor.core.publisher.Flux;

@RestController
public class PersonListController {

    @Autowired
    PersonService personService;

    @GetMapping(path = "/person-list-1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> personList1(){
        return personService.flux1();
    }

    @GetMapping(path = "/person-list-2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> personList2() {
        return personService.flux2();
    }

    @GetMapping(path = "/person-list-3", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> personList3() {
        return personService.flux3();
    }

    @GetMapping(path = "/person-list-4", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> personList4(){
        return  personService.flux4();
    }
}
