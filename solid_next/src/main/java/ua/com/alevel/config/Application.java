package ua.com.alevel.config;

public class Application {

    public static ApplicationContext start(String packageToScan) {
        JavaApplicationConfiguration javaApplicationConfiguration = new JavaApplicationConfiguration(packageToScan);
        ApplicationContext context = new ApplicationContext(javaApplicationConfiguration);
        ObjectFactory objectFactory = new ObjectFactory(context);
        context.setObjectFactory(objectFactory);
        return context;
    }
}
