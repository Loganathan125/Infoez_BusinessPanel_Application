package Com.Stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Driver.DriverFactory;
import Com.Pages.BDPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDSteps {

    AndroidDriver driver;
    BDPage page;
    WebDriverWait wait;

    
    @Given("I am logged in as a business owner")
    public void loggedIn() {

        driver = DriverFactory.getDriver();

        Assert.assertNotNull(
                "Appium driver is not initialized",driver);

        page = new BDPage(driver);

        wait = new WebDriverWait(
                driver, Duration.ofSeconds(20));

        Assert.assertTrue( "Business owner account is not logged in",
                page.profileTab.isDisplayed() &&
                page.openDashboardButton.isDisplayed() &&
                page.dashboardTitle.isDisplayed() );
    }

    @When("I navigate to the business owner profile")
    public void openProfile() {

        page.profileTab.click();
    }

    @Then("I verify the business owner profile is displayed")
    public void verifyProfile() {

        Assert.assertTrue(page.ownerLabel.isDisplayed());
    }

    @Then("I verify the {string} button is displayed")
    public void verifyButton(String button) {

        if (button.equals("Open business dashboard")) {
            Assert.assertTrue(page.openDashboardButton.isDisplayed());
        } else {
            Assert.fail("Unknown button: " + button);
        }
    }

    @Then("I verify the {string} option is displayed")
    public void verifyOption(String option) {

        if (option.equals("Create a listing")) {
            Assert.assertTrue(page.createListingButton.isDisplayed());

        } else if (option.equals("Claim an existing listing")) {
            Assert.assertTrue(page.claimListingButton.isDisplayed());

        } else {
            Assert.fail("Unknown option: " + option);
        }
    }

    @When("I click the Open business dashboard button")
    public void clickDashboard() {

        wait.until(ExpectedConditions.elementToBeClickable(
                page.openDashboardButton)).click();
    }

    @When("I navigate to the business dashboard")
    public void navigateDashboard() {

        page.profileTab.click();

        page.openDashboardButton.click();
    }

    @Then("I verify the Business dashboard page is displayed")
    public void verifyDashboard() {

        Assert.assertTrue(page.dashboardTitle.isDisplayed());
    }

    @Then("I verify the dashboard tabs are displayed")
    public void verifyTabs() {

        Assert.assertTrue(page.overviewTab.isDisplayed());
        Assert.assertTrue(page.leadsTab.isDisplayed());
        Assert.assertTrue(page.reviewsTab.isDisplayed());
        Assert.assertTrue(page.analyticsTab.isDisplayed());
    }

    @When("I select the {string} tab")
    public void selectTab(String tab) {

        if (tab.equalsIgnoreCase("Overview")) {
            page.overviewTab.click();

        } else if (tab.equalsIgnoreCase("Leads")) {
            page.leadsTab.click();

        } else if (tab.equalsIgnoreCase("Reviews")) {
            page.reviewsTab.click();

        } else if (tab.equalsIgnoreCase("Analytics")) {
            page.analyticsTab.click();

        } else if (tab.equalsIgnoreCase("Plan")) {
            page.planTab.click();

        } else {
            Assert.fail("Unknown tab: " + tab);
        }
    }

    @Then("I verify the overview metric {string} is displayed")
    public void verifyMetric(String metric) {

        if (metric.equalsIgnoreCase("Views")) {
            Assert.assertTrue(page.viewsMetric.isDisplayed());

        } else if (metric.equalsIgnoreCase("Calls")) {
            Assert.assertTrue(page.callsMetric.isDisplayed());

        } else if (metric.equalsIgnoreCase("WhatsApp")) {
            Assert.assertTrue(page.whatsappMetric.isDisplayed());

        } else if (metric.equalsIgnoreCase("Directions")) {
            Assert.assertTrue(page.directionsMetric.isDisplayed());

        } else if (metric.equalsIgnoreCase("Enquiries")) {
            Assert.assertTrue(page.enquiriesMetric.isDisplayed());

        } else if (metric.equalsIgnoreCase("Leads")) {
            Assert.assertTrue(page.leadsMetric.isDisplayed());

        } else {
            Assert.fail("Unknown metric: " + metric);
        }
    }

   @Then("I verify the business listing {string} is displayed")
    public void verifyListing(String business) {

        if (business.equals("Bloom Beauty Studio")) {
            Assert.assertTrue(page.bloomBeautyStudio.isDisplayed());

        } else if (business.equals("HomeFix Pro")) {
            Assert.assertTrue(page.homeFixPro.isDisplayed());

        } else if (business.equals("QuickShift Auto")) {
            Assert.assertTrue(page.quickShiftAuto.isDisplayed());

        } else if (business.equals("Aarogya Clinic")) {
            Assert.assertTrue(page.aarogyaClinic.isDisplayed());

        } else {
            Assert.fail("Unknown business: " + business);
        }
    }

    @Then("I verify the leads section is displayed")
    public void verifyLeads() {

        Assert.assertTrue(page.newStatus.isDisplayed());
    }

    @Then("I verify the lead status options are displayed")
    public void verifyStatuses() {

        Assert.assertTrue(page.newStatus.isDisplayed());
        Assert.assertTrue(page.contactedStatus.isDisplayed());
        Assert.assertTrue(page.interestedStatus.isDisplayed());
        Assert.assertTrue(page.convertedStatus.isDisplayed());
    }

    @When("I select the first lead")
    public void selectFirstLead() {

        Assert.assertTrue(page.newStatus.isDisplayed());
    }

    @When("I change the lead status to {string}")
    public void changeLeadStatus(String status) {

        if (status.equalsIgnoreCase("New")) {
            page.newStatus.click();

        } else if (status.equalsIgnoreCase("Contacted")) {
            page.contactedStatus.click();

        } else if (status.equalsIgnoreCase("Interested")) {
            page.interestedStatus.click();

        } else if (status.equalsIgnoreCase("Converted")) {
            page.convertedStatus.click();

        } else {
            Assert.fail("Unknown lead status: " + status);
        }
    }

    @Then("I verify the selected lead status is {string}")
    public void verifyLeadStatus(String status) {

        if (status.equalsIgnoreCase("New")) {
            Assert.assertTrue(page.newStatus.isSelected());

        } else if (status.equalsIgnoreCase("Contacted")) {
            Assert.assertTrue(page.contactedStatus.isSelected());

        } else if (status.equalsIgnoreCase("Interested")) {
            Assert.assertTrue(page.interestedStatus.isSelected());

        } else if (status.equalsIgnoreCase("Converted")) {
            Assert.assertTrue(page.convertedStatus.isSelected());

        } else {
            Assert.fail("Unknown lead status: " + status);
        }
    }

    @Then("I verify the reviews section is displayed")
    public void verifyReviews() {

        Assert.assertTrue(page.replyButton.isDisplayed());
    }

    @Then("I verify customer ratings are displayed")
    public void verifyRatings() {

        Assert.fail(
            "Add a star-rating locator to BusinessOwnerPage"
        );
    }

    @Then("I verify the Reply button is displayed")
    public void verifyReplyButton() {

        Assert.assertTrue(page.replyButton.isDisplayed());
    }

    @When("I click the Reply button for the first review")
    public void clickReply() {

        page.replyButton.click();
    }

    @Then("I verify the review reply option is opened")
    public void verifyReplyOpened() {

        Assert.fail(
            "Add a review reply input locator to BusinessOwnerPage"
        );
    }

   @Then("I verify the analytics section {string} is displayed")
    public void verifyAnalytics(String section) {

        if (section.equals("MONTH TO DATE")) {
            Assert.assertTrue(page.monthToDate.isDisplayed());

        } else if (section.equals("Total customer interactions")) {
            Assert.assertTrue(page.totalInteractions.isDisplayed());

        } else if (section.equals("7-day trends")) {
            Assert.assertTrue(page.sevenDayTrends.isDisplayed());

        } else if (section.equals("Channel breakdown")) {
            Assert.assertTrue(page.channelBreakdown.isDisplayed());

        } else {
            Assert.fail("Unknown analytics section: " + section);
        }
    }

    @Then("I verify the current subscription plan is displayed")
    public void verifyCurrentPlan() {

        Assert.assertTrue(page.currentPlan.isDisplayed());
    }

    @Then("I verify the current plan is {string}")
    public void verifyCurrentPlanName(String plan) {

        Assert.assertEquals(
            plan, "Enterprise",
            "Expected plan differs from the configured test account"
        );
        Assert.assertTrue(page.enterprisePlan.isDisplayed());
    }

    @Then("I verify the subscription plan {string} is displayed")
    public void verifySubscription(String plan) {

        if (plan.equals("Free")) {
            Assert.assertTrue(page.freePlan.isDisplayed());

        } else if (plan.equals("Starter")) {
            Assert.assertTrue(page.starterPlan.isDisplayed());

        } else if (plan.equals("Pro")) {
            Assert.assertTrue(page.proPlan.isDisplayed());

        } else if (plan.equals("Enterprise")) {
            Assert.assertTrue(page.enterprisePlan.isDisplayed());

        } else {
            Assert.fail("Unknown plan: " + plan);
        }
    }

    @Then("I verify the subscription plan {string} has price {string}")
    public void verifyPrice(String plan, String price) {

        Assert.fail(
            "Add price locators to BusinessOwnerPage for plan: " + plan
        );
    }

   @When("I click the Create a listing option")
    public void clickCreateListing() {

        page.createListingButton.click();
    }

    @Then("I verify the List your business page is displayed")
    public void verifyListingPage() {

        Assert.assertTrue(page.listingPageTitle.isDisplayed());
    }

    @Then("I verify the Camera option is displayed")
    public void verifyCamera() {

        Assert.assertTrue(page.cameraButton.isDisplayed());
    }

    @Then("I verify the Gallery option is displayed")
    public void verifyGallery() {

        Assert.assertTrue(page.galleryButton.isDisplayed());
    }

    @Then("I verify the business listing fields are displayed")
    public void verifyListingFields() {

        Assert.assertTrue(page.businessNameField.isDisplayed());
        Assert.assertTrue(page.businessDescriptionField.isDisplayed());
    }

    @When("I enter the business name {string}")
    public void enterBusinessName(String name) {

        if (!name.isEmpty()) {
            page.businessNameField.sendKeys(name);
        }
    }

    @When("I select the business category {string}")
    public void selectCategory(String category) {

        if (category.equals("Beauty clinic")) {
            page.beautyClinicCategory.click();

        } else if (category.equals("Pet Care")) {
            page.petCareCategory.click();

        } else if (category.equals("Electronics")) {
            page.electronicsCategory.click();

        } else if (!category.isEmpty()) {
            Assert.fail("Category locator not defined: " + category);
        }
    }

    @When("I enter the business description {string}")
    public void enterDescription(String description) {

        if (!description.isEmpty()) {
            page.businessDescriptionField.sendKeys(description);
        }
    }

    @When("I enter the street address {string}")
    public void enterAddress(String address) {

        if (!address.isEmpty()) {
            page.streetAddressField.sendKeys(address);
        }
    }

    @When("I enter the area {string}")
    public void enterArea(String area) {

        if (!area.isEmpty()) {
            page.areaField.sendKeys(area);
        }
    }

    @When("I enter the city {string}")
    public void enterCity(String city) {

        if (!city.isEmpty()) {
            page.cityField.sendKeys(city);
        }
    }

    @When("I enter the pincode {string}")
    public void enterPincode(String pincode) {

        if (!pincode.isEmpty()) {
            page.pincodeField.sendKeys(pincode);
        }
    }

    @When("I enter the phone number {string}")
    public void enterPhone(String phone) {

        if (!phone.isEmpty()) {
            page.phoneField.sendKeys(phone);
        }
    }

    @When("I enter the WhatsApp number {string}")
    public void enterWhatsapp(String whatsapp) {

        if (!whatsapp.isEmpty()) {
            page.whatsappField.sendKeys(whatsapp);
        }
    }

    @Then("I verify the business listing details are entered")
    public void verifyEnteredDetails() {

        Assert.assertFalse(
            page.businessNameField.getText().isEmpty()
        );
    }

    @When("I click the Submit for verification button")
    public void submitListing() {

        page.submitVerificationButton.click();
    }

    @Then("I verify the business listing is submitted for verification")
    public void verifySubmitted() {

        Assert.fail(
            "Add the actual submission confirmation locator to POM"
        );
    }

    @Then("I verify the business listing is not submitted")
    public void verifyNotSubmitted() {

        Assert.assertTrue(page.listingPageTitle.isDisplayed());
    }

    @Then("I verify the mandatory field {string} is invalid")
    public void verifyMandatoryField(String field) {

        Assert.fail(
            "Add validation message locator for: " + field
        );
    }

   @When("I navigate to the Enquiries page")
    public void navigateEnquiries() {

        Assert.fail(
            "Add Enquiries navigation locator to BusinessOwnerPage"
        );
    }

    @Then("I verify the Enquiries page is displayed")
    public void verifyEnquiriesPage() {

        Assert.assertTrue(page.enquiriesPageTitle.isDisplayed());
    }

    @Then("I verify enquiry cards are displayed")
    public void verifyEnquiryCards() {

        Assert.assertTrue(page.firstEnquiry.isDisplayed());
    }

    @Then("I verify new enquiry status is displayed")
    public void verifyNewEnquiryStatus() {

        Assert.assertTrue(page.newEnquiryStatus.isDisplayed());
    }
}



