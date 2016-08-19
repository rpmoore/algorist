package org.rpmoore.algorist.trees;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinarySearchTree_Test {
    @Test
    public void singleNodeInsert() {
        final BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert("hi");

        assertThat(binarySearchTree.visit(Node::getValue), is("hi"));
    }
}
