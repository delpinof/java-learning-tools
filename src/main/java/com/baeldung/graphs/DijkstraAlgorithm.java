package com.baeldung.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistanceFromSource(0);

        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unVisitedNodes = new HashSet<>();

        unVisitedNodes.add(source);

        while (unVisitedNodes.size() != 0) {
            Node currentNode = getLowestDistanceNode(unVisitedNodes);
            unVisitedNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!visitedNodes.contains(adjacentNode)) {
                    calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    unVisitedNodes.add(adjacentNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return graph;
    }

    private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
        Node lowestDistanceNode = null;
        int lowestDistance = Integer.MAX_VALUE;
        for (Node node: unsettledNodes) {
            int nodeDistance = node.getDistanceFromSource();
            if (nodeDistance < lowestDistance) {
                lowestDistance = nodeDistance;
                lowestDistanceNode = node;
            }
        }
        return lowestDistanceNode;
    }

    private static void calculateMinimumDistance(Node evaluationNode,
                                                 Integer edgeWeigh, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistanceFromSource();
        if (sourceDistance + edgeWeigh < evaluationNode.getDistanceFromSource()) {
            evaluationNode.setDistanceFromSource(sourceDistance + edgeWeigh);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            evaluationNode.setShortestPath(shortestPath);
        }
    }
}
