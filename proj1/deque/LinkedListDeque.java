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

    /* empty list */
    public LinkedListDeque() {
//        sentinel = new ListNode(null,7, null);
        sentinel = new ListNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T item) {
//        sentinel = new ListNode(null, null, null);
//        sentinel.next = new ListNode(sentinel, item, sentinel);
//        sentinel.next.next = sentinel;
//        sentinel.next.prev = sentinel;
//        size = 1;
//    }
    @Override
    public void addFirst(T item) {
        size++;
        sentinel.next = new ListNode(sentinel, item, sentinel.next);
        /* if addFirst happens for the first time,
        * sentinel.next is going to point to the first item */
        /* sentinel.next.next.prev which is the sentinel's prev would point to the first item*/
        /* prev should point the sentinel */
        /* it would be sentinel -> item -> sentinel.next
        * it would be sentinel -> sentinel.next -> sentinel.next.next*/
        /* its prev should now point to new added one instead of sentinel*/
        sentinel.next.next.prev = sentinel.next;
    }

    @Override
    public void addLast(T item) {
        size += 1;
        /* sentinel prev should point to newly added last item */
        /* new last item next should point to sentinel */
        /* before this function was called, sentinel prev was
        pointing to the "last" item which now should become a prev item after this*/
        sentinel.prev = new ListNode(sentinel.prev, item, sentinel);
        /* need to connect prev and the last item
        * bc only last item prev is pointing to prev and next is pointing
        * to sentinel, last item prev's next isn't pointing to the last item*/
        sentinel.prev.prev.next = sentinel.prev;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        ListNode p = sentinel.next;
        for (int i = 0; i < (size - 1); i++) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();

    }

    @Override
    public T removeFirst() {
        /*  Removes and returns the item at the front of the deque. */
        /* if an empty list */
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            /* sentinel.next.item gets removed */
            ListNode p = sentinel.next;
            /* item's prev after the first one should point to sentinel */
            /* sentinel.next should point to second one */
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            return p.item;
        }
    }

    @Override
    public T removeLast() {
        /*  Removes and returns the item at the back of the deque. */
        /* if an empty list */
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            ListNode q = sentinel.prev;
            /* the second last item's next should point to sentinel */
            /* sentinel.prev always points to the second last one
            * becuz last one gets removed */
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.prev.next = sentinel;
            return q.item;
        }
    }

    @Override
    public T get(int index) {
        /* Gets the item at the given index, where 0 is the front,
        1 is the next item, and so forth.
        If no such item exists, returns null.
        use iteration */
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

    /* recursive helper function */
    private T getRecur(ListNode p, int i, int index) {
        /* sentinel.next --> */
        if (i == index) {
            return p.item;
        } else {
            /* pass in p.next so we can get the next item */
            return getRecur(p.next, i+1, index);
        }
    }


}
