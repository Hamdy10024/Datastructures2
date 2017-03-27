package binarySearchTrees;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary implements IDictionary {

  AVL<String> data;

  public Dictionary() {
    data = new AVL<String>();
    
  }

  public Dictionary(String string) throws FileNotFoundException  {

    data = new AVL<String>();
    load(new File(string));
  }

  @Override
  public void load(File file) throws FileNotFoundException {
    Scanner input = new Scanner(file);
    while (input.hasNext()) {
      data.insert(input.next());
    }
    input.close();

  }

  @Override
  public boolean insert(String word) {
    if (data.search(word)) {
      return false;
    }
    data.insert(word);
    return true;
  }

  @Override
  public boolean exists(String word) {
    
    return data.search(word);
  }

  @Override
  public boolean delete(String word) {
    
    return data.delete(word);
  }

  @Override
  public int size() {
    return data.getSize();
  }

  @Override
  public int height() {
    return data.height();
  }

}
