package ru.netologi.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
private SelenideElement codeFiel = $("[data-test-id='code'] input");
private SelenideElement verifyButton = $("[data-test-id='action-verify']");

public DeshboardPage validVerify(DataHelper.VerificationCode verificationCode){
    codeFiel.setValue(verificationCode.getCode());
    verifyButton.click();
    return new DeshboardPage();
}

}
