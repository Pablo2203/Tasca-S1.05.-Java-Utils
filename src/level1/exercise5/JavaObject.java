package level1.exercise5;

import java.io.Serializable;

public class JavaObject implements Serializable {
    private static final long serialVersionUID = 1L;

    private String path;
    private int level;

    public JavaObject(String path, int level) {
        this.path = path;
        this.level = level;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}