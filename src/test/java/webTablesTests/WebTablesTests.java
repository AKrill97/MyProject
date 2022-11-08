package webTablesTests;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Test;
import pages.WebTablesPage;

public class WebTablesTests extends BaseTest {
    WebTablesPage webTablesPage = new WebTablesPage(webDriver);
    String firstName = "qwerty";
    String lastName = "123456";
    String email = "test@test.test";
    String age = "25";
    String salary = "2500";
    String department = "AQA";


    @Test
    public void createNewRow() {
        homePage.openHomePage()
                .isHomePageOpened()
                .clickOnElementsButton()
                .openWebTablesPage()
                .checkIsRedirectToWebTablesPage()
                .createNewRecordInTable(firstName,lastName, email, age, salary, department)
        ;
    }

    @After
    public void findAndDeleteRow() {
        webTablesPage.deleteRowByFirstName(firstName);
    }
}
