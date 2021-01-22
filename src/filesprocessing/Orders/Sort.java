package filesprocessing.Orders;

import java.io.File;

public class Sort {

    Order order;

    public Sort(Order order) {
        this.order = order;
    }

    /**
     * a sorting algorithm based on the mergeSort algorithm.
     *
     * @param files  - an array of files to sort.
     * @param length - the length of the files array.
     */
    public void sort(File[] files, int length) {
        if (length <= TypeOrder.ONE) {
            return;
        }
        int mid = length / 2;
        File[] l = new File[mid];
        File[] r = new File[length - mid];

        System.arraycopy(files, TypeOrder.ZERO, l, TypeOrder.ZERO, mid);
        System.arraycopy(files, mid, r, TypeOrder.ZERO, length - mid);

        sort(l, mid);
        sort(r, length - mid);

        merge(files, l, r, mid, length - mid);
    }

    /**
     * merge to files arrays based on the merge algorithm.
     *
     * @param a     - the array that the two other arrays merge into.
     * @param l     - an array to be merged.
     * @param r     - an array to be merged.
     * @param left  - ending index of l.
     * @param right - ending index of r.
     */
    private void merge(File[] a, File[] l, File[] r, int left, int right) {

        int i = TypeOrder.ZERO, j = TypeOrder.ZERO, k = TypeOrder.ZERO;
        while (i < left && j < right) {
            if (this.order.compare(l[i], r[j]) <= TypeOrder.ZERO) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}
