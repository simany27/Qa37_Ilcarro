package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        return isElementPresent(By.cssSelector("a[ng-reflect-router-link='logout']"));
    }

    public void logout(){
        click(By.cssSelector("a[ng-reflect-router-link='logout']"));
    }

    public String getMessage(){
//        pause(2000);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void closeWindow() {
        if(isElementPresent(By.cssSelector(".dialog-container>h2"))){
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public String getHint(){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.error"))));
        return wd.findElement(By.cssSelector("div.error")).getText();
    }
}
