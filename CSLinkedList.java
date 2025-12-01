import java.util.*;

public class CSLinkedList<E> extends AbstractList<E> {

    private static final class Node<E> {
    E data;
    Node<E> next;
    Node(E d, Node<E> n) { data = d; next = n; }
  }

  private final Node<E> head;
  private Node<E> tail;
  private int size;

  public CSLinkedList() {
    head = new Node<>(null, null);
    tail = null;
    size = 0;
  }

  @Override
  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  private void checkElementIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private void checkPositionIndex(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private Node<E> nodeAt(int index) {
    checkElementIndex(index);
    Node<E> cur = head.next;
    for (int i = 0; i < index; i++) cur = cur.next;
    return cur;
  }

  @Override
  public boolean add(E e) {
    Node<E> n = new Node<>(e, null);
    if (size == 0) {
      head.next = n;
      tail = n;
    } else {
      tail.next = n;
      tail = n;
    }
    size++;
    modCount++;
    return true;
  }

  @Override
  public void add(int index, E e) {
    checkPositionIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> n = new Node<>(e, prev.next);
    prev.next = n;
    if (index == size) tail = n;
    size++;
    modCount++;
  }

  @Override
  public E get(int index) {
    return nodeAt(index).data;
  }

  @Override
  public E set(int index, E e) {
    Node<E> n = nodeAt(index);
    E old = n.data;
    n.data = e;
    return old;
  }

  @Override
  public E remove(int index) {
    checkElementIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> target = prev.next;
    prev.next = target.next;
    if (target == tail) {
      tail = (prev == head && prev.next == null) ? null : prev;
    }
    size--;
    modCount++;
    return target.data;
  }

  @Override
  public int indexOf(Object o) {
    int i = 0;
    for (Node<E> cur = head.next; cur != null; cur = cur.next, i++) {
      if (o == null ? cur.data == null : o.equals(cur.data)) return i;
    }
    return -1;
  }

  @Override
  public void clear() {
    head.next = null;
    tail = null;
    size = 0;
    modCount++;
  }

  /**
   * Check if an item is already present in list, adds if there isn't
   * @param item
   * @return true or false
   */
  public boolean addIfAbsent(E item) {
      if(indexOf(item) < 0){
          add(item);
          return true;
      }
      else{
          return false;
      }
  }

  /**
   * Moves specific item to the front of the list if found in list
   * @param item
   */
  public void moveToFront(E item){
      int index =  indexOf(item);
      if(index != -1){
          CSLinkedList.this.remove(indexOf(item));
          add(0, item);
      }
  }

  /**
   * Adds item directly after a specific item index
   * @param target
   * @param newItem
   * @return true or false
   */
  public boolean addAfter(E target, E newItem){
      int index = indexOf(target);
      if(index != -1){
          add((index+1), newItem);
          return true;
      }
      return false;
  }

    /**
     * Adds items in order, (Under Construction)
     * @param item
     * @param cmp
     */
  public void addInOrder(E item, Comparator<E> cmp){
      Node<E> newNode = new Node<>(item, null);
      if(head == tail){
          head.next = newNode;
          tail = newNode;
      }
      Node<E> current = head;
      while(cmp.compare(item, current.data) > 0){
          current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
  }

    /**
     * Removes first Occurrence of an item
     * @param item
     * @return true or false
     */
  public boolean removeFirstOccurrence(E item){
      int index = indexOf(item);
      if(index != -1){
          remove(index);
          return true;
      }
      return false;
  }

    /**
     *Copies the original LinkedList into a new list
     * @return
     */
    public CSLinkedList<E> copy(){
        //Make a new CSLinkedList
        CSLinkedList<E> copy = new CSLinkedList<>();
        Node<E> cur = this.head;
        while(cur != null){
            copy.add(cur.data);
            cur = cur.next;
        }
        //Using Collections to shuffle the new CSLinkedList
        Collections.shuffle(copy);

        return copy;
    }


  @Override
  public Iterator<E> iterator() {
    return new Itr();
  }


  private final class Itr implements Iterator<E> {
    private Node<E> prev = head;
    private Node<E> cursor = head.next;
    private Node<E> lastPrev = null;
    private Node<E> lastRet = null;
    private int expectedMod = modCount;

    @Override
    public boolean hasNext() { return cursor != null; }

    @Override
    public E next() {
      checkForComod();
      if (cursor == null) throw new NoSuchElementException();
      lastPrev = prev;
      lastRet = cursor;
      prev = cursor;
      cursor = cursor.next;
      return lastRet.data;
    }

    @Override
    public void remove() {
      checkForComod();
      if (lastRet == null) throw new IllegalStateException();
      lastPrev.next = lastRet.next;
      if (lastRet == tail) {
        tail = (lastPrev == head && lastPrev.next == null) ? null : lastPrev;
      }
      size--;
      modCount++;
      expectedMod++;
      lastRet = null;
    }

    private void checkForComod() {
      if (expectedMod != modCount) throw new ConcurrentModificationException();
    }
  }
}
