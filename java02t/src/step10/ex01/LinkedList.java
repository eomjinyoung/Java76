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
    if (index < 0 || index >= length)
      return null;
    
    Object removedValue = null;
    length--;
    
    if (index == 0) {
      removedValue = start.getValue();
      start = start.getNext();
      return removedValue;
    }
    
    int pos = 0;
    Bucket cursor = start;
    while (pos < index-1) {
      cursor = cursor.getNext();
      pos++;
    }
    
    removedValue = cursor.getNext().getValue();
    cursor.setNext(cursor.getNext().getNext());
    
    return removedValue;
  }
  
  public int size() {
    return length;
  }
  
  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("00000");
    list.add("11111");
    list.add("22222");
    list.add("33333");
    list.add("44444");
    list.add("55555");
 
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("----------------");
    
    System.out.println(list.remove(2));
    System.out.println("----------------");
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println("----------------");
    
    list.add("66666");
    list.remove(0);
    System.out.println("----------------");
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    
    list.remove(4);
    System.out.println("----------------");
    
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    
  }
}







