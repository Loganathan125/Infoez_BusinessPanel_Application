package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ExploreCategoryPage {

	public AndroidDriver driver;

	public ExploreCategoryPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Beauty clinic\")")
	public WebElement beautyClinic;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Explore businesses\"]")
	public WebElement exploreBusinessPage;

	@AndroidFindBy(xpath = "//*[contains(@text,'places found')]")
	public WebElement placesFound;

	@AndroidFindBy(xpath  = "//android.widget.TextView[contains(@text,'reviews')]/preceding-sibling::android.widget.TextView[1]")
	public List<WebElement> placeCards;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pet Care\")")
	public WebElement petCare;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Electronics\")")
	public WebElement electronics;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Bakeries\")")
	public WebElement backeries;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Robotics\")")
	public WebElement robotics;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"12345\")")
	public WebElement numbers;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Restarunts\")")
	public WebElement restaurants;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Yoga\")")
	public WebElement yoga;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\")")
	public WebElement NavigationBack;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\", Fitness & Wellness\"]/android.widget.TextView[@text=\"\"]")
	public WebElement scrollEducation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"\"]")
	public WebElement filterSection;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Most relevant\"]")
	public WebElement mostRelevant;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Any\"]")
	public WebElement any;
	
	@AndroidFindBy(xpath = "//*[starts-with(@text,'Show') and contains(@text,'results')]")
	public WebElement showResult;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"search-input\")")
	public WebElement clear;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"3+\"]")
	public WebElement Rating3;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[starts-with(@content-desc,',')]")
	public WebElement tapRow;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Automative\")")
	public WebElement automative;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"home-location\")")
	public WebElement locationField;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Chennai\")")
	public WebElement city;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Featured in Chennai\")")
	public WebElement featured;
	

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(1)")
	public WebElement cafeBackery;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(3)")
	public WebElement Fitness;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(0)")
	public WebElement AutoRepair;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(1)")
	public WebElement HealthMedical;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(2)")
	public WebElement Retail;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(3)")
	public WebElement Education;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"\").instance(2)")
	public WebElement BeautySpa;

}
