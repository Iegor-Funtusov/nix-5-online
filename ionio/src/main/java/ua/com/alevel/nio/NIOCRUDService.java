package ua.com.alevel.nio;

import ua.com.alevel.CRUDService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOCRUDService implements CRUDService {

    @Override
    public void createFile(String path) {
//        Path path1;
//        Paths paths;
//        Files files;
        Path path1 = Paths.get(path);
        try {
            if (!path1.toFile().exists()) {
                Files.createFile(path1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDir(String path) {
        Path path1 = Paths.get(path);
        try {
            if (!path1.toFile().exists()) {
                Files.createDirectory(path1);
            }
//            Files.createTempDirectory(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createDirs(String path) {
        Path path1 = Paths.get(path);
        try {
            if (!path1.toFile().exists()) {
                Files.createDirectories(path1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readDirs(String path) {
        Set<String> filesPath = new LinkedHashSet<>();
        try {
            Stream<Path> pathStream = Files.walk(Paths.get(path));
            filesPath = pathStream
                    .map(p -> p.toFile().getAbsolutePath())
                    .collect(Collectors.toSet());
            for (String s : filesPath) {
                System.out.println("s = " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDirs(String path) {
        Path path1 = Paths.get(path);
        try {
            Files.deleteIfExists(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteFile(String path) {
        Path path1 = Paths.get(path);
        try {
            Files.deleteIfExists(path1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void move(String from, String to) {
        Path pathFrom = Paths.get(from);
        Path pathTo = Paths.get(to);
        try {
            Files.move(pathFrom, pathTo, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readDirs(to);
    }
}
