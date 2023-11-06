public class Configuration {
    public static final String URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_URI = URL + "/login";
    public static final String REGISTER_URI = URL + "/register";
    public static final String RECOVER_PASSWORD_URI = URL + "/forgot-password";
    public static final String PERSONAL_ACCOUNT_URI = URL + "/account/profile";
    public static final int DEFAULT_TIMEOUT = 10;

    //Драйвера. Хранятся в проекте.
    public static final String CHROME_DRIVER = "src/test/resources/chromedriver";
    public static final String YANDEX_DRIVER = "src/test/resources/yandexdriver";

    //Бинарники браузера. Указан локальный путь.
    public static final String CHROME_BINARY  = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";
    public static final String YANDEX_BINARY = "/Applications/Yandex.app/Contents/MacOS/Yandex";

}


