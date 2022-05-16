package net.brac.web.fluentlenium.util.enums;

public enum Status {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected"),
    ACTIVE("active"),
    DISBURSED("Disbursed");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
