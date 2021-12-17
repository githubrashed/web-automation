package net.brac.web.fluentlenium.component;

import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BaseComponent extends FluentWebElement {
    static final int TIME_OUT_DURATION = 120;

    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public BaseComponent(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

}
