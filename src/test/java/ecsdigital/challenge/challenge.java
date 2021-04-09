package ecsdigital.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class challenge {

	@Test
	public void test() throws InterruptedException {
		String path = System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:3000/");
		driver.findElement(By.xpath("//span[text()='Render the Challenge']")).click();
		for (int i = 1; i <= 3; i++) {
			ArrayList<Integer> value = new ArrayList<Integer>();
			List<WebElement> lists = driver.findElements(By.xpath("//tbody/tr[" + i + "]//td"));
			for (WebElement list : lists) {
				value.add(Integer.parseInt(list.getText()));
			}
			int front = 0;
			int size = value.size();
			for (int j = 0; j < size - 1; j++) {
				front += value.get(j);
				int back = 0;
				for (int k = j + 2; k <= size - 1; k++) {
					back += value.get(k);
					if (front == back) {
						Integer x = j+1;
						driver.findElement(
								By.xpath("//div[text()='submit challenge " + i + "'" + "]/following-sibling::input"))
								.sendKeys(x.toString());
					}

				}
			}
		}
		driver.findElement(By.xpath("//div[text()='Your Name']/following-sibling::input")).sendKeys("naveen prasanth ramsamy");
		driver.findElement(By.xpath("(//div //span)[4]")).click();

	}

}
