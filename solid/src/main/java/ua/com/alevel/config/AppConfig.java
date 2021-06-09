package ua.com.alevel.config;

import ua.com.alevel.util.ResourceUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class AppConfig {

    private Collection<String> paths = new ArrayList<>();

    private static AppConfig instance;

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
        AppProps[] values = AppProps.values();
        for (AppProps value : values) {
            Map<String, String> map = ResourceUtil.getResource(value.getResource());
            paths = map.values();
        }
    }

    public Collection<String> getPaths() {
        return paths;
    }
}

//    private String pathToFile;
//    private String pathToFilebackup;
//    private String pathToFilebackup1;

//    public void init() {
//        AppProps[] values = AppProps.values();
//        for (AppProps value : values) {
//            Map<String, String> map = ResourceUtil.getResource(value.getResource());
//            Field[] declaredFields = this.getClass().getDeclaredFields();
//            for (Field declaredField : declaredFields) {
//                String fieldName = declaredField.getName().toLowerCase();
//                AppFilePath[] appFilePaths = AppFilePath.values();
//                for (AppFilePath appFilePath : appFilePaths) {
//                    String path = String.join("", appFilePath.getPath().split("\\.")).toLowerCase();
//                    if (fieldName.equals(path)) {
//                        if (map.containsKey(appFilePath.getPath())) {
//                            declaredField.setAccessible(true);
//                            try {
//                                declaredField.set(this, map.get(appFilePath.getPath()));
//                            } catch (IllegalAccessException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }