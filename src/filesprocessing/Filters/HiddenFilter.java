package filesprocessing.Filters;

import java.io.File;

public class HiddenFilter extends YesNoFilters implements Filter {
    public HiddenFilter(String yesNo) throws YesNoException {
        super(yesNo);
    }

    @Override
    public boolean isPass(File f) {
        if (this.getYesNo().equals(WritableFilter.NO)) {
            return !f.isHidden();
        }
        return f.isHidden();
    }
}
