package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTablePage {

    WebDriver driver;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://demoqa.com/webtables");
    }

    public void addRecord(String firstName, String lastName, String email,
                          String age, String salary, String department) {

        driver.findElement(By.id("addNewRecordButton")).click();

        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(department);

        driver.findElement(By.id("submit")).click();
    }

    public boolean isRowPresent(String name) {
        return driver.getPageSource().contains(name);
    }

    public boolean searchRecord(String value) {
        driver.findElement(By.id("searchBox")).sendKeys(value);
        return driver.getPageSource().contains(value);
    }

    public void deleteRecord() {
        driver.findElement(By.cssSelector("span[title='Delete']")).click();
    }

    public String getFirstRowText() {
        return driver.findElement(By.cssSelector(".rt-tr-group")).getText();
    }

    public void clickNextPage() {
        driver.findElement(By.cssSelector(".-next")).click();
    }
}