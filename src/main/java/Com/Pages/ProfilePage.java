package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class ProfilePage {

	public AndroidDriver driver;

	public ProfilePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Profile\")")
	public WebElement profile;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create a listing\")")
	public WebElement createListing;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"List your business\")")
	public WebElement listYourBusiness;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Camera\")")
	public WebElement camera;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gallery\")")
	public WebElement gallery;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(21)")
	public WebElement photos;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\")")
	public WebElement imageView;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(5)")
	public WebElement image1;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(4)")
	public WebElement image2;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(3)")
	public WebElement image3;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(2)")
	public WebElement image4;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(1)")
	public WebElement image5;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.sec.android.gallery3d:id/deco_view_layout\").instance(0)")
	public WebElement image6;
	
	@AndroidFindBy(uiAutomator = "(//*[@resource-id='com.sec.android.gallery3d:id/deco_view_layout'])[position()<=6]")
	public WebElement restaurant;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").instance(3)")
	public WebElement done;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-name\")")
	public WebElement businessName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty clinic\")")
	public WebElement category;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-description\")")
	public WebElement description;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-address\")")
	public WebElement streetaddress;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-area\")")
	public WebElement area;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-city\")")
	public WebElement city;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-phone\")")
	public WebElement phone;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-pincode\")")
	public WebElement pincode;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"create-whatsapp\")")
	public WebElement whatsApp;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Claim an existing listing\")")
	public WebElement createExisting;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"claim-search\")")
	public WebElement claimSearch;
	
	@AndroidFindBy(xpath = "//*[@text='Already claimed']")
	public List<WebElement> searchResult;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit for verification\")")
	public WebElement submit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"A\").instance(1)")
	public WebElement dental;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"claim-details\")")
	public WebElement claimDeatil;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Submit claim\")")
	public WebElement submitClaim;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement claimSubmit;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement donePopup;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.infoez.app:id/alert_title\")")
	public WebElement addVerification;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement ok;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Name, category, address, area, and phone are required.\")")
	public WebElement invalid;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Free\").instance(1)")
	public WebElement free;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Plan\"]/preceding-sibling::android.widget.TextView[11]")
	public WebElement subscription;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	public WebElement freesubs;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	public WebElement freeOk;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	public WebElement startersubs;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	public WebElement prosubs;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enterprise\").instance(1)")
	public WebElement entersubs;
	
	
	
	
	
	
	
}
