package net.brac.web.fluentlenium.util.enums;

public enum Project {
    PROGOTI("Progoti", "2", "060");

    private String name;
    private String value;
    private String code;

    Project(String name, String value, String code) {
        this.name = name;
        this.value = value;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
    public String getCode() {
        return code;
    }
}
