package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplTest {
    @Test
    void locale_shouldReturnRussianText_forRussia() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals("Добро пожаловать", localizationService.locale(Country.RUSSIA));
    }

    @Test
    void locale_shouldReturnWelcome_forUsa() {
        LocalizationService localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals("Welcome", localizationService.locale(Country.USA));
    }
}