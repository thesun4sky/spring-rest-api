package com.thesun4sky.springrestapi.events;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class EventResource extends Resource {

    public EventResource(Event event, Link... links) {
        super(event, links);
        add(linkTo(EventController.class).slash(event.getId()).withSelfRel());
    }
}