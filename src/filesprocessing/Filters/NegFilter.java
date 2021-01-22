package filesprocessing.Filters;

import java.io.File;

public class NegFilter implements Filter {

    private Filter filter;

    public NegFilter(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    @Override
    public boolean isPass(File f) {
        return !this.getFilter().isPass(f);
    }
}
