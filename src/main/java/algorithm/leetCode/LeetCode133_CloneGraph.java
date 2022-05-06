package algorithm.leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode133_CloneGraph {
    private HashMap<Integer,UndirectedGraphNode> map=new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return DFS(node);
    }
    private UndirectedGraphNode DFS(UndirectedGraphNode node){
        if(node==null) return null;
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode clone=new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for(UndirectedGraphNode w:node.neighbors){
            clone.neighbors.add(DFS(w));
        }
        return clone;
    }

    public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
        if(node==null) return null;
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> maps = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        maps.put(node,newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode top = queue.poll();

            List<UndirectedGraphNode> neighbors = top.neighbors;
            for (UndirectedGraphNode neighbour : neighbors) {
                if (!maps.containsKey(neighbour)) {
                    UndirectedGraphNode newTmpNode = new UndirectedGraphNode(neighbour.label);
                    maps.put(neighbour, newTmpNode);
                    queue.offer(neighbour);
                }
                maps.get(top).neighbors.add(maps.get(neighbour));
            }
        }
        return newNode;
    }
}

