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
 // 改成接收 补定参数
 // 去掉返回值，让用户 只能通过实例化一种形式得到bsTree的根节点
 insert(...args:Array<number>):void{
   let handleInsert = (node:TreeNode) => {
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
   }
   let promise = new Promise((resolve,reject)=>{})
   console.log(promise)
  args.forEach(element =>handleInsert(new TreeNode(element)));
 }
 // 不需要接收参数
 inOrder():Array<number>{
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
   // 改成 this.tree 直接引用内部的
   order(this.tree)
   return res
 }

}
// 实现一个二叉搜索树的功能
class DemeterImprove{
  public static main() {
      let bsTree = new BSTree()
      // 插入元素 8 7 11 9 3 2
      bsTree.insert(8,7,11,9,3,2)
      let res = bsTree.inOrder()
      mlog.log(res) // [2, 3, 7, 8, 9, 11]
  }
}

export default DemeterImprove
// 可见重新 封装了一下 我们 对外 暴露的代码变少了 很多
// 降低类与类之间的耦合，最少知道原则，对自己依赖的类知道越少越好
// 