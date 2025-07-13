package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {

    @Mock
    private GeoService geoService;

    @Mock
    private LocalizationService localizationService;

    @InjectMocks
    private MessageSenderImpl messageSender;

    @Test
    void send_shouldReturnRussianText_forRussianIp() {
        String russianIp = "172.123.12.19";
        Location russianLocation = new Location("Moscow", Country.RUSSIA, null, 0);
        Mockito.when(geoService.byIp(russianIp)).thenReturn(russianLocation);

        String russianText = "Добро пожаловать";
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn(russianText);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, russianIp);

        String result = messageSender.send(headers);

        Assertions.assertEquals(russianText, result);
    }

    @Test
    void send_shouldReturnEnglishText_forAmericanIp() {
        String americanIp = "96.44.183.149";
        Location americanLocation = new Location("New York", Country.USA, null, 0);
        Mockito.when(geoService.byIp(americanIp)).thenReturn(americanLocation);

        String englishText = "Welcome";
        Mockito.when(localizationService.locale(Country.USA)).thenReturn(englishText);

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, americanIp);

        String result = messageSender.send(headers);

        Assertions.assertEquals(englishText, result);
    }
}