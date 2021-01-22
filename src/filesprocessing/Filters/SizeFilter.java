package filesprocessing.Filters;

import filesprocessing.Type1Error;

public abstract class SizeFilter implements Filter {
    public final static double K = 1024;

    private double upperBound;
    private double lowerBound;
    private double bound;

    public SizeFilter(double lowerBound, double upperBound) throws FilterException {
        if (lowerBound < SmallerThanFilter.ZERO || upperBound < SmallerThanFilter.ZERO) {
            throw new NegativeBoundException();
        }
        if (lowerBound > upperBound) {
            throw new BetweenException();
        } else {
            this.upperBound = upperBound * K;
            this.lowerBound = lowerBound * K;
        }
    }

    public SizeFilter(double bound) throws NegativeBoundException {
        if (bound < SmallerThanFilter.ZERO) {
            throw new NegativeBoundException();
        } else {
            this.bound = bound * K;
        }
    }

    public double getBound() {
        return bound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public double getLowerBound() {
        return lowerBound;
    }
}
