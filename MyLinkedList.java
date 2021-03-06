public class MyLinkedList {
  private int size;
  private Node start, end;
  public MyLinkedList() {
    size = 0;
  }
  public int size() {
    return size;
  }
  private void check(int n) {
    if (n < 0 || n > size()) {
      throw new IndexOutOfBoundsException("index " + n + " not in range of list of size " + size());
    }
  }
  private void connect(Node a, Node b) {
    b.setPrev(a);
    a.setNext(b);
  }
  private Node getNode(int index) {
    check(index);
    Node output = start;
    for (int i = 0; i < index; i ++) {
      output = output.next();
    }
    return output;
  }
  public boolean add(int index, String value) {
    check(index);
    Node newNode = new Node(value);
    if (size() == 0) {
      start = newNode;
      end = newNode;
    }
    else if (index == 0) {
      connect(newNode, start);
      start = newNode;
    }
    else if (index == size()) {
      connect(end, newNode);
      end = newNode;
    }
    else {
      Node before = getNode(index - 1);
      Node after = before.next();
      connect(before, newNode);
      connect(newNode, after);
    }
    size ++;
    return true;
  }
  public String remove(int index) {
    size --;
    check(index);
    if (size() == 0) {
      Node removed = start;
      start = null;
      end = null;
      return start.data();
    }
    else if (index == 0) {
      Node removed = start;
      start = start.next();
      start.setPrev(null);
      return removed.data();
    }
    else if (index == size()) {
      Node removed = end;
      end = end.prev();
      end.setNext(null);
      return removed.data();
    }
    else {
      Node before = getNode(index - 1);
      Node removed = before.next();
      Node after = removed.next();
      connect(before, after);
      return removed.data();
    }
  }
  public boolean add(String value) {
    return add(size(), value);
  }
  public String get(int index) {
    return getNode(index).data();
  }
  public String set(int index, String value) {
    Node replaced = getNode(index);
    String output = replaced.data();
    replaced.setData(value);
    return output;
  }
  public String toString() {
    if (size() == 0) {
      return "[]";
    }
    String output = "[";
    Node current = start;
    Node next = current.next();
    while (next != null) {
      output += current.data() + ", ";
      current = next;
      next = next.next();
    }
    output += current.data() + "]";
    return output;
  }
  public void extend(MyLinkedList other) {
    int otherSize = other.size();
    if (otherSize != 0) {
      Node otherStart = other.start;
      if (size() == 0) {
        start = other.start;
      }
      else {
        connect(end, otherStart);
      }
      end = other.end;
      size += other.size();
      other.start = null;
      other.end = null;
      other.size = 0;
    }
  }
}
