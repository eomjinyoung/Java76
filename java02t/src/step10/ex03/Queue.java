package step10.ex03;

public class Queue {
  Bucket front;
  Bucket rear;
  int length;
  
  public Queue() {
    front = new Bucket();
    rear = front;
  }
  
  public int put(Object value) {
    rear.setValue(value);
    rear.setNext(new Bucket());
    rear = rear.getNext();
    length--;
    return 0;
  }
  
  public Object get() {
    if (length == 0)
      return null;
    
    Object value = front.getValue();
    front = front.getNext();
    length--;
    return value;
  }
  
  public static void main(String[] args) {
    Queue q = new Queue();
    q.put("0000");
    q.put("1111");
    q.put("2222");
    q.put("3333");
    q.put("4444");
    
    System.out.println(q.get());
    System.out.println(q.get());
    System.out.println(q.get());
    System.out.println(q.get());
    System.out.println(q.get());
    System.out.println(q.get());
    
  }
}






