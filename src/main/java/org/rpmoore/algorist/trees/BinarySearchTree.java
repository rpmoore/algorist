package org.rpmoore.algorist.trees;

import org.rpmoore.algorist.util.Compare;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> parent = null;
    public BinarySearchTree() {
    }

    public void insert(final T value) {
        final Node<T> node = new Node<>(value);
        if(parent == null) {
            parent = node;
        } else {
            innerInsert(parent, node);
        }
    }

    private void innerInsert(final Node<T> parent, final Node<T> newNode) {
        if (Compare.lessThan(parent.getValue(), newNode.getValue())) {
            // go right
            final Node<T> right = parent.getRight();
            if (right == null) {
                newNode.setParent(parent);
                parent.setRight(newNode);
            } else {
                innerInsert(right, newNode);
            }
        } else {
            final Node<T> left = parent.getLeft();
            if (left == null) {
                newNode.setParent(parent);
                parent.setLeft(newNode);
            } else {
                innerInsert(left , newNode);
            }
        }
    }

    public T visit(final Visitor<T, Node<T>> visitor) {
        return visitor.visit(parent);
    }

    @FunctionalInterface
    public interface Visitor<R, S> {
        public R visit(S node);
    }
}
