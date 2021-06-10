package ua.com.alevel.config;

import java.util.Map;

public class Application {

    public static ApplicationContext start(String packageToScan, Map<Class, Class> mapImpl) {
        JavaApplicationConfiguration javaApplicationConfiguration = new JavaApplicationConfiguration(packageToScan, mapImpl);
        ApplicationContext context = new ApplicationContext(javaApplicationConfiguration);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setObjectFactory(objectFactory);
        return context;
    }
}
