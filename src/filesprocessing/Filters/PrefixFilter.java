package filesprocessing.Filters;

import java.io.File;

public class PrefixFilter extends NameFilter implements Filter {

    public PrefixFilter(String name) {
        super(name);
    }

    @Override
    public boolean isPass(File f) {
        return f.getName().startsWith(this.getName());
    }
}
