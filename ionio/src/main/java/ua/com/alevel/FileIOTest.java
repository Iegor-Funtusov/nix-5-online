package ua.com.alevel;

import ua.com.alevel.type.FileType;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileIOTest {

    public void test() {
        try (
                BufferedReader reader = new BufferedReader(new FileReader(FileType.FILE_TYPE.getPath()));
                BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.FILE_OUT_TYPE.getPath(), true));
                BufferedReader reader1 = new BufferedReader(new FileReader(FileType.FILE_OUT_TYPE.getPath()))
        ) {
            String input = reader.readLine();
            System.out.println("input = " + input);
//            writer.append("\n");
//            writer.append(input);
            String input1 = reader1.readLine();
            System.out.println("input1 = " + input1);

            Path path = Paths.get(FileType.FILE_OUT_TYPE.getPath());
            List<String> out = Files.readAllLines(path);
            System.out.println("out = " + out);

            String in = "l'kdf'lgkjdsfag;";
            path = Paths.get("new_out.txt");
            byte[] bytes = in.getBytes();
            Files.write(path, "\n".getBytes(), StandardOpenOption.APPEND);
            Files.write(path, bytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
