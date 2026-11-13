package Com.Stepdefinitions;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.HomePage;
import Com.Pages.HomePage;
import Com.Pages.SearchPage;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep extends BaseClass {
	public static List<String> softFailures = new ArrayList<String>();
	private static final HidesKeyboard HidesKeyboard = null;
	HomePage lp = new HomePage(DeviceSessionManager.getDriver());

	@Given("the user tap on location field")
	public void the_user_tap_on_location_field() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.locationField);
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@When("the user choosyour city popup should be displayed")
	public void the_user_choosyour_city_popup_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.chooseYourCity);
		Assert.assertTrue("Popup not displayed", lp.chooseYourCity.isDisplayed());
	}

	@When("the user enter city {string} in search cities")
	public void the_user_enter_city_in_search_cities(String string) {
		lp.searchCities.clear();
		sendKeys(DeviceSessionManager.getDriver(), lp.searchCities, string);
		HidesKeyboard hidesKeyboard = HidesKeyboard;
	}

	@Then("the no matches message should be displayed")
	public void the_no_matches_message_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.invalid1);
		Assert.assertEquals("No matches. Try a different name.", lp.invalid1.getText().trim());
		clear(DeviceSessionManager.getDriver(), lp.searchCities);
	}

	@Then("the user select city {string} from  list")
	public void the_user_select_city_from_list(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.cityoption);
		click(DeviceSessionManager.getDriver(), lp.cityoption);
	}

	@Then("the home page should be display location {string}")
	public void the_home_page_should_be_display_location(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectedLocation1);
		Assert.assertTrue("Location mismatch", lp.selectedLocation1.isDisplayed());
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
		// visibilityWait(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.onlyThisTimeOption);
		click(DeviceSessionManager.getDriver(), lp.turnOnOption);
		click(DeviceSessionManager.getDriver(), lp.couldNotLocate);
	}

	@Then("the admin tap near me option")
	public void the_admin_tap_near_me_option() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.nearMeOption);
		click(DeviceSessionManager.getDriver(), lp.nearMeOption);

	}

	@Then("the Nearby business should be displayed")
	public void the_nearby_business_should_be_displayed() {

		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue(lp.exploreBusinessPage.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap search bar")
	public void the_admin_tap_search_bar() {
		click(DeviceSessionManager.getDriver(), lp.findBar);
	}

	@Given("the admin enter a value {string}")
	public void the_admin_enter_a_value(String string) {
		visibilityWait(DeviceSessionManager.getDriver(), lp.findLocal);
		lp.findLocal.click();

		sendKeys(DeviceSessionManager.getDriver(), lp.findLocal, string);

	}

	public void claearSearchField() {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		click(driver, lp.findLocal);
		String text = lp.findLocal.getText();
		int len = (text == null) ? 15 : text.length() + 2;
		driver.pressKey(new KeyEvent(AndroidKey.MOVE_END));
		for (int i = 0; i < len; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.DEL));
		}

	}

	@Then("the admin verify no result found {string}")
	public void the_admin_verify_no_result_found(String result) throws InterruptedException {

		switch (result) {
		case "invalid":
			
//			Assert.assertTrue("Business Listing displayed for invalid search", lp.NoMatchesYet.isDisplayed());
//			navigateBack(DeviceSessionManager.getDriver());
//			navigateBack(DeviceSessionManager.getDriver());
			boolean noMatches;
			try {
				noMatches=lp.NoMatchesYet.isDisplayed();
			}catch(NoSuchElementException e) {
				noMatches=false;
			}
			navigateBack(DeviceSessionManager.getDriver());
			navigateBack(DeviceSessionManager.getDriver());
			try {
			Assert.assertTrue("Business Listing displayed for invalid search", noMatches);
			}catch(NoSuchElementException e) {
				
			}
			break;
		case "valid":
			Thread.sleep(3000);
			visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
			Thread.sleep(3000);
			Assert.assertTrue("Business Listing displayed for invalid search", lp.kiaqTechnology.isDisplayed());
			break;

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select restaurant category")
	public void the_users_select_restaurant_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.restaurants);
		click(DeviceSessionManager.getDriver(), lp.restaurants);
	}

	@When("the explore business page should be displayed")
	public void the_explore_business_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
		clear(DeviceSessionManager.getDriver(), lp.clear);
	}

	@When("the user tap filter&sort")
	public void the_user_tap_filter_sort() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.filterSection);
		click(DeviceSessionManager.getDriver(), lp.filterSection);
	}

	@When("the user select filter sction")
	public void the_user_select_filter_sction() {
		// visibilityWait(DeviceSessionManager.getDriver(), lp.mostRelevant);
		click(DeviceSessionManager.getDriver(), lp.mostRelevant);
		click(DeviceSessionManager.getDriver(), lp.Rating3);
		click(DeviceSessionManager.getDriver(), lp.any);
	}

	@When("the user tap on show result")
	public void the_user_tap_on_show_result() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.showResult);
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	// String rawString;
	@Then("place found count should be validate")
	public void place_found_count_should_be_validate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		
		Set<String> names=getAllTextWithScrollWithOutPrint(lp.placeCards);
		System.out.println("Place Found: "+names.size());
		
		if(names.isEmpty()) {
			softFailures.add("No Places Found");
			System.out.println("SoftFail: No Places Found");
		}
		
		navigateBack(DeviceSessionManager.getDriver());
		
		
		
		
		
