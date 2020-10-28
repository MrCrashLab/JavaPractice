package Practic_15_16;

import java.util.HashMap;

public class Node {
    private HashMap<Integer, Integer> transitionMap = new HashMap<>();
    private HashMap<Integer, Integer> actionMap = new HashMap<>();
    public Node(int trans0, int node0, int action0, int trans1, int node1, int action1) {
        transitionMap.put(trans0, node0);
        transitionMap.put(trans1, node1);
        actionMap.put(trans0,action0);
        actionMap.put(trans1,action1);
    }

    public HashMap<Integer, Integer> getTransitionMap() {
        return transitionMap;
    }

    public HashMap<Integer, Integer> getActionMap() {
        return actionMap;
    }
}
