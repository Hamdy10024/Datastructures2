package binarySearchTrees;

public class Main {
  public static void main(String[] args){
    BST<Integer> tre = new BST<Integer>();
    tre.insert(4);
    tre.insert(8);
    tre.insert(5);
    tre.insert(0);
    tre.insert(3);
    INode<Integer> test = (Node<Integer>) tre.getRoot();
   // test = (Node<Integer>) test.getRightChild();
   // test = (Node<Integer>) test.getRightChild();
    //test = tre.popMin();
   // System.out.println(test.getValue());
     tre.delete(4);
    test = (Node<Integer>) tre.getRoot();

    test = (Node<Integer>) test.getLeftChild();
    test = (Node<Integer>) test.getRightChild();
    System.out.println(test.getValue());
    
  }

}
