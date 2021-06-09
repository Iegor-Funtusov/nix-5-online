package ua.com.alevel.config;

public enum AppProps {

    CONFIG("config.properties");

    AppProps(String resource) {
        this.resource = resource;
    }

    private final String resource;

    public String getResource() {
        return resource;
    }
}
