package ua.com.alevel.config;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JavaApplicationConfiguration implements ApplicationConfiguration {

    private final Map<Class, Class> mapImpl;
    private final Reflections scanner;

    public JavaApplicationConfiguration(String packageToScan) {
        this.mapImpl = new HashMap<>();
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <I> Class<? extends I> getImplementation(Class<I> type) {
        return mapImpl.computeIfAbsent(type, aClass -> {
            Set<Class<? extends I>> children = scanner.getSubTypesOf(type);
            return children.iterator().next();
        });
    }

    @Override
    public Reflections getScanner() {
        return this.scanner;
    }
}
