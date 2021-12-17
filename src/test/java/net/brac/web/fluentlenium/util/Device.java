package net.brac.web.fluentlenium.util;

import java.awt.*;

public enum Device {
    DESKTOP(1250, 350);

    private int width;
    private int height;

    Device(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimension getScreenSize() {
        return new Dimension(width, height);
    }
}
