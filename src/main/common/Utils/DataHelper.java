package common.Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataHelper {
    private final Locale locale = new Locale("en");
    private final Faker faker = new Faker(locale);

    public static DataHelper getData(){
        return new DataHelper();
    }
    public String getFirstName(){
        return faker.address().firstName();
    }
    public String getLastName(){
        return faker.address().firstName();
    }
    public String getPassword(){
        return faker.internet().password(6,18);
    }
    public String getUseName(){
        return faker.address().firstName();
    }
}
