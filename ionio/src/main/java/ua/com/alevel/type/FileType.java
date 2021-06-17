package ua.com.alevel.type;

public enum FileType {

    FILE_TYPE("test.txt"),
    FILE_OUT_TYPE("out.txt"),
    DIR_TYPE("test"),
    DIRS_TYPE("test/test1/test2"),
    OUT_TYPE("user.out");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
