package merge_sort;

import java.util.ArrayList;

public class Dynamic {
    public static int fibonacci(int n, ArrayList<Integer> mem) {

        if (n < mem.size()) {
            return mem.get(n);
        } else {
            int f;
            if (n < 2) {
                f = 1;
            } else {
                f = fibonacci(n - 2, mem) + fibonacci(n - 1, mem);
            }
            mem.add(f);
            return f;
        }
    }

    public static void main(String[] args) {
        // 1 1 2 3 5 8 13 21 34
        System.out.println(fibonacci(8, new ArrayList<>()));
    }
}
