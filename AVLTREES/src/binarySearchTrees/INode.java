package binarySearchTrees;

public interface INode<T extends Comparable<T>> {
    /**
     * Returns the left child of the current element/node in the heap tree
     *
     * @return INode wrapper to the left child of the current element/node
     */
    INode<T> getLeftChild();

    /**
     * Returns the right child of the current element/node in the heap tree.
     *
     * @return INode wrapper to the right child of the current element/node.
     */
    INode<T> getRightChild();

    /**
     * Returns the parent of the current element/node in the heap tree.
     *
     * @return INode wrapper to the parent of the current element/node.
     */
    INode<T> getParent();

    /**
     * sets parent to currnet Node.
     *
     * @param parent INode wrapper to parent.
     */
    void setParent(INode<T> parent);

    /**
     * Set/Get the value of the current node.
     *
     * @return Value of the current node.
     */
    T getValue();

    /**
     * sets value of current node.
     *
     * @param value value of Node.
     */
    void setValue(T value);

    /**
     * gets height of the current Node.
     *
     * @return integer representing the node height.
     */
    int getHeight();

    /**
     * sets node height in a tree.
     *
     * @param height height to set.
     */
    void setHeight(int height) throws IllegalArgumentException;

    /**
     * adds left child to node.
     *
     * @param leftChild represented as INode.
     */
    void pushLeft(INode<T> leftChild);


    /**
     * adds  child to node.
     *
     * @param Child represented as INode.
     */
    void push(INode<T> Child);

    /**
     * adds right child to node.
     *
     * @param rightChild represented as INode.
     */
    void pushRight(INode<T> rightChild);
}