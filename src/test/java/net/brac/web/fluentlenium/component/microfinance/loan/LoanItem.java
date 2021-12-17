package net.brac.web.fluentlenium.component.microfinance.loan;

import net.brac.web.fluentlenium.component.microfinance.TableItem;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

public class LoanItem extends TableItem {

    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public LoanItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    public String getLoanStatus() {
        return el("td[aria-describedby$='_loan_status']").text().trim();
    }

    public String getProduct() {
        return el("td[aria-describedby$='_loan_name']").text().trim();
    }

    public String getLoanAmount() {
        return el("td[aria-describedby$='_loan_amount']").text().replace(".00", "")
                .replaceAll(",", "").trim();
    }
}
