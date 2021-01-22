package filesprocessing;


public class Section {

    private String filter;

    private String order;

    private int filterRowNum;

    private int orderRowNum;

    private boolean filterWarning;

    private boolean orderWarning;


    public Section(String filter, String order, int filterRowNum, int orderRowNum, boolean filterWarning,
                   boolean orderWarning) {
        this.filter = filter;
        this.order = order;
        this.filterRowNum = filterRowNum;
        this.orderRowNum = orderRowNum;
        this.filterWarning = filterWarning;
        this.orderWarning = orderWarning;

    }

    public boolean isFilterWarning() {
        return filterWarning;
    }

    public boolean isOrderWarning() {
        return orderWarning;
    }

    public String getFilter() {
        return filter;
    }

    public String getOrder() {
        return order;
    }

    public int getFilterRowNum() {
        return filterRowNum;
    }

    public int getOrderRowNum() {
        return orderRowNum;
    }


}
