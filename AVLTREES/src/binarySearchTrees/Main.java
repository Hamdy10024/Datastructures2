package binarySearchTrees;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tre = new BST<>();
        tre.insertNode(4);
        tre.insertNode(8);
        tre.insertNode(5);
        tre.insertNode(0);
        tre.insertNode(3);
        INode<Integer> test;
        // test = (Node<Integer>) test.getRightChild();
        // test = (Node<Integer>) test.getRightChild();
        //test = tre.popMin();
        // System.out.println(test.getValue());
        tre.delete(4);
        test = tre.getRoot();

        test = test.getLeftChild();
        test = test.getRightChild();
        System.out.println(test.getValue());

    }

}
