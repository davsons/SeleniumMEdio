package PruebaNivelMedio.steps;

import PruebaNivelMedio.test.SpotifyRegistrationErrors;
import PruebaNivelMedio.test.SpotifySite;
import PruebaNivelMedio.test.SpotifyValidarPlan;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class SpotifySteps {

    public SpotifySite spotifySite;
    public SpotifyValidarPlan spotifyValidarPlan;
    SpotifyRegistrationErrors spotifyRegistrationErrors;


    public WebDriver driver;

    @Given("Estoy en el Sitio Spotify")
    public void estoy_en_el_sitio_spotify() {
        spotifySite = new SpotifySite(driver);
        spotifySite.ingresoSitio();


    }

    @When("Ingreso a Premium")
    public void ingreso_a_premium() {
        spotifySite.IngresoPremium();


    }

    @When("Individual")
    public void individual() {
        spotifyValidarPlan = spotifySite.IngresoPremium();
        spotifyValidarPlan.planIndividual();


    }

    @Then("Estoy en Plan Individual")
    public void estoy_en_plan_individual() {

        Assert.assertTrue(spotifyValidarPlan.asertIndividual(), "Se esperaba el plan Individual");

    }

    @Then("Estoy en Plan Premium Familiar")
    public void estoy_en_plan_premium_familiar() {

        Assert.assertTrue(spotifyValidarPlan.asertFamiliar(), "Se esperaba el plan Familiar");
    }

    @When("Premium")
    public void premium() {
        spotifyValidarPlan = spotifySite.IngresoPremium();
        spotifyValidarPlan.planFamiliar();

    }

    @When("Entro a Terminos y Condiciones")
    public void entro_a_terminos_y_condiciones() {
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/legal/end-user-agreement/");
    }

    @When("Disfrutando Spotify")
    public void disfrutando_spotify() {
        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());
        boolean Disfrutando = false;
        for (WebElement a1 : a) {
            System.out.println(a1.getText());
            if (a1.getText().equals("Disfrutando Spotify")) {

                Disfrutando = true;
            }

        }
        Assert.assertTrue(Disfrutando, "Se esperaba el plan Familiar");
    }


    @When("Pagos, cancelaciones y periodo de reflexion")
    public void pagos_cancelaciones_y_periodo_de_reflexion() {
        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());
        boolean Pagos = false;
        for (WebElement a1 : a) {
            System.out.println(a1.getText());
            if (a1.getText().equals("Pagos, cancelaciones y periodo de reflexión")) {

                Pagos = true;
            }

        }
        Assert.assertTrue(Pagos, "Se esperaba Pagos, cancelaciones y periodo de reflexion");
    }

    @Then("Uso de nuestro servicio")
    public void uso_de_nuestro_servicio() {
        List<WebElement> a = driver.findElements(By.tagName("a"));
        System.out.println(a.size());
        boolean Usos = false;
        for (WebElement a1 : a) {
            System.out.println(a1.getText());
            if (a1.getText().equals("Uso de nuestro servicio")) {

                Usos = true;
            }

        }
        Assert.assertTrue(Usos, "Se esperaba Uso de nuestro servicio");
    }

    @When("Me registro")
    public void me_registro() {
        driver.findElement(By.xpath("//*[@href='https://www.spotify.com/cl/signup/']")).click();
    }

    @Then("Email Vacio")
    public void email_vacio() {
        //spotifyValidarPlan = spotifySite.IngresoPremium();
        //spotifyValidarPlan.registration();
        //spotifyRegistrationErrors = spotifyValidarPlan.registration();
        //spotifyRegistrationErrors.emailVacio();
        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje =driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        System.out.println("Valido email vacio --->" + mensaje.getText());
        Assert.assertEquals(mensaje.getText(),"Es necesario que introduzcas tu correo electrónico.", "se esperaba el msj Es necesario que introduzcas tu correo electrónico.");
    }

    @Then("Email Invalido")
    public void email_invalido() {
        //spotifyValidarPlan = spotifySite.IngresoPremium();
        //spotifyValidarPlan.registration();
        //spotifyRegistrationErrors = spotifyValidarPlan.registration();
        //spotifyRegistrationErrors.emailInvalido();


        driver.findElement(By.id("email")).sendKeys("fff");
        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje2 =driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com')]"));
        System.out.println("Valido email invalido --->" + mensaje2.getText());
        Assert.assertEquals(mensaje2.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com", "se esperaba el msj Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");
    }

    @Then("Email Existente")
    public void email_existente() {
        //spotifyValidarPlan = spotifySite.IngresoPremium();
        //spotifyValidarPlan.registration();
        //spotifyRegistrationErrors = spotifyValidarPlan.registration();
        //spotifyRegistrationErrors.emailExistente();

        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@class='Button-sc-8cs45s-0 jgLyVk']/div")).click();
        WebElement mensaje3 =driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta. ' )]"));
        System.out.println("Valido email existente --->" + mensaje3.getText());


    }
}




