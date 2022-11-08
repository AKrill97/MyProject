package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends Menu {
    @FindBy(xpath = ".//div[@class='web-tables-wrapper']")
    private WebElement webTable;
    @FindBy(xpath = ".//button[@id='addNewRecordButton']")
    private WebElement addNewRecordButton;
    @FindBy(xpath = ".//form[@id='userForm']")
    private WebElement newRecordForm;
    @FindBy(xpath = ".//input[@id='firstName']")
    private WebElement firstNameInput;
    @FindBy(xpath = ".//input[@id='lastName']")
    private WebElement lastNameInput;
    @FindBy(xpath = ".//input[@id='userEmail']")
    private WebElement emailInput;
    @FindBy(xpath = ".//input[@id='age']")
    private WebElement ageInput;
    @FindBy(xpath = ".//input[@id='salary']")
    private WebElement salaryInput;
    @FindBy(xpath = ".//input[@id='department']")
    private WebElement departmentInput;
    @FindBy(xpath = ".//button[@id='submit']")
    private WebElement submitButton;

    private String deleteButtonInRow = ".//div[text()='%s']//..//span[@title='Delete']";

    public WebTablesPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "webtables";
    }

    public WebTablesPage checkIsRedirectToWebTablesPage() {
        checkUrl();
        Assert.assertTrue("Page does not loaded", webTable.isDisplayed());
        return this;
    }

    public void clickOnAddNewRecordButton() {
        clickOnElement(addNewRecordButton);
        Assert.assertTrue("Message ", newRecordForm.isDisplayed());
    }

    public void enterTextsIntoNewRecordFormFields(String firstName, String lastName, String email, String age, String salary, String department) {
        enterTextIntoElement(firstNameInput, firstName);
        enterTextIntoElement(lastNameInput, lastName);
        enterTextIntoElement(emailInput, email);
        enterTextIntoElement(ageInput, age);
        enterTextIntoElement(salaryInput, salary);
        enterTextIntoElement(departmentInput, department);
    }

    public void submitNewRecord() {
        clickOnElement(addNewRecordButton);
    }

    public WebTablesPage createNewRecordInTable(String firstName, String lastName, String email, String age, String salary, String department) {
        clickOnAddNewRecordButton();
        enterTextsIntoNewRecordFormFields(firstName, lastName, email, age, salary, department);
        submitNewRecord();
        return this;
    }

    public WebTablesPage checkRecordInTable(String firstName) {
        Assert.assertTrue("Message ", findRecordByFirstName(firstName).isDisplayed());
        return this;
    }

    public WebElement findRecordByFirstName(String firstName) {
        return webDriver.findElement(By.xpath(".//div[text()='" + firstName + "']"));
    }

    public WebTablesPage deleteRowByFirstName(String firstName) {
        clickOnElement(String.format(deleteButtonInRow, firstName));

        return this;
    }



}
