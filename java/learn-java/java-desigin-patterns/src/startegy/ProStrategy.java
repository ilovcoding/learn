package startegy;

import java.util.Random;

public class ProStrategy implements Strategy {
    private Random random;
    private int preHandValue = 0;
    private int currentValue = 1;
    private int[][] history = {
            {1,1,1},
            {1,1,1},
            {1,1,1},
    };

    public ProStrategy(long seed) {
        this.random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentValue));
        int handValue = 0;
        if(bet < history[currentValue][0]){
            handValue = 0;
        }else if (bet < history[currentValue][0] + history[currentValue][1]){
            handValue = 1;
        }else {
            handValue = 2;
        }
        preHandValue = currentValue;
        currentValue = handValue;
        return Hand.getHand(handValue);
    }

    @Override
    public void study(boolean win) {
        if(win){
            history[preHandValue][currentValue]++;
        }else {
            history[preHandValue][(currentValue+1)%3]++;
            history[preHandValue][(currentValue+2)%3]++;
        }
    }

    private int getSum(int hv){
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return  sum;
    }
}
