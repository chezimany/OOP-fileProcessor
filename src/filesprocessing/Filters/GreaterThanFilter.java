package filesprocessing.Filters;

import java.io.File;

public class GreaterThanFilter extends SizeFilter implements Filter {


    public GreaterThanFilter(double bound) throws NegativeBoundException {
        super(bound);
    }

    @Override
    public boolean isPass(File f) {
            return f.length() > this.getBound();

    }
}
