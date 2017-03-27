package binarySearchTrees;

import java.util.Stack;

public class BST<T extends Comparable<T>> implements BinaryTree<T> {

  protected INode<T> root;
  protected int nodes;

  public BST() {
    nodes = 0;
    root = null;
  }

  public BST(INode<T> root) {
    this.root = root;
    Stack<INode<T>> counting = new Stack<INode<T>>();
    counting.push(root);
    nodes = 0;
    while (!counting.isEmpty()) {
      INode<T> current = counting.pop();
      if (current.getLeftChild() != null) {
        counting.push(current).getLeftChild();
      }
      if (current.getRightChild() != null) {
        counting.push(current).getRightChild();
      }
      nodes++;
    }
  }

  @Override
  public INode<T> insertNode(T key) {
    if (key == null) {
      throw new IllegalArgumentException("can not insert null");
    }
    if (find(key) != null) {
      return null;
    }
    if (root == null) {
      root = new Node<>(key);
      nodes = 1;
      return root;
    }
    INode<T> current = root;
    INode<T> parent = null;
    while (current != null) {
      if (key.compareTo(current.getValue()) < 0) {
        parent = current;
        current = current.getLeftChild();
      } else {
        parent = current;
        current = current.getRightChild();
      }
    }

    current = new Node<T>(key, parent);
    // parent.push(current);
    INode<T> toReturn = current;
    nodes++;
    reheight(current);
    return toReturn;
  }

  private void reheight(INode<T> current) {

    while (current != null) {
      int leftVal = (current.getLeftChild() == null) ? 0 : current.getLeftChild().getHeight();
      int rightVal = (current.getRightChild() == null) ? 0 : current.getRightChild().getHeight();
      int height = 1;
      height = Math.max(height, rightVal + 1);
      height = Math.max(height, leftVal + 1);
      current.setHeight(height);
      current = current.getParent();
    }
  }

  @Override
  public boolean delete(T key) {
    INode<T> todelete = find(key);
    if (todelete == null) {
      return false;
    }
    INode<T> inst = popMin(todelete.getRightChild());
    if (inst == null) {
      todelete.getParent().push(todelete.getLeftChild());
    } else {
      todelete.setValue(inst.getValue());
    }
    nodes--;
    return true;
  }
  /**
   * finds a node and returns it.
   * @param key key of the node.
   * @return the node itself.
   */

  public INode<T> find(T key) {
    if (key == null) {
      return null;
    }
    INode<T> current = root;
    while (current != null && current.getValue().compareTo(key) != 0) {
      if (key.compareTo(current.getValue()) < 0) {
        current = current.getLeftChild();
      } else {
        current = current.getRightChild();
      }
    }
    return current;
  }

  @Override
  public boolean search(T key) {
    return find(key) != null;
  }

  @Override
  public int height() {
    return ((root == null) ? 0 : root.getHeight());
  }

  @Override
  public Node<T> popMax() {
    if (root == null) {
      return null;
    }
    if (root == null) {
      return null;
    }
    Node<T> minNode = popMax(root);
    if (minNode == root) {
      root = root.getLeftChild();
    }
    nodes--;
    return minNode;
  }

  @Override
  public Node<T> popMin() {
    if (root == null) {
      return null;
    }
    Node<T> minNode = popMin(root);
    if (minNode == root) {
      root = root.getRightChild();
    }
    nodes--;
    return minNode;
  }

  public Node<T> popMin(INode<T> root) {
    if (root == null) {
      return null;
    }
    Node<T> current = (Node<T>) root;
    while (current.getLeftChild() != null) {
      current = (Node<T>) current.getLeftChild();
    }
    if (current == root) {
      INode<T> temp = current.getParent();
      if (current.getRightChild() != null) {
        current.getRightChild().setParent(temp);
      }
      return current;
    }
    if (current.getParent().getLeftChild() == current)
      current.getParent().pushLeft(current.getRightChild());
    else
      current.getParent().pushRight(current.getRightChild());

    reheight(current.getParent());
    return current;
  }

  public Node<T> popMax(INode<T> root) {
    if (root == null) {
      return null;
    }
    Node<T> current = (Node<T>) root;
    while (current.getRightChild() != null) {
      current = (Node<T>) current.getRightChild();
    }
    if (current == root) {
      INode<T> temp = current.getParent();
      if (current.getLeftChild() != null) {
        current.getLeftChild().setParent(temp);
      }
      return current;
    }
    current.getParent().push(current.getLeftChild());
    reheight(current.getParent());
    return current;
  }

  @Override
  public int getSize() {
    return nodes;
  }

  @Override
  public INode<T> getRoot() {
    return root;
  }

}
