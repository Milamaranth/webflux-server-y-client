package com.nttdata.bootcamp.webfluxclientmicro.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.webfluxclientmicro.model.Person;

import reactor.core.publisher.Flux;

@Service
public class PeopleService {
    WebClient webClient = WebClient.create("http://localhost:8090");

    public Flux<Person> peopleFlux() {
        Flux<Person> peopleFlux = Flux.merge(
            webClient.get().uri("/person-list-1").retrieve().bodyToFlux(Person.class),
            webClient.get().uri("/person-list-2").retrieve().bodyToFlux(Person.class),
            webClient.get().uri("/person-list-3").retrieve().bodyToFlux(Person.class),
            webClient.get().uri("/person-list-4").retrieve().bodyToFlux(Person.class)
        );
        peopleFlux.share()
            .filter(p -> p.getFirstname().startsWith("A"))
            .subscribe(p -> {
                System.out.println(p.getLastname() + ", " + p.getFirstname() + " tiene " + p.getAge() + " años de edad");
            });

        return peopleFlux;
    }


}
