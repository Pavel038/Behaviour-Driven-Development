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
import static ru.netologi.web.data.DataHelper.getCart;
import static ru.netologi.web.data.DataHelper.getOtherCard;



public class MoneyTransferTest {
    int depositAmount = 400;
   @Test
    void shouldTransferMoneyBetweenOwnCard() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var autoInfo = DataHelper.getAutoInfo();
        var verificationPage = loginPage.velidLogin(autoInfo);
        var verificationCode = DataHelper.getWerification();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var card = getCart();
       int depositAmount = 400;
        var otherCard = getOtherCard();
        var expectedBalanceFirstCard = dashboardPage.getCardBalance(card) - depositAmount;
        var expectedBalanceSecondCard = dashboardPage.getCardBalance(otherCard) + depositAmount;
        var transferPage = dashboardPage.selectCardToTransfer(otherCard);
        dashboardPage = transferPage.velidTransfer(Integer.parseInt(String.valueOf(depositAmount)), card);
        var actualBalanceFirstCard = dashboardPage.getCardBalance(card);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(otherCard);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }
    @Test
    void shouldTransferMoneyBetweenOwnCar() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999/");
        var loginPage = new LoginPage();
        var autoInfo = DataHelper.getAutoInfo();
        var verificationPage = loginPage.velidLogin(autoInfo);
        var verificationCode = DataHelper.getWerification();
        var dashboardPage = verificationPage.validVerify(verificationCode);
        var card = getCart();
        int depositAmount = 10001;
        var otherCard = getOtherCard();
        var expectedBalanceFirstCard = dashboardPage.getCardBalance(card) - depositAmount;
        var expectedBalanceSecondCard = dashboardPage.getCardBalance(otherCard) + depositAmount;
        var transferPage = dashboardPage.selectCardToTransfer(otherCard);
        dashboardPage = transferPage.velidTransfer(Integer.parseInt(String.valueOf(depositAmount)), card);
        var actualBalanceFirstCard = dashboardPage.getCardBalance(card);
        var actualBalanceSecondCard = dashboardPage.getCardBalance(otherCard);
        assertEquals(expectedBalanceFirstCard, actualBalanceFirstCard);
        assertEquals(expectedBalanceSecondCard, actualBalanceSecondCard);
    }









}