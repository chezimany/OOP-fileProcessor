package filesprocessing.Filters;

import java.io.File;

public class ContainsFilter extends NameFilter implements Filter {

    public ContainsFilter(String name) {
        super(name);
    }

    @Override
    public boolean isPass(File f) {
        return f.getName().contains(this.getName());
    }
}
