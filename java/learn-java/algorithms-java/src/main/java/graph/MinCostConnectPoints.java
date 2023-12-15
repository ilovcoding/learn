/**
 * https://leetcode.cn/problems/min-cost-to-connect-all-points/solution/
 * 最小生成树
 */
package graph;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        Queue<Edge> edgeQueue = new PriorityQueue<Edge>((Edge a, Edge b)->{
            return a.distance - b.distance;
        });
        for(int i = 0; i< points.length; i++) {
            for(int j = i+1; j< points.length; j++){
                edgeQueue.add(new Edge(i,j, distance(points , i,  j)));
            }
        }

        int count = points.length -1;
        int res = 0;
        UnionFind unionFind = new UnionFind(points.length);

        while(count > 0 && edgeQueue.size() > 0){
            Edge edge = edgeQueue.poll();
            if(unionFind.isSameSet(edge.pointA, edge.pointB)){
                continue;
            }
            unionFind.connect(edge.pointA, edge.pointB);
            res += edge.distance;
            count--;

        }
        return res;
    }

    public int distance(int[][] points, int indexA, int indexB){
        return Math.abs(points[indexA][0] - points[indexB][0]) + Math.abs(points[indexA][1] - points[indexB][1]);
    }

    class UnionFind {
        public HashMap<Integer, Integer> parentMap = new HashMap<>();
        public HashMap<Integer, Integer> sizeMap = new HashMap<>();
        public UnionFind (int size){
            for(int i=0 ; i< size; i++){
                parentMap.put(i, i);
                sizeMap.put(i, 1);
            }
        }

        public int findFather (int v){
            Stack<Integer> path = new Stack<>();
            int parentValue = v;
            while( parentValue != parentMap.get(parentValue)){
                path.push(parentValue);
                parentValue = parentMap.get(parentValue);
            }
            while(!path.isEmpty()) {
                parentMap.put(path.pop(), parentValue);
            }
            return parentValue;
        }

        public boolean isSameSet(int a, int b){
            int aParent = findFather(a);
            int bParent = findFather(b);
            return aParent == bParent;
        }

        public void connect(int a, int b){
            if(isSameSet(a, b)){
                return;
            }
            int parentA = findFather(a);
            int parentB = findFather(b);
            int aSize = sizeMap.get(parentA);
            int bSize = sizeMap.get(parentB);
            if(aSize > bSize) {
                parentMap.put(parentB, parentA);
                sizeMap.put(parentA, aSize + bSize);
                sizeMap.remove(parentB);
            }else {
                parentMap.put(parentA, parentB);
                sizeMap.put(parentB, aSize+ bSize);
                sizeMap.remove(parentA);
            }
        }
    }

    class Edge {
        int pointA;
        int pointB;
        int distance;
        Edge(int pointA, int pointB, int distance){
            this.pointA = pointA;
            this.pointB = pointB;
            this.distance = distance;
        }
    }
}
