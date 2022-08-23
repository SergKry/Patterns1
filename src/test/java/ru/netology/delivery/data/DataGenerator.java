package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int date) {
        return LocalDate.now().plusDays(date).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));// TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
    }

    public static String generateCity(String locale) {
        final Random randomCity = new Random();
        String[] city = new String[]{"Архангельск", "Астрахань", "Белгород","Благовещенск", "Великий Новгород",
                "Владивосток", "Владимир", "Волгоград", "Воронеж", "Горно-Алтайск", "Екатеринбург", "Иваново",
                "Ижевск", "Иркутск", "Йошкар-Ола", "Казань", "Калининград", "Калуга", "Кемерово", "Киров",
                "Кострома", "Красноярск", "Курган", "Курск", "Кызыл", "Петропавловск-Камчатский", "Псков",
                "Самара", "Санкт-Петербург", "Саранск", "Томск", "Элиста", "Южно-Сахалинск", "Якутск", "Ярославль"};
        return city[randomCity.nextInt(35)];
    }


        //Faker faker = new Faker(new Locale("ru"));
        //String city = faker.address().city();
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        //return city;
    //}

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker

    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker

    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));// TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}