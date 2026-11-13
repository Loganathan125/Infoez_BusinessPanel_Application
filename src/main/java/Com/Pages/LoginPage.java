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

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Please fill every field.\")")
	public WebElement pleaseFillField;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Enter a valid email address.\")")
	public WebElement enterAEmail;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Invalid credentials\")")
	public WebElement InvalidCredentials;

	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Infoez\")")
	public WebElement Valid;

}
