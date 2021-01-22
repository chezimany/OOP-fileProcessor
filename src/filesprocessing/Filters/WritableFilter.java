package filesprocessing.Filters;

import java.io.File;

public class WritableFilter extends YesNoFilters implements Filter {

    public static final String NO = "NO";

    public WritableFilter(String yesNo) throws YesNoException {
        super(yesNo);
    }

    @Override
    public boolean isPass(File f) {
        if (this.getYesNo().equals(NO)) {
            return !f.canWrite();
        }
        return f.canWrite();
    }
}
