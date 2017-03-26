package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import binarySearchTrees.AVL;

public class AVL_Tests {

  @Test
  public void test() {
    AVL<Integer> tree = new AVL<Integer>();
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    assertTrue(tree.getRoot().getValue() == 6);
  }

}
