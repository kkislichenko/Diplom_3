package page.object;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvoirmentConfiguration {
    public static final int DEFAULT_TIMEOUT = 10;
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_URI = URL + "/login";
    public static final String REGISTER_URI = URL + "/register";
    public static final String RECOVER_PASSWORD_URI = URL + "/forgot-password";
    public static final String PERSONAL_ACCOUNT_URI = URL + "/account/profile";
}
