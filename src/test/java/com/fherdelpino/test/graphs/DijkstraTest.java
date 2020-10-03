package com.fherdelpino.test.graphs;

import com.fherdelpino.graphs.Dijkstra;
import com.fherdelpino.graphs.WeightedNode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Slf4j
public class DijkstraTest {

    @Test
    public void test() {
        WeightedNode weightedNodeA = new WeightedNode("A");
        WeightedNode weightedNodeB = new WeightedNode("B");
        WeightedNode weightedNodeC = new WeightedNode("C");
        WeightedNode weightedNodeD = new WeightedNode("D");
        WeightedNode weightedNodeE = new WeightedNode("E");

        weightedNodeA.getAdjacentNodes().put(weightedNodeB, 6);
        weightedNodeA.getAdjacentNodes().put(weightedNodeD, 1);

        weightedNodeD.getAdjacentNodes().put(weightedNodeB, 2);
        weightedNodeD.getAdjacentNodes().put(weightedNodeE, 1);

        weightedNodeE.getAdjacentNodes().put(weightedNodeB, 2);
        weightedNodeE.getAdjacentNodes().put(weightedNodeC, 5);

        weightedNodeB.getAdjacentNodes().put(weightedNodeC, 5);

        List<WeightedNode> graph = new ArrayList<>();
        graph.add(weightedNodeA);
        graph.add(weightedNodeB);
        graph.add(weightedNodeC);
        graph.add(weightedNodeD);
        graph.add(weightedNodeE);

        List<WeightedNode> result = Dijkstra.findShortestPath(graph, weightedNodeA);

        printResult(result, "C", 7);
    }

    @Test
    public void test2() {
        WeightedNode weightedNodeA = new WeightedNode("A");
        WeightedNode weightedNodeB = new WeightedNode("B");
        WeightedNode weightedNodeC = new WeightedNode("C");
        WeightedNode weightedNodeD = new WeightedNode("D");
        WeightedNode weightedNodeE = new WeightedNode("E");
        WeightedNode weightedNodeF = new WeightedNode("F");
        WeightedNode weightedNodeG = new WeightedNode("G");

        weightedNodeA.getAdjacentNodes().put(weightedNodeB, 4);
        weightedNodeA.getAdjacentNodes().put(weightedNodeC, 3);
        weightedNodeA.getAdjacentNodes().put(weightedNodeE, 7);

        weightedNodeB.getAdjacentNodes().put(weightedNodeC, 6);
        weightedNodeB.getAdjacentNodes().put(weightedNodeD, 5);

        weightedNodeC.getAdjacentNodes().put(weightedNodeD, 11);
        weightedNodeC.getAdjacentNodes().put(weightedNodeE, 8);

        weightedNodeE.getAdjacentNodes().put(weightedNodeD, 2);
        weightedNodeE.getAdjacentNodes().put(weightedNodeG, 5);

        weightedNodeD.getAdjacentNodes().put(weightedNodeF, 2);
        weightedNodeD.getAdjacentNodes().put(weightedNodeG, 10);

        weightedNodeG.getAdjacentNodes().put(weightedNodeF, 3);

        List<WeightedNode> graph = new ArrayList<>();
        graph.add(weightedNodeA);
        graph.add(weightedNodeB);
        graph.add(weightedNodeC);
        graph.add(weightedNodeD);
        graph.add(weightedNodeE);
        graph.add(weightedNodeF);
        graph.add(weightedNodeG);

        List<WeightedNode> result = Dijkstra.findShortestPath(graph, weightedNodeA);

        printResult(result, "F", 11);

    }

    public void printResult(List<WeightedNode> result, String value, int shortest) {
        for (WeightedNode n : result) {
            if (n.getName().equals(value)) {
                assertEquals(shortest, n.getDistanceFromSource());
                log.info("flow={}", n.getName());
                while (n.getPreviousWeightedNode() != null) {
                    log.info("flow={}", n.getPreviousWeightedNode().getName());
                    n = n.getPreviousWeightedNode();
                }
                break;
            }
        }
    }
}
