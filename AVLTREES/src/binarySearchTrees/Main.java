package binarySearchTrees;

import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) {
      Dictionary t = new Dictionary();
      t.insert("Test");
      t.insert("Bag");
      t.insert("Apple");

      t.insert("Abigapple");

      t.insert("Aaaaapple");

      t.insert("Zolopple");
      t.insert("Zzolopple");
      System.out.println(t.exists("Zolopples"));
      System.out.println(t.exists("Aaaaapple"));
      System.out.println(t.exists("Abigapple"));
    }

}
