package net.brac.web.fluentlenium.component.microfinance.loan.proposal;

import net.brac.web.fluentlenium.component.microfinance.loan.LoanItem;
import org.fluentlenium.core.FluentControl;
import org.fluentlenium.core.components.ComponentInstantiator;
import org.openqa.selenium.WebElement;

public class UnApproveLoanItem<T extends UnApproveLoanItem> extends LoanItem {

    /**
     * Creates a new fluent web element.
     *
     * @param element      underlying element
     * @param control      control interface
     * @param instantiator component instantiator
     */
    public UnApproveLoanItem(WebElement element, FluentControl control, ComponentInstantiator instantiator) {
        super(element, control, instantiator);
    }

    public T selectLoan() {
        el("td[aria-describedby$='-grid_id'] input").scrollToCenter().waitAndClick();
        return (T) this;
    }

    public T selectApprover(String approver) {
        el("select[id^='approver_']").fillSelect().withText(approver);
        return (T) this;

    }


}
