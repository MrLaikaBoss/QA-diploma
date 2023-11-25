package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private final SelenideElement debitButton = $("button");
    private final SelenideElement creditButton = $(byText("Купить в кредит"));

    public DebitPage debitPayment() {
        debitButton.click();
        return new DebitPage();
    }

    public CreditPage creditPayment() {
        creditButton.click();
        return new CreditPage();
    }
}
