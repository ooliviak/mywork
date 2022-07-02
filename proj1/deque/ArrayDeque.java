package deque;

public class ArrayDeque<T> implements Deque<T> {

    public T[] items;
    private int size;
    private int capacity;
    private int nextLast;
    private int nextFirst;

    /* starting size -> 8 */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        capacity = items.length;

    }


    private void resize(int capacity) {
        T[] newarr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newarr, 0, size);
        items = newarr;
    }

    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[nextLast] = x;
        size += 1;
    }

    @Override
    public void addFirst(T item) {

    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public int size() {
        return size;
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

    @Override
    public T getRecursive(int i) {
        return null;
    }
}
