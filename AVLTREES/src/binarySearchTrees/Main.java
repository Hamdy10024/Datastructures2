package binarySearchTrees;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Dictionary t = new Dictionary();
    Scanner inp = new Scanner(System.in);
    while (true) {
      String command = inp.next();
      String data;
      switch (command) {

      case "insert":
        data = inp.next();
        System.out.println((t.insert(data) ? "Word successully inserted" : "word already exists"));
        break;
      case "delete":
        data = inp.next();
        System.out.println((t.delete(data) ? "Word successully deleted" : "word doesn't exist"));
        break;
      case "find":
        data = inp.next();
        System.out.println((t.exists(data) ? "Word exists" : "word doesn't exist"));
        break;
      case "size":
        data = inp.next();
        System.out.println(t.size());
        break;
      case "height":
        data = inp.next();
        System.out.println(t.height());
        break;
      case "load":
        data = inp.next();
        try {
          t.load(new File(data));
          System.out.println("Successfuly loaded.");
        } catch (FileNotFoundException e) {
          System.out.println("Cannot find file.");

        }
        break;

      }
    }
  }

}
