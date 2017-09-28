package algolib;

import java.util.*;

class UnionFind<T> {

    private HashMap<T,T> rootMap = null;
    private long connectedGroupCount;

    private void addWithoutCheck(T x){
        rootMap.put(x, x);
        connectedGroupCount += 1;
    }

    public UnionFind(){
        rootMap = new HashMap<T, T>();
        connectedGroupCount = 0;
    }

    public void add(T x){
        T root = rootMap.get(x);

        if (root == null){
            addWithoutCheck(x);
        }
    }

    public T find(T x){
        T root = rootMap.get(x);

        if (root == null){
            addWithoutCheck(x);
        }

        if (root.equals(x)){
            return x;
        }
        else{
            rootMap.put(x,find(root));
        }
        return rootMap.get(x);
    }

    public void connect(T a, T b){
        T root_a = find(a);
        T root_b = find(b);

        if (!root_a.equals(root_b)){
            rootMap.put(root_a, root_b);
            connectedGroupCount--;
        }
    }

    public long count(){
        return connectedGroupCount;
    }

}
