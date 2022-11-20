package api;

import io.restassured.http.ContentType;
import libs.TestData;
import org.apache.log4j.Logger;
import org.junit.Assert;

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

    public void parseExchangeRatesByCurrencyAndSaveInLocalStorage(PrivatApiDTO[] response, String currency) {
        for (PrivatApiDTO privatApiDTO : response) {
            if (privatApiDTO.getCcy().equalsIgnoreCase(currency)) {
                TestData.exchangeBuyCurseFromAPI = Float.parseFloat(privatApiDTO.getBuy());
                TestData.exchangeSaleCurseFromAPI = Float.parseFloat(privatApiDTO.getSale());
                break;
            }
        }

        logger.info(String.format("Currency %s, buy rate = %s, sale rate = %s",
                currency, TestData.exchangeBuyCurseFromAPI, TestData.exchangeSaleCurseFromAPI));
    }
}
