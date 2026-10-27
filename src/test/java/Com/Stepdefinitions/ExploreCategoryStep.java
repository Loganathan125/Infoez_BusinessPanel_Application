package Com.Stepdefinitions;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.openxml4j.util.ZipInputStreamZipEntrySource;
import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import Com.BaseClass.BaseClass;
import Com.Driver.DeviceSessionManager;
import Com.Pages.ExploreCategoryPage;
import Com.Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExploreCategoryStep extends BaseClass {
	ExploreCategoryPage lp = new ExploreCategoryPage(DeviceSessionManager.getDriver());

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
		visibilityWait(DeviceSessionManager.getDriver(), lp.mostRelevant);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
	}

	@Given("the users select Health&Medical category")
	public void the_users_select_health_medical_category() {
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
			Assert.assertEquals("places Listed " + headerCount, names.size());

		}
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
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
		click(DeviceSessionManager.getDriver(), lp.NavigationBack);
	}
}
