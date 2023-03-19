package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("input#email"), email);
        type(By.cssSelector("input#password"), password);
    }

    public void submitLogin(){
        click(By.xpath("//button[contains(text(), 'alla!')]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//h2[text()='Logged in success']"));
    }

    public void logout(){
        click(By.xpath("//button[text()='Ok']"));
        click(By.cssSelector("a[ng-reflect-router-link='logout']"));
    }
}
