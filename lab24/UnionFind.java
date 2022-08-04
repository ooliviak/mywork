public class UnionFind {

    /* TODO: Add instance variables here. */
    public int[] id;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        if (N < 0) {
            throw new IllegalArgumentException();
        }
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = -1;
        }

    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        return -1 * id[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return id[v];
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        int root = v;
        int temp;
        // TODO: YOUR CODE HERE
        if (v < 0 || v >= id.length) {
            throw new IllegalArgumentException();
        } else if (id[v] < 0) {
            return v;
        } else if (id[id[v]] < 0) {
            return id[v];
        } else {
            while (id[root] >= 0) {
                root = id[root];
            }
            // make it become a direct child of the root
            while (id[v] >= 0) {
                temp = id[v];
                id[v] = root;
                v = temp;
            }
            return root;
        }
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing a item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (connected(v1, v2)) {
            return;
        } else if (v1 == v2) {
            return;
        } else {
            int root1 = find(v1);
            int root2 = find(v2);
            int size1 = sizeOf(root1);
            int size2 = sizeOf(root2);
            if (size1 == size2) {
                id[root1] = root2;
                id[root2] = -1 * (size1 + size2);
            } else if (size1 < size2) {
                id[root1] = root2;
                id[root2] = -1 * (size1 + size2);
            } else {
                id[root2] = root1;
                id[root1] = -1 * (size1 + size2);
            }
        }
    }

}
