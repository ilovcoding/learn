package union;

import java.util.HashMap;
import java.util.Stack;

public class DisjointSetData {
    public HashMap<Integer,Integer> parentMap  = new HashMap<>();;
    public HashMap<Integer,Integer> sizeMap =  new HashMap<>();

    public DisjointSetData(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            parentMap.put(i, i);
            sizeMap.put(i, 1);
        }
    }

    public void  union(int a, int e){
        if(isSameSet(a,e)){
            return;
        }
        int aSize = sizeMap.get(a);
        int eSize = sizeMap.get(e);
        int parentA = findFather(a);
        int parentE = findFather(e);
        if(aSize > eSize){
            parentMap.put(parentE, parentA);
            sizeMap.put(parentA, aSize+ eSize);
            sizeMap.remove(parentE);
        }else {
            parentMap.put(parentA, parentE);
            sizeMap.remove(parentA);
            sizeMap.put(parentE, aSize+ eSize);
        }
    }

    public int findFather(int v){
        Stack<Integer> path = new Stack<>();
        int parentValue = v;
        while (parentValue != parentMap.get(parentValue)){
            path.push(parentValue);
            parentValue = parentMap.get(parentValue);
        }
        while (!path.isEmpty()){
            parentMap.put(path.pop(), parentValue);
        }
        return parentValue;
    }

    public boolean  isSameSet(int a, int e){
        int parentA = findFather(a);
        int parentE = findFather(e);
        return parentA == parentE;
    }

    public static void main(String[] args) {
        DisjointSetData disjointSetData = new DisjointSetData(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8 });
        System.out.println(disjointSetData.isSameSet(1,2)); // false
        disjointSetData.union(1,2);
        System.out.println(disjointSetData.isSameSet(1,2)); // true
        System.out.println(disjointSetData.isSameSet(1,3)); // false
        disjointSetData.union(3,2);
        System.out.println(disjointSetData.isSameSet(1,3)); // true
    }
}