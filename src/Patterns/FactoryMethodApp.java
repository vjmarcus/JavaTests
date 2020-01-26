package Patterns;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args) {

       WatchMaker maker = getMakerByName("Digital");
       Watch watch = maker.createWatch();
       watch.showTime();
    }
    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital")) {
            return new DigitalWatchMaker();
        } else if (maker.equals("Rome")) {
            return new RomeWatchMaker();
        }
        throw new RuntimeException("Не знаю такой тип часов" + maker);
    }
}
// 1. Делаем интерфейс часов
interface Watch{
    void showTime();
}
// 2. Создаем класс цифровых часов
class DigitalWatch implements Watch{
    // Переопределяем метод
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}
// Класс Римских часов
class RomeWatch implements Watch {
    @Override
    public void showTime() {
        System.out.println("XXXI-XXII");
    }
}
// 4. Фабричный метод, типа завод часов
interface WatchMaker {
    // 5. Создаем часы, не знаем, какие часы, возвращает часы в зависимости от производителя
    Watch createWatch();
}
// А Это производственная линия завода часов
class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
// Это другая линия производства
class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}
