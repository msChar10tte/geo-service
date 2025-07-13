package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class GeoServiceImplTest {
    @Test
    void byIp_shouldReturnRussia_forRussianIp() {
        GeoService geoService = new GeoServiceImpl();
        String ip = "172.10.20.30";
        Assertions.assertEquals(Country.RUSSIA, geoService.byIp(ip).getCountry());
    }

    @Test
    void byIp_shouldReturnUsa_forAmericanIp() {
        GeoService geoService = new GeoServiceImpl();
        String ip = "96.100.200.255";
        Assertions.assertEquals(Country.USA, geoService.byIp(ip).getCountry());
    }
}