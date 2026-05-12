package com.krce.tests;

import com.krce.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test(priority = 1)
    public void validFormTest() {

        FormPage form = new FormPage(driver);

        form.openPage();

        form.setName();
        form.setEmail();
        form.setGender();
        form.setNumber();
        form.setDob();
        form.setSubjects();
        form.setHobbies();
        form.setPictures();
        form.setAddress();
        form.setStateCity();

        form.submit();

        Assert.assertTrue(form.successMessage(), "Form submission failed!");
    }

    @Test(priority = 2)
    public void emptyMandatoryFieldsTest() {

        FormPage form = new FormPage(driver);

        form.clickForm();
        form.clickPractiseForm();

        form.submit();

        Assert.assertFalse(
                form.isSuccessPopupDisplayed(),
                "Form should NOT submit with empty mandatory fields"
        );
    }
}