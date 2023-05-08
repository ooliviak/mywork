package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {

    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private static final int INITSIZE = 8;
    private static final int LENGTH = 16;

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {
        int index = 0;
        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public T next() {
            T result = get(index);
            index += 1;
            return result;
        }
    }

    /** Creates an empty array deque. */
    /** The starting size of your array should be 8. */
    public ArrayDeque() {
        items = (T[]) new Object[INITSIZE];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        if (capacity == (items.length / 2)) {
            int index = 0;
            int countNull = 0;
            /** to find the start of the array. excluding null in front. */
            while (items[index] == null) {
                countNull += 1;
                index += 1;
            }
            for (int x = 0; x < countNull; x++) {
                newItems[x] = items[x];
            }
        } else {
            for (int i = 0; i < nextFirst + 1; i++) {
                newItems[i] = items[i];
            }
            for (int i = nextFirst + 1; i < (nextFirst + items.length + 1); i++) {
                newItems[i] = null;
            }
            int count = 0;
            int j = nextLast;
            int i = nextFirst + (items.length) + 1;
            while (i < capacity) {
                newItems[i] = items[j];
                j++;
                i++;
                count++;
            }
            items = newItems;
            if (nextFirst == 0) {
                nextFirst = size;
            } else if (nextLast == 0 || count == 0) {
                nextLast = size;
                nextFirst = items.length - 1;
            } else {
                nextFirst = items.length - count - 1;
                nextLast = nextLast;
            }
        }

    }


    /** Adds an item to the front of the array deque. */
    public void addFirst(T item) {

        if ((size == items.length)) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            /** the new front should loop back around to the end of the array. */
            nextFirst = items.length - 1;
        } else {
            nextFirst = (nextFirst - 1 + items.length) % items.length;
        }
        size += 1;
    }

    /** Adds an item to the back of the array deque. */
    public void addLast(T item) {

        if ((size == items.length)) {
            resize(items.length * 2);
        }
        items[nextLast] = item;
        /** the new last would point back to the front of the array. */
        if (nextLast == (items.length - 1)) {
            nextLast = 0;
        } else {
            nextLast = (nextLast + 1) % items.length;
        }
        size += 1;

    }

    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque() {
        String deque = "";
        int index = 0;
        while (index <= (items.length - 1)) {
            if (index == (items.length - 1)) {
                deque = deque + items[index];
            } else {
                deque = deque + items[index] + ", ";
            }
            index += 1;
        }
        System.out.println(deque);

    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        double ratio = (double) size / items.length;
        int prevFirst = 0;
        T frontItem = null;

        if (isEmpty()) {
            return null;
        }  else if (nextFirst == (items.length - 1)) {
            prevFirst = 0;
            frontItem = items[prevFirst];
            nextFirst = prevFirst;
            size -= 1;
            if ((ratio < 0.25) && (items.length >= LENGTH)) {
                resize(items.length / 2);
            }
        } else {
            prevFirst = (nextFirst + 1) % items.length;
            frontItem = items[prevFirst];
            nextFirst = prevFirst;
            size -= 1;
            if ((ratio < 0.25) && (items.length >= LENGTH)) {
                resize(items.length / 2);
            }
        }
        items[nextFirst] = null;
        return frontItem;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        double ratio = (double) size / items.length;
        int prevLast = 0;
        T lastItem = null;

        if (isEmpty()) {
            return null;
        } else if (nextLast == 0) {
            prevLast = items.length  - 1;
            lastItem = items[prevLast];
            nextLast = prevLast;
            size -= 1;
            if ((ratio < 0.25) && (items.length >= LENGTH)) {
                resize(items.length / 2);
            }
        } else {
            prevLast = (nextLast - 1 + items.length) % items.length;
            lastItem = items[prevLast];
            nextLast = prevLast;
            size -= 1;
            if ((ratio < 0.25) && (items.length >= LENGTH)) {
                resize(items.length / 2);
            }
        }
        items[prevLast] = null;
        return lastItem;
    }

    /** Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque*/
    public T get(int index) {
        if (index >= items.length) {
            return null;
        } else if (index < 0) {
            return null;
        } else {
            return items[(nextFirst + index + 1) % items.length];
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Deque diffArray) {
            if (this.size != diffArray.size()) {
                return false;
            }
            int index = 0;
            while (index < size) {
                if (!this.get(index).equals(diffArray.get(index))) {
                    return false;
                }
                index++;
            }
            return true;
        }
        return false;
    }
}





