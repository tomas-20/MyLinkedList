public class Node {
  private String data;
  private Node next, prev;
  public Node(String s) {
    data = s;
  }
  public String data() {
    return data;
  }
  public Node next() {
    return next;
  }
  public Node prev() {
    return prev;
  }
  public void setData(String thing) {
    data = thing;
  }
  public void setNext(Node thing) {
    next = thing;
  }
  public void setPrev(Node thing) {
    prev = thing;
  }
}
