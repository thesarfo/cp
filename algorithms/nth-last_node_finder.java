public static Node nthLastNode(LinkedList list, int n) {
  Node current = null;
  Node tailSeeker = list.head;
  int count = 0;
  while (tailSeeker != null) {
    tailSeeker = tailSeeker.getNextNode();
    if (count >= n) {
      if (current == null) {
        current = list.head;
      }
      current = current.getNextNode();
    }
    count++;
  }
  return current;
}