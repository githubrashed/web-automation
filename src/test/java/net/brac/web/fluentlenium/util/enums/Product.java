package net.brac.web.fluentlenium.util.enums;

public enum Product {
    BD_10038("[BD-10038] General 24% Reducing (DABI)", "42"),
    BD_10072("[BD-10072] General 24,22,20 % Reducing (Progoti)", "76");

    private String name;
    private String value;

    Product(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
