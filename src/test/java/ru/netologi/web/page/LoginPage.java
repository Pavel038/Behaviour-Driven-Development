package ru.netologi.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement verifyLogin = $("[data-test-id='login'] input");
    private SelenideElement verifyPassword = $("[data-test-id='password'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-login']");

    public VerificationPage velidLogin(DataHelper.AutoInfo info){
        verifyLogin.setValue(info.getLogin());
        verifyPassword.setValue(info.getPasword());
        verifyButton.click();
        return new VerificationPage();

    }
}
