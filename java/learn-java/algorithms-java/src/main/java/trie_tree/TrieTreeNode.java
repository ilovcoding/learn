package trie_tree;

import java.util.HashMap;
import java.util.Map;

public class TrieTreeNode {
    //    字符被使用的次数
    public int count;
    //   是否是某个单词的结束, 默认 0,每承担一次结尾 end+1;
    public int end;
    public Map<Character, TrieTreeNode> children;

    public TrieTreeNode() {
        this.count = 0;
        this.end = 0;
        this.children = new HashMap<>();
    }
}
