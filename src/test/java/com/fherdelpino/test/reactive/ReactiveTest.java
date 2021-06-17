package com.fherdelpino.test.reactive;

import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactiveTest {

    @Test
    public void testFlux() {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .subscribe(elements::add);

        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testMono() {
        Publisher<String> just = Mono.just("foo");
    }
}
