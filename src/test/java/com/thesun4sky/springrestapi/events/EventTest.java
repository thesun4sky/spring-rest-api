package com.thesun4sky.springrestapi.events;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Java6Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        Event event = new Event();
        String name = "Event";
        String description = "Spring";
        event.setName(name);
        event.setDescription(description);

        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    @Parameters
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        //  Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();

        //  when
        event.update();

        //  then
        Java6Assertions.assertThat(event.isFree()).isEqualTo(isFree);
    }

    //원래 @Parameters(method = "parametersForTestFree") 를 Test에 달아야 하는데
    //prefix 인 paramtersFor... 로하면 자동으로 Parameters 어노테이션만 달면 파람으로 들어감
    private Object[] parametersForTestFree() {
        return new Object[] {
           new Object[] {0, 0, true},
           new Object[] {100, 0, false},
           new Object[] {0, 100, false},
           new Object[] {100, 200, false},
        };
    }

    @Test
    @Parameters
    public void testOffline(String location, boolean isOffline) {
        //  Given
        Event event = Event.builder()
                .location(location)
                .build();

        //  when
        event.update();

        //  then
        Java6Assertions.assertThat(event.isOffline()).isEqualTo(isOffline);

    }

    private Object[] parametersForTestOffline() {
        return new Object[] {
                new Object[] {"강남", true},
                new Object[] {null, false},
                new Object[] {"     ", false},
        };
    }
}