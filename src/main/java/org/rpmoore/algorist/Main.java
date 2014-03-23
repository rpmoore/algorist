package org.rpmoore.algorist;

import org.rpmoore.algorist.graph.*;

public class Main {

    public static void main(String [] args) throws Exception {
        final AdjacencyList graph = new AdjacencyList();

        /*
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        /*
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 5, 6);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 5);
        graph.addEdge(2, 5, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 5, 1);
        */

        /*
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 7);
        graph.addEdge(1, 4, 12);
        graph.addEdge(2, 3, 9);
        graph.addEdge(2, 5, 7);
        graph.addEdge(3, 4, 4);
        graph.addEdge(3, 5, 4);
        graph.addEdge(3, 6, 3);
        graph.addEdge(4, 6, 7);
        graph.addEdge(5, 7, 5);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 2);
        */

        /*
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        */


        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 5);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 5, 7);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 4);
        graph.addEdge(3, 6, 3);
        graph.addEdge(4, 6, 4);
        graph.addEdge(2, 7, 12);
        graph.addEdge(5, 6, 1);
        graph.addEdge(5, 8, 5);
        graph.addEdge(6, 8, 7);
        graph.addEdge(7, 8, 3);


        System.out.println(graph);

        final BFS breadthTraverse = new BFS(graph, 1);
        System.out.println(breadthTraverse.call());

        final Dijkstra dijkstra = new Dijkstra(graph, 1);
        System.out.println(dijkstra.call());

        /*
        final DFS depthTraverse = new DFS(graph, 1);
        System.out.println(depthTraverse.call());

        /*
        final Prim primTraverse = new Prim(graph, 1);
        System.out.println(primTraverse.call());
        */
    }

}
