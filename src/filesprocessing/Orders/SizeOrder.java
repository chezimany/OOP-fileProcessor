package filesprocessing.Orders;

import java.io.File;

public class SizeOrder implements Order {
    @Override
    public int compare(File file1, File file2) {
        return Long.compare(file1.length(), file2.length());
    }
}
