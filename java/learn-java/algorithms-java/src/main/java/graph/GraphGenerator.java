package graph;

// 示例将二维数组转化成图
public class GraphGenerator {
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.edges.contains(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(weight,fromNode,toNode);
            // from 节点出度++
            fromNode.out ++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(newEdge);
            toNode.in++;
            graph.edges.add(newEdge);
        }
        return  graph;
    }
}
