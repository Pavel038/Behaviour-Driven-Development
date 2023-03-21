package ru.netologi.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    public SelenideElement amount = $("[data-test-id='amount'] input");
    public SelenideElement from = $("[data-test-id='from'] input");

    public SelenideElement transfer = $("[data-test-id='action-transfer']");

    public void velidTransfer(int depositAmount, DataHelper.Card card){
        amount.setValue(String.valueOf(depositAmount));
        from.setValue(card.getNumber());
        transfer.click();
        new DeshboardPage() ;
    }
}
