package builder;

import java.util.ArrayList;
import java.util.List;

public class HobbyInfo {
    ArrayList<String> games;
    ArrayList<String> foods;

    public HobbyInfo(ArrayList<String> games, ArrayList<String> foods) {
        this.games = games;
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "HobbyInfo{" +
                "games=" + games +
                ", foods=" + foods +
                '}';
    }
}
