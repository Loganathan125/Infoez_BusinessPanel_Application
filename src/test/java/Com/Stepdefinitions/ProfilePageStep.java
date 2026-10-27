package Com.Stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.ProfilePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfilePageStep extends BaseClass {

	ProfilePage lp = new ProfilePage(DeviceSessionManager.getDriver());

	@Given("the user tap profile btn")
	public void the_user_tap_profile_btn() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.profile);
		click(DeviceSessionManager.getDriver(), lp.profile);
	}

	@Given("the business page should be displayed")
	public void the_business_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.createListing);
		click(DeviceSessionManager.getDriver(), lp.createListing);
	}

	@Then("the user tap create a listing")
	public void the_user_tap_create_a_listing() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.listYourBusiness);
		Assert.assertTrue(lp.listYourBusiness.isDisplayed());
	}

	@Given("the user tap camera")
	public void the_user_tap_camera() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.camera);
		click(DeviceSessionManager.getDriver(), lp.camera);
	}

	@Then("the user verify the camera")
	public void the_user_verify_the_camera() {

	}

	@Given("the user tap gallery option")
	public void the_user_tap_gallery_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.gallery);

		click(DeviceSessionManager.getDriver(), lp.gallery);
	}

	@Given("the user select the images")
	public void the_user_select_the_images() {

		click(DeviceSessionManager.getDriver(), lp.photos);
		click(DeviceSessionManager.getDriver(), lp.done);
	}

	@Then("the user validate the images")
	public void the_user_validate_the_images() {
		Assert.assertTrue("5MB Error Message not displayed", lp.imageView.isDisplayed());
	}

	@Given("the user tap gallery")
	public void the_user_tap_gallery() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.gallery);

		click(DeviceSessionManager.getDriver(), lp.gallery);
	}

	@When("the user select the imeage")
	public void the_user_select_the_imeage() {
		for(int i=0;i<6;i++) {
		DeviceSessionManager.getDriver().findElements((By) lp.restaurant).get(i).click();
		}
			
	}

	@Then("the user validate the image view")
	public void the_user_validate_the_image_view() {
		click(DeviceSessionManager.getDriver(), lp.done);
		Assert.assertTrue("Images not displayed", lp.imageView.isDisplayed());
	}

	@Given("the user enter business name {string}")
	public void the_user_enter_business_name(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.businessName, string);
	}

	@When("the user enter description {string}")
	public void the_user_enter_description(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.description, string);
	}

	@When("the user select a category")
	public void the_user_select_a_category() {
		click(DeviceSessionManager.getDriver(), lp.category);
	}

	@When("the user enter  street {string}")
	public void the_user_enter_street(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.streetaddress, string);
	}

	@When("the user enter area  {string}")
	public void the_user_enter_area(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.area, string);
	}

	@When("the user enter city  {string}")
	public void the_user_enter_city(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.city, string);
	}

	@When("the user enter  pincode {string}")
	public void the_user_enter_pincode(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.pincode, string);
	}

	@When("the user enter phoneNumber {string}")
	public void the_user_enter_phone_number(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.phone, string);
	}

	@When("the user enter whatsappNumber  {string}")
	public void the_user_enter_whatsapp_number(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.whatsApp, string);
	}

	@When("the user submit the business verification form")
	public void the_user_submit_the_business_verification_form() {
		click(DeviceSessionManager.getDriver(), lp.submit);
	}

	@Then("business name required validation  submission should be displayed {string}")
	public void business_name_required_validation_submission_should_be_displayed(String expected) {
		switch (expected) {
		case "Invalid":
			String actual1 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual1);
			System.out.println(actual1);

			break;
		case "Invalid1":
			String actual2 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual2);
			System.out.println(actual2);

			break;
		case "Invalid2":
			String actual3 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual3);
			System.out.println(actual3);

			break;
		case "Invalid3":
			String actual4 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual4);
			System.out.println(actual4);

			break;
		case "Invalid4":
			String actual5 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual5);
			System.out.println(actual5);

			break;
		case "Invalid5":
			String actual6 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual6);
			System.out.println(actual6);

			break;
		case "Invalid6":
			String actual7 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual7);
			System.out.println(actual7);

			break;
		case "Invalid7":
			String actual8 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual8);
			System.out.println(actual8);

			break;
		case "Invalid8":
			String actual9 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual9);
			System.out.println(actual9);

			break;

		case "valid":
			String actual10 = gettext(DeviceSessionManager.getDriver(), lp.invalid);
			Assert.assertEquals("Name, category, address, area, and phone are required.", actual10);
			System.out.println(actual10);

			break;

		}
	}

	@Given("the user tap claim an existing listing")
	public void the_user_tap_claim_an_existing_listing() {
		click(DeviceSessionManager.getDriver(), lp.createExisting);
	}

	String searchedCity;

	@When("the user search the city {string}")
	public void the_user_search_the_city(String city) {
		searchedCity = city;
		sendKeys(DeviceSessionManager.getDriver(), lp.claimSearch, city);
		pressEnter((AndroidDriver) DeviceSessionManager.getDriver());
	}

	@Then("the result should be displayed")
	public void the_result_should_be_displayed() {
		Assert.assertFalse("Result are empty for city: " + searchedCity, lp.searchResult.isEmpty());
	}

	@Given("the user select any business name")
	public void the_user_select_any_business_name() {
		click(DeviceSessionManager.getDriver(), lp.dental);
	}

	@When("the user scroll till bottom")
	public void the_user_scroll_till_bottom() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Submit claim");
	}

	@When("the user enter mobile number {string}")
	public void the_user_enter_mobile_number(String string) {
		sendKeys(DeviceSessionManager.getDriver(), lp.claimDeatil, string);
	}

	@When("the user tap submit claims btn")
	public void the_user_tap_submit_claims_btn() {
		click(DeviceSessionManager.getDriver(), lp.submitClaim);
	}

	@Then("the user validate the claims submitted")
	public void the_user_validate_the_claims_submitted() {
		Assert.assertTrue("Claim not submitted", lp.claimSubmit.isDisplayed());
		click(DeviceSessionManager.getDriver(), lp.donePopup);
	}

	@When("the user scroll a till bottom")
	public void the_user_scroll_a_till_bottom() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Submit claim");
	}

	@When("the user enter mobile number")
	public void the_user_enter_mobile_number() {

	}

	@When("the user tap submit claims button")
	public void the_user_tap_submit_claims_button() {
		click(DeviceSessionManager.getDriver(), lp.submitClaim);
	}

	@Then("the user validate  claims submitted")
	public void the_user_validate_claims_submitted() {
		Assert.assertTrue("Claim is submitted", lp.addVerification.isDisplayed());
		click(DeviceSessionManager.getDriver(), lp.ok);
	}

	@Given("the user tap free card subscription")
	public void the_user_tap_free_card_subscription() {
		click(DeviceSessionManager.getDriver(), lp.free);
	}

	@When("the user validate the free card subscription")
	public void the_user_validate_the_free_card_subscription() {
		String actual = gettext(DeviceSessionManager.getDriver(), lp.freesubs);
		Assert.assertEquals("Free is now active on your account.", actual);
		click(DeviceSessionManager.getDriver(), lp.freeOk);

	}

	@When("the user tap starter card subscription")
	public void the_user_tap_starter_card_subscription() {
		click(DeviceSessionManager.getDriver(), lp.startersubs);
	}

	@When("the user validate the starter card subscription")
	public void the_user_validate_the_starter_card_subscription() {
		String actual = gettext(DeviceSessionManager.getDriver(), lp.startersubs);
		Assert.assertEquals("Starter is now active on your account.", actual);
		click(DeviceSessionManager.getDriver(), lp.freeOk);
	}

	@When("the user tap pro card subscription")
	public void the_user_tap_pro_card_subscription() {
		click(DeviceSessionManager.getDriver(), lp.prosubs);
	}

	@When("the user validate the pro card subscription")
	public void the_user_validate_the_pro_card_subscription() {
		String actual = gettext(DeviceSessionManager.getDriver(), lp.prosubs);
		Assert.assertEquals("Pro is now active on your account.", actual);
		click(DeviceSessionManager.getDriver(), lp.freeOk);
	}

	@When("the user tap enterprice card subscription")
	public void the_user_tap_enterprice_card_subscription() {
		click(DeviceSessionManager.getDriver(), lp.entersubs);
	}

	@When("the user validate the enterprice card subscription")
	public void the_user_validate_the_enterprice_card_subscription() {
		String actual = gettext(DeviceSessionManager.getDriver(), lp.entersubs);
		Assert.assertEquals("Enterprise is now active on your account.", actual);
		click(DeviceSessionManager.getDriver(), lp.freeOk);
	}

}
