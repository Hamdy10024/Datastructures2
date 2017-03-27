package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import binarySearchTrees.AVL;

public class AVL_Tests {

  @Test
  public void testRotate() {
    AVL<Integer> tree = new AVL<Integer>();
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    assertTrue(tree.getRoot().getValue() == 6);
  }

  @Test
  public void testDepth() {
    AVL<Integer> tree = new AVL<Integer>();
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    tree.insert(9);
    tree.insert(10);
    assertTrue(tree.height() == 3);
  }

  @Test
  public void testSize() {
    AVL<Integer> tree = new AVL<Integer>();
    for (int i = 0; i < 100; i++)
      tree.insert(i);
    for (int i = 0; i < 100; i++)
      tree.insert(i);
    assertTrue(tree.height() < 10);
    assertTrue(tree.getSize() == 100);
  }

  @Test
  public void testDelete() {
    AVL<Integer> tree = new AVL<Integer>();
    for (int i = 0; i < 100; i++) {
      tree.insert(i);
    }
    for (int i = 0; i < 200; i += 2) {
      assertEquals(tree.search(i), (i < 100));
    }
    for (int i = 1; i < 200; i += 2) {
      boolean test = tree.delete(i);

      assertEquals(test, (i < 100));
    }

    for (int i = 0; i < 200; i += 2) {
      assertEquals(tree.search(i), (i < 100) && (i % 2 == 0));
    }

  }
}
