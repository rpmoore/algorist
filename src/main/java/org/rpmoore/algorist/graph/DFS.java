package org.rpmoore.algorist.graph;

import java.util.*;
import java.util.concurrent.Callable;

public class DFS implements Callable<List<Integer>> {

    private final AdjacencyList graph;
    private final int startNode;

    public DFS(final AdjacencyList graph, final int startNode) {
        this.graph = graph;
        this.startNode = startNode;
    }

    @Override
    public List<Integer> call() throws Exception {
        final Set<Integer> visited = new HashSet<>();
        final List<Integer> visitOrder = new ArrayList<>();

        visitDFS(startNode, visited, visitOrder);

        return visitOrder;
    }

    private void visitDFS(final int node, final Set<Integer> visited, final List<Integer> visitOrder) {

        visited.add(node);
        visitOrder.add(node);
        for(final AdjacencyList.EdgeNode edgeNode: graph.getEdges(node)) {
            if(visited.contains(edgeNode.getLabel())){
                continue;
            }
            System.out.println("Visit: " + edgeNode.getLabel());
            visitDFS(edgeNode.getLabel(),visited, visitOrder);
        }
    }
}
