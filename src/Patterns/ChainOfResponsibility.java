package Patterns;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Logger logger0 = new SMSLogger(Level.ERROR);
        Logger logger1 = new FileLogger(Level.DEBUG);
        Logger logger2 = new EmailLogger(Level.INFO);
        logger0.setNext(logger1);
        logger1.setNext(logger2);
        logger0.writeMessage("Все хорошо!", Level.INFO);
        logger0.writeMessage("Идет режим отладки", Level.DEBUG);
        logger0.writeMessage("Система упала", Level.ERROR);
    }
}

class Level {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger {
    int priority;
    Logger next;

    public Logger(int priority) {
        this.priority = priority;
    }

    public void writeMessage(String message, int level) {
        if (level <= priority) {
            write(message);
        }
        if (next != null) {
            next.writeMessage(message, level);
        }
    }

    abstract void write(String message);

    public abstract void setNext(Logger next);
}

class SMSLogger extends Logger {
    public SMSLogger(int priority) {
        super(priority);
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void write(String message) {
        System.out.println("СМС = " + message);
    }
}

class FileLogger extends Logger {
    public FileLogger(int priority) {
        super(priority);
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void write(String message) {
        System.out.println("Записываем в файл = " + message);
    }
}

class EmailLogger extends Logger {
    public EmailLogger(int priority) {
        super(priority);
    }

    public void setNext(Logger next) {
        this.next = next;
    }

    public void write(String message) {
        System.out.println("E-mail = " + message);
    }
}
