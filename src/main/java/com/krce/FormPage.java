
package com.krce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    WebDriver driver;
    By form=By.xpath("//h5[text()='Forms']");//form locator globally
    By practiseForm=By.xpath("//span[text()='Practice Form']");
    By firstname=By.id("firstName");
    By lastname=By.id("lastName");
    By email= By.id("userEmail");
    By gender=By.id("gender-radio-1");
    By number=By.id("userNumber");
    By dob=By.id("dateOfBirthInput");
    By monthDrop=By.className("react-datepicker__month-select");
    By yearDrop=By.className("react-datepicker__year-select");
    By subjects=By.id("subjectsInput");
    By hobbies=By.id("hobbies-checkbox-1");
    By pictures=By.id("uploadPicture");
    By address=By.id("currentAddress");
    By state=By.id("react-select-3-input");
    By city=By.id("react-select-4-input");
    By submit=By.id("submit");
    By successPopUp=By.id("example-modal-sizes-title-lg");

    public FormPage(WebDriver driver){
        this.driver=driver;
    }
    public void clickForm(){
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(form)
        );
    }
    public void clickPractiseForm(){
        driver.findElement(practiseForm).click();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(firstname)
        );
    }
    public void setName(){
        driver.findElement(firstname).sendKeys("Kannagi");
        driver.findElement(lastname).sendKeys("Govindaraj");
    }
    public void setEmail(){
        driver.findElement(email).sendKeys("kans@gmail.com");
    }
    public void setGender(){
        driver.findElement(gender).click();
    }
    public void setNumber(){
        driver.findElement(number).sendKeys("9482634425");
    }
    public void setDob(){
        driver.findElement(dob).click();
        Select month = new Select(
                driver.findElement(monthDrop));

        month.selectByVisibleText("May");

        Select year = new Select(
                driver.findElement(yearDrop));

        year.selectByVisibleText("2005");
        driver.findElement(
                By.xpath(
                        "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='28']"
                )
        ).click();
    }
    public void setSubjects(){
        driver.findElement(subjects).sendKeys("ComputerScience");
        driver.findElement(subjects)
                .sendKeys(Keys.ENTER);
    }
    public void setHobbies(){
        driver.findElement(hobbies).click();
    }
    public void setPictures(){
        driver.findElement(pictures).sendKeys("C:\\Users\\acer\\Pictures\\bts.png");
    }
    public void setAddress(){
        driver.findElement(address).sendKeys("AAABBBYY");
    }
    public void setStateCity(){
        driver.findElement(state).sendKeys("TN");
        driver.findElement(state)
                .sendKeys(Keys.ENTER);
        driver.findElement(city).sendKeys("Trichy");
        driver.findElement(city)
                .sendKeys(Keys.ENTER);
    }
    public void submit(){
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(submit));
    }
    public boolean successMessage(){
        try{

            return driver.findElement(successPopUp)
                    .isDisplayed();

        } catch (Exception e){

            return false;
        }

    }
    public boolean isGenderSelected(){

        return driver.findElement(gender)
                .isSelected();
    }
    public boolean isHobbySelected(){

        return driver.findElement(hobbies)
                .isSelected();
    }
}

