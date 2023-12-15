import Sort from './Sort';
import testAray from './TestArray';

class TreeNode {
  val: any;
  left: any;
  right: any;
  constructor(val: number) {
    this.val = val
    this.left = null
    this.right = null
  }
}

class BST {
  tree: TreeNode | null;
  resArr: number[];
  constructor(array: number[]) {
    this.tree = null
    this.resArr = []
    array.map(value => this.insert(value))
  }
  insert(val: number) {
    if (this.tree == null) {
      this.tree = new TreeNode(val)
      return
    }
    let pTree = this.tree // 存一下指针
    while (pTree != null) {
      // 开始执行插入的流程
      if (pTree.val >= val) {
        if (pTree.left == null) {
          pTree.left = new TreeNode(val)
          return
        }
        pTree = pTree.left
      } else {
        if (pTree.right == null) {
          pTree.right = new TreeNode(val)
          return
        }
        pTree = pTree.right
      }
    }
  }
  inOrder(tree: TreeNode | null) {
    if (tree == null) {
      return
    }

    this.inOrder(tree.left)
    this.resArr.push(tree.val)
    this.inOrder(tree.right)
  }
}

class HeapSort implements Sort {
  method(arr: number[]): number[] {
    let bst = new BST(arr)
    bst.inOrder(bst.tree)
    return bst.resArr
  }
  main(): void {
    let res = this.method(testAray)
    // console.log(res)
  }
}
export default HeapSort