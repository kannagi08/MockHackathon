package com.krce.tests;

import com.krce.pages.AlertPage;
import com.krce.pages.WindowPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Module3Test extends BaseTest {

    @Test
    public void testAlertsAndWindows() {

        AlertPage alertPage = new AlertPage(driver);
        WindowPage windowPage = new WindowPage(driver);

        // 1. SIMPLE ALERT
        String simple = alertPage.simpleAlert(
                By.id("alertButton"),
                By.id("result")
        );
        System.out.println("Simple Alert: " + simple);

        Assert.assertTrue(simple.contains("You clicked"));

        // 2. CONFIRM ALERT
        String confirm = alertPage.confirmAlert(
                By.id("confirmButton"),
                By.id("result")
        );
        System.out.println("Confirm Alert: " + confirm);

        // 3. PROMPT ALERT
        String prompt = alertPage.promptAlert(
                By.id("promtButton"),
                "Kannagi",
                By.id("result")
        );
        System.out.println("Prompt Alert: " + prompt);

        Assert.assertTrue(prompt.contains("Kannagi"));

        // 4. NEW TAB
        String tabTitle = windowPage.openNewTab("https://www.google.com");
        System.out.println("Tab Title: " + tabTitle);

        Assert.assertTrue(tabTitle.contains("Google"));

        // 5. NEW WINDOW
        String winTitle = windowPage.openNewWindow("https://www.selenium.dev");
        System.out.println("Window Title: " + winTitle);
    }
}