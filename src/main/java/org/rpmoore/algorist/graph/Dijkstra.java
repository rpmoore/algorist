package org.rpmoore.algorist.graph;

import java.util.*;
import java.util.concurrent.Callable;

public class Dijkstra implements Callable<List<Integer>> {

    private class PathNode implements Comparable<PathNode> {
        final private int weight;
        final private int label;
        public PathNode(final int weight, final int label) {
            this.weight = weight;
            this.label = label;
        }

        public int getWeight() {
            return weight;
        }

        public int getLabel() {
            return label;
        }

        @Override
        public int compareTo(final PathNode o) {
            return Integer.compare(this.getWeight(), o.getWeight());
        }
    }

    private final AdjacencyList graph;
    private final int startNode;
    public Dijkstra(final AdjacencyList graph, final int startNode) {
        this.graph = graph;
        this.startNode = startNode;
    }

    @Override
    public List<Integer> call() throws Exception {
        final PriorityQueue<PathNode> visitQueue = new PriorityQueue<>();
        final Set<Integer> visited = new HashSet<>();
        final List<Integer> visitOrder = new ArrayList<>();

        final List<AdjacencyList.EdgeNode> edges = graph.getEdges(startNode);
        addToQueue(0,edges, visitQueue, visited);
        visited.add(startNode);
        visitOrder.add(startNode);

        while(!visitQueue.isEmpty()) {
            visitDFS(visitQueue.poll(), visitQueue, visited, visitOrder);
        }

        return visitOrder;
    }

    private void visitDFS(final PathNode node, final PriorityQueue<PathNode> visitQueue, final Set<Integer> visited, final List<Integer> visitOrder) {
        final int nodeLabel = node.getLabel();
        if(visited.contains(nodeLabel)) {
            return;
        }
        final List<AdjacencyList.EdgeNode> edges = graph.getEdges(nodeLabel);
        addToQueue(node.weight, edges, visitQueue, visited);
        visited.add(nodeLabel);
        visitOrder.add(nodeLabel);
    }

    private void addToQueue(final int currentWeight, final List<AdjacencyList.EdgeNode> newEdges, final PriorityQueue<PathNode> visitQueue, final Set<Integer> visited ) {
        for(final AdjacencyList.EdgeNode edgeNode: newEdges) {
            if(!visited.contains(edgeNode.getLabel())) {
                final int weight = currentWeight + edgeNode.getWeight();
                System.out.println("Adding node (" + edgeNode.getLabel() + ") with weight " + weight);
                visitQueue.offer(new PathNode(weight, edgeNode.getLabel()));
            }
        }
    }
}
