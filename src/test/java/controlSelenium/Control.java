
package controlSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Sesion;

import java.security.NoSuchAlgorithmException;

public class Control {
    protected By locator;
    protected WebElement control;

    public Control(By locator){
        this.locator=locator;
    }

    protected void findControl(){
        this.control= Sesion.getInstance().getDriver().findElement(this.locator);
    }

    public void click(){
        this.findControl();
        this.control.click();
    }


    public void setValue(String value){
        this.findControl();
        this.control.clear();
        this.control.sendKeys(value);
    }

    public boolean isDisplayedControle(){
        try {
            this.findControl();
            return this.control.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }


    public String getText() throws NoSuchAlgorithmException {
        this.findControl();
        return this.control.getText();
    }

}

