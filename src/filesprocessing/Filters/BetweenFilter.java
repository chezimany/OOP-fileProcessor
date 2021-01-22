package filesprocessing.Filters;

import filesprocessing.Type1Error;

import java.io.File;

public class BetweenFilter extends SizeFilter implements Filter {


    public BetweenFilter(double lowerBound, double upperBound) throws FilterException {
        super(lowerBound, upperBound);
    }

    @Override
    public boolean isPass(File f) {
        double size = f.length();
        return size <= this.getUpperBound() && size >= this.getLowerBound();
    }

}
