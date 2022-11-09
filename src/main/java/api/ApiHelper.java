package api;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());

    public PrivatApiDTO[] getExchangeRatesFromAPI() {
        return given().contentType(ContentType.JSON)
                    .queryParam("exchange")
                    .queryParam("json")
                    .queryParam("coursid", 5)
               .when()
                    .get("https://api.privatbank.ua/p24api/pubinfo")
               .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response().as(PrivatApiDTO[].class);
    }

    public float parseRateByCurrency(String currency) {
        PrivatApiDTO[] listOfRates = getExchangeRatesFromAPI();
        float rate = 0;
        for (PrivatApiDTO s : listOfRates) {
            if (s.getBuy().equalsIgnoreCase(currency)) {
                rate = Float.parseFloat(s.getBuy());
                break;
            }
        }
        logger.info(String.format("Currency %s, rate = %s", currency, rate));
        return rate;
    }
}
