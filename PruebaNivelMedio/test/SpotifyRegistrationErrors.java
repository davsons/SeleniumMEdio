package PruebaNivelMedio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SpotifyRegistrationErrors {

    public WebDriver driver;

    public SpotifyRegistrationErrors(WebDriver remoteDriver) {

        driver = remoteDriver;
    }

    public void emailVacio(){

        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje =driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        System.out.println("Valido email vacio --->" + mensaje.getText());
        Assert.assertEquals(mensaje.getText(),"Es necesario que introduzcas tu correo electrónico.", "se esperaba el msj Es necesario que introduzcas tu correo electrónico.");


    }

    public void emailInvalido(){
        driver.findElement(By.id("email")).sendKeys("fff");
        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje2 =driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        System.out.println("Valido email invalido --->" + mensaje2.getText());
        Assert.assertEquals(mensaje2.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "se esperaba el msj Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");


    }
    public void emailExistente(){
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje3 =driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta. ' )]"));
        System.out.println("Valido email existente --->" + mensaje3.getText());


    }
}
