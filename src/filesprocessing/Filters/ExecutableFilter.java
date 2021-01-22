package filesprocessing.Filters;

import java.io.File;

public class ExecutableFilter extends YesNoFilters implements Filter {


    public ExecutableFilter(String yesNo) throws YesNoException {
        super(yesNo);
    }

    @Override
    public boolean isPass(File f) {
        if (this.getYesNo().equals(WritableFilter.NO)) {
            return !f.canExecute();
        }
        return f.canExecute();
    }
}
