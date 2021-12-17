package net.brac.web.fluentlenium.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;
import java.util.Optional;

public enum SupportedWebDriver {

    FIREFOX("firefox", false) {
        @Override
        public Capabilities getCapabilities(Device device) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setAcceptInsecureCerts(true);
            firefoxOptions.addPreference("javascript.enabled", true);
            firefoxOptions.addArguments("-width", Integer.toString(device.getScreenSize().width), "-height", Integer.toString(device.getScreenSize().height));
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
            return capabilities;
        }
    };
    private String name;
    private boolean windowResizeRequired;

    SupportedWebDriver(String name, boolean windowResizeRequired) {
        this.name = name;
        this.windowResizeRequired = windowResizeRequired;
    }

    public String getName() {
        return name;
    }

    public boolean isWindowResizeRequired() {
        return windowResizeRequired;
    }

    public abstract Capabilities getCapabilities(Device device);

    public static Optional<SupportedWebDriver> find(String name) {
        return Arrays.stream(SupportedWebDriver.values()).filter(driver -> driver.getName().equalsIgnoreCase(name)).findFirst();
    }
}