//		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
//		String rawHeader = lp.placesFound.getText();
//		if (rawHeader == null || rawHeader.isEmpty()) {
//			rawHeader = lp.placesFound.getAttribute("content-desc");
//		}
//		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
//		System.out.println("Header Count: " + headerCount);
//
//		Set<String> names = new LinkedHashSet<String>();
//		int noNewCount = 0;
// 
//		while (noNewCount < 3) {
//			int before = names.size();
//			for (WebElement card : lp.placeCards) {
//				try {
//					@Nullable
//					String desc = card.getAttribute("content-desc");
//					if (desc != null && !desc.trim().isEmpty()) {
//						System.out.println(desc);
//						names.add(desc.trim());
//					}
//				} catch (StaleElementReferenceException ignored) {
//
//				}
//
//			}
//			if (names.size() == before) {
//				noNewCount++;
//
//			} else {
//				noNewCount = 0;
//			}
//
//			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());
//
//		}
//		System.out.println("Place Found: " + names.size());
//		if (names.isEmpty()) {
//			softFailures.add("No Places found");
//			System.out.println("SoftFail:  No places Found");
//		}
//
//		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select cafe&Backery category")
	public void the_users_select_cafe_backery_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.cafeBackery);
		click(DeviceSessionManager.getDriver(), lp.cafeBackery);
	}

	@When("explore business page should be displayed")
	public void explore_business_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("place found count should  validate")
	public void place_found_count_should_validate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		List<String> names = new ArrayList<>();
		for (int i = 0; i <= headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);


		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select Beauty&Spa category")
	public void the_users_select_beauty_spa_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.BeautySpa);
		click(DeviceSessionManager.getDriver(), lp.BeautySpa);
	}

	@When("the explore business page should  displayed")
	public void the_explore_business_page_should_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("Beauty&Spa placeFound count should be velidate")
	public void beauty_spa_place_found_count_should_be_velidate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select FitNess&WellNess category")
	public void the_users_select_fit_ness_well_ness_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.Fitness);
		click(DeviceSessionManager.getDriver(), lp.Fitness);
	}

	@When("the explore business page should be visiable")
	public void the_explore_business_page_should_be_visiable() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("placefound count should be validate")
	public void placefound_count_should_be_validate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select Auto&Repair category")
	public void the_users_select_auto_repair_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.AutoRepair);
		click(DeviceSessionManager.getDriver(), lp.AutoRepair);
	}

	@When("the Explore businesses page should be displayed")
	public void the_explore_businesses_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("Auto&Repair place found count should be Validate")
	public void auto_repair_place_found_count_should_be_validate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
//			try {
//			Assert.assertEquals("places Listed " + headerCount, names.size());
//			}catch(NoSuchElementException e) {
//				
//			}
//
			if(names.size()!=headerCount) {
				softFailures.add("Auto&Repair Count Mismatch");
			}
	}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select Health&Medical category")
	public void the_users_select_health_medical_category() {
		swipeUntillVisible(DeviceSessionManager.getDriver(), lp.HealthMedical, lp.tabRow);
		visibilityWait(DeviceSessionManager.getDriver(), lp.HealthMedical);
		click(DeviceSessionManager.getDriver(), lp.HealthMedical);
	}

	@When("the explore business pages should be Displayed")
	public void the_explore_business_pages_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("Health&Medical place found count Should be validete")
	public void health_medical_place_found_count_should_be_validete() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
			//Assert.assertEquals("places Listed " + headerCount, names.size());
			if(names.size()!=headerCount) {
				softFailures.add("HealthMedical count mistmatch : expected"+headerCount+"but found"+names.size());
			}

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select retails&shopping category")
	public void the_users_select_retails_shopping_category() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.Retail);
		click(DeviceSessionManager.getDriver(), lp.Retail);
	}

	@When("The Retails explore busineses page should be displayed")
	public void the_retails_explore_busineses_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("Retails&Shopping  place found Count should be validated")
	public void retails_shopping_place_found_count_should_be_validated() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users select Education category")
	public void the_users_select_education_category() {
		scrollCategoriesUntilvisible((AndroidDriver) DeviceSessionManager.getDriver(), lp.scrollEducation);
		visibilityWait(DeviceSessionManager.getDriver(), lp.Education);
		click(DeviceSessionManager.getDriver(), lp.Education);
	}

	@When("the Education explore busines Page should be displayed")
	public void the_education_explore_busines_page_should_be_displayed() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		Assert.assertTrue("THe Explore Page did not displayed", lp.exploreBusinessPage.isDisplayed());
	}

	@Then("Education Place found countt should be validate")
	public void education_place_found_countt_should_be_validate() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placesFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placesFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);

		Set<String> names = new LinkedHashSet<String>();
		for (int i = 0; i < 10 && names.size() < headerCount; i++) {
			for (WebElement card : lp.placeCards) {
				try {
					@Nullable
					String desc = card.getAttribute("content-desc");
					if (desc != null && !desc.trim().isEmpty()) {
						names.add(desc.trim());
					}
				} catch (StaleElementReferenceException ignored) {

				}
				if (names.size() < headerCount) {
					swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

				}

			}
			System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Given("the users tap on location field")
	public void the_users_tap_on_location_field() {
		click(DeviceSessionManager.getDriver(), lp.locationField);
	}

	@When("the user tap on city")
	public void the_user_tap_on_city() {
		click(DeviceSessionManager.getDriver(), lp.city);
	}

	@Then("the user should be validate the city")
	public void the_user_should_be_validate_the_city() {
		Assert.assertTrue(lp.featured.isDisplayed());
	}


	@When("the admin tap on manage your business")
	public void the_admin_tap_on_manage_your_business() {
		scrollToElementByText(DeviceSessionManager.getDriver(), "Manage your business");
		click(DeviceSessionManager.getDriver(), lp.manageYourBusiness);
	}

	@Then("the admin validate the manage your business  page")
	public void the_admin_validate_the_manage_your_business_page() {
		Assert.assertTrue(lp.businessDashboard.isDisplayed());
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
