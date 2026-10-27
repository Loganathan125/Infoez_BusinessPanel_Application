package Com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.And;

public class LoginPage {
	public AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\", Profile\")")
	public WebElement profileBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Log in or register\")")
	public WebElement registerBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-email\")")
	public WebElement UserName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-password\")")
	public WebElement Password;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-submit\")")
	public WebElement LoginBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement invalidEmail;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement emptyEmail;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement emptyPass;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement Invalid1;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement invalid2;
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement invalid3;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement invalid4;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement invalid5;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement invalid6;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement Invalid7;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement Invalid8;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement invalid9;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Infoez\")")
	public WebElement Valid;
	
	}
