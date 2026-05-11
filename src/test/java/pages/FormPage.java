package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class FormPage extends BasePage {

        WebDriver driver;

        public FormPage(WebDriver driver) {

            super(driver);
            this.driver = driver;

            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "firstName")
        WebElement firstName;

        @FindBy(id = "lastName")
        WebElement lastName;

        @FindBy(id = "userEmail")
        WebElement email;

        @FindBy(xpath = "//label[text()='Male']")
        WebElement maleRadio;

        @FindBy(xpath = "//label[text()='Sports']")
        WebElement sportsCheckbox;

        @FindBy(id = "userNumber")
        WebElement mobile;

        @FindBy(id = "submit")
        WebElement submitBtn;

        @FindBy(id = "name")
        WebElement successMessage;

        public void enterFirstName(String fname) {

            waitForElement(firstName);
            firstName.sendKeys(fname);
        }

        public void enterLastName(String lname) {
            lastName.sendKeys(lname);
        }

        public void enterEmail(String mail) {
            email.sendKeys(mail);
        }

        public void selectGender() {
            maleRadio.click();
        }

        public void selectSports() {
            sportsCheckbox.click();
        }

        public void enterMobile(String number) {
            mobile.sendKeys(number);
        }

        public void clickSubmit() {

            ((JavascriptExecutor)driver)
                    .executeScript("arguments[0].click();", submitBtn);
        }

        public boolean isSubmissionSuccessful() {

            return successMessage.isDisplayed();
        }

        public boolean isRadioSelected() {

            return maleRadio.isSelected();
        }

        public boolean isCheckboxSelected() {

            return sportsCheckbox.isSelected();
        }
    }

