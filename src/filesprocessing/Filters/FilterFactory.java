package filesprocessing.Filters;

import filesprocessing.Type1Error;

public class FilterFactory {

    public static final int ONE = 1;
    public static final int ZERO = 0;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final String NOT = "NOT";
    public static final String HASH = "#";

    /**
     * creates a filter matching the given string
     *
     * @param filterDetails - details of the filter
     * @return a filter
     * @throws Type1Error
     */
    public Filter createFilter(String filterDetails) throws FilterException {
        String[] details = filterDetails.split(HASH);
        String last = details[details.length - ONE];
        String name = details[ZERO];
        Filter filter;
        switch (name) {
            case "all":
                if (details.length == ONE) {
                    filter = new AllFilter();
                } else {
                    if (last.equals(NOT)) {
                        Filter neg = new AllFilter();
                        filter = new NegFilter(neg);
                    } else {
                        throw new FilterParameterException();
                    }
                }
                return filter;
            case "greater_than":
                double bound = Double.parseDouble(details[ONE]);
                try {
                    if (details.length == TWO) {
                        filter = new GreaterThanFilter(bound);
                    } else {
                        if (last.equals(NOT) && details.length == 3) {
                            GreaterThanFilter neg = new GreaterThanFilter(bound);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (NegativeBoundException e) {
                    throw e;
                }
                return filter;
            case "between":
                try {
                    double lower = Double.parseDouble(details[ONE]);
                    double upper = Double.parseDouble(details[TWO]);
                    if (details.length == THREE) {
                        filter = new BetweenFilter(lower, upper);
                    } else {
                        if (last.equals(NOT)) {
                            BetweenFilter neg = new BetweenFilter(lower, upper);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (NegativeBoundException e) {
                    throw e;
                }
                return filter;
            case "smaller_than":
                try {
                    bound = Double.parseDouble(details[ONE]);
                    if (details.length == TWO) {
                        filter = new SmallerThanFilter(bound);
                    } else {
                        if (last.equals(NOT) && details.length == 3) {
                            SmallerThanFilter neg = new SmallerThanFilter(bound);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (NegativeBoundException e) {
                    throw e;
                }
                return filter;
            case "file":
                if (details.length == TWO) {
                    filter = new FileFilter(details[ONE]);
                } else {
                    if (last.equals(NOT)) {
                        FileFilter neg = new FileFilter(details[ONE]);
                        filter = new NegFilter(neg);
                    } else {
                        throw new FilterParameterException();
                    }
                }
                return filter;
            case "contains":
                if (details.length == TWO) {
                    filter = new ContainsFilter(details[ONE]);
                } else {
                    if (last.equals(NOT)) {
                        ContainsFilter neg = new ContainsFilter(details[ONE]);
                        filter = new NegFilter(neg);
                    } else {
                        throw new FilterParameterException();
                    }
                }
                return filter;
            case "prefix":
                if (details.length == TWO) {
                    filter = new PrefixFilter(details[ONE]);
                } else {
                    if (last.equals(NOT)) {
                        PrefixFilter neg = new PrefixFilter(details[ONE]);
                        filter = new NegFilter(neg);
                    } else {
                        throw new FilterParameterException();
                    }
                }
                return filter;
            case "suffix":
                if (details.length == TWO) {
                    filter = new SuffixFilter(details[ONE]);
                } else {
                    if (last.equals(NOT)) {
                        SuffixFilter neg = new SuffixFilter(details[ONE]);
                        filter = new NegFilter(neg);
                    } else {
                        throw new FilterParameterException();
                    }
                }
                return filter;
            case "writable":
                try {
                    if (details.length == TWO) {
                        filter = new WritableFilter(details[ONE]);
                    } else {
                        if (details.length == FilterFactory.THREE && last.equals(NOT)) {
                            WritableFilter neg = new WritableFilter(details[ONE]);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (YesNoException e) {
                    throw e;
                }
                return filter;
            case "executable":
                try {
                    if (details.length == TWO) {
                        filter = new ExecutableFilter(details[ONE]);
                    } else {
                        if (last.equals(NOT)) {
                            ExecutableFilter neg = new ExecutableFilter(details[ONE]);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (YesNoException e) {
                    throw e;
                }
                return filter;
            case "hidden":
                try {
                    if (details.length == TWO) {
                        filter = new HiddenFilter(details[ONE]);
                    } else {
                        if (last.equals(NOT)) {
                            HiddenFilter neg = new HiddenFilter(details[ONE]);
                            filter = new NegFilter(neg);
                        } else {
                            throw new FilterParameterException();
                        }
                    }
                } catch (YesNoException e) {
                    throw e;
                }
                return filter;
            default:
                throw new FilterParameterException();
        }
    }
}
