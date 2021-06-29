package PruebaNivelMedio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpotifyValidarPlan {
    public WebDriver driver;

    public SpotifyValidarPlan(WebDriver remoteDriver){

        driver= remoteDriver;
    }

    public void planIndividual(){
        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
        System.out.println(h3s.size());
        boolean Individual =false;
        for (WebElement h3:h3s){
            System.out.println(h3.getText());
            if (h3.getText().equals("Individual")){

                Individual =true;
            }

        }

    }
    public void planFamiliar(){

        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
        System.out.println(h3s.size());
        boolean Familiar =false;
        for (WebElement h3:h3s){
            System.out.println(h3.getText());
            if (h3.getText().equals("Familiar")){

                Familiar =true;
            }

        }
    }

    public boolean asertIndividual(){

        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
        System.out.println(h3s.size());
        boolean Individual =false;
        for (WebElement h3:h3s){
            System.out.println(h3.getText());
            if (h3.getText().equals("Individual")){

                Individual =true;
            }

        }
        //Assert.assertTrue(Individual,"Se esperaba el plan Individual");
        return Individual;
    }
    public boolean asertFamiliar(){

        List<WebElement> h3s = driver.findElements(By.tagName("h3"));
        System.out.println(h3s.size());
        boolean Familiar =false;
        for (WebElement h3:h3s){
            System.out.println(h3.getText());
            if (h3.getText().equals("Familiar")){

                Familiar =true;
            }

        }
        //Assert.assertTrue(Individual,"Se esperaba el plan Individual");
        return Familiar;
    }

      /*public void registration(){

        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/cl/signup/']")).click();



    }*/
}
