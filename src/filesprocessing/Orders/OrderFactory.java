package filesprocessing.Orders;

import filesprocessing.Filters.Filter;
import filesprocessing.Filters.FilterFactory;
import filesprocessing.Type1Error;

public class OrderFactory {

    private static final String REVERSE = "REVERSE";

    /**
     * create a new order matching the given details.
     *
     * @param orderDetails - details of order to return.
     * @return - a new order matching the details.
     * @throws Type1Error - if no such order exists.
     */
    public Order createOrder(String orderDetails) throws OrderParameterException {
        String[] details = orderDetails.split(FilterFactory.HASH);
        String name = details[FilterFactory.ZERO];
        String last = details[details.length - FilterFactory.ONE];
        Order order;

        switch (name) {
            case "abs":
                if (details.length == FilterFactory.ONE) {
                    order = new AbsOrder();
                } else {
                    if (last.equals(REVERSE)) {
                        AbsOrder toReverse = new AbsOrder();
                        order = new Reverse(toReverse);
                    } else {
                        throw new OrderParameterException();
                    }
                }
                return order;
            case "type":
                if (details.length == FilterFactory.ONE) {
                    order = new TypeOrder();
                } else {
                    if (last.equals(REVERSE)) {
                        TypeOrder toReverse = new TypeOrder();
                        order = new Reverse(toReverse);
                    } else {
                        throw new OrderParameterException();
                    }
                }
                return order;
            case "size":
                if (details.length == FilterFactory.ONE) {
                    order = new SizeOrder();
                } else {
                    if (last.equals(REVERSE)) {
                        SizeOrder toReverse = new SizeOrder();
                        order = new Reverse(toReverse);
                    } else {
                        throw new OrderParameterException();
                    }
                }
                return order;
            default:
                throw new OrderParameterException();
        }
    }
}
