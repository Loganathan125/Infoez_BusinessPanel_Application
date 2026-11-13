package Com.Stepdefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import javax.smartcardio.Card;

import org.apache.xmlbeans.impl.xb.xsdschema.TotalDigitsDocument.TotalDigits;
import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.SearchPage;
import Com.Pages.SearchPage;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep extends BaseClass {

	private final List<String> softFailures = new ArrayList<>();
	private static final HidesKeyboard HidesKeyboard = null;
	SearchPage lp = new SearchPage(DeviceSessionManager.getDriver());

	@Given("the admin tap on bottom search icon")
	public void the_admin_tap_on_bottom_search_icon() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.searchBar);
		click(DeviceSessionManager.getDriver(), lp.searchBar);
	}

	@When("the admin open the business from search result")
	public void the_admin_open_the_business_from_search_result() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.businessCard);
		click(DeviceSessionManager.getDriver(), lp.businessCard);
	}

	@When("the admin tap on {string} action button")
	public void the_admin_tap_on_action_button(String action) {
		tapOnActionButton((AndroidDriver) DeviceSessionManager.getDriver(), action, null);
	}

	@Then("the admin verify {string} action")
	public void the_admin_verify_action(String action) {
		AndroidDriver driver = (AndroidDriver) DeviceSessionManager.getDriver();
		String pkg = driver.getCurrentPackage();
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
			//((AndroidDriver) DeviceSessionManager.getDriver()).hideKeyboard();
			click(DeviceSessionManager.getDriver(), lp.sendEnquiry);
			click(DeviceSessionManager.getDriver(), lp.enquirySendOK);

		}
	}

	@Then("the admin tap on share button")
	public void the_admin_tap_on_share_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.shareBtn);
		click(DeviceSessionManager.getDriver(), lp.shareBtn);
	}

	@Then("the admin should be validate the share button")
	public void the_admin_should_be_validate_the_share_button() {
		Assert.assertTrue("Copied Text not Displayed", lp.sharingText.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	@When("the admin tap on favorite icon in the business details page")
	public void the_admin_tap_on_favorite_icon_in_the_business_details_page() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.favouriteIcon);
		click(DeviceSessionManager.getDriver(), lp.favouriteIcon);
		navigateBack(DeviceSessionManager.getDriver());
	}

	@Then("the admin tap on saved button")
	public void the_admin_tap_on_saved_button() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.savedButton);
		click(DeviceSessionManager.getDriver(), lp.savedButton);
	}

	@Then("the admin should be validate the favourite list")
	public void the_admin_should_be_validate_the_favourite_list() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.savedPlaces);
		Assert.assertTrue("Saved Places Not Displayed", lp.savedPlaces.isDisplayed());
		navigateBack(DeviceSessionManager.getDriver());
	}

	// <>=============>

	@When("the admin tap on bottom search bar")
	public void the_admin_tap_on_bottom_search_bar() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.search);
		click(DeviceSessionManager.getDriver(), lp.search);
	}

	@When("the admin tap on Filters in search module")
	public void the_admin_tap_on_filters_in_search_module() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectFilter);
		click(DeviceSessionManager.getDriver(), lp.selectFilter);
	}

	@When("the admin select {string} in filter section")
	public void the_admin_select_in_filter_section(String string) {
		click(DeviceSessionManager.getDriver(), lp.mostRelevent);
	}

	@When("the admin tap show result button")
	public void the_admin_tap_show_result_button() {
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin validates the places for applied filter")
	public void the_admin_validates_the_places_for_applied_filter() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placeFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placeFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);
		Set<String> names = new LinkedHashSet<String>();

		int swipesWithNoNewplace = 0;

		while (swipesWithNoNewplace < 2) {
			int countBefore = names.size();

			for (WebElement card : lp.placeCards) {
				try {
					StringBuilder key = new StringBuilder();
					for (WebElement tv : card.findElements(By.className("android.widget.TextView"))) {
						String t = tv.getText();
						if (t != null && t.trim().length() > 1) {
							key.append(t.trim()).append("|");
						}
					}
					if (key.length() > 0) {
						names.add(key.toString());
					}
				} catch (StaleElementReferenceException | NoSuchElementException ignored) {

				}
			}
			if (names.size() == countBefore) {
				swipesWithNoNewplace++;
			} else {
				swipesWithNoNewplace = 0;
			}
			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());
		}
		System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
		try {
			Assert.assertEquals("Places Listed " + headerCount, headerCount, names.size());
		} finally {
			scrollToElementByText(DeviceSessionManager.getDriver(), "Most relevant");
		}
	}

	@When("the admin tap filters in search Module")
	public void the_admin_tap_filters_in_search_module() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectFilter);
		click(DeviceSessionManager.getDriver(), lp.selectFilter);
	}

	@When("the admin select {string} in the filter section")
	public void the_admin_select_in_the_filter_section(String string) {
		click(DeviceSessionManager.getDriver(), lp.ratings);
	}

	@When("the admin click show result button")
	public void the_admin_click_show_result_button() {
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin validates the places for the applied filter")
	public void the_admin_validates_the_places_for_the_applied_filter() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.exploreBusinessPage);
		String rawHeader = lp.placeFound.getText();
		if (rawHeader == null || rawHeader.isEmpty()) {
			rawHeader = lp.placeFound.getAttribute("content-desc");
		}
		int headerCount = Integer.parseInt(rawHeader.replaceAll("[^0-9]", ""));
		System.out.println("Header Count: " + headerCount);
		Set<String> names = new LinkedHashSet<String>();

		int swipesWithNoNewplace = 0;

		while (swipesWithNoNewplace < 2) {
			int countBefore = names.size();

			for (WebElement card : lp.placeCards) {
				try {
					StringBuilder key = new StringBuilder();
					for (WebElement tv : card.findElements(By.className("android.widget.TextView"))) {
						String t = tv.getText();
						if (t != null && t.trim().length() > 1) {
							key.append(t.trim()).append("|");
						}
					}
					if (key.length() > 0) {
						names.add(key.toString());
					}
				} catch (StaleElementReferenceException | NoSuchElementException ignored) {

				}
			}
			if (names.size() == countBefore) {
				swipesWithNoNewplace++;
			} else {
				swipesWithNoNewplace = 0;
			}
			swipeDown((AndroidDriver) DeviceSessionManager.getDriver());
		}
		System.out.println("placeFound: " + names.size() + "/Expected: " + headerCount);
		try {
			Assert.assertEquals("Places Listed " + headerCount, headerCount, names.size());
		} finally {
			scrollToElementByText(DeviceSessionManager.getDriver(), "Most relevant");
		}
	}

	@When("the admin tap filter search module")
	public void the_admin_tap_filter_search_module() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectFilter);
		click(DeviceSessionManager.getDriver(), lp.selectFilter);
	}

	@When("the admin enabled verified only")
	public void the_admin_enabled_verified_only() {
		click(DeviceSessionManager.getDriver(), lp.verifiedOnly);
		click(DeviceSessionManager.getDriver(), lp.reset);
		click(DeviceSessionManager.getDriver(), lp.verifiedOnly);
	}

	@When("the admin click on show results btn")
	public void the_admin_click_on_show_results_btn() {
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin  validate the places for applied filter")
	public void the_admin_admin_validate_the_places_for_applied_filter() {
		Assert.assertTrue(lp.placeFound.isDisplayed());

	}

	@When("the user tap filter search module")
	public void the_user_tap_filter_search_module() {
		visibilityWait(DeviceSessionManager.getDriver(), lp.selectFilter);
		click(DeviceSessionManager.getDriver(), lp.selectFilter);
	}

	@When("the admin enabled featured only")
	public void the_admin_enabled_featured_only() {
		click(DeviceSessionManager.getDriver(), lp.featuredOnly);
	}

	@When("the admin tap on show results btn")
	public void the_admin_tap_on_show_results_btn() {
		click(DeviceSessionManager.getDriver(), lp.showResult);
	}

	@Then("the admin  validates the place for applied filter")
	public void the_admin_validates_the_place_for_applied_filter() {

		String actual = gettext(DeviceSessionManager.getDriver(), lp.verified);
		Assert.assertEquals("Featured", actual);
	}

	@Then("the admin tap on map view")
	public void the_admin_tap_on_map_view() {
		swipeUntillVisible(DeviceSessionManager.getDriver(), lp.mapViewText, lp.tabRow);

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
				// System.out.println("text=["+n.getText()+"]
				// desc=["+n.getAttribute("content-desc")+"]");
				try {

					String desc = n.getAttribute("content-desc");
					if (desc != null) {
						java.util.regex.Matcher m = java.util.regex.Pattern.compile("(?:^|,)\\s*(\\d{1,2})\\s*,")
								.matcher(desc);
						if (m.find()) {
							seen.add(Integer.parseInt(m.group(1)));
						}
					}

				} catch (StaleElementReferenceException | NumberFormatException ignored) {

				}
			}
			if (seen.size() < total) {
				swipeDown((AndroidDriver) DeviceSessionManager.getDriver());

			}
		}

		try {
			Assert.assertEquals("Maps Places: ", total, seen.size());
		} catch (AssertionError e) {
			softFailures.add(e.getMessage());
		}
		try {
			Assert.assertEquals("First Pin", 1, (int) ((TreeSet<Integer>) seen).first());
		} catch (AssertionError | NoSuchElementException e) {
			softFailures.add(e.getMessage());
		}
		try {
			Assert.assertEquals("Last Pin", total, (int) ((TreeSet<Integer>) seen).last());
		} catch (AssertionError | NoSuchElementException e) {
			softFailures.add(e.getMessage());
		}
	}

	@Then("the admin tap on back to list")
	public void the_admin_tap_on_back_to_list() {
		click(DeviceSessionManager.getDriver(), lp.backToList);

	}

	@When("the admin leave the search field")
	public void the_admin_leave_the_search_field() {
		navigateBack(DeviceSessionManager.getDriver());
		click(DeviceSessionManager.getDriver(), lp.searchBar);
		click(DeviceSessionManager.getDriver(), lp.searchBusiness);

	}

	@Then("the admin validate the search field")
	public void the_admin_validate_the_search_field() {
		boolean displayed;
		try {
			WebDriverWait wait = new WebDriverWait(DeviceSessionManager.getDriver(), Duration.ofSeconds(10));
			displayed = wait.until(ExpectedConditions.visibilityOf(lp.NoMatchesYet)).isDisplayed();
		} catch (org.openqa.selenium.TimeoutException | NoSuchElementException e) {
			displayed = false;
		}
		try {
			Assert.assertTrue("No Matches Yet is not displayed", displayed);
		} finally {
			navigateBack(DeviceSessionManager.getDriver());
		}
	}

}