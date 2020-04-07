package selenium;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium2 {

	public static void main(String[] args) {
		ArrayList<String> shopList = ReadLine.makeShopList();

		// ChromeDriverのパスを設定
        System.setProperty("webdriver.chrome.driver", "/Users/goodlove0125/Downloads/chromedriver");

        // WebDriverのインスタンスを作成
        WebDriver driver = new ChromeDriver();

        // 開きたいサイトのURLを引数に指定
        driver.get("https://www.ubereats.com/jp/location/fukuoka");
        WebElement e = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/main/div[5]/div/div/div/div[1]/div[2]/a"));
        e.click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        for(String url : shopList) {
        	driver.get(url);
            e = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/main/div[2]/div[2]/h3[1]/a"));
            e.click();
            driver.getCurrentUrl();
            System.out.println(driver.getCurrentUrl());
        }

	}

}
