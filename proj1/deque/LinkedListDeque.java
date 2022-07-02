package deque;

public class LinkedListDeque<T> implements Deque<T> {

    private class IntListNode {
        public int item;
        public IntListNode next;
        public IntListNode prev;
        public IntListNode(IntListNode prev, int item, IntListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    /* The first item (if it exists) is at sentinel.next. */
    private IntListNode sentinel;
    private int size;

    /* empty list */
    public LinkedListDeque() {
        sentinel = new IntListNode(null,7, null);
        sentinel.next = sentinel;
        size = 0;
    }

//    public LinkedListDeque(int x) {
//        sentinel = new IntListNode(7, null);
//        sentinel.next = new IntListNode(x, null);
//        sentinel.next.next = sentinel;
//        size = 1;
//    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    public T getRecursive(int index) {
        return null;
    }
}
