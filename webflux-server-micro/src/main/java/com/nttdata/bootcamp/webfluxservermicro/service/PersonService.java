package com.nttdata.bootcamp.webfluxservermicro.service;

import java.time.Duration;

import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.webfluxservermicro.model.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonService {
    public Flux<Person> flux1() {
        return Flux.just(
            new Person("Hob","Hayward", 34),
            new Person("Finrod", "Felagund", 90),
            new Person("Frodo", "Baggins", 50),
            new Person("Kili", "Dis", 33)
        ).delayElements(Duration.ofSeconds(1));
    }

    public Flux<Person> flux2(){
        return Flux.just(
            new Person("Adelard", "Took", 10),
            new Person("Pippin", "Took", 27),
            new Person("Tom", "Bombadil", 999),
            new Person("Thorin", "Oakshild", 44)
        ).delayElements(Duration.ofSeconds(2));
    }

    public Flux<Person> flux3(){
        return Flux.just(
            new Person("Grima", "Wormtongue", 31),
            new Person("Bilbo", "Baggins", 114),
            new Person("Arwen", "Undomiel", 68)
        ).delayElements(Duration.ofSeconds(3));
    }

    public Flux<Person> flux4(){
        return Flux.just(
            new Person("Samgise", "Wise", 25),
            new Person("Belladona", "Took", 60),
            new Person("Aragorn", "of Gondor", 80),
            new Person("Asphodel", "Brandybuck", 30)
        ).delayElements(Duration.ofSeconds(4));
    }
}
