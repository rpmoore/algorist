package org.rpmoore.algorist.graph;


import java.util.*;
import java.util.concurrent.Callable;

public class Prim implements Callable<List<Integer>> {

    final private AdjacencyList graph;
    final private int startNode;

    public Prim(final AdjacencyList graph, final int startNode) {
        this.graph = graph;
        this.startNode = startNode;
    }

    @Override
    public List<Integer> call() throws Exception {
        final PriorityQueue<AdjacencyList.EdgeNode> visitQueue = new PriorityQueue<>();
        final Set<Integer> visited = new HashSet<>();
        final List<Integer> visitOrder = new ArrayList<>();

        final List<AdjacencyList.EdgeNode> edges = graph.getEdges(startNode);
        addToQueue(edges, visitQueue, visited);
        visited.add(startNode);
        visitOrder.add(startNode);

        while(!visitQueue.isEmpty()) {
            visitDFS(visitQueue.poll().getLabel(), visitQueue, visited, visitOrder);
        }

        return visitOrder;
    }

    private void visitDFS(final int node, final PriorityQueue<AdjacencyList.EdgeNode> visitQueue, final Set<Integer> visited, final List<Integer> visitOrder) {
        if(visited.contains(node)) {
            return;
        }
        final List<AdjacencyList.EdgeNode> edges = graph.getEdges(node);
        addToQueue(edges, visitQueue, visited);
        visited.add(node);
        visitOrder.add(node);
    }

    private void addToQueue(final List<AdjacencyList.EdgeNode> newEdges, final PriorityQueue<AdjacencyList.EdgeNode> visitQueue, final Set<Integer> visited ) {
        for(final AdjacencyList.EdgeNode edgeNode: newEdges) {
            if(!visited.contains(edgeNode.getLabel())) {
                visitQueue.offer(edgeNode);
            }
        }
    }
}
