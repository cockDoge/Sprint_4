package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import POM.MainPage;

import static org.junit.Assert.assertTrue;

// Украл идею с extends у ИИ
@RunWith(Parameterized.class)
public class FaqTest extends BrowserBase {

    private final int questionIndex;
    private final String expectedAnswerPart;

    public FaqTest(int questionIndex, String expectedAnswerPart) {
        this.questionIndex = questionIndex;
        this.expectedAnswerPart = expectedAnswerPart;
    }
    @Parameterized.Parameters()
    public static Object[][] getFaqData() {
        return new Object[][] {
                { 0, "Сутки — 400 рублей" },
                { 1, "Пока что у нас так" },
                { 2, "Допустим, вы оформляете заказ на 8 мая" },
                { 3, "Только начиная с завтрашнего дня" },
                { 4, "Пока что нет!" },
                { 5, "Самокат приезжает к вам с полной зарядкой" },
                { 6, "Да, пока самокат не привезли." },
                { 7, "Да, обязательно" }
        };
    }

    @Test
    public void testFaqAnswerOpens() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFaqQuestion(questionIndex);

        String actualAnswer = mainPage.getFaqAnswer(questionIndex);

        assertTrue("Текст ответа не совпадает!", actualAnswer.contains(expectedAnswerPart));
    }
}