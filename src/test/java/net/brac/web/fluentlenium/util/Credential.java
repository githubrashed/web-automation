package net.brac.web.fluentlenium.util;

public class Credential {

    private String baseUrl;
    private String username;
    private String password;
    private String officeCode;

    public Credential(String baseUrl, String username, String password, String officeCode) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
        this.officeCode = officeCode;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getOfficeCode() {
        return officeCode;
    }
}
