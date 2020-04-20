package com.sparta.tck.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FormPage {

    WebDriver webDriver;
    //First Name Field
    By firstNameField = new By.ById("firstName");
    By firstNameFieldFormValidation = new By.ByCssSelector("body > div > form > div:nth-child(1) > div > div");
    //Last Name Field
    By lastNameField = new By.ById("lastName");
    By lastNameFieldFormValidation = new By.ByCssSelector("body > div > form > div:nth-child(2) > div > div");
    //Age Field
    By ageField = new By.ByXPath("/html/body/div/form/div[3]/div/input");
    By ageFieldFormValidation = new By.ByCssSelector("body > div > form > div:nth-child(3) > div > div");
    //Gender Field
    By genderField = new By.ByXPath("/html/body/div/form/div[5]");
    By mGenderFieldFormValidation = new By.ByXPath("/html/body/div/form/div[5]/input");
    By fGenderFieldFormValidation = new By.ByXPath("/html/body/div/form/div[6]/input");
    //University Field
    By universityField = new By.ByXPath("/html/body/div/form/div[8]/div/select/option[3]");
    By universityFieldFormValidation = new By.ByXPath("/html/body/div/form/div[8]/div/select/option[3]");
    //Email Field
    By emailField = new By.ById("inputemailaddress");
    By emailFieldFormValidation = new By.ByCssSelector("body > div > form > div:nth-child(15) > div > div");
    //Rate Field
    By rateField = new By.ById("value_for_slider");
    By rateFieldFormValidation = new By.ById("value_for_slider");
    //Sign in button
    By signInButton = new By.ByXPath("/html/body/div/form/button");


    public FormPage(WebDriver driver) {
        this.webDriver = driver;
        webDriver.manage().window().maximize();
        webDriver.get("http://localhost:9292/");
    }

    public void enterFirstNameIntoField(String fName) {
        webDriver.findElement(firstNameField).sendKeys(fName);
    }

    public boolean isValidFirstName() {
        return webDriver.findElement(firstNameFieldFormValidation).isDisplayed();
    }

    public void enterLastNameIntoField(String lName) {
        webDriver.findElement(lastNameField).sendKeys(lName);
    }

    public boolean isValidLastName() {
        return webDriver.findElement(lastNameFieldFormValidation).isDisplayed();
    }

    public void enterAgeIntoField(String age) {
        webDriver.findElement(ageField).sendKeys(age);
    }

    public boolean isValidAge() {
        return webDriver.findElement(ageFieldFormValidation).isDisplayed();
    }

    public void selectGender() {
        webDriver.findElement(genderField).click();
    }

    public boolean isMGenderSelected() {
        return webDriver.findElement(mGenderFieldFormValidation).isSelected();
    }

    public boolean isFGenderSelected() {
        return webDriver.findElement(fGenderFieldFormValidation).isSelected();
    }

    public void selectUniversity() {
        webDriver.findElement(universityField).click();
    }

    public boolean isUniversitySelected() {
        return webDriver.findElement(universityFieldFormValidation).isSelected();
    }

    public void enterEmailIntoField(String email) {
        webDriver.findElement(emailField).sendKeys(email);
    }

    public boolean isValidEmail() {
        return webDriver.findElement(emailFieldFormValidation).isDisplayed();
    }

    public void rateForm(float number) {
        WebElement slider =  webDriver.findElement(rateField);
        int pixelsToMove = GetPixelsToMove(slider, number, 100, 0);
        Actions SliderAction = new Actions(webDriver);
        SliderAction.clickAndHold(slider)
                .moveByOffset((-(int)slider.getSize().width / 2), 0)
                .moveByOffset(pixelsToMove, 0).release().perform();
    }
    private static int GetPixelsToMove(WebElement Slider, float amount, float SliderMax, float SliderMin)
    {
        int pixels = 0;
        float tempPixels = Slider.getSize().width;
        tempPixels = tempPixels / (SliderMax - SliderMin);
        tempPixels = tempPixels * (amount - SliderMin);
        pixels = (int) tempPixels;
        return pixels;
    }

    public boolean isRated(String number) {
        return webDriver.findElement(rateFieldFormValidation).getText().equals(number);
    }

    public void clickSignIn() {
        webDriver.findElement(signInButton).click();
    }
}
