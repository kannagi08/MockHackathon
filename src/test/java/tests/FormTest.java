package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {

    @DataProvider(name = "formData")
    public Object[][] getData() {

        return new Object[][] {

                {"Kannagi", "G", "kannagi@gmail.com", "9876543210"},
                {"John", "Doe", "john@gmail.com", "9876543211"}
        };
    }

    @Test(dataProvider = "formData")
    public void verifyFormSubmission(String fname,
                                     String lname,
                                     String mail,
                                     String phone) {

        FormPage form = new FormPage(driver);

        form.enterFirstName(fname);
        form.enterLastName(lname);
        form.enterEmail(mail);

        form.selectGender();

        form.selectSports();

        form.enterMobile(phone);

        form.clickSubmit();

        Assert.assertTrue(form.isSubmissionSuccessful());
    }

    @Test
    public void verifyRadioButton() {

        FormPage form = new FormPage(driver);

        form.selectGender();

        Assert.assertTrue(form.isRadioSelected());
    }

    @Test
    public void verifyCheckbox() {

        FormPage form = new FormPage(driver);

        form.selectSports();

        Assert.assertTrue(form.isCheckboxSelected());
    }

    @Test
    public void verifyMandatoryFieldError() {

        FormPage form = new FormPage(driver);

        form.clickSubmit();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("automation-practice-form"));
    }
}