package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import POM.MainPage;
import POM.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
// Украл идею с extends у ИИ
public class OrderTest extends BrowserBase {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final String period;
    private final boolean isTopButton;

    public OrderTest(String name, String surname, String address, String metro, String phone,
                     String date, String period, boolean isTopButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.isTopButton = isTopButton;
    }

    @Parameterized.Parameters(name = "Заказ {0} {1}, кнопка {7}")
    public static Object[][] getOrderData() {
        return new Object[][] {
                // Набор 1: Верхняя кнопка (true)
                {"Иван", "Петров", "Москва, ул. Ленина 1", "Черкизовская", "89991112233",
                        "15.12.2025", "сутки", true},

                // Набор 2: Нижняя кнопка (false)
                {"Анна", "Сидорова", "Москва, пр. Мира 10", "Сокольники", "89994445566",
                        "20.12.2025", "двое суток", false}
        };
    }

    @Test
    public void testOrderFlow() {
        MainPage mainPage = new MainPage(driver);

        if (isTopButton) {
            mainPage.clickOrderButtonTop();
        } else {
            mainPage.clickOrderButtonBottom();
        }//Украл идею у ИИ

        OrderPage orderPage = new OrderPage(driver);
        orderPage.fillName(name);
        orderPage.fillSurname(surname);
        orderPage.fillAddress(address);
        orderPage.fillMetro(metro);
        orderPage.fillPhone(phone);
        orderPage.clickNextButton();

        orderPage.fillDate(date);
        orderPage.selectRentPeriod(period);
        orderPage.clickOrderButton();

        orderPage.clickConfirmYes();

        assertTrue("Сообщение об успешном заказе не появилось!", orderPage.isSuccessMessageVisible());
    }
}