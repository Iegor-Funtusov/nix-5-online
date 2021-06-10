package ua.com.alevel.config;

import org.reflections.Reflections;

public interface ApplicationConfiguration {

    <I> Class<? extends I> getImplementation(Class<I> type);
    Reflections getScanner();
}
