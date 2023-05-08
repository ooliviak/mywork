package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    /** circular sentinel topology */

    /** source from hug's lecture */
    private Node sentinel;
    private int size;


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
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

    /** source from hug's lecture */
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** source from hug's lecture */
    /** Creates an empty linked list deque. */
    public LinkedListDeque() {
        /** Sentinel = new Node(null, item, null).
         * item can be any item such as number/string/..etc */
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /** Adds an item to the front of the linked list deque. */
    public void addFirst(T item) {
        /** New item prev would point back to sentinel since it's going
         * to be the first item of the list */
        /** never re-assign sentinel */
        /** if it's an empty list, we re-assign sentinel's next and sentinel's prev */
        Node firstItem = sentinel.next;
        Node newItem = new Node(sentinel, item, firstItem);

        if (isEmpty()) {
            firstItem = newItem;
            sentinel.prev = firstItem;
        } else {
            /** we re-assign first item to the new node
             * and the original first item's prev to the new node */
            /** ex) x - 3 - 9
             * addFirst(2) ---> x - 2 - 3 - 9
             * we have to connect 3 prev to 2 */
            firstItem = newItem;
            /** needs a node that points back to new item. */
            firstItem.next.prev = newItem;
        }
        sentinel.next = firstItem;
        size = size + 1;
    }

    /** Adds an item to the back of the linked list deque */
    public void addLast(T item) {
        Node lastItem = sentinel.prev;
        Node newlastItem = new Node(sentinel.prev, item, sentinel);

        if (isEmpty()) {
            /** if the list is empty, it's the same thing as addFirst function. */
            Node firstItem = sentinel.next;
            Node newItem = new Node(sentinel, item, firstItem);

            firstItem = newItem;
            sentinel.prev = firstItem;
            sentinel.next = firstItem;
        } else {
            /** ex) x - 3 - 9
             * addLast(4) ---> x - 3 - 9 - 4
             /** sentinel's prev points to the last node */
            /** we re-assign original last item to the new last node
             * and new node's prev would point to the original last node.
             * New node's next would point to the sentinel.
             * The original last item's next point to sentinel, but
             * we change it so that it points to the last item.
             * so 9's next points to 4 */
            lastItem = newlastItem;
            lastItem.prev.next = lastItem;
            sentinel.prev = lastItem;
        }
        size = size + 1;
    }

    public int size() {
        return size;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line.*/
    public void printDeque() {
        String deque = "";
        Node curr = sentinel.next;
        int index = 0;
        while (index <= (size - 1)) {
            if (index == (size - 1)) {
                deque = deque + curr.item;
            } else {
                deque = deque + curr.item + ", ";
            }
            curr = curr.next;
            index = index + 1;
        }
        System.out.println(deque);

    }

    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Node first = sentinel.next;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = size - 1;
            return first.item;
        } else {
            /** sentinel.next is always going to be the front item. */
            Node first = sentinel.next;
            /** ex) x - 3 - 9
             * removeFirst() --> x - 9 */
            sentinel.next = first.next;
            /** after this, sentinel's next points to 9, and
             * we want 9's prev to point to sentinel. */
            sentinel.next.prev = sentinel;
            size = size - 1;
            return first.item;
        }
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Node first = sentinel.next;
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
            size = size - 1;
            return first.item;
        } else {
            /** sentinel.prev is always going to be the last item. */
            Node last = sentinel.prev;
            /** ex) x - 3 - 9
             * removeLast() --> x - 3 */
            sentinel.prev = last.prev;
            /** after this, we want last item's next to point to sentinel. */
            sentinel.prev.next = sentinel;
            size = size - 1;
            return last.item;
        }

    }

    /** Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque*/
    public T get(int index) {
        if (size == 1) {
            return sentinel.next.item;
        } else if (index == 0) {
            return sentinel.next.item;
        } else if (index < size) {
            int ind = 0;
            Node curr = sentinel.next;
            while (curr.item != null) {
                if (ind == index) {
                    break;
                } else {
                    ind = ind + 1;
                }
                /** update current node. */
                curr = curr.next;
            }
            return curr.item;
        } else {
            /** If no such item exists, returns null. */
            return null;
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Deque diffList) {
            if (this.size != diffList.size()) {
                return false;
            }
            int index = 0;
            while (index < size) {
                if (!this.get(index).equals(diffList.get(index))) {
                    return false;
                }
                index++;
            }
            return true;
        }
        return false;
    }

    private T getRecursiveHelper(int x, int index, Node item) {
        if (index == 0) {
            return item.item;
        } else if (x == index) {
            return item.item;
        } else {
            return getRecursiveHelper(x + 1, index, item.next);
        }
    }

    /** Get function in recursive form. */
    public T getRecursive(int index) {
        if (index >= size) {
            /** If no such item exists, returns null. */
            return null;
        } else if (index < 0) {
            return null;
        } else if (size == 1) {
            return sentinel.next.item;
        } else {
            return getRecursiveHelper(0, index, sentinel.next);
        }
    }


}

