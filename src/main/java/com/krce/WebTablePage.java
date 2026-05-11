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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By addBtn = By.id("addNewRecordButton");
    By searchBox = By.id("searchBox");

    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By email = By.id("userEmail");
    By age = By.id("age");
    By salary = By.id("salary");
    By department = By.id("department");
    By submit = By.id("submit");

    By rows = By.cssSelector(".rt-tbody .rt-tr-group");

    // ✅ SAFE PAGE LOAD (NO CLICK ELEMENTS MENU)
    public void openPage() {
        driver.get("https://demoqa.com/webtables");

        wait.until(ExpectedConditions.visibilityOfElementLocated(addBtn));
    }

    // ✅ SAFE CLICK METHOD (FIX FOR CLICK INTERCEPTED)
    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", element);

        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }

    // Add record
    public void addRecord(String fn, String ln, String em, String ag, String sal, String dep) {

        safeClick(addBtn);

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(email).sendKeys(em);
        driver.findElement(age).sendKeys(ag);
        driver.findElement(salary).sendKeys(sal);
        driver.findElement(department).sendKeys(dep);

        safeClick(submit);

        wait.until(ExpectedConditions.invisibilityOfElementLocated(submit));
    }

    // Search
    public boolean searchRecord(String value) {

        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));

        search.clear();
        search.sendKeys(value);

        return wait.until(driver ->
                driver.getPageSource().contains(value)
        );
    }

    // Delete first record
    public void deleteRecord() {

        By deleteBtn = By.id("delete-record-1");

        safeClick(deleteBtn);
    }

    // Row check
    public boolean isRowPresent(String text) {

        return wait.until(driver ->
                driver.getPageSource().contains(text)
        );
    }

    // FIRST ROW TEXT (FIXED TIMEOUT ISSUE)
    public String getFirstRowText() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(rows));

        List<WebElement> allRows = driver.findElements(rows);

        for (WebElement row : allRows) {
            String text = row.getText().trim();
            if (!text.isEmpty()) {
                return text;
            }
        }

        return "";
    }

    // NEXT PAGE CLICK (SAFE)
    public void clickNextPage() {

        By nextBtn = By.xpath("//button[text()='Next' or contains(text(),'Next')]");

        safeClick(nextBtn);

        wait.until(ExpectedConditions.stalenessOf(
                driver.findElements(rows).get(0)
        ));
    }
}