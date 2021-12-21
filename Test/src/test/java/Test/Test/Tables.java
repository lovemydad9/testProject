package Test.Test;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.tools.xjc.Driver;

public class Tables extends HomePage {

	public static void main(String[] args) {
		HomePage tb = new HomePage();
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getWindowHandle());
		WebElement table=driver.findElement(By.xpath("//*[@id='countries']"));
		js.executeScript("arguments[0].scrollIntoView();", table);
		System.out.println(table.getSize());
		List<WebElement> Row = table.findElements(By.xpath("//tbody/tr"));
		Iterator<WebElement> Rowiterator =Row.iterator();
		
		while(Rowiterator.hasNext())
		{
			WebElement row =Rowiterator.next();
			List<WebElement> Col =row.findElements(By.xpath("td"));
			Iterator<WebElement> Coliterator =Col.iterator();
			while(Coliterator.hasNext())
					{
						WebElement column = Coliterator.next();
						
						System.out.println(column.getText());
					}
			
			
			
		}
		System.out.println(Row.size());
		
		
		
		
		
				
				
				

	}

}
