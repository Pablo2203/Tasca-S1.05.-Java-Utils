package exercise1.model;

import java.io.Serializable;

public class JavaObject implements Serializable {
    private static final long serialVersionUID = 1L; // Recomendado para identificar la versión de la clase

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