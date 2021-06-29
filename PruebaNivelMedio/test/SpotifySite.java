package PruebaNivelMedio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SpotifySite {

    public WebDriver driver;

    public SpotifySite(WebDriver remoteDriver){

        driver= remoteDriver;
    }

    public void ingresoSitio(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.spotify.com/cl/");


    }

    public SpotifyValidarPlan IngresoPremium(){

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/cl/premium/']")).click();
        SpotifyValidarPlan spotifyValidarPlan = new SpotifyValidarPlan(driver);
        return spotifyValidarPlan;





    }
}
