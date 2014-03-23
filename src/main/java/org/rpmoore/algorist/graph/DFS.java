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
        final Set<Integer> visiited = new HashSet<>();
        final List<Integer> visitOrder = new ArrayList<>();

        visitDFS(startNode, visiited, visitOrder);

        return visitOrder;
    }

    private void visitDFS(final int node, final Set<Integer> visited, final List<Integer> visitOrder) {
        if(visited.contains(node)) {
            return;
        }

        visited.add(node);
        visitOrder.add(node);
        for(final AdjacencyList.EdgeNode edgeNode: graph.getEdges(node)) {
            visitDFS(edgeNode.getLabel(),visited, visitOrder);
        }
    }
}
