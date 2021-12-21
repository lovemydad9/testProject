package Test.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	public static String finalcity;
	static WebDriver driver =initializeDriver();
	static JavascriptExecutor js = (JavascriptExecutor) driver;
	static TakesScreenshot scrShot =((TakesScreenshot)driver);
	public static WebDriver initializeDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\cpraveenkumarredd\\Documents\\chromedriver_win32\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	public static void selectCity(WebDriver driver,String City)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> ls = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for (WebElement w : ls)
		{
			WebElement city=w.findElement(By.xpath("div/div/p"));
			finalcity=city.getText();
			js.executeScript("arguments[0].scrollIntoView(true);",city );
			if(finalcity.contains(City))
			{
				w.click();
			}
			System.out.println("Entered Correctly");
		}
	}
	public static void flightBooking()  {
		
		
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		System.out.println(driver.findElement(By.xpath("//*[@id='fromCity']")).isDisplayed());
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='fromCity']"))).doubleClick().perform();
		WebElement fromCity=driver.findElement(By.xpath("//*[@placeholder='From']"));
		fromCity.sendKeys("Mumbai");
		selectCity(driver,"Mumbai");
		WebElement toCity=driver.findElement(By.xpath("//*[@placeholder='To']"));
		toCity.sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		selectCity(driver,"Hyderabad");

	}
	
	public static void main(String[] args) throws IOException {
		//flightBooking();
		String test="Praveen";
		char[] a =test.toCharArray();
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		
		FileInputStream fis =new FileInputStream(new File("C:\\Users\\cpraveenkumarredd\\Documents\\testing.xlsx"));
		XSSFWorkbook  wb= new XSSFWorkbook(fis);
		XSSFSheet ws = wb.getSheetAt(0);
		int RowNo = ws.getLastRowNum()	- ws.getFirstRowNum();
		System.out.println(RowNo);
		Iterator<Row> rowIterator =ws.rowIterator();
		String colValue;
		while(rowIterator.hasNext())
		{
			Row r = (Row) rowIterator.next();
			Iterator<Cell> Coliterator = r.cellIterator();
			while(Coliterator.hasNext())
			{
				Cell cell = Coliterator.next();
				colValue =cell.getStringCellValue();
				System.out.println(colValue);
				
			}	
		}
		
		wb.close();
	}
}


	
		
		
		
		
		
		
