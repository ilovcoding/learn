package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphDFS {
    public static void dfs(Node start){
        if(start == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        System.out.println(start.value);
        set.add(start);
        stack.add(start);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            for (Node next: start.nexts){
                if(!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next.value);
                    // break 作用是沿一条边走到底，不要进入其他分支。
                    break;
                }
            }
        }
    }
}
