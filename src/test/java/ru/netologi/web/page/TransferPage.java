package ru.netologi.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netologi.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {

    private SelenideElement amount = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");

    private SelenideElement transfer = $("[data-test-id='action-transfer']");

    public DeshboardPage velidTransfer(int depositAmount, DataHelper.Card card){
        amount.setValue(String.valueOf(depositAmount));
        from.setValue(card.getNumber());
        transfer.click();
        return new DeshboardPage() ;

}
}
