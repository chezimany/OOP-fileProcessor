package filesprocessing.Orders;

import java.io.File;
import java.util.ArrayList;

public class TypeOrder implements Order {

    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static String EMPTY_STRING = "";

    @Override
    public int compare(File file1, File file2) {
        String[] file1Name = file1.getName().split("\\.");
        String[] file2Name = file2.getName().split("\\.");
        int name1Length = file1Name.length - ONE;
        int name2Length = file2Name.length - ONE;
        if (name1Length <= ZERO) {
            if (name2Length <= ZERO) {
                return ZERO;
            } else {
                return file2Name[name2Length].compareTo(EMPTY_STRING);
            }
        } else if (name2Length <= ZERO) {
            return file1Name[name1Length].compareTo(EMPTY_STRING);
        } else {
            return file1Name[name1Length].compareTo(file2Name[name2Length]);
        }
    }
}
