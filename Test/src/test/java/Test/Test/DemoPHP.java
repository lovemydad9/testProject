package Test.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
//import org.apache.commons.io.FileUtilsorg.apache.commons.io.FileUtils;

import com.sun.tools.xjc.Driver;

public class DemoPHP extends HomePage
{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new HomePage();
		driver.manage().window().maximize();
		//= new File("C:\\Users\\cpraveenkumarredd\\Documents\\demo.xlsx");
		//"C:\Users\cpraveenkumarredd\Desktop\531968IPSF202122"
		driver.get("https://phptravels.com/");
		File  testOutput;
		testOutput=scrShot.getScreenshotAs(OutputType.FILE);
		
		driver.findElement(By.linkText("Demo")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		String homePageWidow=driver.getWindowHandle();
		Set<String> handles=driver.getWindowHandles();
		for(String handle: handles)
		{
			driver.switchTo().window(handle);
			System.out.println(driver.getWindowHandle());
		}
		//driver.switchTo().window(homePageWidow);
		String text=driver.findElement(By.xpath("//*[@class='main-title go-right h3']/strong")).getText();
		testOutput=scrShot.getScreenshotAs(OutputType.FILE);
		System.out.println(text);
		File DestFile=new File("C:\\Users\\cpraveenkumarredd\\Documents\\demo1.png");
	FileUtils.copyFile(testOutput, DestFile);
	System.out.println("done");
		
	}

}
