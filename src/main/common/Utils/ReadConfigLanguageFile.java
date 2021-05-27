package common.Utils;


import java.util.Locale;
import java.util.ResourceBundle;

public class ReadConfigLanguageFile {

    public static final ReadConfigLanguageFile CONFIG_RESOURCE = getInstance(System.getProperty("language"));
    private final ResourceBundle resourceConfig;

    private ReadConfigLanguageFile(String language) {
        System.out.println(System.getProperty("language"));
        System.out.println(language);
        Locale locale = null;
        if ("vi".equals(language)) {
            locale = new Locale("vi");
        } else if ("en".equals(language)){
            locale = Locale.ENGLISH;
        }
        resourceConfig = ResourceBundle.getBundle("language", locale);
    }

    public static ReadConfigLanguageFile getInstance(String language) {
        return new ReadConfigLanguageFile(language);
    }

    public String getValue(String key) {
        return resourceConfig.getString(key);
    }
}

