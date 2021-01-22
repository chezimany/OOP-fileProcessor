package filesprocessing;

import filesprocessing.Filters.*;
import filesprocessing.Orders.*;

import java.io.File;
import java.util.ArrayList;

public class DirectoryProcessor {
    private final static int ARGS_LENGTH = 2;
    private final static String ERROR_MSG = "ERROR: ";
    private  ArrayList<File> myFiles = new ArrayList<>();
    private  File source, commandFile;
    public static final String WARNING_MSG = "Warning in line ";

    private void validationCheck(String[] args) throws Type2Error {
        if (args.length != ARGS_LENGTH) {
            throw new Type2Error("invalid arguments number");
        }
        try {
            this.source = new File(args[0]);
            this.commandFile = new File(args[1]);

            if (!source.isDirectory() || source.listFiles() == null) {
                throw new Type2Error("error opening source directory");
            }

            for (File file : source.listFiles()) {
                if (file.isFile()) {
                    myFiles.add(file);
                } else continue;
            }

        } catch (Exception e) {
            throw new Type2Error(e.getMessage());
        }
    }

    private File[] createFileArray(Filter filter, Order order) {
        ArrayList<File> filteredList = new ArrayList<>();
        for (File file : myFiles) {
            if (filter.isPass(file)) {
                filteredList.add(file);
            }
        }
        File[] filtered = new File[filteredList.size()];
        for (int i = 0; i < filteredList.size(); i++) {
            filtered[i] = filteredList.get(i);
        }
        AbsOrder abs = new AbsOrder();
        if (order instanceof Reverse) {
            Reverse rev = new Reverse(abs);
            Sort revSort = new Sort(rev);
            revSort.sort(filtered, filtered.length);
        } else {
            Sort absSort = new Sort(abs);
            absSort.sort(filtered, filtered.length);
        }
        Sort finalSort = new Sort(order);
        finalSort.sort(filtered, filtered.length);
        return filtered;
    }

    public static void main(String[] args) {
        try {
            DirectoryProcessor dp = new DirectoryProcessor();
            dp.validationCheck(args);
            ArrayList<Section> parsed = new ArrayList<>();
            Parser parser = new Parser();
            FilterFactory filterFactory = new FilterFactory();
            OrderFactory orderFactory = new OrderFactory();
            parser.Parse(dp.commandFile, parsed);
            for (Section section : parsed) {
                Filter filter = new AllFilter();
                Order order = new AbsOrder();
                try {
                    String filterDetails = section.getFilter();
                    filter = filterFactory.createFilter(filterDetails);
                } catch (FilterException e) {
                    int line = section.getFilterRowNum();
                    System.err.println(WARNING_MSG + line);
                    filter = new AllFilter();
                }
                try {
                    String orderDetails = section.getOrder();
                    order = orderFactory.createOrder(orderDetails);
                } catch (OrderParameterException e) {
                    int line = section.getOrderRowNum();
                    System.err.println(WARNING_MSG + line);
                    order = new AbsOrder();
                }
                File[] sortedFiltered = dp.createFileArray(filter, order);
                for (File file : sortedFiltered) {
                    System.out.println(file.getName());
                }
            }
        } catch (Type2Error type2Error) {
            System.err.println(ERROR_MSG + type2Error.getMessage());
            return;
        }
    }
}
