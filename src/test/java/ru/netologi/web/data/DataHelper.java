package ru.netologi.web.data;

import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    ;

    @Value
    public static class AutoInfo {
        private String login;
        private String pasword;
    }

    public static AutoInfo getAutoInfo() {
        return new AutoInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getWerification() {
        return new VerificationCode("12345");

    }
    @Value
    public static class Card{
        private String number;

    }
public static Card getCart(){

        return new Card("5559000000000001");
}

public static Card getOtherCard(){
        return new Card("5559000000000002");
}


}
