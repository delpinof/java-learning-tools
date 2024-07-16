package com.fherdelpino.datastructures;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class HashMapTest {

    @Test
    public void testPutGet() {
        Map<Integer,String> users = new HashMap<>();

        users.put(1, "john");
        users.put(2, "jane");
        users.put(3, "alan");

        assertThat(users.get(1)).isEqualTo("john");
        assertThat(users.get(2)).isEqualTo("jane");
        assertThat(users.get(3)).isEqualTo("alan");
    }

    @Test
    public void testUpsert() {
        Map<Integer,String> users = new HashMap<>();

        users.put(1, "john");
        users.put(2, "jane");
        users.put(3, "alan");
        users.put(1, "Fernando");

        assertThat(users.get(1)).isEqualTo("Fernando");
        assertThat(users.get(2)).isEqualTo("jane");
        assertThat(users.get(3)).isEqualTo("alan");
    }

    @Test
    public void testOverCapacity() {
        Map<Integer,String> users = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            users.put(i, "user" + i);
        }

        for (int i = 0; i < 20; i++) {
            assertThat(users.get(i)).isEqualTo("user" + i);
        }
    }

    @Test
    public void testKeys() {
        Map<Integer, String> users = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            users.put(i, "user" + i);
        }

        assertThat(users.keys())
                .containsExactlyInAnyOrderElementsOf(IntStream.range(0, 20)
                        .boxed()
                        .collect(Collectors.toUnmodifiableSet()));

    }
}
