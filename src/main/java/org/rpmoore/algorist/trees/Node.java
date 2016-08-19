package org.rpmoore.algorist.trees;

public class Node<T> {
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;
    private final T value;

    public Node(final Node<T> parent, final Node<T> left, final Node<T> right, final T value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public Node(final T value) {
        this(null, null, null, value);
    }

    public Node<T> getParent() {
        return parent;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public T getValue() {
        return value;
    }

    public void setParent(final Node<T> parent) {
        this.parent = parent;
    }

    public void setLeft(final Node<T> left) {
        this.left = left;
    }

    public void setRight(final Node<T> right) {
        this.right = right;
    }
}
