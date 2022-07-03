package deque;

public class ArrayDeque<T> implements Deque<T> {

    public T[] items;
    private int size;
    private int nextLast;
    private int nextFirst;
    private int ratio;

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
        /* */
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
        /* so that if nextLast reaches end, it would point to 0 */
        nextLast = (nextLast + 1) % items.length;
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
        /*  Removes and returns the item at the front of the deque. */
        if (isEmpty() ) {
            return null;
        } else {
            /* example from slide, addFirst('f') when nextFirst = 3,
            after addFirst, nextFirst would be 2 but we need nextFirst to be 3
            and change item to null */
            nextFirst = (nextFirst + 1) % items.length;
            size -= 1;
            T removedFirstitem = items[nextFirst];
            items[nextFirst] = null;
            ratio = size / items.length;
            if (ratio < 0.25) {
                resize(items.length / 2);
            }
            return removedFirstitem;
        }

    }

    @Override
    public T removeLast() {
        /*  Removes and returns the item at the back of the deque. */
        if (size == 0) {
            return null;
        } else {
            size -= 1;
            if (nextLast == 0) {
                nextLast = items.length - 1;
            } else {
                nextLast = nextLast - 1;
            }
            T removedLastitem = items[nextLast];
            ratio = size / items.length;
            if (ratio < 0.25) {
                resize(items.length / 2);
            }
            return removedLastitem;
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            /* in case there are empty spaces in array, want actual index */
            int actualindex = (nextLast + index + 2) % 8;
            return items[actualindex];
        }
    }


}
