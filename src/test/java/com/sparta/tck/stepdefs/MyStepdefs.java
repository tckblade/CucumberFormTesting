package com.sparta.tck.stepdefs;

import com.sparta.tck.driver.DriverManager;
import com.sparta.tck.driver.DriverManagerFactory;
import com.sparta.tck.driver.DriverType;
import com.sparta.tck.page.FormPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs {
    //WebDriver webDriver = new ChromeDriver();
    DriverManager  driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
    FormPage formPage;

    @Given("I am on the form page")
    public void iAmOnTheFormPage() {
        formPage = new FormPage(driverManager.getDriver());
    }

    // ------First Name Field
    @When("I enter a valid first name into the field")
    public void iEnterAValidFirstNameIntoTheField() {
        formPage.enterFirstNameIntoField("Tolga");
        formPage.clickSignIn();
    }

    @Then("The form validated my first name")
    public void theFormValidatedMyFirstName() {
        Assertions.assertFalse(formPage.isValidFirstName());
        driverManager.getDriver().close();
    }

    @When("I enter a invalid first name into the field")
    public void iEnterAInvalidFirstNameIntoTheField() {
        formPage.enterFirstNameIntoField("012345678910");
        formPage.clickSignIn();
    }

    @Then("The form informs me of an invalid first name")
    public void theFormInformsMeOfAnInvalidFirstName() {
        Assertions.assertTrue(formPage.isValidFirstName());
        driverManager.getDriver().close();
    }

    // ------Last Name Field
    @When("I enter a valid last name into the field")
    public void iEnterAValidLastNameIntoTheField() {
        formPage.enterLastNameIntoField("Komur");
        formPage.clickSignIn();
    }

    @Then("The form validated my last name")
    public void theFormValidatedMyLastName() {
        Assertions.assertFalse(formPage.isValidLastName());
        driverManager.getDriver().close();
    }

    @When("I enter a invalid last name into the field")
    public void iEnterAInvalidLastNameIntoTheField() {
        formPage.enterLastNameIntoField("012345678910");
        formPage.clickSignIn();
    }

    @Then("The form informs me of an invalid last name")
    public void theFormInformsMeOfAnInvalidLastName() {
        Assertions.assertTrue(formPage.isValidLastName());
        driverManager.getDriver().close();
    }

    // ------Age Field
    @When("I enter a valid number for age into the field")
    public void iEnterAValidNumberForAgeIntoTheField() {
        formPage.enterAgeIntoField("23");
        formPage.clickSignIn();
    }

    @Then("The form validated the number entered for age")
    public void theFormValidatedTheNumberEnteredForAge() {
        Assertions.assertFalse(formPage.isValidAge());
        driverManager.getDriver().close();
    }

    @When("I enter a invalid number for age into the field")
    public void iEnterAInvalidNumberForAgeIntoTheField() {
        formPage.enterAgeIntoField("-23");
        formPage.clickSignIn();
    }

    @Then("The form informs me of an invalid number for age")
    public void theFormInformsMeOfAnInvalidNumberForAge() {
        Assertions.assertTrue(formPage.isValidAge());
        driverManager.getDriver().close();
    }

    // ------Gender Field
    @When("I select my gender")
    public void iSelectMyGender() {
        formPage.selectGender();
        formPage.clickSignIn();
    }

    @Then("The correct selected gender is displayed")
    public void theCorrectSelectedGenderIsDisplayed() {
        Assertions.assertTrue(formPage.isMGenderSelected());
        driverManager.getDriver().close();
    }

    @Then("The opposite gender is not selected")
    public void theOppositeGenderIsNotSelected() {
        Assertions.assertFalse(formPage.isFGenderSelected());
        driverManager.getDriver().close();
    }

    // ------University Field
    @When("I select a university")
    public void iSelectAUniversity() {
        formPage.selectUniversity();
        formPage.clickSignIn();
    }

    @Then("I have selected a university")
    public void iHaveSelectedAUniversity() {
        Assertions.assertTrue(formPage.isUniversitySelected());
        driverManager.getDriver().close();
    }

    // ------Email Field
    @When("I enter a valid email into the field")
    public void iEnterAValidEmailIntoTheField() {
        formPage.enterEmailIntoField("tkomur@spartaglobal.com");
        formPage.clickSignIn();
    }

    @Then("The form validated the email that was entered")
    public void theFormValidatedTheEmailThatWasEntered() {
        Assertions.assertFalse(formPage.isValidEmail());
        driverManager.getDriver().close();
    }

    @When("I enter a invalid email into the field")
    public void iEnterAInvalidEmailIntoTheField() {
        formPage.enterEmailIntoField("tkomur@@@spartaglo?bal.com");
        formPage.clickSignIn();
    }

    @Then("The form informs me of an invalid email")
    public void theFormInformsMeOfAnInvalidEmail() {
        Assertions.assertTrue(formPage.isValidEmail());
        driverManager.getDriver().close();
    }

    // ------Rate Field
    @When("I rate the form for my experience")
    public void iRateTheFormForMyExperience() {
        formPage.rateForm(60f);
        formPage.clickSignIn();
    }

    @Then("The corresponding value rated is displayed.")
    public void theCorrespondingValueRatedIsDisplayed() {
        Assertions.assertTrue(formPage.isRated("60"));
    }
}
