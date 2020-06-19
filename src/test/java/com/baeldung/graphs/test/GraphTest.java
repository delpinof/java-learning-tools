package com.baeldung.graphs.test;

import com.baeldung.graphs.DijkstraAlgorithm;
import com.baeldung.graphs.Graph;
import com.baeldung.graphs.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class GraphTest {

    Graph inputGraph = new Graph();

    Node nodeA = new Node("A");

    @Before
    public void setUp() {
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        inputGraph.addNode(nodeA);
        inputGraph.addNode(nodeB);
        inputGraph.addNode(nodeC);
        inputGraph.addNode(nodeD);
        inputGraph.addNode(nodeE);
        inputGraph.addNode(nodeF);

    }

    @Test
    public void testDijkstra() {
        Graph graphResult = DijkstraAlgorithm.calculateShortestPathFromSource(inputGraph, nodeA);
        for(Node node: graphResult.getNodes()) {
            log.info("node={}, distance={}", node.getName(), node.getDistanceFromSource());
        }
    }
}
