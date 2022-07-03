package deque;

import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {

    private class ListNode {
        public T item;
        public ListNode next;
        public ListNode prev;
        public ListNode(ListNode prev, T item, ListNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private ListNode sentinel;
    private int size;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T otherList = (T) o;
        if (size != ((LinkedListDeque<T>)otherList).size) return false;

        ListNode l1 = sentinel.next;
        ListNode l2 = ((LinkedListDeque<T>)otherList).sentinel.next;

        while (l1 != sentinel && l2 != ((LinkedListDeque<T>)otherList).sentinel) {
            if (!l1.item.equals(l2.item)) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != sentinel || l2 != ((LinkedListDeque<T>)otherList).sentinel) {
            return false;
        }
        return true;
    }

    /* Empty list. */
    public LinkedListDeque() {
        /* Sentinel = new ListNode(null,7, null). */
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }


    @Override
    public void addFirst(T item) {
        /* If addFirst happens, sentinel.next is going to point to the first item. */
        /* Sentinel.next.next.prev which is the sentinel's prev would point to the first item. */
        /* Prev should point the sentinel. */
        /* It would be sentinel -> item -> sentinel.next
        * It would be sentinel -> sentinel.next -> sentinel.next.next. */
        /* Its prev should now point to new added one instead of sentinel. */
        if (size == 0) {
            sentinel.next = new ListNode(sentinel, item, sentinel.next);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next = new ListNode(sentinel, item, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size++;

    }

    @Override
    public void addLast(T item) {
        /* Sentinel prev should point to newly added last item. */
        /* New last item next should point to sentinel. */
        /* Before this function was called, sentinel prev was
        pointing to the "last" item which now should become a prev item after this. */
        /* Need to connect prev and the last item
        * Because only last item prev is pointing to prev and next is pointing.
        * To sentinel, last item prev's next isn't pointing to the last item. */
        if (size == 0) {
            sentinel.next = new ListNode(sentinel, item, sentinel.next);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.prev = new ListNode(sentinel.prev, item, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size += 1;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ListNode p = sentinel.next;
        for (int i = 0; i < (size - 1); i++) {
            if (i == (size - 1)) {
                System.out.print(p.item);
            } else {
                System.out.print(p.item + " ");
            }
            p = p.next;
        }
        System.out.println();

    }

    @Override
    public T removeFirst() {
        /*  Removes and returns the item at the front of the deque. */
        /* If an empty list. */
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            /* Sentinel.next.item gets removed. */
            ListNode p = sentinel.next;
            /* Item's prev after the first one should point to sentinel. */
            /* Sentinel.next should point to second one. */
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return p.item;
        }
    }

    @Override
    public T removeLast() {
        /* Removes and returns the item at the back of the deque. */
        /* If an empty list. */
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            ListNode q = sentinel.prev;
            /* The second last item's next should point to sentinel. */
            /* Sentinel.prev always points to the second last one.
            * Because last one gets removed. */
            sentinel.prev.prev.next = sentinel;
            sentinel.prev= sentinel.prev.prev;
            return q.item;
        }
    }

    @Override
    public T get(int index) {
        /* Gets the item at the given index, where 0 is the front,
        1 is the next item, and so forth.
        If no such item exists, returns null.
        Use iteration */
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return sentinel.next.item;
        } else if (index >= size) {
            return null;
        } else {
            ListNode p = sentinel.next;
            while (index > 0) {
                p = p.next;
                index -= 1;
            }
            return p.item;
        }
    }

    public T getRecursive(int index) {
        ListNode p = sentinel.next;
        if (index >= size) {
            return null;
        } else if (index == 0) {
            return p.item;
        } else {
            return getRecur(p, 0, index);
        }
    }

    /* Recursive helper function. */
    private T getRecur(ListNode p, int i, int index) {
        if (i == index) {
            return p.item;
        } else {
            /* Pass in p.next so we can get the next item. */
            return getRecur(p.next, i + 1, index);
        }
    }


}
