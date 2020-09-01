package dataProviders;

import org.testng.annotations.DataProvider;

public class LanguageDataProvider {
    @DataProvider
    public static Object[][] languageDataProvider() {
        return new Object[][]{
                {"EN", "\"ENGLISH\""},
                {"DE", "\"GERMAN\""},
                {"RO", "\"ROMANIAN\""},
                {"IT", "\"ITALIAN\""},
                {"FR", "\"FRENCH_BELGIUM\""},
                {"NL", "\"DUTCH\""}
        };
    }
}
