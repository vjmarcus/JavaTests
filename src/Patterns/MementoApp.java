package Patterns;

public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL 1", 30000);
        System.out.println(game);
        File file = new File();
        file.setSave(game.save());
        game.set("LVL 2", 50000);
        System.out.println(game);
        Game loadedGame = new Game();
        loadedGame.load(file.getSave());
        System.out.println("Загружаемся");
        System.out.println(loadedGame.toString());
    }
}
class Game{
    private String level;
    private int ms;

    public void set(String level, int ms){
        this.level = level;
        this.ms = ms;
    }
    public Save save(){
        return new Save(level, ms);
    }
    public void load(Save save){
        level = save.getLevel();
        ms = save.getMs();
    }

    @Override
    public String toString() {
        return "Game [level = " + level + ", ms = " + ms + "]";
    }
}
class Save{
    private final String level;
    private final int ms;

    public Save(String level, int ms) {
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}
class File{
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}