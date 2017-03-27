package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import binarySearchTrees.Dictionary;

public class Dictinary_Test {

  private Dictionary load() {
    try{
    Dictionary dic = new Dictionary("input.txt");

    return dic;
    }
    catch(Throwable t) {
      System.out.println("cannot load");
      return null;
    }
  }
  @Test
  public void test() {
   assertFalse(load() ==null);
  }

}
