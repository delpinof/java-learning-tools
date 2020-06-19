package com.fherdelpino.test.graphs;

import com.fherdelpino.graphs.Dijkstra;
import com.fherdelpino.graphs.Node;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
public class DijkstraTest {

    @Test
    public void test() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        nodeA.getAdjacentNodes().put(nodeB, 6);
        nodeA.getAdjacentNodes().put(nodeD, 1);

        nodeD.getAdjacentNodes().put(nodeB, 2);
        nodeD.getAdjacentNodes().put(nodeE, 1);

        nodeE.getAdjacentNodes().put(nodeB, 2);
        nodeE.getAdjacentNodes().put(nodeC, 5);

        nodeB.getAdjacentNodes().put(nodeC, 5);

        List<Node> graph = new ArrayList<>();
        graph.add(nodeA);
        graph.add(nodeB);
        graph.add(nodeC);
        graph.add(nodeD);
        graph.add(nodeE);

        List<Node> result = Dijkstra.findShortestPath(graph, nodeA);

        printResult(result, "C", 7);
    }

    @Test
    public void test2() {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        nodeA.getAdjacentNodes().put(nodeB, 4);
        nodeA.getAdjacentNodes().put(nodeC, 3);
        nodeA.getAdjacentNodes().put(nodeE, 7);

        nodeB.getAdjacentNodes().put(nodeC, 6);
        nodeB.getAdjacentNodes().put(nodeD, 5);

        nodeC.getAdjacentNodes().put(nodeD, 11);
        nodeC.getAdjacentNodes().put(nodeE, 8);

        nodeE.getAdjacentNodes().put(nodeD, 2);
        nodeE.getAdjacentNodes().put(nodeG, 5);

        nodeD.getAdjacentNodes().put(nodeF, 2);
        nodeD.getAdjacentNodes().put(nodeG, 10);

        nodeG.getAdjacentNodes().put(nodeF, 3);

        List<Node> graph = new ArrayList<>();
        graph.add(nodeA);
        graph.add(nodeB);
        graph.add(nodeC);
        graph.add(nodeD);
        graph.add(nodeE);
        graph.add(nodeF);
        graph.add(nodeG);

        List<Node> result = Dijkstra.findShortestPath(graph, nodeA);

        printResult(result, "F", 11);

    }

    public void printResult(List<Node> result, String value, int shortest) {
        for (Node n : result) {
            if (n.getName().equals(value)) {
                assertEquals(shortest, n.getDistanceFromSource());
                log.info("flow={}", n.getName());
                while (n.getPreviousNode() != null) {
                    log.info("flow={}", n.getPreviousNode().getName());
                    n = n.getPreviousNode();
                }
                break;
            }
        }
    }
}
