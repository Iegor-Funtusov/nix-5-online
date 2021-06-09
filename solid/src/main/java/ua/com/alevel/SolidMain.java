package ua.com.alevel;

// S - SRP
// O - OCP
// L - LSP
// I - ISP
// D - DIP

import ua.com.alevel.config.AppConfig;
import ua.com.alevel.writer.AppFileWriter;
import ua.com.alevel.writer.ConsoleWriter;

import java.util.Collection;

public class SolidMain {

    public static void main(String[] args) {

        Collection<String> paths = AppConfig.getInstance().getPaths();

        String text = new ConsoleWriter().getTextByUserInput();

        for (String path : paths) {
            new AppFileWriter().writeToFile(text, path);
        }
    }
}


//        List<String> paths = Arrays.asList(
//                AppConfig.getInstance().getPathToFile(),
//                AppConfig.getInstance().getPathToFilebackup(),
//                AppConfig.getInstance().getPathToFilebackup1()
//        );
