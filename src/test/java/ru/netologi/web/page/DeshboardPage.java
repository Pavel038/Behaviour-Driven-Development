package ru.netologi.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeshboardPage {


    public void Dashboard() {
    }

    private static SelenideElement firstCard = $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [role='button']");
    private static SelenideElement secondCard = $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [role='button']");

    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";



    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);

    }

    public int getSecondCardBalance() {
        var balance = cards.last().text();
        return extractBalance(balance);
    }

        public static TransferPage firstCardButton() {
        firstCard.click();
       return new TransferPage();
    }


    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}

