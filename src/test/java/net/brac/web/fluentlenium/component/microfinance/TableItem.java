package net.brac.web.fluentlenium.component.microfinance;

import net.brac.web.fluentlenium.component.BaseComponent;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

public abstract class TableItem extends BaseComponent {
    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public TableItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    public String getMemberName() {
        return el("td[aria-describedby$='_memberName']").text().trim();
    }

    public String getErpMemberNumber() {
        return el("td[aria-describedby$='_member_no']").text().trim();
    }

    public String getMemberNumber() {
        return el("td[aria-describedby$='_referenceNo']").text().trim();
    }
}
