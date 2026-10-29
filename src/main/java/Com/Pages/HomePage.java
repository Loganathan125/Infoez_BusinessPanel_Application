package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class HomePage {

	public AndroidDriver driver;

	public HomePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement notifySymbol;
	
	@AndroidFindBy(xpath  = "//*[string-length(@text)>0 and translate(@text,'0123456789','')='' or string-length(@content-desc)>0 and translate(@content-desc,'0123456789','')='']")
	public WebElement beforeCount;
	
//	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").descriptionContains(\"Murali\").instance(0)")
//	public WebElement firstNotification;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(1)")
	public WebElement firstNotification;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")")
	public WebElement locationField;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"city-search-input\")")
	public WebElement searchCities;
	
	@AndroidFindBy(xpath = "//*[contains(translate(@text,'CHENNAI','chennai'),'chennai') or contains(translate(@content-desc,'CHENNAI','chennai'),'chennai')]")
	public WebElement cityoption;
	
//	@AndroidFindBy(xpath = "//*[contains(@text,'Chennai') or contains(@content-desc,'Chennai')]")
//	public WebElement selectedLocation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai, India\")")
	public WebElement selectedLocation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Near me\")")
	public WebElement nearMeOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_one_time_button\")")
	public WebElement onlyThisTimeOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement turnOnOption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No matches yet\")")
	public WebElement NoMatchesYet;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement navigationBack;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Use my current location\")")
	public WebElement useMyCurrentLocation;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement searchBar;
	
	@AndroidFindBy(xpath  = "//android.view.ViewGroup[starts-with(@resource-id,'save-business-')]")
	public WebElement favouriteIcon;
	
	@AndroidFindBy(xpath   = "//android.widget.TextView[@text='Saved']")
	public WebElement savedButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'places worth coming back to')]")
	public WebElement savedPlaces;

	@AndroidFindBy(xpath = "//android.widget.Button[starts-with(@resource-id,'business-card-')][1]")
	public WebElement businessCard;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Call\")")
	public WebElement call;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"WhatsApp\")")
	public WebElement whatsapp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.whatsapp:id/title\")")
	public WebElement whatsappTitle;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Directions\")")
	public WebElement directions;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enquire\")")
	public WebElement enquire;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tell the business what you need...\")")
	public WebElement sendAnEnquiry;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Send enquiry\")")
	public WebElement sendEnquiry;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement EnquirySend;
	
	@AndroidFindBy(xpath  = "(//android.view.ViewGroup[@clickable='true'])[1]")
	public WebElement navigateBackk;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement profile;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement adminPage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in or register\")")
	public WebElement loginAsRegister;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Customer\")")
	public WebElement customer;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Log in\").instance(1)")
	public WebElement login;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement customerProfile;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"My enquiries\")")
	public WebElement myEnquirys;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement shareBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(1)")
	public WebElement copy;
	
	@AndroidFindBy(xpath  = "//android.widget.Toast[@text=\"Copied to clipboard.\"]")
	public WebElement copied;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"What are you looking for?\")")
	public WebElement findLocal;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement findBar;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"business-card-cc741254-9389-4f7d-bbdd-c8b319abb2c7\")")
	public WebElement kiaqBusiness;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Search\"]")
	public WebElement search;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Verified\").instance(0)")
	public WebElement verifiedoption;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Verified\").instance(1)")
	public WebElement verified;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Open today')]")
	public List<WebElement> openToday;
	
	
	@AndroidFindBy(xpath = "//*[contains(@text,'places found')]/following::*[@text='Verified']")
	public WebElement verified1;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'places found')]")
	public WebElement placeFound;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explore businesses\"]")
	public WebElement exploreBusinessPage;
	
	@AndroidFindBy(xpath  = "//*[starts-with(resource-id,'business-card-')]")
	public List<WebElement> placeCards;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"4+ rating\")")
	public WebElement ratings;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"5.0\").instance(0)")
	public WebElement ratingValue;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Featured\")")
	public WebElement featured;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Map view\")")
	public WebElement mapView;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"List view\")")
	public WebElement listView;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Back to list\")")
	public WebElement backToList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'places on the map')]")
	public WebElement placesOnMap;
	
	@AndroidFindBy(xpath = "//*[starts-with(@resource-id,'map-pin-')]")
	public List<WebElement> mapcards;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement searchBusiness;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No matches yet\")")
	public WebElement nomatchYet;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement controlcenter;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Control center\")")
	public WebElement controlPage;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"See all\")")
	public WebElement seeAll;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"View all\")")
	public WebElement viewAll;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Most relevant\")")
	public WebElement mostRelevent;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(15)")
	public WebElement verifiedOnly;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(18)")
	public WebElement featuredOnly;
	
	@AndroidFindBy(xpath = "//*[starts-with(@text,'Show') and contains(@text,'results')]")
	public WebElement showResult;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Reset\")")
	public WebElement reset;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement manageBusiness;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business dashboard\")")
	public WebElement businessDashboard;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Filters & sort\")")
	public WebElement filterSort;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Top rated\")")
	public WebElement topRated;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"4+\")")
	public WebElement rating4;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Newest\")")
	public WebElement newest;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"4.5+\")")
	public WebElement rating5;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Most reviewed\")")
	public WebElement mostReviewed;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"No matches. Try a different name.\")")
	public WebElement invalid1;
	
	
	
	
}
