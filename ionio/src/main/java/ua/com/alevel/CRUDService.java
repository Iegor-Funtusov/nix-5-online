package ua.com.alevel;

public interface CRUDService {

    void createFile(String path);
    void createDir(String path);
    void createDirs(String path);
    void readDirs(String path);
    void deleteDirs(String path);
    void deleteFile(String path);
}
