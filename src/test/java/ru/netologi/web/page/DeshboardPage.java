package ru.netologi.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeshboardPage {


    public void Dashboard() {
    }



    private ElementsCollection cards = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getCardBalance(DataHelper.Card card) {
        var text = cards.findBy(Condition.text(card.getNumber().substring(12, 16))).getText();
        return extractBalance(text);
    }

    public TransferPage selectCardToTransfer(DataHelper.Card card) {
        cards.findBy(Condition.text(card.getNumber().substring(12, 16))).$("button").click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }
}
