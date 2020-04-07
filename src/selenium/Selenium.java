package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) {


		// ChromeDriverのパスを設定
        System.setProperty("webdriver.chrome.driver", "/Users/goodlove0125/Downloads/chromedriver");

        // WebDriverのインスタンスを作成
        WebDriver driver = new ChromeDriver();

        // 開きたいサイトのURLを引数に指定
        driver.get("https://www.ubereats.com/jp/location/fukuoka");
        
	}

}
