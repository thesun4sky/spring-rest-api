package com.thesun4sky.springrestapi.events;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class EventResource extends Resource<Event> {


    public EventResource(Event event, Link... links) {
        super(event, links);

        // add(new Link("http://localhost:8080/api/events" + event.getId())); 이것보다 아래가 더 Type Safe 하다.
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}
