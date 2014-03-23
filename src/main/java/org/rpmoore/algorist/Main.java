package org.rpmoore.algorist;

import org.rpmoore.algorist.graph.AdjacencyList;
import org.rpmoore.algorist.graph.BFS;
import org.rpmoore.algorist.graph.DFS;

public class Main {

    public static void main(String [] args) throws Exception {
        final AdjacencyList graph = new AdjacencyList();

        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        System.out.println(graph);

        final BFS breadthTraverse = new BFS(graph, 1);
        System.out.print(breadthTraverse.call());

        final DFS depthTraverse = new DFS(graph, 1);
        System.out.print(depthTraverse.call());
    }

}
