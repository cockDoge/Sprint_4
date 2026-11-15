package POM;

import org.openqa.selenium.*;

public class OrderPage {
    private WebDriver driver;

// Поле «Имя»
private By nameInput = By.xpath("//input[@placeholder='* Имя']");

// Поле «Фамилия»
private By surnameInput = By.xpath("//input[@placeholder='* Фамилия']");

// Поле «Адрес»
private By addressInput = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

// Поле «Станция метро»
private By metroInput = By.xpath("//input[@placeholder='* Станция метро']");

// Поле «Телефон»
private By phoneInput = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

// Кнопка «Далее»
private By nextButton = By.xpath("//button[text()='Далее']");

// Поле «Когда привезти самокат»
private By dateInput = By.xpath("//input[@placeholder='* Когда привезти самокат']");

// Выпадающий список «Срок аренды»
private By rentPeriodDropdown = By.className("Dropdown-root");

// Кнопка «Заказать» (на втором экране)
private By orderButton = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[text()='Заказать']");

// Кнопка «Да» в окне подтверждения
private By confirmYesButton = By.xpath("//button[text()='Да']");

// Текст в окне «Заказ оформлен»
private By successMessage = By.xpath("//div[contains(text(), 'Заказ оформлен')]");

public OrderPage(WebDriver driver) {
    this.driver = driver;
}

// Методы для заполнения первого экрана

public void fillName(String name) {
    driver.findElement(nameInput).sendKeys(name);
}

public void fillSurname(String surname) {
    driver.findElement(surnameInput).sendKeys(surname);
}

public void fillAddress(String address) {
    driver.findElement(addressInput).sendKeys(address);
}

    public void fillMetro(String metro) {
        driver.findElement(metroInput).sendKeys(metro);
        driver.findElement(By.xpath("//div[contains(@class, 'select-search__select')]//*[contains(text(), '" + metro + "')]")).click();
    } // украл способ поиска у ИИ

public void fillPhone(String phone) {
    driver.findElement(phoneInput).sendKeys(phone);
}

public void clickNextButton() {
    driver.findElement(nextButton).click();
}

// Методы для заполнения второго экрана

public void fillDate(String date) {
    driver.findElement(dateInput).sendKeys(date);
    driver.findElement(dateInput).sendKeys(Keys.ENTER);
}

public void selectRentPeriod(String period) {
    driver.findElement(rentPeriodDropdown).click();
    driver.findElement(By.xpath("//div[contains(@class, 'Dropdown-option') and text()='" + period + "']")).click();
}

public void clickOrderButton() {
    driver.findElement(orderButton).click();
}
// Метод для работы с окном подтверждением

public void clickConfirmYes() {
    driver.findElement(confirmYesButton).click();
}
public boolean isSuccessMessageVisible() {
    return driver.findElement(successMessage).isDisplayed();
}
}