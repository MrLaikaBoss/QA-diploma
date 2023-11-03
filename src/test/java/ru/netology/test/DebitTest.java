package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitTest {
    PaymentPage paymentPage;

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        paymentPage = open("http://localhost:8080", PaymentPage.class);
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessPayment() {
        var cardInfo = new DataHelper().getValidCardInfo("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifySuccessMessage();
        assertEquals ("APPROVED", new SQLHelper().getDebitStatus());
    }

    @Test
    void shouldNotPayWithEmptyCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCardNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyMonthApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithEmptyYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyNameApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyNullName();
    }

    @Test
    void shouldNotPayWithEmptyCvcApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithLetters() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithLetters();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithSymbols() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithSymbols();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithNotExistNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithNotExistNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyErrorMessage();
        assertEquals ("DECLINED", new SQLHelper().getDebitStatus());
    }

    @Test
    void shouldNotPayWithInvalidMonthApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotPayWithInvalidYearWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithOneLetterApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithNumbersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithCyrillicApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldSuccessPaymentDeclinedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyErrorMessage();
        assertEquals ("DECLINED", new SQLHelper().getDebitStatus());
    }

    @Test
    void shouldNotPayWithEmptyMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithEmptyYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyNameDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyNullName();
    }

    @Test
    void shouldNotPayWithEmptyCvcDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotPayWithInvalidYearWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithOneLetterDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithNumbersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithCyrillicDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }
}