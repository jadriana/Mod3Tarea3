
package testcases;


import org.junit.Assert;
import org.junit.jupiter.api.*;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.SignUpModal;
import session.Sesion;

import java.security.NoSuchAlgorithmException;

public class TodoLyTest {


    MainPage mainPage = new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    LoginPage loginPage = new LoginPage();

    @BeforeEach
    public void before(){
        Sesion.getInstance().getDriver().get("http://todo.ly/");
    }

    @Test
    public void verifyTheProjectIsLogged() throws NoSuchAlgorithmException {
        mainPage.loginButton.click();
        signUpModal.fullNameTextBox.setValue("jaqc8088471");
        signUpModal.emailTextBox.setValue("jaqc8088471@test.com");
        signUpModal.passwordTextBox.setValue("jaqc8088471");
        signUpModal.agreeCheckBox.click();
        signUpModal.loginButton.click();

        // verificaciones...
        Assert.assertEquals("ERROR! Cuenta no creada","Logout",loginPage.logoutLabel.getText());

    }

    @AfterEach
    public void after(){
        Sesion.getInstance().closeSesion();
    }


}