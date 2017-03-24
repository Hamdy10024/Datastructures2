package binarySearchTrees;

public class BST<T extends Comparable<T>> implements BinaryTree<T> {

    protected INode<T> root;
    private int nodes;

    public BST() {
        nodes = 0;
        root = null;
    }

    public BST(INode<T> root) {
        this.root = root;
        //TODO calculate nodes
    }

    @Override
    public void insert(T key) {
        if (root == null) {
            root = new Node<>(key);
            nodes = 1;
            return;
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
        if (key.compareTo(parent.getValue()) < 0) {
            current = new Node<>(key, parent);
            parent.pushLeft(current);
        } else {
            current = new Node<>(key, parent);
            parent.pushRight(current);
        }
        while (current != null) {
            int leftVal = (current.getLeftChild() == null) ? 0 : current.getLeftChild().getHeight();
            int rightVal = (current.getRightChild() == null) ? 0 : current.getRightChild().getHeight();
            int height = current.getHeight();
            height = Math.max(height, rightVal);
            height = Math.max(height, leftVal);
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
        BST<T> tempTree = new BST<>(todelete.getRightChild());
        INode<T> inst = tempTree.popMin();
        todelete.pushRight(tempTree.getRoot());
        todelete.setValue(inst.getValue());
        return true;
    }

    private INode<T> find(T key) {
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
        return root.getHeight();
    }

    @Override
    public Node<T> popMax() {
        if (root == null) {
            return null;
        }
        Node<T> current = (Node<T>) root;
        while (current.getRightChild() != null) {
            current = (Node<T>) current.getRightChild();
        }
        if (current == root) {
            root = root.getLeftChild();
            nodes--;
            return current;
        }
        current.getParent().pushRight(current.getLeftChild());
        nodes--;
        return current;
    }

    @Override
    public Node<T> popMin() {
        if (root == null) {
            return null;
        }
        Node<T> current = (Node<T>) root;
        while (current.getLeftChild() != null) {
            current = (Node<T>) current.getLeftChild();
        }
        if (current == root) {
            root = root.getRightChild();
            nodes--;
            return current;
        }
        current.getParent().pushLeft(current.getRightChild());
        nodes--;
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
