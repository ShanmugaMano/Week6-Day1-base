package base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilis.ReadExcel2;

public class ProjectSpecificMethods {
	public  ChromeDriver driver;
	public String excelFileName;
	
	@DataProvider
	public String[][] sendData() throws IOException{
		return ReadExcel2.excelRead(excelFileName);
	}
	
	@BeforeMethod
	public void startApp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	

}
@AfterMethod
	public void postCondition() {
		driver.close();
	}
}