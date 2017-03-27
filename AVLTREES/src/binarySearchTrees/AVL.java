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
    if (temp.getParent() == null) {
      this.root = temp;
    }
    node.pushRight(temp.getLeftChild());
    temp.pushLeft(node);
    node.setParent(temp);
    this.updateHeight(node);
    this.updateHeight(temp);
  }

  private void updateHeight(INode<T> node) {
    node.setHeight(Math.max(this.height(node.getLeftChild()), height(node.getRightChild())) + 1);
  }

  private int height(INode<T> node) {
    if (node == null) {
      return 0;
    }
    return node.getHeight();
  }

  private void rightRotate(INode<T> node) {
    INode<T> temp = node.getLeftChild();
    temp.setParent(node.getParent());
    if (temp.getParent() == null) {
      this.root = temp;
    }
    node.pushLeft(temp.getRightChild());
    temp.pushRight(node);
    this.updateHeight(node);
    this.updateHeight(temp);
  }

  private void rebalance(INode<T> node) {
    while (node != null) {
      this.updateHeight(node);

      if (this.height(node.getLeftChild()) >= 2 + this.height(node.getRightChild())) {

        if (this.height(node.getLeftChild().getLeftChild()) 
            < this.height(node.getLeftChild().getRightChild())) {

          this.leftRotate(node.getLeftChild());
        }
        this.rightRotate(node);
      } else if (this.height(node.getRightChild()) >= 2 + this.height(node.getLeftChild())) {

       
        if (this.height(node.getRightChild().getRightChild()) 
            < this.height(node.getRightChild().getLeftChild())) {
          this.rightRotate(node.getRightChild());
        }
        this.leftRotate(node);
      }
      node = node.getParent();
    }
  }

  @Override
  public void insert(T key) {
    INode<T> pus = super.insertNode(key);
    if (pus == null) {
      return;
    }
    this.rebalance(pus);
  }
  
  @Override 
  public boolean delete(T key) {
    INode<T> todelete = find(key);
    if (todelete == null) {
      return false;
    }
    INode<T> inst = popMin(todelete.getRightChild());
    if (inst == null) {
      if (todelete.getParent().getLeftChild() == todelete) {
        todelete.getParent().pushLeft(todelete.getLeftChild());
      } else {
        todelete.getParent().pushRight(todelete.getLeftChild());
      }
      
      rebalance(todelete.getParent());
    } else {
      
      todelete.setValue(inst.getValue());
      rebalance(inst.getParent());
    }
    nodes--;
    return true;
    
  }

}
