package startegy;

public class Hand {
    //    石头
    public static final int HAND_VALUE_ROCK = 0;
    //    剪刀
    public static final int HAND_VALUE_SCISSOR = 1;
    //    布
    public static final int HAND_VALUE_PAPER = 2;
    public static final Hand[] hand = {
            new Hand(HAND_VALUE_ROCK),
            new Hand(HAND_VALUE_SCISSOR),
            new Hand(HAND_VALUE_PAPER)
    };
    private static final String[] name = {
            "石头","剪刀","布"
    };
    private int handleValue;

    public Hand(int handleValue) {
        this.handleValue = handleValue;
    }

    public static Hand getHand(int handleValue){
        return hand[handleValue];
    }

    public boolean isStrongerThan(Hand h){
        return fight(h) == 1;
    }

    public boolean isWeakerThan(Hand h){
        return fight(h) == -1;
    }

    public int fight(Hand h){
        if(this.handleValue == h.handleValue){
            return 0;
        }
        if((this.handleValue +1) %3 == h.handleValue){
            return 1;
        }
        return -1;
    }
    public String toString(){
        return name[handleValue];
    }
}
