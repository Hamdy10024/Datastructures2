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
        height = 0;

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
        height = 0;
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
            throw new IllegalArgumentException();
        }
        this.height = height;

    }

    @Override
    public void pushLeft(INode<T> leftChild) {
        if (leftChild == null) {
            return;
        }
        if (!(leftChild instanceof Node<?>)) {
            throw new ClassCastException();
        }
        this.left = (Node<T>) leftChild;
        height = Math.max(height, leftChild.getHeight() + 1);

    }

    @Override
    public void pushRight(INode<T> rightChild) {

        if (rightChild == null) {
            return;
        }
        if (!(rightChild instanceof Node<?>)) {
            throw new ClassCastException();
        }
        this.right = (Node<T>) rightChild;
        height = Math.max(height, rightChild.getHeight() + 1);
    }

    @Override
    public INode<T> getParent() {

        return parent;
    }

    @Override
    public void setParent(INode<T> parent) {
        if (!(parent instanceof Node<?>)) {
            throw new ClassCastException();
        }
        this.parent = (Node<T>) parent;

    }


}
