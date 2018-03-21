package royalroadl_extractor;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class extractor {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		System.setProperty("webdriver.chrome.driver","src\\royalroadl_extractor\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

        //go to webfiction
        driver.get("http://royalroadl.com/fiction/17153/masternever-and-the-flow-of-death/chapter/201332/chapter-2-the-scroll-of-the-masters");
        
        //pega texto
        WebElement query = driver.findElement(By.className("aspectRatioPlaceholder"));
        
        //salva no arquivo
        salvaArquivo(query);
        
        //passa pro proximo
        (driver.findElement(By.partialLinkText("Next"))).click();;
	}
	
	public static void salvaArquivo(WebElement query) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
        writer.println(query.getText());
        writer.close();
	}

}
