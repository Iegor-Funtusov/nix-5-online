package ua.com.alevel;

// S - SRP
// O - OCP
// L - LSP
// I - ISP
// D - DIP

public class SolidMain {

    public static void main(String[] args) {

        String pathToFile = AppConfig.getInstance().getPathToFile();
        String pathToFilebackup = AppConfig.getInstance().getPathToFilebackup();

        String text = new ConsoleWriter().getTextByUserInput();

        new AppFileWriter().writeToFile(text, pathToFile);
        new AppFileWriter().writeToFile(text, pathToFilebackup);
    }
}
