package Patterns;

public class AbstractFactoryApp {
    public static void main(String[] args) {
// 6. Создаем саму фабрику и передаем ей код фабрики, которая нам нужна
        DeviceFactory deviceFactory = getFactoryByCountry("RU");
        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();
        TouchPad touchPad = deviceFactory.getTouchPad();
        mouse.click();
        keyboard.print();
        touchPad.track(19, 299);
// Если нужна другая фабрика ,создаем другую

        DeviceFactory engDeviceFactory = getFactoryByCountry("EN");
        Mouse enMouse = engDeviceFactory.getMouse();
        Keyboard enKeyboard = engDeviceFactory.getKeyboard();
        TouchPad enTouchPad = engDeviceFactory.getTouchPad();
        enMouse.click();
        enKeyboard.println();
        enTouchPad.track(34, 11);

    }

// 5. Создаем управляюший метод
    private static DeviceFactory getFactoryByCountry(String language) {
        switch (language) {
            case "RU":
                return new RusDeviceFactory();
            case "EN":
                return new EngDeviceFactory();
            default:
                throw new RuntimeException("Unsupported code");
        }
    }
}

// 1. Создаем интерфейсы
interface Mouse {
    void click();

    void dbClick();

    void scroll(int direction);
}

interface Keyboard {
    void print();

    void println();
}

interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    Keyboard getKeyboard();

    TouchPad getTouchPad();
}

// 2. Реализуем две фабрики, русскую и английскую (классы с русским и английским)
class RusMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Щелчок мышкой");
    }

    @Override
    public void dbClick() {
        System.out.println("Двойной щелчок мышкой");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скроллим вверх");
        } else if (direction < 0) {
            System.out.println("Скроллим вниз");
        } else {
            System.out.println("Не скроллим");
        }
    }
}

class RusKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переносом строки");
    }
}

class RusTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Передвинулись на " + s + " пикселей");
    }
}

class EngMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dbClick() {
        System.out.println("Double mouse click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        } else {
            System.out.println("No scroll");
        }
    }
}

class EngKeyboard implements Keyboard {
    @Override
    public void print() {
        System.out.println("Print line");
    }

    @Override
    public void println() {
        System.out.println("Print line with empty line");
    }
}

class EngTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Move to " + s + " pixels");
    }
}

// 3. Создаем сами фабрики, которые будут производить эти устройства
class RusDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new RusMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new RusKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RusTouchPad();
    }
}

class EngDeviceFactory implements DeviceFactory {
    @Override
    public Mouse getMouse() {
        return new EngMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return new EngKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EngTouchPad();
    }
}