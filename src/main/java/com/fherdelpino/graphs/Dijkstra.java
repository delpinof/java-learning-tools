package com.fherdelpino.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dijkstra {

    public static List<WeightedNode> findShortestPath(List<WeightedNode> graph, WeightedNode source) {

        Queue<WeightedNode> unVisitedWeightedNodes = new LinkedList<>();

        source.setDistanceFromSource(0);
        unVisitedWeightedNodes.add(source);

        while (unVisitedWeightedNodes.size() > 0) {
            WeightedNode unVisitedWeightedNode = unVisitedWeightedNodes.poll();
            for (WeightedNode unVisitedWeightedNodeChild : unVisitedWeightedNode.getAdjacentNodes().keySet()) {
                int childDistanceFromParent = unVisitedWeightedNode.getAdjacentNodes().get(unVisitedWeightedNodeChild);
                int parentDistanceFromSource = unVisitedWeightedNode.getDistanceFromSource();
                int childDistanceFromSource = childDistanceFromParent + parentDistanceFromSource;
                if (childDistanceFromSource < unVisitedWeightedNodeChild.getDistanceFromSource()) {
                    unVisitedWeightedNodeChild.setDistanceFromSource(childDistanceFromSource);
                    unVisitedWeightedNodeChild.setPreviousWeightedNode(unVisitedWeightedNode);
                }
                unVisitedWeightedNodes.add(unVisitedWeightedNodeChild);
            }
        }
        return graph;
    }

}
