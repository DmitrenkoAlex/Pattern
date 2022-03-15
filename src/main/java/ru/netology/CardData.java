package ru.netology;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class CardData {
    public static Faker faker = new Faker(new Locale("ru"));

    public static String getCity() {
        Random random = new Random();
        int rand = random.nextInt(12);
        String city[] = {"Екатеринбург", "Йошкар-Ола", "Калининград", "Кемерово", "Киров", "Кострома", "Краснодар",
                "Красноярск", "Курган", "Курск", "Санкт-Петербург", "Сыктывкар", "Чебоксары"};
        return city[rand];
    }


    public static String getDataRandom(int days) {
        String inputDate = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.uuuu"));
        return inputDate;
    }


    public static String getName(){
        return faker.name().fullName();
    }

    public static String getPhone(){
        return faker.phoneNumber().phoneNumber();

    }


}
