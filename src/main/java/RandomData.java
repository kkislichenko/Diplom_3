import api.UserRegistration;
import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomData {
    public static String randomEmail(){
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().emailAddress();
        //return (RandomStringUtils.randomAlphanumeric(10, 12)) + "@yandex.ru";
    }
    public static UserRegistration randomUserRegistration(){
        //return new UserRegistration((RandomStringUtils.randomAlphanumeric(10, 12)) + "@yandex.ru", "UserAutotestPassword", "UserAutotestName");
        return new UserRegistration(randomEmail(), "UserAutotestPassword", "UserAutotestName");
    }
}
