package Practic_15_16;

import java.util.ArrayList;
import java.util.HashMap;

public class Imaginarium {
    private ArrayList<Node> nodeList = new ArrayList<>();
    private HashMap<Integer, String> transitionAction = new HashMap<>();

    public Imaginarium() {
        createTransitAction();
        createNodeList();
    }

    public void job(ArrayList<Integer> transition){
        int startNode = 0;
        for (int i = 0; i < transition.size(); i++) {
            System.out.println(transitionAction.get(nodeList.get(startNode).getActionMap().get(transition.get(i))));
            startNode = nodeList.get(startNode).getTransitionMap().get(transition.get(i));
        }
    }
    private void createNodeList(){
        Node tmp = new Node(0, 1, 0, 1,4,1);
        nodeList.add(tmp);
        tmp = new Node(0,2,3,1,3,5);
        nodeList.add(tmp);
        tmp = new Node(0,3,5,1,4,1);
        nodeList.add(tmp);
        tmp = new Node(0,2,2,1,4,4);
        nodeList.add(tmp);
        tmp = new Node(0,0,4,1,2,2);
        nodeList.add(tmp);
    }

    private void createTransitAction(){
        transitionAction.put(0,"create_project");
        transitionAction.put(1,"add_library");
        transitionAction.put(2,"restart");
        transitionAction.put(3,"test");
        transitionAction.put(4,"deploy");
        transitionAction.put(5,"drop_db");
    }


}
