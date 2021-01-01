package com.thesun4sky.springrestapi.events;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class EventResource extends Resource<Event> {


    public EventResource(Event event, Link... links) {
        super(event, links);
    }
}
