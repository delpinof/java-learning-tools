package com.fherdelpino.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Dijkstra {

    public static List<Node> findShortestPath(List<Node> graph, Node source) {

        Queue<Node> unVisitedNodes = new LinkedList<>();

        source.setDistanceFromSource(0);
        unVisitedNodes.add(source);

        while (unVisitedNodes.size() > 0) {
            Node unVisitedNode = unVisitedNodes.poll();
            for (Node unVisitedNodeChild : unVisitedNode.getAdjacentNodes().keySet()) {
                int childDistanceFromParent = unVisitedNode.getAdjacentNodes().get(unVisitedNodeChild);
                int parentDistanceFromSource = unVisitedNode.getDistanceFromSource();
                int childDistanceFromSource = childDistanceFromParent + parentDistanceFromSource;
                if (childDistanceFromSource < unVisitedNodeChild.getDistanceFromSource()) {
                    unVisitedNodeChild.setDistanceFromSource(childDistanceFromSource);
                    unVisitedNodeChild.setPreviousNode(unVisitedNode);
                }
                unVisitedNodes.add(unVisitedNodeChild);
            }
        }
        return graph;
    }

}
