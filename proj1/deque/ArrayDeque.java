package deque;

public class ArrayDeque<T> implements Deque<T> {

    public T[] items;
    private int size;

//    private int capacity;
    private int nextLast;
    private int nextFirst;

    /* starting size -> 8 */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 1;
        nextLast = 0;
    }
    /* source - proj1 tip slide */
    private void resize(int capacity) {
        /* capacity = size + 1 */
        T[] newarr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newarr, 0, size);
        items = newarr;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst = nextFirst - 1;
        }
    }

    /* source - proj1 tip slide */
    @Override
    public void addLast(T item) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = nextLast + 1;
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


}
