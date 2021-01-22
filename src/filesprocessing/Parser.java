package filesprocessing;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public static final String ORDER = "ORDER";
    public static final String FILTER = "FILTER";
    public static final String NO_FILTER_SUB = "missing filter sub-section";
    public static final String NO_ORDER_SUB = "missing order sub-section";
    public static final String DEFAULT_FILTER = "all";
    public static final String DEFAULT_ORDER = "abs";


    public void Parse(File commandFile, ArrayList<Section> sections) throws Type2Error {
        try {
            int lines = 0;

            // count how many lines the file has
            FileReader read = new FileReader(commandFile);
            BufferedReader count = new BufferedReader(read);
            while (count.readLine() != null) {
                lines++;
            }
            count.close();

            FileReader toRead = new FileReader(commandFile);
            BufferedReader buf = new BufferedReader(toRead);
            String line = buf.readLine();
            int lineCounter = 1;
            String filterDetails, orderDetails;
            int filterRow, orderRow;
            boolean filterWarning = false;
            boolean orderWarning = false;
            Scanner scanner = new Scanner(commandFile);
            if (!scanner.hasNext()) {
                throw new Type2Error("command file is empty");
            }

            while (line != null) {
                if (!line.equals(FILTER)) {
                    throw new Type2Error(NO_FILTER_SUB);

                }
                line = buf.readLine();
                lineCounter++;
                if (line == null) {
                    throw new Type2Error(NO_FILTER_SUB);
                }
                if (line.isEmpty()) {
                    filterRow = lineCounter;
                    filterWarning = true;
                    filterDetails = DEFAULT_FILTER;
                    line = buf.readLine();
                    lineCounter++;

                } else {
                    filterDetails = line;
                    filterRow = lineCounter;
                    line = buf.readLine();
                    lineCounter++;
                }

                if (line == null || !line.equals(ORDER)) {   /// to check
                    throw new Type2Error(NO_ORDER_SUB);

                }
                line = buf.readLine();
                lineCounter++;
                if (line == null || line.equals(FILTER)) {
                    orderRow = lineCounter - 1;
                    orderWarning = true;
                    orderDetails = DEFAULT_ORDER;
                } else if (line.isEmpty()) {
                    orderRow = lineCounter - 1;
                    orderWarning = true;
                    orderDetails = DEFAULT_ORDER;
                    line = buf.readLine();
                    lineCounter++;
                } else {
                    orderDetails = line;
                    orderRow = lineCounter;
                    line = buf.readLine();
                    lineCounter++;
                }

                sections.add(new Section(filterDetails, orderDetails, filterRow, orderRow,
                        filterWarning, orderWarning));
                filterWarning = false;
                orderWarning = false;


                if (line == null) break;

                    /* if the first line of the section is not FILTER */
                else if (!line.equals(FILTER)) throw new Type2Error(NO_FILTER_SUB);
            }
        } catch (IOException e) {
            throw new Type2Error();
        }
    }
}
