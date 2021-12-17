package net.brac.web.fluentlenium.component.microfinance.loan.disbursement;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

public class DisbursedLoanItem extends LoanItem {

    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public DisbursedLoanItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    @Override
    public String getMemberNumber() {
        return el("td[aria-describedby$='_memberRefCode']").text().trim();
    }

    public String getDuration() {
        return el("td[aria-describedby$='_duration']").text().trim().replaceAll(".00", "");
    }
}
