package flyweight;

public class Main {
    public static void main(String[] args) {
//        将一个数转换成二进制显示
        int number = 7;
        String str = Integer.toBinaryString(6);
        for (char cc:str.toCharArray()){
            System.out.print(NumberFactory.getInstance().getNumber(cc));
        }
    }
}
