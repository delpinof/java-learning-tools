package com.fherdelpino.datastructures;

import java.util.Set;

public interface Map<K, V> {
    void put(K key, V value);

    V get(K key);

    Set<K> keys();
}
