package binarySearchTrees;

/**
 * Created by heshamelsawaf on 24/03/17. AVL tree based on BST;
 */
public class AVL<T extends Comparable<T>> extends BST<T> implements AVLTree<T> {
  @Override
  public INode<T> getTree() {
    return super.getRoot();
  }

  private void leftRotate(INode<T> node) {
    INode<T> temp = node.getRightChild();
    temp.setParent(node.getParent());
    if (temp.getParent() == null)
      this.root = temp;
    else {
      if (temp.getParent().getLeftChild().equals(node))
        temp.getParent().pushLeft(temp);
      else if (temp.getParent().getRightChild().equals(node))
        temp.getParent().pushRight(temp);
    }
    node.pushRight(temp.getLeftChild());
    if (node.getRightChild() != null)
      node.getRightChild().setParent(node);
    temp.pushLeft(node);
    node.setParent(temp);
    this.updateHeight(node);
    this.updateHeight(temp);
  }

  private void updateHeight(INode<T> node) {
    node.setHeight(Math.max(this.height(node.getLeftChild()), height(node.getRightChild())) + 1);
  }

  private int height(INode<T> node) {
    if (node == null)
      return -1;
    return node.getHeight();
  }

  private void rightRotate(INode<T> node) {
    INode<T> temp = node.getLeftChild();
    temp.setParent(node.getParent());
    if (temp.getParent() == null)
      this.root = temp;
    else {
      if (temp.getParent().getLeftChild().equals(node))
        temp.getParent().pushLeft(temp);
      else if (temp.getParent().getRightChild().equals(node))
        temp.getParent().pushRight(temp);
    }
    node.pushLeft(temp.getRightChild());
    if (node.getLeftChild() != null)
      node.getLeftChild().setParent(node);
    temp.pushRight(node);
    node.setParent(temp);
    this.updateHeight(node);
    this.updateHeight(temp);
  }

  @Override
  public INode<T> insert(T key) {
    return super.insert(key);
    // TODO Re balance tree;

  }
  
 
}

