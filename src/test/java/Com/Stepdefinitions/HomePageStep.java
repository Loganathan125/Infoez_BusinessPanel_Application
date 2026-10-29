package Com.Stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import javax.smartcardio.Card;

import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep extends BaseClass {

	HomePage lp = new HomePage(DeviceSessionManager.getDriver());

	@Given("the user tap on location field")
	public void the_user_tap_on_location_field() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.locationField);
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@When("the user search city {string}")
	public void the_user_search_city(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.searchCities);
		sendKeys(DeviceSessionManager.getDriver(), lp.searchCities, string);
	}

	@When("the user select city {string} from the list")
	public void the_user_select_city_from_the_list(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.cityoption);
		click(DeviceSessionManager.getDriver(), lp.cityoption);
	}

	@Then("the home page should display location {string}")
	public void the_home_page_should_display_location(String location) {

		switch (location) {
		case "invalid1":
		case "invalid2":
			String actual1 = gettext(DeviceSessionManager.getDriver(), lp.invalid1);
			Assert.assertEquals("No matches. Try a different name.", actual1);
			System.out.println(actual1);

			break;
		default:
			visibilityWait(DeviceSessionManager.getDriver(), lp.cityoption);
			click(DeviceSessionManager.getDriver(), lp.cityoption);
			visibilityWait(DeviceSessionManager.getDriver(), lp.selectedLocation);
			Assert.assertTrue("The Location did not selected", lp.selectedLocation.isDisplayed());
			break;
		}

	}

	@Then("the admin tap on lodation field")
	public void the_admin_tap_on_lodation_field() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.locationField);
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@Then("the amin tap on use my current location")
	public void the_amin_tap_on_use_my_current_location() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.useMyCurrentLocation);
		click(DeviceSessionManager.getDriver(), lp.useMyCurrentLocation);
	}

	@Then("the admin tap on this time option")
	public void the_admin_tap_on_this_time_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.turnOnOption);
	}

	@Then("use my current location should be displayed")
	public void use_my_current_location_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
		Assert.assertFalse("FAIL: NO Matches Yet Message is Displayed", lp.NoMatchesYet.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());

	}

	@Then("the admin tap near me option")
	public void the_admin_tap_near_me_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.nearMeOption);
		click(DeviceSessionManager.getDriver(), lp.nearMeOption);
	}

	@Then("the admin tap on only this time option")
	public void the_admin_tap_on_only_this_time_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
	}

	@Then("the admin tap turn on option")
	public void the_admin_tap_turn_on_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.turnOnOption);
		click(DeviceSessionManager.getDriver(), lp.turnOnOption);
	}

	@Then("the Nearby business should be displayed")
	public void the_nearby_business_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
		boolean result = lp.NoMatchesYet.isDisplayed();
		Assert.assertFalse("FAIL: NO Matches Yet Message is Displayed", result);
	}

	@Given("the admin click on search bar")
	public void the_admin_click_on_search_bar() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.searchBar);
		click(DeviceSessionManager.getDriver(), lp.searchBar);
	}

	@When("the admin tap on any Business name")
	public void the_admin_tap_on_any_business_name() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.businessCard);
		click(DeviceSessionManager.getDriver(), lp.businessCard);
	}

	@When("the admin tap call function")
	public void the_admin_tap_call_function() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.call);
		click(DeviceSessionManager.getDriver(), lp.call);
	}

	@Then("the admin should be validate the call functionality")
	public void the_admin_should_be_validate_the_call_functionality() {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		@Nullable
		String pkg = driver.getCurrentPackage();
		System.out.println("Current Package: " + pkg);
		Assert.assertTrue("Dialer Not Opened,current package: " + pkg,
				pkg.contains("dialer") || pkg.contains("contacts") || pkg.contains("incallui"));
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap whatsapp function")
	public void the_admin_tap_whatsapp_function() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.whatsapp);
		click(DeviceSessionManager.getDriver(), lp.whatsapp);
	}

	@Then("the admin should be validate the whatsapp functionality")
	public void the_admin_should_be_validate_the_whatsapp_functionality() {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		@Nullable
		String pkg = driver.getCurrentPackage();
		System.out.println("Current Package: " + pkg);
		System.out.println("Current Activity: " + driver.currentActivity());
		Assert.assertTrue("WhatsApp Not Opend: " + pkg, pkg.contains("WhatsApp"));

		visibilityWait(DeviceSessionManager.getDriver(), lp.whatsappTitle);
		Assert.assertTrue("Welcome Screen Not Displayed :", lp.whatsappTitle.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap directions functions")
	public void the_admin_tap_directions_functions() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.directions);
		click(DeviceSessionManager.getDriver(), lp.directions);
	}

	@Then("the admin should be redirected to maps")
	public void the_admin_should_be_redirected_to_maps() {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ignored) {

		}
		String pkg = driver.getCurrentPackage();
		System.out.println("Current Package: " + pkg);
		boolean mapsOpened = pkg.contains("maps");
		Assert.assertTrue("FAIL: Maps Not Opened.current package: " + pkg, mapsOpened);
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap enquire functions")
	public void the_admin_tap_enquire_functions() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.enquire);
		click(DeviceSessionManager.getDriver(), lp.enquire);
	}

	@Then("the admin enter enquiry message and send")
	public void the_admin_enter_enquiry_message_and_send() {
		sendKeys(DeviceSessionManager.getDriver(), lp.sendAnEnquiry, "Tell the Business");
		((AndroidDriver) DeviceSessionManager.getDriver()).hideKeyboard();
		click(DeviceSessionManager.getDriver(), lp.sendEnquiry);

	}

	@Then("the admin tap on share button")
	public void the_admin_tap_on_share_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.shareBtn);
		click(DeviceSessionManager.getDriver(), lp.shareBtn);
	}

	@Then("the admin should be validate the share button")
	public void the_admin_should_be_validate_the_share_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.copy);
		click(DeviceSessionManager.getDriver(), lp.copy);
		// Assert.assertTrue("Copied Text not Displayed", lp.copied.isDisplayed());
	}

	@Then("the admin tap on favorite icon")
	public void the_admin_tap_on_favorite_icon() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.favouriteIcon);
		click(DeviceSessionManager.getDriver(), lp.favouriteIcon);
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap on saved button")
	public void the_admin_tap_on_saved_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.savedButton);
		click(DeviceSessionManager.getDriver(), lp.savedButton);
	}

	@Then("the admin should be validate the favourite icon")
	public void the_admin_should_be_validate_the_favourite_icon() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.savedPlaces);
		Assert.assertTrue("Saved Places Not Displayed", lp.savedPlaces.isDisplayed());
	}
	// <>=============>

	@Given("the admin enter a value {string}")
	public void the_admin_enter_a_value(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.findLocal);
		lp.findLocal.click();

		sendKeys(DeviceSessionManager.getDriver(), lp.findLocal, string);

	}

	@When("the admin tap search bar")
	public void the_admin_tap_search_bar() {
		click(DeviceSessionManager.getDriver(), lp.findBar);
	}

