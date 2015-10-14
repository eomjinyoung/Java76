package step10.ex01;

public class LinkedList {
  private Bucket start;
  private Bucket end;
  private int length;
  
  public LinkedList() {
    start = new Bucket();
    end = start;
  }
  
  public int add(Object value) {
    end.setValue(value);
    end.setNext(new Bucket());
    end = end.getNext();
    length++;
    return 0;
  }
  
  public Object get(int index) {
    if (index < 0 || index >= length)
      return null;
    
    int pos = 0;
    Bucket cursor = start;
    
    while (pos < index) {
      cursor = cursor.getNext();
      pos++;
    }
    
    return cursor.getValue();
  }
  
  public Object remove(int index) {
    //
    return null;
  }
}







