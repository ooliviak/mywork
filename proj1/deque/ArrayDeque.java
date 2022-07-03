package deque;

public class ArrayDeque<T> implements Deque<T> {

    private T[] items;
    private int size;
    private int nextLast;
    private int nextFirst;
    private double ratio;

    /* Starting size -> 8. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T otherArray = (T) o;
        if (size != ((ArrayDeque<T>)otherArray).size) return false;

        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == ((ArrayDeque<T>)otherArray).items[j]) {
                j++;
                return true;
            }
        }
        return true;
    }

    /* Source - proj1 tip slide. */
    private void resize(int capacity) {
        /* Capacity = size + 1. */
        T[] newarr = (T[]) new Object[capacity];
        System.arraycopy(items, 0, newarr, 0, size);
        items = newarr;
        nextFirst = 0;
        nextLast = size;
    }

    @Override
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        /* If front item is at position zero, and addFirst,
        the new front item in the deque will be the last item
        in the array. */
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
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        /* So that if nextLast reaches end, it would point to 0. */
        nextLast = (nextLast + 1) % items.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < (items.length - 1); i++) {
            if (i == (items.length - 1)) {
                System.out.print(items[i]);
            } else {
                System.out.print(items[i] + " ");
            }
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        /*  Removes and returns the item at the front of the deque. */
        if (isEmpty() ) {
            return null;
        } else {
            /* Example from slide, addFirst('f') when nextFirst = 3,
            after addFirst, nextFirst would be 2 but we need nextFirst to be 3
            and change item to null. */
            nextFirst = (nextFirst + 1) % items.length;
            size -= 1;
            T removedFirstitem = items[nextFirst];
            items[nextFirst] = null;
            ratio = (double) size / items.length;
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
            /* Return previous nextLast item. */
            size -= 1;
            /* If nextLast is now 0, it means that prev nextLast was 7
            (if it's length was 8). */
            if (nextLast == 0) {
                nextLast = items.length - 1;
            } else {
                nextLast = nextLast - 1;
            }
            T removedLastitem = items[nextLast];
            items[nextLast] = null;
            ratio = (double) size / items.length;
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
            /* So nextFirst + 1 would be the starting point.
            * So we want the ith index from there.
            * Want actual index. */
            int actualindex = (nextFirst + 1 + index) % items.length;
            return items[actualindex];
        }
    }


}
