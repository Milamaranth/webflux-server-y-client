package com.nttdata.bootcamp.webfluxclientmicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import com.nttdata.bootcamp.webfluxclientmicro.model.Person;
import com.nttdata.bootcamp.webfluxclientmicro.service.PeopleService;

import reactor.core.publisher.Flux;

@Controller
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping("/people-list")
    public String index(final Model model) {
        final Flux<Person> peoplelist = peopleService.peopleFlux();
        IReactiveDataDriverContextVariable people = new ReactiveDataDriverContextVariable(peoplelist, 1);
        model.addAttribute("people", people);
        return "index";
    }
}
