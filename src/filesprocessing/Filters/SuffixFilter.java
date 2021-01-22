package filesprocessing.Filters;

import java.io.File;

public class SuffixFilter extends NameFilter implements Filter {
    public SuffixFilter(String name) {
        super(name);
    }

    @Override
    public boolean isPass(File f) {
        return f.getName().endsWith(this.getName());
    }
}
