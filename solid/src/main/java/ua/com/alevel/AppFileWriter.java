package ua.com.alevel;

import java.io.FileWriter;
import java.io.IOException;

public class AppFileWriter {

    public void writeToFile(String text, String pathToFile) {
        if (text != null) {
            try (FileWriter fileWriter = new FileWriter(pathToFile)) {
                fileWriter.write(text);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
