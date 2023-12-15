package startegy;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        long seed1 = new Date().getTime();
        long seed2 = new Date().getTime()/1000;
        System.out.println("seed1= "+ seed1);
        System.out.println("seed2= "+ seed2);
        Player player1 = new Player("T", new WinningStrategy(seed1));
        Player player2 = new Player("H",new ProStrategy(seed2));
        for (int i = 0; i < 1000; i++) {
            Hand nextHand1 = player1.nextHand();
            Hand nextHand2 = player2.nextHand();
            if(nextHand1.isStrongerThan(nextHand2)){
//                System.out.println("Winner:" + player1);
                player1.win();
                player2.lose();
            }else if (nextHand2.isStrongerThan(nextHand1)){
//                System.out.println("Winner:"+player2);
                player1.lose();
                player2.win();
            }else {
//                System.out.println("Even……");
                player1.even();
                player2.even();
            }
        }
        System.out.println("Total Result:");
        System.out.println(player1);
        System.out.println(player2);
    }
}
