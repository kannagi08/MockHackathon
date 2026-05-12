package com.krce.tests;

import com.krce.WebTablePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebTableTest {

    WebDriver driver;

    WebTablePage tablePage;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demoqa.com/webtables");

        tablePage = new WebTablePage(driver);
    }

    @Test(priority = 1)
    public void addRecordTest() {

        tablePage.addRecord(
                "Kannagi",
                "G",
                "kannagi@test.com",
                "22",
                "50000",
                "QA"
        );

        tablePage.searchRecord("Kannagi");

        Assert.assertTrue(
                tablePage.isRecordPresent("Kannagi")
        );

        System.out.println("ADD RECORD TEST PASSED");
    }

    @Test(priority = 2)
    public void searchRecordTest() {

        tablePage.searchRecord("Kannagi");

        Assert.assertTrue(
                tablePage.isRecordPresent("Kannagi")
        );

        System.out.println("SEARCH RECORD TEST PASSED");
    }

    @Test(priority = 3)
    public void deleteRecordTest() {

        tablePage.searchRecord("Kannagi");

        tablePage.deleteRecord();

        tablePage.searchRecord("Kannagi");

        Assert.assertFalse(
                tablePage.isRecordPresent("Kannagi")
        );

        System.out.println("DELETE RECORD TEST PASSED");
    }

    @Test(priority = 4)
    public void paginationTest() {

        Assert.assertTrue(
                tablePage.checkPagination()
        );

        System.out.println("PAGINATION TEST PASSED");
    }

    @AfterClass
    public void tearDown() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}