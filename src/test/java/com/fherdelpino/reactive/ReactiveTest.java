package com.fherdelpino.reactive;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ReactiveTest {

    @Test
    public void testFlux() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        List<Integer> elements = new ArrayList<>();

        flux.log().subscribe(elements::add);

        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testMono() {
        Mono.just("foo");
    }
}