//	@Then("the admin verify no result found")
//	public void the_admin_verify_no_result_found() {
//		visibilityWait(DeviceSessionManager.getDriver(), lp.nomatchYet);
//		Assert.assertTrue("No restults message not displayed", lp.NoMatchesYet.isDisplayed());
//		navigateBack(DeviceSessionManager.getDriver());
//		
//		
//	}

	@Then("the admin verify no result found {string}")
	public void the_admin_verify_no_result_found(String result) {

		switch (result) {
		case "invalid":
			String actual = gettext(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
			Assert.assertTrue("No restults message not displayed", lp.NoMatchesYet.isDisplayed());
			navigateBack(DeviceSessionManager.getDriver());
			break;
		case "valid":
			lp.findLocal.click();
			lp.findLocal.clear();
			// sendKeys(DeviceSessionManager.getDriver(), lp.findLocal,searchfield);
			String actual1 = gettext(DeviceSessionManager.getDriver(), lp.NoMatchesYet);
			Assert.assertTrue("No restults message not displayed", lp.NoMatchesYet.isDisplayed());
			break;

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap on  search bar")
	public void the_admin_tap_on_search_bar() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.search);
		click(DeviceSessionManager.getDriver(), lp.search);
	}

	@Then("the admin verify result found")
	public void the_admin_verify_result_found() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue(lp.exploreBusinessPage.isDisplayed());
	}

	@Then("the admin tap mostRelevant")
	public void the_admin_tap_most_relevant() {
		click(DeviceSessionManager.getDriver(), lp.mostRelevent);
	}

	@Then("the admin should be validate most relevant filter")
	public void the_admin_should_be_validate_most_relevant_filter() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.filterSort);
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin tap on top rated filter")
	public void the_admin_tap_on_top_rated_filter() {
		click(DeviceSessionManager.getDriver(), lp.mostRelevent);
		click(DeviceSessionManager.getDriver(), lp.topRated);

	}

	@Then("the admin tap rating {int}+")
	public void the_admin_tap_rating(Integer int1) {
		click(DeviceSessionManager.getDriver(), lp.rating4);
		click(DeviceSessionManager.getDriver(), lp.showResult);

	}

	@Then("the admin  should be validate the top rated filter")
	public void the_admin_should_be_validate_the_top_rated_filter() {
		Assert.assertTrue(lp.topRated.isDisplayed());
	}

	@Then("the admin tap on newest filter")
	public void the_admin_tap_on_newest_filter() {
		click(DeviceSessionManager.getDriver(), lp.topRated);
		click(DeviceSessionManager.getDriver(), lp.newest);
	}

	@Then("the admin tap rating {double}")
	public void the_admin_tap_rating(Double double1) {
		click(DeviceSessionManager.getDriver(), lp.rating5);
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin should be validate the newest")
	public void the_admin_should_be_validate_the_newest() {
		Assert.assertTrue(lp.newest.isDisplayed());
	}

	@Then("the admin tap on most reviewed")
	public void the_admin_tap_on_most_reviewed() {
		click(DeviceSessionManager.getDriver(), lp.newest);
		click(DeviceSessionManager.getDriver(), lp.mostReviewed);
		click(DeviceSessionManager.getDriver(), lp.showResult);

	}

	@Then("the admin should be validated the most reviewed")
	public void the_admin_should_be_validated_the_most_reviewed() {
		Assert.assertTrue(lp.mostReviewed.isDisplayed());
	}

	@Then("the admin tap verified only")
	public void the_admin_tap_verified_only() {
		click(DeviceSessionManager.getDriver(), lp.mostReviewed);
		click(DeviceSessionManager.getDriver(), lp.verifiedOnly);
	}

	@Then("the admin tap featured only")
	public void the_admin_tap_featured_only() {
		click(DeviceSessionManager.getDriver(), lp.featuredOnly);
	}

	@Then("the admin tap show result")
	public void the_admin_tap_show_result() {
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin click on verified card")
	public void the_admin_click_on_verified_card() {
		click(DeviceSessionManager.getDriver(), lp.verified);
	}

	@Then("the admin validate the  verified card")
	public void the_admin_validate_the_verified_card() {
		click(DeviceSessionManager.getDriver(), lp.featured);
	}

	@Then("the admin click on rating card")
	public void the_admin_click_on_rating_card() {
		click(DeviceSessionManager.getDriver(), lp.ratings);
	}

	@Then("the admin validate the  rating card")
	public void the_admin_validate_the_rating_card() {
		Assert.assertTrue(lp.ratingValue.isDisplayed());
	}

	@Then("the admin tap on feature card")
	public void the_admin_tap_on_feature_card() {
		click(DeviceSessionManager.getDriver(), lp.featured);
	}

	@Then("the admin validate the the featured card")
	public void the_admin_validate_the_the_featured_card() {
		String actual = gettext(DeviceSessionManager.getDriver(), lp.featured);
		Assert.assertEquals("Verified", actual);
	}

	@Then("the admin tap on map view")
	public void the_admin_tap_on_map_view() {
		scrollCategoriesUntilvisible((AndroidDriver) DeviceSessionManager.getDriver(), lp.mapView);
		click(DeviceSessionManager.getDriver(), lp.mapView);
	}

	@Then("the admin verify the list view")
	public void the_admin_verify_the_list_view() {
		Assert.assertTrue(lp.listView.isDisplayed());
	}

	@Then("the admin verify the places on the map")
	public void the_admin_verify_the_places_on_the_map() {
		int total = Integer.parseInt(lp.placesOnMap.getText().replaceAll("[^0-9]", ""));

		Set<Integer> seen = new TreeSet<Integer>();
		int prev = -1;
		for (int i = 0; i < 100 && seen.size() < total && seen.size() != prev; i++) {
			prev = seen.size();
			for (WebElement n : lp.mapcards) {
				try {
					seen.add(Integer.parseInt(n.getText().trim()));
				} catch (StaleElementReferenceException | NumberFormatException ignored) {

				}
			}
			if (seen.size() < total) {
				swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

			}
		}

		System.out.println("Pins Found: " + seen);
		Assert.assertEquals("Maps Places: ", total, seen.size());
		Assert.assertEquals("First Pin", 1, (int) ((TreeSet<Integer>) seen).first());
		Assert.assertEquals("Last Pin", total, (int) ((TreeSet<Integer>) seen).last());
	}

	@Then("the admin tap on back to list")
	public void the_admin_tap_on_back_to_list() {
		click(DeviceSessionManager.getDriver(), lp.backToList);
	}

	@When("the admin leave the search field")
	public void the_admin_leave_the_search_field() {
		click(DeviceSessionManager.getDriver(), lp.searchBusiness);
	}

	@Then("the admin validate the search field")
	public void the_admin_validate_the_search_field() {
		Assert.assertTrue("No Matches Yet is not displayed", lp.NoMatchesYet.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap on control center card")
	public void the_admin_tap_on_control_center_card() {
		click(DeviceSessionManager.getDriver(), lp.searchBusiness);
	}

	@Then("the admin validate the control center page")
	public void the_admin_validate_the_control_center_page() {
		Assert.assertTrue(lp.controlPage.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap see all")
	public void the_admin_tap_see_all() {
		click(DeviceSessionManager.getDriver(), lp.seeAll);
		Assert.assertTrue(lp.exploreBusinessPage.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap view all")
	public void the_admin_tap_view_all() {
		click(DeviceSessionManager.getDriver(), lp.viewAll);
		Assert.assertTrue(lp.exploreBusinessPage.isDisplayed());
	}
}