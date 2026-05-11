package com.krce.tests;

import com.krce.WebTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test(priority = 1)
    public void addRowTest() {

        WebTablePage table = new WebTablePage(driver);
        table.openPage();

        table.addRecord(
                "Kannagi",
                "Govind",
                "kannagi@gmail.com",
                "22",
                "50000",
                "QA"
        );

        Assert.assertTrue(table.isRowPresent("Kannagi"));
    }

    @Test(priority = 2)
    public void searchTest() {

        WebTablePage table = new WebTablePage(driver);
        table.openPage();

        Assert.assertTrue(table.searchRecord("Cierra"));
    }

    @Test(priority = 3)
    public void deleteTest() {

        WebTablePage table = new WebTablePage(driver);
        table.openPage();

        table.deleteRecord();

        Assert.assertFalse(table.isRowPresent("Cierra"));
    }

    @Test(priority = 4)
    public void paginationTest() {

        WebTablePage table = new WebTablePage(driver);
        table.openPage();

        String before = table.getFirstRowText();

        table.clickNextPage();

        String after = table.getFirstRowText();

        System.out.println("Before: " + before);
        System.out.println("After : " + after);

        Assert.assertNotEquals(before, after);
    }
}