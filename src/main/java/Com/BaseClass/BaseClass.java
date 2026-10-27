package Com.BaseClass;


import java.time.Duration;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.Scenario;

import java.util.ArrayList;
import java.util.Collection;
public class BaseClass {
	private static final Duration TIMEOUT = Duration.ofSeconds(80);

	public static AndroidDriver driver;
	public static void click(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));

		element.click();
	}

	public static void visibilityWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void ViewWait(AndroidDriver driver,WebElement firstApproveBtn) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

	}

	public static void clickableWait(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void sendKeys(AndroidDriver driver, WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.visibilityOf(element));

		element.click();
		element.clear();
		element.sendKeys(text);
		driver.hideKeyboard();
	}
	public void pressEnter(AndroidDriver driver) {
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}
	public void clear(AndroidDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);

		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.clear();
	}

	public static boolean displayed(AndroidDriver driver, WebElement element) {

		return element.isDisplayed();
	}

//
//  public static void takeScreenshot(AndroidDriver driver,String fileName) throws Exception {
//
//      TakesScreenshot ts = (TakesScreenshot) driver;
//
//      File source = ts.getScreenshotAs(OutputType.FILE);
//
//      File destination = new File("screenshots/" + fileName + ".png");
//
//      FileUtils.copyFile(source, destination);
//  }

//	public String ScreenShots(AndroidDriver driver, String Scenario) {
//		String timeStamp = LocalDateTime.now().toString().replace(":", "_");
//		String filePath = System.getProperty("user.dir") + "/ScreenShots/" + Scenario + "_" + timeStamp + ".png";
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File temp = ts.getScreenshotAs(OutputType.FILE);
//		File dest = new File(filePath);
//		try {
//			org.openqa.selenium.io.FileHandler.copy(temp, dest);
//		} catch (Exception e) {
//			throw new RuntimeException("Screenshot is Not Captured");
//		}
//		return filePath;
//	}

	public static void takeScreenshot(AndroidDriver driver, Scenario scenario, String status) {

		try {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			String screenshotName = status + " - " + scenario.getName();
			scenario.attach(screenshot, "image/png", screenshotName);
			System.out.println("Screenshot attached to Cucumber report: " + screenshotName);
		} catch (Exception e) {
			System.out.println("Screenshot failed: " + e.getMessage());
		}
	}
	

	

	public static void swipeUp(AndroidDriver driver) {

		driver.executeScript("mobile: swipeGesture",
				Map.of("left", 100, "top", 100, "width", 200, "height", 600, "direction", "up", "percent", 0.75));
	}

	public static void swipeDown(AndroidDriver driver) {

		driver.executeScript("mobile: scrollGesture",
				Map.of("left", 100, "top", 800, "width", 800, "height", 900, "direction", "down", "percent", 0.5));
	}
	public static void ScrollList(AndroidDriver driver) {
		try {
			WebElement list=driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().scrollable(true)"));
		
  
		driver.executeScript("mobile: scrollGesture",
				Map.of("elementId",((RemoteWebElement) list).getId(),"direction", "down", "percent", 0.5));
		}
		 catch (Exception e) {
			 driver.executeScript("mobile: scrollGesture",
						Map.of("left", 100, "top", 800, "width", 800, "height", 900, "direction", "down", "percent", 0.5));
		}
		try {
			Thread.sleep(800);
		} catch (InterruptedException ignored) {
			
		}
	}
	
	public String gettext(AndroidDriver driver,WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return element.getText();

	}
	public void scrollToElementByText(AndroidDriver driver, String text) {
		 
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
		 
		+ ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
		}
	public void ScrollLeft(AndroidDriver driver) {
		
		 org.openqa.selenium.Dimension size = driver.manage().window().getSize();
		 int y = (int) (size.getHeight()*0.42);
		  int startX = (int) (size.getWidth()*0.85);
		 int endX=(int) (size.getWidth()*0.15);
		 PointerInput finger=new PointerInput(PointerInput.Kind.TOUCH, "finger");
		 Sequence swipe=new Sequence(finger, 1);
		 swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX,y));
		 swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		 swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, y));
		 swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		java.util.List<Sequence> actions=new ArrayList<>();
		actions.add(swipe);
		driver.perform(actions);
//		int yPos=800;
//		 driver.executeScript("mobile: swipeGesture",
//					Map.of("left", 50, "top", yPos, "width", screenWidth-100, "height", 100, "direction", "left", "percent", 0.75));
	}
	
	public void scrollCategoriesUntilvisible(AndroidDriver driver,WebElement scrollEducation) {
		int screenWWidth = driver.manage().window().getSize().getWidth();
		System.out.println("Screen Width: "+ screenWWidth);
		for(int i=0;i<10;i++) {
			
			
			try {
				Rectangle rect = scrollEducation.getRect();
				System.out.println("Try "+i+"-> X="+rect.getX()+"width="+rect.getWidth());
				int centerX = rect.getX()+rect.getWidth()/2;
				if(centerX >0 && centerX < screenWWidth){
					return;
					
				}
			} catch (Exception e) {
				System.out.println("Try"+i+"->Education not found: "+e.getClass().getSimpleName());
			}

			}
			ScrollLeft(driver);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ignored) {
				
			}
			throw new NoSuchElementException("Category not visible after swiping");
		}

	}

	

