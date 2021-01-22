package filesprocessing.Filters;

import java.io.File;

public class SmallerThanFilter extends SizeFilter implements Filter {
    public static final int ZERO = 0;

    public SmallerThanFilter(double bound) throws NegativeBoundException {
        super(bound);
    }

    @Override
    public boolean isPass(File f) {
        return f.length() < this.getBound();
    }

}
