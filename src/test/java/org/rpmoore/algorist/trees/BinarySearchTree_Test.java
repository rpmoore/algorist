package org.rpmoore.algorist.trees;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class BinarySearchTree_Test {
    @Test
    public void singleNodeInsert() {
        final BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert("hi");

        assertThat(binarySearchTree.visit(Node::getValue), is("hi"));
    }

    @Test
    public void twoNodes() {
        final BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert("hi");
        binarySearchTree.insert("hello");

        assertThat(binarySearchTree.visit(Node::getValue), is("hi"));
        assertThat(binarySearchTree.visit(node -> {
            assertThat(node.getLeft(), is(notNullValue()));
            assertThat(node.getRight(), is(nullValue()));
            return node.getLeft().getValue();
        }), is("hello"));
    }
}
