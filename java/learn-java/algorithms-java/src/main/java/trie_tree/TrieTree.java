package trie_tree;

import java.util.Map;

public class TrieTree {

    private TrieTreeNode root;

    public TrieTree() {
        this.root = new TrieTreeNode();
    }

    public void insert(String word) {
        TrieTreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.get(c) == null) {
//                没有对应节点
                cur.children.put(c, new TrieTreeNode());
            } else {
//              使用过的次数++
                cur.count++;
            }
            cur = cur.children.get(c);
        }
//        每个单词的结束
        cur.end++;
    }

    public boolean search(String word) {
        TrieTreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.get(c) == null) {
//                没有对应节点
                return  false;
            }
            cur = cur.children.get(c);
        }
        return cur.end > 0;
    }

    public boolean startsWidth(String prefix) {
        TrieTreeNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children.get(c) == null) {
//                没有对应节点
                return  false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }

}
