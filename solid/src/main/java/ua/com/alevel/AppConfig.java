package ua.com.alevel;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppConfig {

    private String pathToFile;
    private String pathToFilebackup;

    private static AppConfig instance;

    private List<String> stringPaths;

    private AppConfig() {
        init();
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public void init() {
        initFilePath();
        AppProps[] values = AppProps.values();
        for (AppProps value : values) {
            Map<String, String> map = ResourceUtil.getResource(value.getResource());
            if (map.containsKey(AppConstants.PATH_TO_FILE)) {
                pathToFile = map.get(AppConstants.PATH_TO_FILE);
            }
            if (map.containsKey(AppConstants.PATH_TO_FILE_BACKUP)) {
                pathToFilebackup = map.get(AppConstants.PATH_TO_FILE_BACKUP);
            }
        }
    }

    private void initFilePath() {
        Field[] declaredFields = this.getClass().getDeclaredFields();
        stringPaths = Arrays.stream(declaredFields)
                .map(Field::getName)
                .filter(name -> name.startsWith("pathTo"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }

    public String getPathToFile() {
        return pathToFile;
    }

    public String getPathToFilebackup() {
        return pathToFilebackup;
    }
}
