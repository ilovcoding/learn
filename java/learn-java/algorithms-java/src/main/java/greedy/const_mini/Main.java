import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.PriorityQueue;

public class Main {

    public static long method(int[] arr){
        long res = 0;
        // 优先队列
        Queue<Long> queue = new PriorityQueue<Long>(arr.length, ( o1, o2)->{
            if(o1 > o2){
                return 1;
            }else if(o1 == o2){
                return 0;
            }else{
                return -1;
            }
        });
        for(int i =0;i < arr.length; i++ ){
            queue.add((long)(arr[i]));
        }
        while(queue.size() > 1){
            long miniOne = queue.poll();
            long miniTwo = queue.poll();
            long cost = miniOne + miniTwo;
            res += cost;
            queue.add(cost);
        }
        return res;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        String[] costStrList = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(costStrList[i]);
        }
        System.out.println(method(arr));
    }

}