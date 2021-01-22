package filesprocessing.Filters;

import java.io.File;

public class FileFilter implements Filter {

    private String name;

    public FileFilter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isPass(File f) {
        return f.getName().equals(this.getName());
    }
}
