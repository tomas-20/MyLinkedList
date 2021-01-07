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
   if (n > size()) {
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
   String output = "[";
   Node current = start;
   Node next = current.next();
   while (next != null) {
     output += current.data() + ", ";
     current = current.next();
   }
   output += current.data() + "]";
   return output;
 }
}
