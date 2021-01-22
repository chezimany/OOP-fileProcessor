package filesprocessing.Filters;
import filesprocessing.Type1Error;

import java.io.File;

public interface Filter {

    /**
     * checks if a given file passes the filters conditions.
     * @param f - file to check.
     * @return - true if passed, false otherwise.
     */
    boolean isPass (File f);


}
