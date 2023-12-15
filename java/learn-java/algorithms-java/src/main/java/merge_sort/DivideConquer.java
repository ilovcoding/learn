package merge_sort;

public class DivideConquer {
    public static int fibonacci(int n){
        if(n<2){
            return 1;
        } else {
            return  fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 21 34
        System.out.println(fibonacci(8));
    }
}
