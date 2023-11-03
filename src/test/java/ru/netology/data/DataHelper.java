package ru.netology.data;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("en"));

    private static String getCardNumber(String card) {
        if (card.equalsIgnoreCase("approved")) {
            return "4444 4444 4444 4441";
        } else if (card.equalsIgnoreCase("declined")) {
            return "4444 4444 4444 4442";
        }
        else return card;
    }

    private static String generateRandomMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String month = LocalDate.now().plusMonths(3).format(format);
        return month;
    }

    private static String generateRandomYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String year = LocalDate.now().plusYears(3).format(format);
        return year;
    }

    private static String generateRandomName(String locale) {
        var faker = new Faker(new Locale(locale));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    private static String generateRandomCvc() {
        String cvc = Integer.toString(faker.number().numberBetween(100, 999));
        return cvc;
    }

    public CardInfo getValidCardInfo(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String name;
        String cvc;
    }

    private static String generateInvalidCardNumber() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String cardNumber = fakeValuesService.numerify("##########");
        return cardNumber;
    }

    private static String generateInvalidCardNumberWithLetters() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String cardNumber = fakeValuesService.letterify("????????????????");
        return cardNumber;
    }

    private static String generateInvalidCardNumberWithSymbols() {
        String cardNumber = "*&^";
        return cardNumber;
    }

    private static String generateInvalidCardNumberWithNotExistNumber() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String cardNumber = fakeValuesService.numerify("#### #### #### ####");
        return cardNumber;
    }

    private static String generateInvalidMonth() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM");
        String month = Integer.toString(faker.number().numberBetween(13, 99));
        return month;
    }

    private static String generateInvalidMonthWithOneNumber() {
        String month = Integer.toString(faker.number().numberBetween(1, 9));
        return month;
    }

    private static String generateInvalidMonthWithLetters() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String month = fakeValuesService.letterify("???");
        return month;
    }

    private static String generateInvalidMonthWithSymbols() {
        String month = "*&^";
        return month;
    }

    private static String generateInvalidYear() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yy");
        String year = Integer.toString(faker.number().numberBetween(10, 22));
        return year;
    }

    private static String generateInvalidYearWithOneNumber() {
        String year = Integer.toString(faker.number().numberBetween(1, 9));
        return year;
    }

    private static String generateInvalidYearWithLetters() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String year = fakeValuesService.letterify("???");
        return year;
    }

    private static String generateInvalidYearWithSymbols() {
        String year = "*&^";
        return year;
    }

    private static String generateInvalidNameWithOneLetter() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String name = fakeValuesService.letterify("?");
        return name;
    }

    private static String generateInvalidNameWithNumbers() {
        String name = Integer.toString(faker.number().numberBetween(0, 999));
        return name;
    }

    private static String generateInvalidNameWithSymbols() {
        String name = "*&^";
        return name;
    }

    private String generateInvalidCvc() {
        String cvc = Integer.toString(faker.number().numberBetween(00, 99));
        return cvc;
    }

    private static String generateInvalidCvcWithOneNumber() {
        String cvc = Integer.toString(faker.number().numberBetween(0, 9));
        return cvc;
    }

    private static String generateInvalidCvcWithLetters() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en"), new RandomService());
        String cvc = fakeValuesService.letterify("???");
        return cvc;
    }

    private static String generateInvalidCvcWithSymbols() {
        String cvc = "*&^";
        return cvc;
    }

    public static CardInfo getInvalidCardInfoWithEmptyCardNumber() {
        return new CardInfo(
                " ",
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithEmptyMonth(String card) {
        return new CardInfo(
                getCardNumber(card),
                " ",
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithEmptyYear(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                " ",
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithEmptyName(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                " ",
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithEmptyCvc(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                " ");
    }

    public static CardInfo getInvalidCardInfoWithInvalidCardNumber() {
        return new CardInfo(
                generateInvalidCardNumber(),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCardNumberWithLetters() {
        return new CardInfo(
                generateInvalidCardNumberWithLetters(),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCardNumberWithSymbols() {
        return new CardInfo(
                generateInvalidCardNumberWithSymbols(),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCardNumberWithNotExistNumber() {
        return new CardInfo(
                generateInvalidCardNumberWithNotExistNumber(),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidMonth(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateInvalidMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidMonthWithOneNumber(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateInvalidMonthWithOneNumber(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidMonthWithLetters(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateInvalidMonthWithLetters(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidMonthWithSymbols(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateInvalidMonthWithSymbols(),
                generateRandomYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidYear(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateInvalidYear(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidYearWithOneNumber(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateInvalidYearWithOneNumber(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidYearWithLetters(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateInvalidYearWithLetters(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidYearWithSymbols(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateInvalidYearWithSymbols(),
                generateRandomName("en"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidNameWithOneLetter(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateInvalidNameWithOneLetter(),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidNameWithNumbers(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateInvalidNameWithNumbers(),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidNameWithCyrillic(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("ru"),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidNameWithSymbols(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateInvalidNameWithSymbols(),
                generateRandomCvc());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCvcWithOneNumber(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateInvalidCvcWithOneNumber());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCvcWithLetters(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateInvalidCvcWithLetters());
    }

    public static CardInfo getInvalidCardInfoWithInvalidCvcWithSymbols(String card) {
        return new CardInfo(
                getCardNumber(card),
                generateRandomMonth(),
                generateRandomYear(),
                generateRandomName("en"),
                generateInvalidCvcWithSymbols());
    }
}
