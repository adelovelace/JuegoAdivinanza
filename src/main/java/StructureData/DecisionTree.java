package StructureData;

import java.util.*;

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


    //inserta las preguntas
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

        System.out.println("Nivel: " + level);

    }

    public void addAnswers(ArrayList<E> answers, DecisionTree<E> tree){

        for (E answer: answers) {


            List<String> ans = Arrays.asList(answer.toString().split(" "));

            String name = ans.get(0);
            System.out.println("Nombre:" +  name);
            String ultimo = ans.get(ans.size()-1);
            System.out.println("Ultimo:" +  ultimo);
            Node<E> node = tree.root;

            for (int i=1; i < ans.size()-1; i++){
                if(ans.get(i).compareTo("SI")==0){
                    node=node.left;
                }
                else{
                    node= node.right;
                }
            }
            Node<E> nuevo= new Node<>((E) name);
            if (ultimo.compareTo("SI")==0){
                node.left = nuevo;
            }else{
                node.right = nuevo;
            }


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


//    public static void main(String[] args) {
//
//        DecisionTree <String> decisionTree = new DecisionTree();
//
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Es un animal?");
//        arrayList.add("Es mamifero?");
//        arrayList.add("Es Carnivoro?");
//        arrayList.add("Es de 4 patas?");
//
//        decisionTree.addQuestion(arrayList);
//
//        System.out.println(decisionTree.breadthTraversal());
//
//        ArrayList<String> arrayOso = new ArrayList<>();
//        arrayOso.add("Oso SI SI SI SI");
//
//        ArrayList<String> arrayVenado = new ArrayList<>();
//        arrayVenado.add("Venado SI SI NO SI");
//
//        ArrayList<String> arrayLechuza = new ArrayList<>();
//        arrayLechuza.add("Lechuza SI NO SI NO");
//
//        ArrayList<String> arrayPaloma = new ArrayList<>();
//        arrayPaloma.add("Paloma SI NO NO NO");
//
//
//
//        decisionTree.addAnswers(arrayOso,decisionTree);
//        decisionTree.addAnswers(arrayVenado,decisionTree);
//        decisionTree.addAnswers(arrayLechuza,decisionTree);
//        decisionTree.addAnswers(arrayPaloma,decisionTree);
//
//        System.out.println(decisionTree.breadthTraversal());
//
//
//
//
//    }

}
