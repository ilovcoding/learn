package graph;

import java.util.*;

public class GraphTopologySort {
    public static List<Node> sortedTopology(Graph graph){
        // 记录节点和对应节点的入度
        HashMap<Node,Integer>  inMap = new HashMap<>();
        // 入度为0的节点存在此队列中
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()){
            inMap.put(node, node.in);
            if(node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> result = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            result.add(cur);
            for (Node next: cur.nexts){
                inMap.put(next, inMap.get(next)-1);
                if(inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return result;
    }
}
