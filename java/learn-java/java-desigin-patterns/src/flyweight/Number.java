package flyweight;

public class Number {
    private char num;

    public Number(char num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return num+" ";
    }
}
