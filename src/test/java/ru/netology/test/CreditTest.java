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

public class CreditTest {

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
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifySuccessMessage();
        assertEquals("APPROVED", SQLHelper.getCreditStatus());
    }


    @Test
    void shouldNotPayWithEmptyCardNumber() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyCardNumber();
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyMonthApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyMonth("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithEmptyYearApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyYear("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyNameApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyName("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyNullName();
    }

    @Test
    void shouldNotPayWithEmptyCvcApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyCvc("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumber() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCardNumber();
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithLetters() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCardNumberWithLetters();
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithSymbols() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCardNumberWithSymbols();
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCardNumberWithNotExistNumber() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCardNumberWithNotExistNumber();
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyErrorMessage();
    }

    @Test
    void shouldNotPayWithInvalidMonthApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonth("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithOneNumberApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithLettersApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithLetters("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithSymbolsApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithSymbols("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidYearApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYear("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotPayWithInvalidYearWithOneNumberApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithLettersApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithLetters("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithSymbolsApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithSymbols("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithOneLetterApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithOneLetter("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithNumbersApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithNumbers("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithCyrillicApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithCyrillic("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithSymbolsApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithSymbols("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithOneNumberApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithLettersApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithLetters("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithSymbolsApprovedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithSymbols("approved");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldSuccessPaymentDeclinedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyErrorMessage();
        assertEquals ("DECLINED", SQLHelper.getCreditStatus());
    }

    @Test
    void shouldNotPayWithEmptyMonthDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyMonth("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithEmptyYearDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyYear("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithEmptyNameDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyName("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyNullName();
    }

    @Test
    void shouldNotPayWithEmptyCvcDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithEmptyCvc("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidMonthDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonth("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithOneNumberDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithLettersDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithLetters("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidMonthWithSymbolsDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidMonthWithSymbols("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayWithInvalidYearDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYear("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotPayWithInvalidYearWithOneNumberDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithLettersDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithLetters("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidYearWithSymbolsDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidYearWithSymbols("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithOneLetterDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithOneLetter("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithNumbersDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithNumbers("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithCyrillicDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithCyrillic("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidNameWithSymbolsDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidNameWithSymbols("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithOneNumberDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithLettersDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithLetters("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayWithInvalidCvcWithSymbolsDeclinedCard() {
        var cardInfo = DataHelper.getInvalidCardInfoWithInvalidCvcWithSymbols("declined");
        var creditPage = paymentPage.creditPayment();
        creditPage.enterCardData(cardInfo);
        creditPage.verifyInvalidFormat();
    }
}