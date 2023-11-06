package page.object;

public class EnvoirmentConfiguration {
    public static final int DEFAULT_TIMEOUT = 10;

    public static final String URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_URI = URL + "/login";
    public static final String REGISTER_URI = URL + "/register";
    public static final String RECOVER_PASSWORD_URI = URL + "/forgot-password";
    public static final String PERSONAL_ACCOUNT_URI = URL + "/account/profile";

    //Драйвера. Хранятся в проекте.
    public static final String CHROME_DRIVER = System.getProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
    public static final String YANDEX_DRIVER = System.getProperty("webdriver.yandex.driver", "src/test/resources/yandexdriver");
    public static final String FIREFOX_BINARY = System.getProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");

    //Бинарники браузера. Указан локальный путь.
    public static final String CHROME_BINARY = System.getProperty("webdriver.chrome.binary","/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
    public static final String YANDEX_BINARY = System.getProperty("webdriver.yandex.binary", "/Applications/Yandex.app/Contents/MacOS/Yandex");
    public static final String FIREFOX_DRIVER = System.getProperty("webdriver.gecko.binary", "/Applications/Firefox.app/Contents/MacOS/firefox");
}
