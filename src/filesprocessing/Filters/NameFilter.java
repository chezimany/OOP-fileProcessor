package filesprocessing.Filters;

public abstract class NameFilter implements Filter{

    private String name;

    public NameFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
