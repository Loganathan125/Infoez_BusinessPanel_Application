package Com.Stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends BaseClass {

	LoginPage lp = new LoginPage(DeviceSessionManager.getDriver());

	@Given("ven the user tap profile button")
	public void ven_the_user_tap_profile_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.profileBtn);
		click(DeviceSessionManager.getDriver(), lp.profileBtn);
	}

	@Given("the user tap login or register button")
	public void the_user_tap_login_or_register_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.registerBtn);
		click(DeviceSessionManager.getDriver(), lp.registerBtn);

	}

	@When("the user enter username {string}")
	public void the_user_enter_username(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.UserName);
		sendKeys(DeviceSessionManager.getDriver(), lp.UserName, string);
	}

	@When("the user enter password {string}")
	public void the_user_enter_password(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.Password);
		sendKeys(DeviceSessionManager.getDriver(), lp.Password, string);
	}

	@When("the user click on login button")
	public void the_user_click_on_login_button() {
		click(DeviceSessionManager.getDriver(), lp.LoginBtn);

	}

	@Then("the user redirected the home page {string}")
	public void the_user_redirected_the_home_page(String HomePage) {
		switch (HomePage) {
		case "InValid1":
			String actual1 = gettext(DeviceSessionManager.getDriver(), lp.Invalid1);
			Assert.assertEquals("Please fill every field.", actual1);
			System.out.println(actual1);
			break;
		case "InValid2":
			String actual2 = gettext(DeviceSessionManager.getDriver(), lp.invalid2);
			Assert.assertEquals("Enter a valid email address.", actual2);
			System.out.println(actual2);
			break;

		case "InValid3":
			String actual3 = gettext(DeviceSessionManager.getDriver(), lp.invalid3);
			Assert.assertEquals("Invalid credentials", actual3);
			System.out.println(actual3);
			break;
		case "InValid4":
			String actual4 = gettext(DeviceSessionManager.getDriver(), lp.invalid4);
			Assert.assertEquals("Invalid credentials", actual4);
			System.out.println(actual4);
			break;
		case "InValid5":
			String actual5 = gettext(DeviceSessionManager.getDriver(), lp.invalid5);
			Assert.assertEquals("Invalid credentials", actual5);
			System.out.println(actual5);
			break;
		case "InValid6":
			String actual6 = gettext(DeviceSessionManager.getDriver(), lp.invalid6);
			Assert.assertEquals("Invalid credentials", actual6);
			System.out.println(actual6);
			break;
		case "InValid7":
			String actual7 = gettext(DeviceSessionManager.getDriver(), lp.Invalid7);
			Assert.assertEquals("Enter a valid email address.", actual7);
			System.out.println(actual7);
			break;
		case "InValid8":
			String actual8 = gettext(DeviceSessionManager.getDriver(), lp.Invalid8);
			Assert.assertEquals("Enter a valid email address.", actual8);
			System.out.println(actual8);
			break;
		case "InValid9":
			String actual9 = gettext(DeviceSessionManager.getDriver(), lp.invalid9);
			Assert.assertEquals("Invalid credentials", actual9);
			System.out.println(actual9);
			break;
		case "InValid10":
			String actual10 = gettext(DeviceSessionManager.getDriver(), lp.invalidEmail);
			Assert.assertEquals("Enter a valid email address.", actual10);
			System.out.println(actual10);
			break;
		case "InValid11":
			String actual11 = gettext(DeviceSessionManager.getDriver(), lp.emptyEmail);
			Assert.assertEquals("Please fill every field.", actual11);
			System.out.println(actual11);
			break;
		case "InValid12":
			String actual12 = gettext(DeviceSessionManager.getDriver(), lp.emptyPass);
			Assert.assertEquals("Please fill every field.", actual12);
			System.out.println(actual12);
			break;
		case "Valid":
			String actual13 = gettext(DeviceSessionManager.getDriver(), lp.Valid);
			Assert.assertEquals("Infoez", actual13);
			System.out.println(actual13);
			break;

		}
	}

}
