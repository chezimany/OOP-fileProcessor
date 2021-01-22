package filesprocessing.Orders;

import java.io.File;

public interface Order {

    /**
     * compare between two files
     *
     * @param file1 - a file to compare.
     * @param file2 - a file to compare.
     * @return a positive integer if file1 turned out to be larger, zero if equal
     * and a negetive integer if file2 turned out to be larger.
     */
    int compare(File file1, File file2);
}
