package filesprocessing.Orders;

import java.io.File;

public class Reverse implements Order {

    public final static int NEGATIVE_ONE = -1;

    private Order order;

    public Reverse(Order order) {
        this.order = order;
    }

    @Override
    public int compare(File file1, File file2) {
        return this.order.compare(file2, file1);
    }
}
