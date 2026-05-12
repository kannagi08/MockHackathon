package com.krce.pages;

import org.openqa.selenium.*;

public class WindowPage extends BasePage {

    public WindowPage(WebDriver driver) {
        super(driver);
    }

    // New Tab
    public String openNewTab(String url) {

        String main = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);

        String title = driver.getTitle();

        driver.close();
        driver.switchTo().window(main);

        return title;
    }

    // New Window
    public String openNewWindow(String url) {

        String main = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);

        String title = driver.getTitle();

        driver.close();
        driver.switchTo().window(main);

        return title;
    }
}