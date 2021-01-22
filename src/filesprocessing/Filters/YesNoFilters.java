package filesprocessing.Filters;

public abstract class YesNoFilters implements Filter {
    private String YesNo;
    private String[] legal = {"YES", "NO"};

    public YesNoFilters(String yesNo) throws YesNoException {
        if (!yesNo.equals(legal[0]) && !yesNo.equals(legal[1])) {
            throw new YesNoException();
        } else {
            YesNo = yesNo;
        }
    }

    public String getYesNo() {
        return YesNo;
    }
}
