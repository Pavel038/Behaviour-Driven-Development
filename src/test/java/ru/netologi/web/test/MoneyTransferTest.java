package ru.netologi.web.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netologi.web.data.DataHelper;
import ru.netologi.web.page.DeshboardPage;
import ru.netologi.web.page.LoginPage;
import ru.netologi.web.page.TransferPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netologi.web.data.DataHelper.getOtherCard;
import static ru.netologi.web.page.DeshboardPage.firstCardButton;


public class MoneyTransferTest {
    int depositAmount = 400;
    @BeforeEach
    void shouldTransferMoneyBetweenOwnCard() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var autoInfo = DataHelper.getAutoInfo();
        var verificationPage = loginPage.velidLogin(autoInfo);
        var verificationCode = DataHelper.getWerification();
        verificationPage.validVerify(verificationCode);
    }

       @Test
       public void velidPerevod(){
       var deshboardPage = new DeshboardPage();
       var balans1 = deshboardPage.getFirstCardBalance();
       var balans2 = deshboardPage.getSecondCardBalance();

       var transfer = firstCardButton();
           transfer.velidTransfer(depositAmount, getOtherCard());
           var firstCardBalance = balans1 + depositAmount;
           var secondCardBalance = balans2 - depositAmount;

           assertEquals(firstCardBalance, deshboardPage.getFirstCardBalance());
           assertEquals(secondCardBalance, deshboardPage.getSecondCardBalance());



    }





}