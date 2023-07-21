package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int finalNode =  graph.length;
        int[] visited = new int[finalNode];
        for(int i=0; i< graph.length; i++){
            visited[i] = 1;
            int[] nextList = graph[i];
            List<Integer> aaa= new ArrayList<>();
            aaa.isEmpty();
            List<Integer> lista = new ArrayList<>();
            HashSet<Integer> a = new HashSet<>();
        }
        return  null;
    }
    public static void main(String[] args) {
        int[][] test = {{1,2},{3},{3},{}};
        System.out.println(new AllPathsSourceTarget().allPathsSourceTarget(test));
    }
}
