package net.brac.web.fluentlenium.test;


import net.brac.web.fluentlenium.util.Credential;
import net.brac.web.fluentlenium.util.CredentialException;
import net.brac.web.fluentlenium.util.CredentialStore;
import net.brac.web.fluentlenium.util.Device;
import org.apache.commons.lang3.StringUtils;
import org.fluentlenium.adapter.testng.FluentTestNg;
import org.fluentlenium.core.FluentPage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BaseTest extends FluentTestNg {
    private static final String DEFAULT_CREDENTIALS_FILE = "credentials.properties";

    private static final String DEFAULT_ERP_CREDENTIAL = "default.erp";

    private static final String KEY_SUFFIX_BASE_URL = ".baseUrl";
    private static final String KEY_SUFFIX_USERNAME = ".username";
    private static final String KEY_SUFFIX_PASSWORD = ".password";
    private static final String KEY_SUFFIX_OFFICE_CODE = ".officeCode";

    protected Credential loadCredential(String name) {
        CredentialStore store = CredentialStore.instance();
        if (store.isNotPopulated()){
            populateCredentialStore();
        }
        String baseUrl = store.get(name + KEY_SUFFIX_BASE_URL);
        String username = store.get(name + KEY_SUFFIX_USERNAME);
        String password = store.get(name + KEY_SUFFIX_PASSWORD);
        String officeCode = store.get(name + KEY_SUFFIX_OFFICE_CODE);
        if (StringUtils.isNotBlank(baseUrl)) {
            return new Credential(baseUrl, username, password, officeCode);
        }
        throw new CredentialException("Credential with name: '" + name + "' not found");
    }

    protected Credential erpCredential() {
        return loadCredential(DEFAULT_ERP_CREDENTIAL);
    }

    private void populateCredentialStore() {
        try {
            Properties properties = new Properties();
            properties.load(credentialsInputStream());
            CredentialStore store = CredentialStore.instance();
            properties.forEach((key, value) -> store.put(key.toString(), value.toString()));
            store.setPopulated(true);
        } catch (IOException e) {
            throw new CredentialException("Unable to load credentials from file", e);
        }
    }
    private InputStream credentialsInputStream() throws FileNotFoundException {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_CREDENTIALS_FILE);
    }

    public <P extends FluentPage> P goT0(P page, String baseUrl) {
        if (StringUtils.isNotBlank(page.getUrl())) {
            super.setBaseUrl(baseUrl);
        }
        return goTo(page);
    }
    private Device getTargetDevice() {
        return Device.DESKTOP;
    }
}
