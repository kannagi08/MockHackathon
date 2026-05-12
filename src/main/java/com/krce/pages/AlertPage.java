package com.krce.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class AlertPage extends BasePage {

    WebDriverWait wait;

    public AlertPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 1. Simple Alert
    public String simpleAlert(By button, By result) {
        click(button);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        return getText(result);
    }

    // 2. Confirm Alert
    public String confirmAlert(By button, By result) {
        click(button);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        return getText(result);
    }

    // 3. Prompt Alert
    public String promptAlert(By button, String input, By result) {
        click(button);

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys(input);
        alert.accept();

        return getText(result);
    }
}