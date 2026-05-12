package com.krce.tests;

import com.krce.pages.WidgetsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WidgetsTest extends BaseTest {

    @Test(priority = 1)
    public void datePickerTest() {

        WidgetsPage page = new WidgetsPage(driver);

        page.openDatePickerPage();

        page.selectDate();

        String date = page.getSelectedDate();

        System.out.println("Selected Date: " + date);

        Assert.assertEquals(date, "05/20/2026");

        System.out.println("DATE PICKER TEST PASSED");
    }

    @Test(priority = 2)
    public void sliderTest() {

        WidgetsPage page = new WidgetsPage(driver);

        page.openSliderPage();

        page.moveSlider();

        String value = page.getSliderValue();

        System.out.println("Slider Value: " + value);

        Assert.assertEquals(value, "70");

        System.out.println("SLIDER TEST PASSED");
    }

    @Test(priority = 3)
    public void accordionTest() {

        WidgetsPage page = new WidgetsPage(driver);

        page.openAccordionPage();

        page.clickSecondSection();

        Assert.assertTrue(page.isSecondSectionExpanded());

        System.out.println("ACCORDION TEST PASSED");
    }
}