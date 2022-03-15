package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDataTest {


    @Test
    public void shouldRegByAcc() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val(CardData.getCity());
        String date = CardData.getDataRandom(4);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(date);
        $("[data-test-id='name'] input").val(CardData.getName());
        $("[data-test-id='phone'] input").val(CardData.getPhone());
        $("span.checkbox__box").click();
        $(withText("Запланировать")).click();
        $(withText("Успешно!")).shouldBe(visible);
        $("[data-test-id='success-notification']").shouldBe(visible).shouldHave(Condition.text("Встреча успешно запланирована на " + date));
        String date2 = CardData.getDataRandom(5);
        $("[placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[placeholder='Дата встречи']").setValue(date2);
        $(withText("Запланировать")).click();
        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(visible);
        $("[data-test-id=replan-notification] button.button").click();
        $(withText("Успешно")).shouldBe(visible,Duration.ofSeconds(15));

    }


}