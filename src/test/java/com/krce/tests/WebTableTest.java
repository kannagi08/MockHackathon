package com.krce.tests;

import com.krce.WebTablePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test(priority = 1)
    public void addRecordTest() {

        WebTablePage table = new WebTablePage(driver);

        table.openPage();

        table.addRecord();

        Assert.assertTrue(table.isRecordAdded());

        System.out.println("ADD RECORD TEST PASSED");
    }

    @Test(priority = 2)
    public void searchRecordTest() {

        WebTablePage table = new WebTablePage(driver);

        table.openPage();

        table.searchRecord();

        Assert.assertTrue(table.isRecordFound());

        System.out.println("SEARCH RECORD TEST PASSED");
    }

    @Test(priority = 3)
    public void deleteRecordTest() {

        WebTablePage table = new WebTablePage(driver);

        table.openPage();

        table.deleteRecord();

        System.out.println("DELETE RECORD TEST PASSED");
    }

    @Test(priority = 4)
    public void paginationTest() {

        WebTablePage table = new WebTablePage(driver);

        table.openPage();

        table.paginationTest();

        System.out.println("PAGINATION TEST PASSED");
    }
}