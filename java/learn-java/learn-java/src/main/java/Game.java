import java.util.List;

public class Game {
    private String game;
    private List<People> wzPeoples;
    public void playGame(People people){
        this.wzPeoples.add(people);
    }

    public Game(String game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "Game{" +
                "wzPeoples=" + wzPeoples +
                '}';
    }
}
