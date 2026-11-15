package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;

    // Кнопка «Заказать» вверху страницы (в хедере)
    private By orderButtonTop = By.xpath("//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']");

    // Кнопка «Заказать» в середине страницы (в блоке с описанием)
    private By orderButtonBottom = By.xpath("//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
}

    // Вопрос N в блоке «Вопросы о важном»
    private By faqQuestion(int index) {
        return By.id("accordion__heading-" + index);
    }

    // Ответ N в блоке «Вопросы о важном»
    private By faqAnswer(int index) {
        return By.id("accordion__panel-" + index);
    }

    // Методы для FAQ

    public void clickFaqQuestion(int index) {
        WebElement question = driver.findElement(faqQuestion(index));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", question);
        question.click();
    }

    public String getFaqAnswer(int index) {
        return driver.findElement(faqAnswer(index)).getText();
    }

    // Методы для кнопок заказа

    public void clickOrderButtonTop(){
        driver.findElement(orderButtonTop).click();
    }
    public void clickOrderButtonBottom(){
        WebElement button = driver.findElement(orderButtonBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
        button.click();
}
}