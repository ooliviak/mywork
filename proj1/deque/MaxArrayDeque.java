package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> comp;
    public MaxArrayDeque(Comparator<T> c) {
        comp = c;
    }

    public T max() {

        if (this.size() == 0) {
            return null;
        } else {
            T maxNum = this.get(0);

            for (int index = 0; index < this.size(); index++) {
                if (comp.compare(maxNum, this.get(index)) > 0) {
                    continue;
                } else {
                    maxNum = this.get(index);
                }
            }
            return maxNum;
        }
    }

    public T max(Comparator<T> c) {
        if (this.size() == 0) {
            return null;
        } else {
            T maxNum = this.get(0);

            for (int index = 0; index < this.size(); index++) {
                if (c.compare(maxNum, this.get(index)) > 0) {
                    continue;
                } else {
                    maxNum = this.get(index);
                }
            }
            return maxNum;
        }

    }

}
