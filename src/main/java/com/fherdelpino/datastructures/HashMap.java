package com.fherdelpino.datastructures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_CAPACITY = 10;

    private final List<List<Entry<K, V>>> buckets;
    private final int capacity;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        this.capacity = capacity;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    @Override
    public void put(K key, V value) {
        int index = getIndex(key);
        var bucket = buckets.get(index);
        if (bucket.isEmpty()) {
            bucket.add(new Entry<>(key, value));
        } else {
            //hash collision
            bucket.stream()
                    .filter(entry -> entry.getKey().equals(key))
                    .findFirst()
                    .ifPresentOrElse(entry -> entry.setValue(value),
                            () -> bucket.add(new Entry<>(key, value))
                    );
        }
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        return buckets.get(index)
                .stream()
                .filter(entry -> entry.getKey().equals(key))
                .findFirst()
                .map(Entry::getValue)
                .orElse(null);
    }

    @Override
    public Set<K> keys() {
        return buckets.stream()
                .flatMap(Collection::stream)
                .map(Entry::getKey)
                .collect(Collectors.toUnmodifiableSet());
    }

    private int getIndex(K key) {
        return key.hashCode() % capacity;
    }

    @AllArgsConstructor
    @Getter
    static class Entry<K, V> {
        private final K key;
        @Setter
        private V value;
    }
}


