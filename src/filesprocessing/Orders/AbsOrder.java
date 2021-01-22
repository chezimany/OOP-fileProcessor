package filesprocessing.Orders;

import java.io.File;
import java.util.ArrayList;

public class AbsOrder implements Order {

    @Override
    public int compare(File file1, File file2) {
        return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
    }
}

