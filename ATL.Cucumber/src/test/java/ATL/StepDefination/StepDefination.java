package ATL.StepDefination;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(Cucumber.class)
public class StepDefination {
	public static WebDriver driver;
	@Given("^Launch the browser and Brandintelle application$")
	public void _launch_the_browser_and_brandintelle_application() throws Throwable {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito","--disable-notifications");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("https://qa.m-net.in/login"); //https://qa.m-net.in/login
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@When("^Uaser ID and Password both are correct$")
	public void _uaser_id_and_password_both_are_correct() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/form/div[2]/input")).sendKeys("Sanyuktaa");
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[2]/label/span")).click();
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button/button")).click();
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/form/div[2]/div/input")).sendKeys("Tt@123456");

	}

	@Then("^Click on Login and User should be on Home Page$")
	public void _click_on_login_and_user_should_be_on_home_page() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"m_login\"]/div/div[1]/div/div[2]/div/div/div/div/div/m-login/div[3]/m-spinner-button/button/span/span")).click();
		Thread.sleep(4000);
	}

	@And("^Sraech ATL application$")
	public void _sraech_atl_application() throws Throwable {
		WebElement search = driver.findElement(By.xpath("//*[@id=\"m_quicksearch_input\"]"));
		search.sendKeys("Estimate");
		Thread.sleep(3000);
		WebElement SelATL = driver.findElement(By.xpath("//*[@id=\"m_quicksearch\"]/m-portlet/div/div[3]/perfect-scrollbar/div/div[1]/div/div/div/div[1]/div[2]/span[1]"));
		SelATL.click();
	}
	@Then("^Click on Import Estimate from menu$")
	public void _click_on_import_estimate_from_menu() throws Throwable {
		Thread.sleep(8000);
		driver.switchTo().frame(0);

		Actions action = new Actions(driver);
		WebElement ClickHam= driver.findElement(By.xpath("//*[@id=\"m_header\"]/div/div/div[1]/div"));
		action.moveToElement(ClickHam).click().build().perform();

		WebElement clksidebar = driver.findElement(By.xpath("//*[@id=\"m_ver_menu\"]/ul[3]/li/a/i[1]"));
		action.moveToElement(clksidebar).click().build().perform();
		Thread.sleep(3000);

		WebElement selest = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/ul[3]/li[1]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
		action.moveToElement(selest).click().build().perform();
		Thread.sleep(3000);
		System.out.println("2");
		Thread.sleep(3000);
		driver.switchTo().frame(0);

		WebElement selmedium = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[2]/div/ng-multiselect-dropdown/div/div[1]/span"));
		selmedium.click();
		WebElement TVmedium = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[2]/div/ng-multiselect-dropdown/div/div[2]/ul[2]/li[1]/div"));
		TVmedium.click();
		WebElement selbrand = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[3]/div[1]/div[1]/div/button/span/span/i"));
		selbrand.click();
		Thread.sleep(5000);

		Actions actionB = new Actions(driver);
		WebElement selbr1 = driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
		actionB.moveToElement(selbr1).sendKeys("Brand 1").build().perform();
		Thread.sleep(3000);

		WebElement brand = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-brandmaster/div/mat-dialog-content/table/tbody/tr[1]"));
		brand.click();

		WebElement clkagency = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[4]/div[1]/div/div/button/span/span/i"));
		clkagency.click();
		Thread.sleep(3000);
		Actions action1 = new Actions(driver);
		WebElement seragency = driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
		action1.moveToElement(seragency).sendKeys("AARTI ADVERTISING");
		Thread.sleep(2000);
		WebElement selagency = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-vendormaster/div/mat-dialog-content/table/tbody/tr[1]/td[1]"));
		selagency.click();

		WebElement selcamp = driver.findElement(By.xpath("//*[@id=\"m_wizard_form_step_1\"]/div/div[4]/div[2]/div/div/button"));
		selcamp.click();
		Thread.sleep(3000);
		Actions action2 = new Actions(driver);
		WebElement sercamp = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-campaignmaster/div/div/mat-form-field/div/div[1]/div/input"));
		action2.moveToElement(sercamp).sendKeys("First Campaign");
		Thread.sleep(2000);
		WebElement firstcamp = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/mat-dialog-container/app-campaignmaster/div/mat-dialog-content/table/tbody/tr[1]/td[1]"));
		firstcamp.click();

		WebElement savencon = driver.findElement(By.xpath("//*[@id=\"m_wizard\"]/div[2]/div[2]/div/div/div[1]/form/div[2]/div/div/div[3]/button"));
		savencon.click();

		WebElement impest = driver.findElement(By.xpath("//*[@id=\"m-dropzone-two\"]"));
		impest.click();

		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Automation testing\\AutoITWorkspace\\FileUpload_ATLEST.exe");
		Thread.sleep(3000);

		WebElement apply = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/form/div[1]/div[2]/button"));
		apply.click();

		WebElement savecont = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[2]/form/div[3]/div/div/div[3]/button"));
		savecont.click();

		WebElement correlation = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[3]/form/div[2]/div/div/div[3]/button"));
		correlation.click();

		WebElement clkattachment = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[4]/form/div[1]/div[2]/div"));
		clkattachment.click();

		Thread.sleep(3000);
		Runtime.getRuntime().exec("E:\\Automation testing\\AutoITWorkspace\\FileUpload_ATLAttach.exe");
		Thread.sleep(3000);

		WebElement saveconattach = driver.findElement(By.xpath("//*[@id=\"m_wizard\"]/div[2]/div[2]/div/div/div[4]/form/div[2]/div/div/div[3]/button"));
		saveconattach.click();

		WebElement save = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/app-import-estimate/div[2]/div/div/div/div[2]/div[2]/div/div/div[5]/form/div/div[2]/div/div/div[3]/button"));
		save.click();

		Thread.sleep(3000);

		WebElement saveest = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/button[1]"));
		saveest.click();
		Thread.sleep(3000);
	}

	@And("^close the Browser$")
	public void _close_the_browser() throws Throwable {
		driver.close();
	}

}