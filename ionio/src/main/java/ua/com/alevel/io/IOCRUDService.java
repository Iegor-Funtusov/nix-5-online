package ua.com.alevel.io;

import org.apache.commons.io.FileUtils;
import ua.com.alevel.CRUDService;

import java.io.File;
import java.io.IOException;

public class IOCRUDService implements CRUDService {

    @Override
    public void createFile(String path) {
        File file = new File(path);
        if (path.startsWith(".")) {
            setHiddenAttrib(file);
        }
        String absolutePath = file.getAbsolutePath();
        String path1 = file.getPath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("path1 = " + path1);
        boolean isFile = false;
        try {
            boolean newFile = file.createNewFile();
            System.out.println("newFile = " + newFile);
            isFile = file.isFile();
            System.out.println("isFile = " + isFile);
            boolean hidden = file.isHidden();
            System.out.println("hidden = " + hidden);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDir(String path) {
        File file = new File(path);
        boolean mkdir = file.mkdir();
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("file = " + file.isDirectory());
        System.out.println("mkdir = " + mkdir);
    }

    @Override
    public void createDirs(String path) {
        File file = new File(path);
        boolean mkdir = file.mkdirs();
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath = " + absolutePath);
        System.out.println("file = " + file.isDirectory());
        System.out.println("mkdir = " + mkdir);
    }

    @Override
    public void readDirs(String path) {
        read(new File(path));
    }

    @Override
    public void deleteDirs(String path) {
        File file = new File(path);
//        delete(file);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(String path) {
        File file = new File(path);
        boolean delete = file.delete();
        System.out.println("delete = " + delete);
    }

    private void delete(File fileDir) {
        File[] files = fileDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                delete(file);
            } else {
                file.delete();
            }
        }
    }

    private void read(File fileDir) {
        File[] files = fileDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("dir = " + file);
                read(file);
            } else {
                System.out.println("file = " + file);
            }
        }
    }

    // only for windows
    private static void setHiddenAttrib(File file) {
        try {
            Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
            p.waitFor();
            if (file.isHidden()) {
                System.out.println(file.getName() + " hidden attribute is set to true");
            } else {
                System.out.println(file.getName() + " hidden attribute not set to true");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
