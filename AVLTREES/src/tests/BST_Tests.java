package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import binarySearchTrees.BST;
import binarySearchTrees.BinaryTree;
import binarySearchTrees.INode;

public class BST_Tests {

  @Test
  public void testHeight() {
    BST<Integer> tree = new BST<Integer>();
    tree.insertNode(4);
    assertEquals(tree.getRoot().getHeight(),1);
    tree.insertNode(5);

    assertEquals(tree.getRoot().getHeight(),2);

    tree.insertNode(6);

    assertEquals(tree.getRoot().getHeight(),3);

    tree.insertNode(2);

    assertEquals(tree.getRoot().getHeight(),3);

    tree.insertNode(3);

    assertTrue(tree.getRoot().getLeftChild().getValue() == 2);

    assertTrue(tree.getRoot().getLeftChild().getLeftChild() == null);
    
    assertTrue((tree.getRoot().getValue()) ==4);
    
    
  }
  BST<Integer> createTree() {
    BST<Integer> tree = new BST<Integer>();
    tree.insertNode(5);
    tree.insertNode(8);
    tree.insertNode(3);
    tree.insertNode(6);
    tree.insertNode(7);
    return tree;
  }
  
  @Test
  public void testInsert() {
    
    BST<Integer> tree = createTree();
    INode<Integer> sea = tree.getRoot();
    assertTrue(sea.getValue() == 5);
    assertTrue(sea.getLeftChild().getValue() == 3);
    sea = sea.getRightChild();
    assertTrue(sea.getValue() == 8);
    assertTrue(sea.getRightChild() == null);
    assertTrue(sea.getLeftChild().getValue() == 6);
    sea = sea.getLeftChild();
    assertTrue(sea.getLeftChild() == null);
    assertTrue(sea.getRightChild().getValue() == 7);
   
  }

  @Test
  public void testDelete() {
    BST<Integer> tree = createTree();
   // assertTrue(tree.find(5) == tree.getRoot());

    INode<Integer> sea = tree.getRoot();
    assertTrue(sea.getHeight() == 4);
    tree.delete(5);
    sea = tree.getRoot();
    assertTrue(sea.getValue() == 6);

    assertTrue(sea.getHeight() == 3);
    assertTrue(sea.getLeftChild().getValue() == 3);
    sea = sea.getRightChild();
    assertTrue(sea.getValue() == 8);
    assertTrue(sea.getRightChild() == null);
    assertTrue(sea.getLeftChild().getValue() == 7);
    sea = sea.getLeftChild();
    assertTrue(sea.getLeftChild() == null);
    assertTrue(sea.getRightChild()== null);
  }
}
