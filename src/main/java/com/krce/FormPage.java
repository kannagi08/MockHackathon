package com.krce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
    }



    public void openPage() {
        driver.get("https://demoqa.com/automation-practice-form");
        js.executeScript("window.scrollBy(0,200)");
    }

    public void clickForm() {
        driver.get("https://demoqa.com/");
    }

    public void clickPractiseForm() {

        WebElement formsTile = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//h5[text()='Forms']")
                )
        );

        js.executeScript("arguments[0].scrollIntoView(true);", formsTile);
        js.executeScript("arguments[0].click();", formsTile);

        WebElement practiceForm = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[text()='Practice Form']")
                )
        );

        js.executeScript("arguments[0].click();", practiceForm);
    }


    By firstname = By.id("firstName");
    By lastname = By.id("lastName");
    By email = By.id("userEmail");
    By number = By.id("userNumber");
    By dob = By.id("dateOfBirthInput");
    By monthDrop = By.className("react-datepicker__month-select");
    By yearDrop = By.className("react-datepicker__year-select");
    By subjects = By.id("subjectsInput");
    By pictures = By.id("uploadPicture");
    By address = By.id("currentAddress");
    By submit = By.id("submit");
    By successPopUp = By.id("example-modal-sizes-title-lg");


    public void setName() {
        driver.findElement(firstname).sendKeys("Kannagi");
        driver.findElement(lastname).sendKeys("Govindaraj");
    }

    public void setEmail() {
        driver.findElement(email).sendKeys("kans@gmail.com");
    }

    public void setGender() {
        WebElement gender = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[text()='Male']")
                )
        );
        js.executeScript("arguments[0].click();", gender);
    }

    public void setNumber() {
        driver.findElement(number).sendKeys("9482634425");
    }

    public void setDob() {
        driver.findElement(dob).click();

        new Select(driver.findElement(monthDrop)).selectByVisibleText("May");
        new Select(driver.findElement(yearDrop)).selectByVisibleText("2005");

        driver.findElement(By.xpath(
                "//div[contains(@class,'react-datepicker__day') " +
                        "and not(contains(@class,'outside-month')) and text()='28']"
        )).click();
    }

    public void setSubjects() {
        WebElement sub = driver.findElement(subjects);
        sub.sendKeys("Computer Science");
        sub.sendKeys(Keys.ENTER);
    }

    public void setHobbies() {
        WebElement hobby = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//label[text()='Sports']")
                )
        );
        js.executeScript("arguments[0].click();", hobby);
    }

    public void setPictures() {
        driver.findElement(pictures)
                .sendKeys("C:\\Users\\acer\\Pictures\\bts.png");
    }

    public void setAddress() {
        WebElement addr = driver.findElement(address);
        js.executeScript("arguments[0].scrollIntoView(true);", addr);
        addr.clear();
        addr.sendKeys("AAABBBYY");
    }

    public void setStateCity() {

        js.executeScript("window.scrollBy(0,300)");

        WebElement state = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("react-select-3-input")
                )
        );

        js.executeScript("arguments[0].click();", state);
        state.sendKeys("NCR");
        state.sendKeys(Keys.ENTER);

        try { Thread.sleep(1000); } catch (Exception ignored) {}

        WebElement city = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.id("react-select-4-input")
                )
        );

        js.executeScript("arguments[0].click();", city);
        city.sendKeys("Delhi");
        city.sendKeys(Keys.ENTER);
    }


    public void submit() {
        js.executeScript("arguments[0].click();",
                driver.findElement(submit));
    }

    // ================= VALIDATION =================

    public boolean successMessage() {
        try {
            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(successPopUp)
            ).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSuccessPopupDisplayed() {
        try {
            return driver.findElement(successPopUp).isDisplayed();
        } catch (Exception e) {
            return false;
        }}}