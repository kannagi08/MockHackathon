package com.krce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebTablePage {

    WebDriver driver;
    WebDriverWait wait;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open page
    public void openPage() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
    }

    // Add record
    public void addRecord() {

        driver.findElement(By.id("addNewRecordButton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john@test.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("50000");
        driver.findElement(By.id("department")).sendKeys("QA");

        driver.findElement(By.id("submit")).click();
    }

    // Verify added record
    public boolean isRecordAdded() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'John')]")));

        return driver.findElement(
                        By.xpath("//*[contains(text(),'John')]"))
                .isDisplayed();
    }

    // Search record
    public void searchRecord() {

        WebElement searchBox = driver.findElement(By.id("searchBox"));

        searchBox.clear();
        searchBox.sendKeys("John");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'John')]")));
    }

    // Verify searched record
    public boolean isRecordFound() {

        return driver.findElement(
                        By.xpath("//*[contains(text(),'John')]"))
                .isDisplayed();
    }

    // Delete record
    public void deleteRecord() {

        driver.findElement(By.id("delete-record-4")).click();
    }

    // Pagination test
    public void paginationTest() {

        try {

            WebElement nextBtn = driver.findElement(By.xpath("//button[text()='Next']"));

            if (nextBtn.isEnabled()) {
                nextBtn.click();
                System.out.println("Pagination working");
            } else {
                System.out.println("Pagination not available");
            }

        } catch (Exception e) {

            System.out.println("Pagination not found");
        }
    }
}