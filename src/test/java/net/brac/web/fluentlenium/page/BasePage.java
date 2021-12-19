package net.brac.web.fluentlenium.page;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public abstract class BasePage extends FluentPage {
    private static final String ELEMENT_ID = "class";
    private static final String TAG_BODY = "body";
    public static final String PAGE_ID = "login";
    private static final String CLASS_ALERT_SUCCESS = ".success";
    static public final int TIME_OUT_DURATION = 320;

    private static final String CLASS_FORM_ERROR = ".error";

    public abstract String getPageId();

    public String currentPageId() {
        return el(TAG_BODY).attribute(ELEMENT_ID);
    }

    public boolean hasAlertSuccess() {
        return find(CLASS_ALERT_SUCCESS).count() > 0;
    }

    protected int waitForBlockOverlayForWaitLoading() {
        FluentList<FluentWebElement> fluentWebElements = find("div.blockUI.blockOverlay");
        boolean hasFluentWebElement = fluentWebElements.count() > 0;
        int iteration = 0;
        while (hasFluentWebElement && (iteration < 500)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iteration = iteration + 1;
            hasFluentWebElement = fluentWebElements.count() > 0;
        }
        return iteration;
    }

    public void waitForBlockOverlay() {
        waitForLoading(find("div.blockUI.blockOverlay"));
    }

    protected int waitForLoading(FluentList<FluentWebElement> fluentWebElements) {
        boolean hasFluentWebElement = fluentWebElements.count() > 0;
        int iteration = 0;
        while (hasFluentWebElement && (iteration < 500)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iteration = iteration + 1;
            hasFluentWebElement = fluentWebElements.count() > 0;
        }
        return iteration;
    }

    public boolean hasFormError() {
        return find(CLASS_FORM_ERROR).count() > 0;
    }

    public boolean hasText(String text) {
        FluentList<FluentWebElement> fluentWebElements = find(By.xpath("//div[contains(text(),'" + text + "')]"));
        await().atMost(TIME_OUT_DURATION, TimeUnit.SECONDS).until(fluentWebElements).size().greaterThanOrEqualTo(1);
        return fluentWebElements.count() > 0;
    }

    public void hasBlockPageImage() {
        waitForLoading(find("div.blockUI.blockPage img"));
    }
    public void hasFancyBoxOverlay() {
        waitForLoading(find("div#fancybox-overlay"));
    }
}