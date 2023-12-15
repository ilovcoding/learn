package graph

type Node struct {
	value int    // 节点的值
	in    int    // 入度
	out   int    // 出度
	nexts []Node // 从节点出发连接的节点
	edges []Node // 从节点出发连接的边
}

type Edge struct {
	weight int
	from   Node
	to     Node
}

type Graph struct {
	nodes map[int]Node
	edges map[Edge]bool
}

func (n Node) NewNode(value int) *Node {
	node := &Node{}
	node.value = value
	node.in = 0
	node.out = 0

	return node
}

func NewEdge(weight int, from Node, to Node) *Edge {
	edge := &Edge{}
	edge.weight = weight
	edge.from = from
	edge.to = to
	return edge
}
