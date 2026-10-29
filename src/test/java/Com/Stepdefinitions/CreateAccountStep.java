package Com.Stepdefinitions;

import org.junit.Assert;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.CreateAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateAccountStep extends BaseClass {

	CreateAccountPage lp = new CreateAccountPage(DeviceSessionManager.getDriver());

	@Given("the user launch the   applicationn")
	public void the_user_launch_the_applicationn() {
		relaunchApp(DeviceSessionManager.getDriver());
	}

	@When("ven the user tap profile btn")
	public void ven_the_user_tap_profile_btn() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.profileBtn);
		click(DeviceSessionManager.getDriver(), lp.profileBtn);
	}

	@When("the user tap login or register btn")
	public void the_user_tap_login_or_register_btn() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.registerBtn);
		click(DeviceSessionManager.getDriver(), lp.registerBtn);
	}

	@When("to user tap create account card")
	public void to_user_tap_create_account_card() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.createAccount);
		click(DeviceSessionManager.getDriver(), lp.createAccount);
		click(DeviceSessionManager.getDriver(), lp.businessOwner);

	}

	@When("the user enter a fullname {string}")
	public void the_user_enter_a_fullname(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.fullName);
		sendKeys(DeviceSessionManager.getDriver(), lp.fullName, string);
	}

	@When("the user enter a email {string}")
	public void the_user_enter_a_email(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.email);
		sendKeys(DeviceSessionManager.getDriver(), lp.email, string);
	}

	@When("the user enter a password {string}")
	public void the_user_enter_a_password(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.password);
		sendKeys(DeviceSessionManager.getDriver(), lp.password, string);
	}

	@When("the user tap on create account button")
	public void the_user_tap_on_create_account_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.createAccountBtn);
		click(DeviceSessionManager.getDriver(), lp.createAccountBtn);
	}

	@Then("the page should be redirected home page {string}")
	public void the_page_should_be_redirected_home_page(String expected) {

		switch (expected) {
		case "invalid1":
			String actual1 = gettext(DeviceSessionManager.getDriver(), lp.invalid1);
			Assert.assertTrue(lp.invalid1.isDisplayed());
			System.out.println(actual1);

			break;
		case "invalid2":
			String actual2 = gettext(DeviceSessionManager.getDriver(), lp.invalid2);
			Assert.assertTrue(lp.invalid2.isDisplayed());
			System.out.println(actual2);

			break;
		case "invalid3":
			String actual3 = gettext(DeviceSessionManager.getDriver(), lp.invalid3);
			Assert.assertTrue(lp.invalid3.isDisplayed());
			System.out.println(actual3);

			break;
		case "invalid4":
			String actual4 = gettext(DeviceSessionManager.getDriver(), lp.invalid4);
			Assert.assertTrue(lp.invalid4.isDisplayed());
			System.out.println(actual4);

			break;
		case "invalid5":
			String actual5 = gettext(DeviceSessionManager.getDriver(), lp.invalid5);
			Assert.assertTrue(lp.invalid5.isDisplayed());
			System.out.println(actual5);

			break;
		case "invalid6":
			String actual6 = gettext(DeviceSessionManager.getDriver(), lp.invalid6);
			Assert.assertTrue(lp.invalid6.isDisplayed());
			System.out.println(actual6);

			break;
		case "invalid7":
			String actual7 = gettext(DeviceSessionManager.getDriver(), lp.invalid7);
			Assert.assertTrue(lp.invalid7.isDisplayed());
			System.out.println(actual7);

			break;
		case "invalid8":
			String actual8 = gettext(DeviceSessionManager.getDriver(), lp.invalid8);
			Assert.assertTrue(lp.invalid8.isDisplayed());
			System.out.println(actual8);

			break;
		case "valid":
			String actual9 = gettext(DeviceSessionManager.getDriver(), lp.valid);
			Assert.assertTrue(lp.valid.isDisplayed());
			System.out.println(actual9);

			break;

		}

	}
}
