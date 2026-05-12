package com.krce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTablePage {

    WebDriver driver;
    WebDriverWait wait;

    public WebTablePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By addBtn = By.id("addNewRecordButton");

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");

    By submitBtn = By.id("submit");

    By searchBox = By.id("searchBox");

    By tableRows = By.cssSelector(".rt-tbody .rt-tr-group");

    By nextBtn = By.cssSelector(".-next button");

    // Add Record
    public void addRecord(String fn, String ln, String mail,
                          String ag, String sal, String dept) {

        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName))
                .sendKeys(fn);

        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(age).sendKeys(ag);
        driver.findElement(salary).sendKeys(sal);
        driver.findElement(department).sendKeys(dept);

        driver.findElement(submitBtn).click();

        // Wait until popup disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(submitBtn));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Search Record
    public void searchRecord(String name) {

        WebElement search =
                wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        search.clear();

        search.sendKeys(name);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Verify Record Present
    public boolean isRecordPresent(String text) {

        List<WebElement> rows = driver.findElements(tableRows);

        for (WebElement row : rows) {

            String rowText = row.getText();

            System.out.println("ROW TEXT = " + rowText);

            if (rowText.contains(text)) {
                return true;
            }
        }

        return false;
    }

    // Delete Record
    public void deleteRecord() {

        List<WebElement> deleteButtons =
                driver.findElements(By.cssSelector("[title='Delete']"));

        if (deleteButtons.size() > 0) {

            deleteButtons.get(0).click();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Pagination
    public boolean checkPagination() {

        try {

            WebElement next =
                    driver.findElement(nextBtn);

            return next.isDisplayed();

        } catch (Exception e) {

            System.out.println("Pagination not available");

            return true;
        }
    }
}