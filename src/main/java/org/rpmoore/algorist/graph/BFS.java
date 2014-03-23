package org.rpmoore.algorist.graph;

import java.util.*;
import java.util.concurrent.Callable;

public class BFS implements Callable<List<Integer>> {

    private final AdjacencyList graph;
    private final int startNode;

    public BFS(final AdjacencyList graph, final int startNode) {
        this.graph = graph;
        this.startNode = startNode;
    }

    @Override
    public List<Integer> call() throws Exception {
        final Queue<Integer> visitQueue = new LinkedList<>();
        final Set<Integer> visited = new HashSet<>();
        final List<Integer> visitOrder = new ArrayList<>();
        visitDFS(startNode, visitQueue, visited, visitOrder);

        return visitOrder;
    }

    private void visitDFS(final int node, final Queue<Integer> visitQueue, final Set<Integer> visited, final List<Integer> visitOrder) {
        if(visited.contains(node)) {
            return;
        }
        final List<AdjacencyList.EdgeNode> edges = graph.getEdges(node);
        addToQueue(edges, visitQueue, visited);
        visited.add(node);
        visitOrder.add(node);
        if(!visitQueue.isEmpty()) {
            visitDFS(visitQueue.poll(), visitQueue, visited, visitOrder);
        }
    }

    private void addToQueue(final List<AdjacencyList.EdgeNode> newEdges, final Queue<Integer> visitQueue, final Set<Integer> visited ) {
        for(final AdjacencyList.EdgeNode edgeNode: newEdges) {
            if(!visited.contains(edgeNode.getLabel())) {
                visitQueue.offer(edgeNode.getLabel());
            }
        }
    }
}
