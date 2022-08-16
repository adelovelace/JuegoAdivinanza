package StructureData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DecisionTree<E> {

    private Node<E> root;
    private Queue<Node<E>> queue = new LinkedList<>();

    public DecisionTree(E data) {
        this.root.data = data;
        this.queue.add(this.root);
    }

    public DecisionTree() {
    }

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }



    public boolean insert (E data){

        if(data == null){
            return false;
        }

        Node<E> node = new Node<>(data);

        if(this.root == null){
            this.root = node;
        }else if(queue.peek().getLeft() == null){ //left node
            queue.peek().setLeft(node);
        }else{ //right node
            queue.peek().setRight(node);
            queue.remove();
        }

        queue.add(node);
        return true;
    }

    public void addQuestion(ArrayList<E> questions){

        int level = 0;
        int times = 0;

        for (E question: questions) {
            if(level == 0){
                this.insert(question);
            }else{
                for (int i = 0; i < times; i++) {
                    this.insert(question);
                }
            }
            times = (int) Math.pow(2,level+1);
            level++;
        }

    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public E getRootContent(){
        return this.root.getData();
    }




    public LinkedList<E> breadthTraversal() {
        LinkedList<E> traversal = new LinkedList<>();
        Queue<Node<E>> q = new LinkedList<>();
        q.offer(this.root);
        while (!q.isEmpty()) {
            Node<E> node = q.poll();
            if (node != null) {
                traversal.add(node.getData());
            }
            if (node.getLeft() != null) {
                q.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                q.offer(node.getRight());
            }
        }
        return traversal;
    }


    public static void main(String[] args) {

        DecisionTree <String> decisionTree = new DecisionTree();

        decisionTree.insert("mama");
        decisionTree.insert("papa");
        decisionTree.insert("Es Carnivoro?");
        decisionTree.insert("Es de 4 patas?");

        System.out.println(decisionTree.breadthTraversal());
        
    }

}
