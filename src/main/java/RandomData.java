import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomEmail(){
        return (RandomStringUtils.randomAlphanumeric(10, 12)) + "@yandex.ru";
    }
}
