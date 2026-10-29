package Com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BDPage {

	 public AndroidDriver driver;

	    public  BDPage(AndroidDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(
	            new AppiumFieldDecorator(driver, Duration.ofSeconds(5)),this);
	    }

	    
	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	    public WebElement profileTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business owner\")")
	    public WebElement ownerLabel;

	    @AndroidFindBy(xpath = "//*[@text='Open business dashboard' or @content-desc='Open business dashboard']")
	    public WebElement openDashboardButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create a listing\")")
	    public WebElement createListingButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Claim an existing listing\")")
	    public WebElement claimListingButton;

	    
	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business dashboard\")")
	    public WebElement dashboardTitle;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Overview\")")
	    public WebElement overviewTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leads\")")
	    public WebElement leadsTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reviews\")")
	    public WebElement reviewsTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Analytics\")")
	    public WebElement analyticsTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Plan\")")
	    public WebElement planTab;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Views\")")
	    public WebElement viewsMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Calls\")")
	    public WebElement callsMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"WhatsApp\")")
	    public WebElement whatsappMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Directions\")")
	    public WebElement directionsMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquiries\")")
	    public WebElement enquiriesMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leads\")")
	    public WebElement leadsMetric;

	    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Your listings\")")
	    public WebElement yourListings;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bloom Beauty Studio\")")
	    public WebElement bloomBeautyStudio;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"HomeFix Pro\")")
	    public WebElement homeFixPro;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"QuickShift Auto\")")
	    public WebElement quickShiftAuto;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Aarogya Clinic\")")
	    public WebElement aarogyaClinic;

	    // ==============================
	    // LEADS
	    // ==============================

	    @AndroidFindBy(xpath = "(//*[@text='New'])[1]")
	    public WebElement newStatus;

	    @AndroidFindBy(xpath = "(//*[@text='Contacted'])[1]")
	    public WebElement contactedStatus;

	    @AndroidFindBy(xpath = "(//*[@text='Interested'])[1]")
	    public WebElement interestedStatus;

	    @AndroidFindBy(xpath = "(//*[@text='Converted'])[1]")
	    public WebElement convertedStatus;

	    // ==============================
	    // REVIEWS
	    // ==============================

	    @AndroidFindBy(xpath = "(//*[@text='Reply'])[1]")
	    public WebElement replyButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Testing\")")
	    public WebElement reviewText;

	    // ==============================
	    // ANALYTICS
	    // ==============================

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"MONTH TO DATE\")")
	    public WebElement monthToDate;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Total customer interactions\")")
	    public WebElement totalInteractions;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"7-day trends\")")
	    public WebElement sevenDayTrends;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Channel breakdown\")")
	    public WebElement channelBreakdown;

	    // ==============================
	    // SUBSCRIPTION PLANS
	    // ==============================

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"CURRENT PLAN\")")
	    public WebElement currentPlan;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enterprise\")")
	    public WebElement enterprisePlan;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\")")
	    public WebElement freePlan;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Starter\")")
	    public WebElement starterPlan;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pro\")")
	    public WebElement proPlan;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Switch to Free\")")
	    public WebElement switchToFreeButton;

	    @AndroidFindBy(xpath = "(//*[@text='Upgrade'])[1]")
	    public WebElement upgradeButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"List your business\")")
	    public WebElement listingPageTitle;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Camera\")")
	    public WebElement cameraButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gallery\")")
	    public WebElement galleryButton;

	    @AndroidFindBy(xpath = "//*[@text=\"e.g. Mira's Studio\" or @hint=\"e.g. Mira's Studio\"]")
	    public WebElement businessNameField;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty clinic\")")
	    public WebElement beautyClinicCategory;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pet Care\")")
	    public WebElement petCareCategory;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Electronics\")")
	    public WebElement electronicsCategory;

	    @AndroidFindBy(xpath = "//*[@text='What makes your business special?' or @hint='What makes your business special?']")
	    public WebElement businessDescriptionField;

	    @AndroidFindBy(xpath = "//*[@text='Building, street, landmark' or @hint='Building, street, landmark']")
	    public WebElement streetAddressField;

	    @AndroidFindBy(xpath = "//*[@text='Anna Nagar' or @hint='Anna Nagar']")
	    public WebElement areaField;

	    @AndroidFindBy(xpath = "//*[@text='Chennai' or @hint='Chennai']")
	    public WebElement cityField;

	    @AndroidFindBy(xpath = "//*[@text='600040' or @hint='600040']")
	    public WebElement pincodeField;

	    @AndroidFindBy(xpath = "//*[@text='+91 90000 00000' or @hint='+91 90000 00000']")
	    public WebElement phoneField;

	    @AndroidFindBy(xpath = "//*[@text='Same as phone' or @hint='Same as phone']")
	    public WebElement whatsappField;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit for verification\")")
	    public WebElement submitVerificationButton;

	    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquiries\")")
	    public WebElement enquiriesPageTitle;

	    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"I would like to know more\")")
	    public WebElement firstEnquiry;

	    @AndroidFindBy(xpath = "(//*[@text='NEW'])[1]")
	    public WebElement newEnquiryStatus;
	}


