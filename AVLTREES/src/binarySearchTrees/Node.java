package binarySearchTrees;

public class Node<T extends Comparable<T>> implements INode<T> {

  private Node<T> left;
  private Node<T> right;

  private Node<T> parent;
  private T value;
  private int height;

  /**
   * unparametrized consttructor for Node.
   */
  public Node() {
    value = null;
    right = null;
    left = null;
    height = 1;

  }

  /**
   * Constuctor for node with value.
   */
  public Node(T val) {
    value = val;
    right = null;
    left = null;
    height = 1;

  }

  /**
   * Constuctor for node with value.
   */
  public Node(T val, INode<T> parent) {
    value = val;
    right = null;
    left = null;
    height = 1;
    setParent(parent);

  }

  /**
   * Constuctor for node with value.
   */
  public Node(T val, Node<T> left, Node<T> right) {
    value = val;
    height = 1;
    pushLeft(left);
    pushRight(right);

  }

  @Override
  public INode<T> getLeftChild() {
    return left;
  }

  @Override
  public INode<T> getRightChild() {
    return right;
  }

  @Override
  public T getValue() {
    return value;
  }

  @Override
  public void setValue(T value) {
    this.value = value;

  }

  @Override
  public int getHeight() {

    return height;
  }

  @Override
  public void setHeight(int height) throws IllegalArgumentException {
    if (height < 1) {
      throw new IllegalArgumentException("can not have height less than one");
    }
    this.height = height;

  }

  @Override
  public void pushLeft(INode<T> leftChild) {
    if (leftChild == null || left == leftChild) {
      left =  (Node<T>) leftChild;
      return;
    }
    if (!(leftChild instanceof Node<?>)) {
      throw new ClassCastException();
    }
    this.left = (Node<T>) leftChild;
    if (leftChild.getParent() != this) {
      leftChild.setParent(this);
    }
   // height = Math.max(height, leftChild.getHeight() + 1);

  }

  @Override
  public void pushRight(INode<T> rightChild) {

    if (rightChild == null || right == rightChild) {
      right = (Node<T>) rightChild;
      return;
    }
    if (!(rightChild instanceof Node<?>)) {
      throw new ClassCastException();
    }
    this.right = (Node<T>) rightChild;
    if (rightChild.getParent() != this) {
      rightChild.setParent(this);
    }
  //  height = Math.max(height, rightChild.getHeight() + 1);
  }

  @Override
  public INode<T> getParent() {

    return parent;
  }

  @Override
  public void setParent(INode<T> parent) {
    if (!(parent instanceof Node<?>) && parent != null) {
      throw new ClassCastException();
    }
    this.parent = (Node<T>) parent;
    if (parent == null) {
      return;
    } else {
      parent.push(this);
    }

  }

  @Override
  public void push(INode<T> child) {
    if (child.getValue().compareTo(value) < 0) {
      pushLeft(child);
    } else {
      pushRight(child);
    }
    
  }

}
