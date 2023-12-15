package memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Memento memento = gamer.crateMemento();
        for (int i = 0; i < 100; i++) {
            System.out.println("=== " +i);
            System.out.println("当前状态:"+gamer);
            gamer.bet();
            System.out.println("所持有的金钱为"+gamer.getMoney()+"元。");
            if(gamer.getMoney() > memento.getMoney()){
                System.out.println("持有的金钱增多了，保存当前游戏状态");
                memento = gamer.crateMemento();
            }else if(gamer.getMoney()< memento.getMoney()/2){
                System.out.println("持有的金钱少了很多，因此游戏回到之前的状态");
                gamer.restoreMemento(memento);
            }
        }
    }
}
