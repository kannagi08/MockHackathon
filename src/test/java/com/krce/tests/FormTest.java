package com.krce.tests;

import com.krce.FormPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {

    @Test(priority = 1)
    public void testForm() throws InterruptedException {

        FormPage form = new FormPage(driver);

        form.clickForm();
        Thread.sleep(2000);

        form.clickPractiseForm();
        Thread.sleep(2000);

        form.setName();
        Thread.sleep(2000);

        form.setEmail();
        Thread.sleep(2000);

        form.setGender();
        Thread.sleep(2000);

        form.setNumber();
        Thread.sleep(2000);

        form.setDob();
        Thread.sleep(2000);

        form.setSubjects();
        Thread.sleep(2000);

        form.setHobbies();
        Thread.sleep(2000);

        form.setPictures();
        Thread.sleep(2000);

        form.setAddress();
        Thread.sleep(2000);

        form.setStateCity();
        Thread.sleep(2000);

        form.submit();
        Thread.sleep(3000);

        Assert.assertTrue(form.successMessage());
        Assert.assertTrue(form.isGenderSelected());
        Assert.assertTrue(form.isHobbySelected());
    }

    @Test(priority = 2)
    public void emptyMandatoryFieldsTest() throws InterruptedException {

        FormPage form = new FormPage(driver);

        form.clickForm();
        Thread.sleep(2000);

        form.clickPractiseForm();
        Thread.sleep(2000);

        form.submit();
        Thread.sleep(3000);

        Assert.assertFalse(form.successMessage());
    }
}