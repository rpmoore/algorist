package org.rpmoore.algorist.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyList {
    public class EdgeNode {
        private final int weight;
        private final int label;

        public EdgeNode(final int orig, final int weight) {
            this.label = orig;
            this.weight = weight;
        }

        public int getLabel() {
            return label;
        }

        public int getWeight() {
            return weight;
        }
    }

    private final ArrayList<List<EdgeNode>> graph = new ArrayList<>();

    private int edgeCount = 0;

    public int getEdgeCount() {
        return edgeCount;
    }

    public void addEdge(final int orig, final int dest) {
        addEdge(orig, dest, 1);
    }

    public void addEdge(final int orig, final int dest, final boolean directed) {
        addEdge(orig, dest, directed, 1);
    }

    public void addEdge(final int orig, final int dest, final int weight) {
        addEdge(orig, dest, false, weight);
    }

    public void addEdge(final int orig, final int dest, final boolean directed, final int weight) {
        final List<EdgeNode> edgeList = getEdgeList(orig);
        edgeList.add(new EdgeNode(dest, weight));

        if(directed) {
            edgeCount++;
        }
        else{
            addEdge(dest, orig, true, weight);
        }
    }

    public List<EdgeNode> getEdges(final int vert) {
        return getEdgeList(vert);
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Num Edges: ").append(getEdgeCount()).append('\n');
        for(int i = 1; i <= graph.size(); i++ ) {
            builder.append(i).append(": ");
            for(final EdgeNode edge: getEdgeList(i)) {
                builder.append(" ").append(edge.getLabel());
            }
            builder.append('\n');
        }
        return builder.toString();
    }

    private List<EdgeNode> getEdgeList(final int edge) {
        final int adjustedEdge = edge-1;
        final List<EdgeNode> edgeList;
        final int graphInitSize = graph.size();
        if(adjustedEdge >= graphInitSize) {
            final int diff = edge - graphInitSize;
            List<EdgeNode> tempList = null;
            for(int i = 0; i < diff; i ++) {
                tempList = new LinkedList<>();
                graph.add(tempList);
            }
            edgeList = tempList;
        }
        else {
            edgeList = graph.get(adjustedEdge);
        }

        return edgeList;
    }
}
