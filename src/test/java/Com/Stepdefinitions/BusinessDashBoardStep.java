package Com.Stepdefinitions;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.ISDTContent;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.BusinessDashBoardPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BusinessDashBoardStep extends BaseClass {

	private static final String APP_PACKAGE = null;
	BusinessDashBoardPage lp = new BusinessDashBoardPage(DeviceSessionManager.getDriver());

	@Given("the user tap on  business dashboard card")
	public void the_user_tap_on_business_dashboard_card() {

		click(DeviceSessionManager.getDriver(), lp.profile);
		click(DeviceSessionManager.getDriver(), lp.openBusinessDashboard);
		Assert.assertTrue(lp.businessDashBoard.isDisplayed());
	}

	private int readCount(String metric) {
		long end = System.currentTimeMillis() + 8000;
		while (System.currentTimeMillis() < end) {
			List<WebElement> tvs = DeviceSessionManager.getDriver()
					.findElements(By.className("android.widget.TextView"));

			for (int i = 1; i < tvs.size(); i++) {
				if (tvs.get(i).getText().contains(metric)) {

					String num = tvs.get(i - 1).getText().replaceAll("[^0-9]", "");
					if (!num.isEmpty()) {
						return Integer.parseInt(num);

					}
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {

				}
			}
		}

		throw new AssertionError("Could not read count for " + metric);

	}

	private void captureAfterCounts() {
		afterCounts.clear();

		for (String m : METRICS) {
			afterCounts.put(m, readCount(m));
		}
		System.out.println("After: " + afterCounts);
	}

	Map<String, Integer> beforeCounts = new LinkedHashMap<>();
	Map<String, Integer> afterCounts = new LinkedHashMap<>();
	String[] METRICS = { "Views", "Calls", "WhatsApp", "Directions", "Enquiries" };

	@When("the user note all the counts on the dashbaord")

	public void the_user_note_all_the_counts_on_the_dashbaord() {
		beforeCounts.clear();

		for (String m : METRICS) {
			beforeCounts.put(m, readCount(m));
		}
		System.out.println("Before: " + beforeCounts);

	}

	@When("the user open a random listion from {string}")
	public void the_user_open_a_random_listion_from(String string) {

		click(DeviceSessionManager.getDriver(), lp.active);

	}

	@When("the admin tap on {string} action btn")
	public void the_admin_tap_on_action_btn(String action) {
		tapOnActionButton((AndroidDriver) DeviceSessionManager.getDriver(), action, null);
	}

	@Then("the admin verify the {string} action")
	public void the_admin_verify_the_action(String action) throws InterruptedException {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		String pkg = driver.getCurrentPackage();
		AssertionError pending = null;
		switch (action.toLowerCase()) {
		case "call":
			Assert.assertTrue("Dialer Not Opened,current package: " + pkg,
					pkg.contains("dialer") || pkg.contains("contacts") || pkg.contains("incallui"));
			navigateBack(DeviceSessionManager.getDriver());
			navigateBack(DeviceSessionManager.getDriver());
			navigateBack(DeviceSessionManager.getDriver());
			break;

		case "whatsapp":
			Assert.assertTrue("Welcome Screen Not Displayed :", lp.whatsappTitle.isDisplayed());
			navigateBack(DeviceSessionManager.getDriver());
			navigateBack(DeviceSessionManager.getDriver());
			break;

		case "directions":

			try {
				Assert.assertFalse("Maps not opened,Current package: " + pkg,
						pkg.toLowerCase().contains("maps") || lp.directionsOk.isDisplayed());
			} catch (AssertionError e) {
				pending = e;
			} finally {
				try {
					click(DeviceSessionManager.getDriver(), lp.directionsOk);
				} catch (Exception e) {

				}
				driver.activateApp("com.infoez.app");
				navigateBack(DeviceSessionManager.getDriver());
			}

			break;
		case "enquire":
			sendKeys(DeviceSessionManager.getDriver(), lp.sendAnEnquiry, "Tell the Business");
			Thread.sleep(2000);
			click(DeviceSessionManager.getDriver(), lp.sendEnquiry);
			click(DeviceSessionManager.getDriver(), lp.enquirySendOK);
			navigateBack(DeviceSessionManager.getDriver());
			break;
		}
		captureAfterCounts();
		navigateBack(DeviceSessionManager.getDriver());
		if (pending != null)
			throw pending;

	}

	// ---------- Listings count scenario ----------

	private int headertotal;
	private final Set<String> seenListings = new LinkedHashSet<>();

	@Given("the user read the total from the {string} header")
	public void i_read_the_total_from_the_header(String header) {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		String txt = gettext(DeviceSessionManager.getDriver(), lp.yourListings);
		headertotal = Integer.parseInt(txt.replaceAll("[^0-9]", ""));
		System.out.println("Before: " + header + "=" + headertotal);
	}

	private void collectListingNames(AndroidDriver driver) {

	}

	@When("the user scroll to the end of the listings")
	public void i_scroll_to_the_end_of_the_listings() {

	}

	@Then("the number of unique listings should equal the header total")
	public void the_number_of_unique_listings_should_equal_the_header_total() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	// --------------------------------//-------------------

	@Given("the user tap business dashboard card")
	public void the_user_tap_business_dashboard_card() {
		click(DeviceSessionManager.getDriver(), lp.openBusinessDashboard);
	}

	@When("the user tap on any business card")
	public void the_user_tap_on_any_business_card() {
		click(DeviceSessionManager.getDriver(), lp.active);
	}

	private boolean reviewPublished;

	private boolean iDisplayedSafe(WebElement element) {
		try {
			return element.isDisplayed();

		} catch (Exception e) {
			return false;
		}

	}

	private boolean alreadySharedShown;

	@When("the user tap on write a review")
	public void the_user_tap_on_write_a_review() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Reviews");
		click(DeviceSessionManager.getDriver(), lp.writeARevirew);

		if (iDisplayedSafe(lp.writeReview)) {

			sendKeys(DeviceSessionManager.getDriver(), lp.writeReview, "Great Service");
			click(DeviceSessionManager.getDriver(), lp.publishReview);
			reviewPublished = true;
		} else {
			alreadySharedShown = iDisplayedSafe(lp.alreadyShared);
			click(DeviceSessionManager.getDriver(), lp.publishedOk);
			reviewPublished = false;
		}

	}

	@Then("the user verify the review")
	public void the_user_verify_the_review() {
		if (reviewPublished) {
			Assert.assertTrue("The Review is not published", lp.publishReview.isDisplayed());
			click(DeviceSessionManager.getDriver(), lp.publishedOk);
		} else {
			System.out.println("Already Shared");
			Assert.assertTrue("Already shared message not show ", alreadySharedShown);
		}

	}

	@Then("the admin tap on share btn")
	public void the_admin_tap_on_share_btn() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Address");
		click(DeviceSessionManager.getDriver(), lp.shareBtn);
	}

	@Then("the admin should be validate  share button")
	public void the_admin_should_be_validate_share_button() {
		Assert.assertTrue("Copied Text not Displayed", lp.sharingText.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap  favorite icon in the business details page")
	public void the_admin_tap_favorite_icon_in_the_business_details_page() {
		click(DeviceSessionManager.getDriver(), lp.favouriteIcon);
		navigateBack(DeviceSessionManager.getDriver());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap  saved button")
	public void the_admin_tap_saved_button() {
		click(DeviceSessionManager.getDriver(), lp.saved);
	}

	@Then("the admin should  validate the favourite list")
	public void the_admin_should_validate_the_favourite_list() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.savedPlaces);
		Assert.assertTrue("Saved Places Not Displayed", lp.savedPlaces.isDisplayed());
	}

	@When("the user tap on {string}")
	public void the_user_tap_on(String string) {
		click(DeviceSessionManager.getDriver(), lp.profile);
		click(DeviceSessionManager.getDriver(), lp.openBusinessDashboard);

		click(DeviceSessionManager.getDriver(), lp.leadsTap);

		WebElement leads = lp.tapRow
				.findElement(AppiumBy.xpath(".//*[@text='" + string + "' or @content-desc='" + string + "'][1]"));

		leads.click();
		Assert.assertTrue("Status not enabled", leads.isEnabled());

	}

	@When("the user tap on reviews tab")
	public void the_user_tap_on_reviews_tab() {
		 click(DeviceSessionManager.getDriver(),lp.reviews);

	}

	@Then("the user reply to the review with {string}")
	public void the_user_reply_to_the_review_with(String string) {
		AndroidDriver driver=(AndroidDriver) DeviceSessionManager.getDriver();
		try {
			click(DeviceSessionManager.getDriver(), lp.replyBtn);

		} catch (NoSuchElementException e) {
			System.out.println("No reply button avialable,Skipping");
			return;
		}
		click(DeviceSessionManager.getDriver(), lp.replyTo);
//		driver.executeScript("mobile:shell", java.util.Map.of(
//				"command","input","args",java.util.List.of("text",string.replaceAll(" ", "%s"))
//				));
	 sendKeys(DeviceSessionManager.getDriver(), lp.replyTo, "Great Experince");
		 if(driver.isKeyboardShown()) {
			 driver.hideKeyboard();
		 }
		click(DeviceSessionManager.getDriver(), lp.postReply);
	}

	@Then("the user verify the reply posted message")
	public void the_user_verify_the_reply_posted_message() {
		Assert.assertTrue("Reply posted alert not Displayed", lp.replyPosted.isDisplayed());
		click(DeviceSessionManager.getDriver(), lp.replyOK);
	}

	@Given("the user tap on plan tap")
	public void the_user_tap_on_plan_tap() {
		swipeUntillVisible(DeviceSessionManager.getDriver(), lp.planText, lp.tabRow);
		click(DeviceSessionManager.getDriver(), lp.planText);
	}

	@When("the user tap upgrade on {string}")
	public void the_user_tap_upgrade_on(String string) {
		click(DeviceSessionManager.getDriver(), lp.upgrade);
	}

	@When("the user select payment method {string}")
	public void the_user_select_payment_method(String string) {
		click(DeviceSessionManager.getDriver(), lp.phonepe);

	}

	@When("the user tap on pay button")
	public void the_user_tap_on_pay_button() {
		click(DeviceSessionManager.getDriver(), lp.paymentConfirm);
	}

	@Then("the user verify the plan active {string}")
	public void the_user_verify_the_plan_active(String string) {
		Assert.assertTrue("The plan Is InActive", lp.planAcive.isDisplayed());
		click(DeviceSessionManager.getDriver(), lp.planOK);
		String txt = gettext(DeviceSessionManager.getDriver(), lp.starter);
		System.out.println("The Current Plan: " + txt);
	}

}
