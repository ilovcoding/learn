import mlog from '../../../utils/mlog';
/// 迪米特法则 最少知道原则
// 高内聚 低耦合
class TreeNode {
  val: number;
  left: null | TreeNode;
  right: null | TreeNode;
  constructor(val:number){
    this.val = val
    this.left = null
    this.right = null
  }
}
class BSTree{
 tree: null | TreeNode;
 constructor(){
   this.tree = null
 }
 insert(node:TreeNode){
   if(this.tree === null){
     this.tree = node
   } else {
     let root = this.tree
     while(true){
         if(node.val>root.val){
           if(root.right === null){
             root.right = node
             break
           }
           root = root.right
         } else { 
           if(root.left === null){
             root.left = node
             break
           }
           root = root.left
       }
     }
   }
   return this.tree
 }
 perOrder(tree:TreeNode|null){
  let res:number[] = []
  function order(tree:TreeNode|null){
    if(tree === null){
      return res     
    }
    order(tree.left)
    res.push(tree.val)
    order(tree.right)
    return res
   }
   order(tree)
   return res
 }

}
// 实现一个二叉搜索树的功能
class Demeter{
  public static main() {
      let bsTree = new BSTree()
      bsTree.insert(new TreeNode(8))
      bsTree.insert(new TreeNode(7))
      bsTree.insert(new TreeNode(11))
      bsTree.insert(new TreeNode(9))
      bsTree.insert(new TreeNode(3))
      bsTree.insert(new TreeNode(2))
      let res = bsTree.perOrder(bsTree.tree)
      mlog.log(res) // [2, 3, 7, 8, 9, 11]
  }
}

export default Demeter

/**
 * 可以看出 上面的 代码 看上去没有问题了
 * 首先我们实现了二叉树节点插入的功能
 * 然后调用中序遍历得到了 排序之后的结果
 * 但是 很明显具体的插入操作不应该暴露出来，
 * 包括inOrder函数其实 没必要接收参数
 * 因此我们在 DemeterImprove中给出修改方案
 */
