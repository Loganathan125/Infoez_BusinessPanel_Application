package Com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CreateAccountPage {
	public AndroidDriver driver;

	public CreateAccountPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);

	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\", Profile\")")
	public WebElement profileBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().description(\"Log in or register\")")
	public WebElement registerBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create account\")")
	public WebElement createAccount;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Business owner\")")
	public WebElement businessOwner;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"register-name\")")
	public WebElement fullName;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-email\")")
	public WebElement email;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login-password\")")
	public WebElement password;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Create account\").instance(1)")
	public WebElement createAccountBtn;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement invalid1;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement invalid2;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement invalid3;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement invalid4;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Password must be at least 8 characters.\")")
	public WebElement invalid5;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email already registered\")")
	public WebElement invalid6;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\\\"Email already registered\\\")")
	public WebElement invalid7;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Email already registered\")")
	public WebElement invalid8;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Infoez\")")
	public WebElement valid;
	
	
}
