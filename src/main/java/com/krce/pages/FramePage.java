package com.krce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {

    WebDriver driver;

    public FramePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open page
    public void openPage() {

        driver.get("https://demoqa.com/nestedframes");

        driver.manage().window().maximize();
    }

    // Switch to parent frame
    public void switchToParentFrame() {

        driver.switchTo().frame("frame1");
    }

    // Get parent frame text
    public String getParentFrameText() {

        return driver.findElement(By.tagName("body")).getText();
    }

    // Switch to child frame
    public void switchToChildFrame() {

        driver.switchTo().frame(0);
    }

    // Get child frame text
    public String getChildFrameText() {

        return driver.findElement(By.tagName("p")).getText();
    }

    // Switch back to main page
    public void switchToMainPage() {

        driver.switchTo().defaultContent();
    }

    // Verify main page accessible
    public boolean isMainPageAccessible() {

        return driver.findElement(
                        By.xpath("//h1[text()='Nested Frames']"))
                .isDisplayed();
    }
}