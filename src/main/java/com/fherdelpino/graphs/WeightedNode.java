package com.fherdelpino.graphs;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class WeightedNode {

    @NonNull
    private String name;

    private int distanceFromSource = Integer.MAX_VALUE;

    private WeightedNode previousWeightedNode;

    private Map<WeightedNode, Integer> adjacentNodes = new HashMap<>();

}
