package com.krce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WidgetsPage {

    WebDriver driver;
    WebDriverWait wait;

    public WidgetsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDatePickerPage() {
        driver.get("https://demoqa.com/date-picker");
    }

    public void selectDate() {

        WebElement dateBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("datePickerMonthYearInput"))
        );

        dateBox.click();

        dateBox.sendKeys(Keys.CONTROL + "a");
        dateBox.sendKeys(Keys.DELETE);

        dateBox.sendKeys("05/20/2026");
        dateBox.sendKeys(Keys.ENTER);
    }

    public String getSelectedDate() {

        return driver.findElement(
                        By.id("datePickerMonthYearInput"))
                .getAttribute("value");
    }


    public void openSliderPage() {
        driver.get("https://demoqa.com/slider");
    }

    public void moveSlider() {

        WebElement slider = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@type='range']"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // change slider value using JS
        js.executeScript(
                "arguments[0].value='70'; arguments[0].dispatchEvent(new Event('change'));",
                slider
        );
    }

    public String getSliderValue() {

        return driver.findElement(
                        By.id("sliderValue"))
                .getAttribute("value");
    }


    public void openAccordionPage() {
        driver.get("https://demoqa.com/accordian");
    }

    public void clickSecondSection() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement section = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("section2Heading"))
        );

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                section
        );

        js.executeScript(
                "arguments[0].click();",
                section
        );
    }

    public boolean isSecondSectionExpanded() {

        WebElement content = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("section2Content"))
        );

        return content.isDisplayed();
    }
}