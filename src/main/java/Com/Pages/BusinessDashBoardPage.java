package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class BusinessDashBoardPage {

	public AndroidDriver driver;

	public BusinessDashBoardPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement profile;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Open business dashboard\")")
	public WebElement openBusinessDashboard;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business dashboard\")")
	public WebElement businessDashBoard;

	@AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Your listings')]/following-sibling::android.view.ViewGroup)[1]")
	public WebElement listingHeader;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Your listings')]")
	public WebElement yourListings;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement active;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Your listings')]/following-sibling::android.view.ViewGroup")
	public List<WebElement> listingCards;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Views']/../android.widget.TextView[2]")
	public WebElement viewCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Calls\"]/preceding-sibling::android.widget.TextView[2]")
	public WebElement callsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WhatsApp']/following-sibling::android.widget.TextView[2]")
	public WebElement whatsappCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Directions']/following-sibling::android.widget.TextView[2]")
	public WebElement directionsCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Enquiries']/following-sibling::android.widget.TextView[2]")
	public WebElement enquiresCard;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.whatsapp:id/title\")")
	public WebElement whatsappTitle;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement directionsOk;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement enquirySendOK;

	public WebElement metricCard(String metric) {
		switch (metric) {
		case "Views":
			return viewCard;
		case "Calls":
			return callsCard;
		case "WhatsApp":
			return whatsappCard;
		case "Directions":
			return directionsCard;
		case "Enquiries":
			return enquiresCard;
		default:
			throw new IllegalArgumentException("Unknown Metric: " + metric);

		}

	}

	public WebElement actionsButton(String action) {
		switch (action) {
		case "call":
			return call;
		case "WhatsApp":
			return whatsapp;
		case "Directions":
			return directions;
		case "Enquire":
			return enquire;

		default:
			throw new IllegalArgumentException("Unknown actions: "+action);
		}
		

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Call\")")
	public WebElement call;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"WhatsApp\")")
	public WebElement whatsapp;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Directions\")")
	public WebElement directions;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquire\")")
	public WebElement enquire;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tell the business what you need...\")")
	public WebElement sendAnEnquiry;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Send enquiry\")")
	public WebElement sendEnquiry;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Write a review\")")
	public WebElement writeARevirew;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"What stood out?\")")
	public WebElement writeReview;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Publish review\")")
	public WebElement publishReview;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement reviewPublished;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement publishedOk;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement alreadyShared;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement shareBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.android.intentresolver:id/headline\"]")
	public WebElement sharingText;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement favouriteIcon;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Saved\")")
	public WebElement saved;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'places worth coming back to')]")
	public WebElement savedPlaces;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Leads\").instance(0)")
	public WebElement leadsTap;
	
	@AndroidFindBy(xpath = "(//android.widget.TextView[@text='Ravi'])[1]/following-sibling::android.widget.HorizontalScrollView[1]")
	public WebElement tapRow;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reviews\")")
	public WebElement reviews;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reply\").instance(0)")
	public WebElement replyBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"owner-reply-input\")")
	public WebElement replyTo;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Post reply\")")
	public WebElement postReply;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement replyPosted;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement replyOK;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"owner-tab-plan\")")
	public WebElement planText;
	
	@AndroidFindBy(xpath  = "//android.widget.HorizontalScrollView/android.view.ViewGroup")
	public WebElement tabRow;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Starter']/following::*[@text='Upgrade' or @content-desc='Upgrade'][1]")
	public WebElement upgrade;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"PhonePe\")")
	public WebElement phonepe;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"payment-confirm\")")
	public WebElement paymentConfirm;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement planAcive;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement planOK;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Starter\").instance(0)")
	public WebElement starter;
	
	
	
	
	
}
