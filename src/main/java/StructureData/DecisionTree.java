package StructureData;



import java.util.*;

public class DecisionTree<E> {

    private Node<E> root;
    private Queue<Node<E>> queue = new LinkedList<>();
    private ArrayList<E> leafs = new ArrayList<>();
    private ArrayList<E> guessLeafs = new ArrayList<>();

    public DecisionTree(E data) {
        this.root.data = data;
        this.queue.add(this.root);
    }

    public DecisionTree() {
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

    //
    public void guesses (DecisionTree<E> tree, ArrayList<String> paths){

        Node<E> node = tree.root;

        for(int i =0; i < paths.size(); i++){

            if(paths.get(i).compareTo("SI")==0){
                if(node.left == null){
                    System.out.println("izquierdo es nulo");
                    break;
                }
                node=node.left;
            }
            else{
                if(node.right == null){
                    System.out.println("derecho es nulo");
                    break;
                }
                node= node.right;
            }


        }

        //solucion esta en el for :D

        if(node.left !=null){
            this.guessLeafs.clear();
            printLeafNodes(node);
        }



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


    //is a leaf
    public boolean isLeaf(Node<E> node){

        if(node == null){
            System.out.println("It is not a leaf");
            return false;
        }

        if(node.left == null && node.right == null){
            return true;
        }

        return false;
    }

    public void printLeafNodes(Node node)
    {

        // If node is null, return
        if (node == null){
            this.leafs.add((E)"Node does not exist!");
            this.guessLeafs.add((E)"Node does not exist!");
        }

        // If node is leaf node, print its data
        if (isLeaf(node))
        {
            this.leafs.add((E)node.data);
            this.guessLeafs.add((E)node.data);
            System.out.println("Hoja " + node.getData().toString());

        }


        // If left child exists, check for leaf
        // recursively
        if (node.left != null)
            printLeafNodes(node.left);

        // If right child exists, check for leaf
        // recursively
        if (node.right != null)
            printLeafNodes(node.right);

    }

    //calculate tree level
    public int levelCalc(Node node){

        if(node.right == null && node.left==null){
            return 1;
        }

        if(node.left !=null){
            return levelCalc(node.left) + 1;
        }

        if(node.right !=null){
            return levelCalc(node.right) + 1;
        }

        return 0;
    }

    //getters and setters
    public Node<E> getRoot() {
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public Queue<Node<E>> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Node<E>> queue) {
        this.queue = queue;
    }

    public ArrayList<E> getLeafs() {
        return leafs;
    }

    public void setLeafs(ArrayList<E> leafs) {
        this.leafs = leafs;
    }

    public static void main(String[] args) {

        DecisionTree <String> decisionTree = new DecisionTree();

        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("Es un animal?");
        arrayList.add("Es mamifero?");
        arrayList.add("Es Carnivoro?");
        arrayList.add("Es de 4 patas?");

        decisionTree.addQuestion(arrayList);

        System.out.println(decisionTree.breadthTraversal());

        ArrayList<String> arrayOso = new ArrayList<>();
        arrayOso.add("Oso SI SI SI");
//        arrayOso.add("Oso SI SI SI SI");

        ArrayList<String> arrayVenado = new ArrayList<>();
        arrayVenado.add("Venado SI NO SI");
//        arrayVenado.add("Venado SI SI NO SI");

        ArrayList<String> arrayLechuza = new ArrayList<>();
        arrayLechuza.add("Lechuza NO SI NO");
//        arrayLechuza.add("Lechuza SI NO SI NO");

        ArrayList<String> arrayPaloma = new ArrayList<>();
        arrayPaloma.add("Paloma NO NO NO");
//        arrayPaloma.add("Paloma SI NO NO NO");



        decisionTree.addAnswers(arrayOso,decisionTree);
        decisionTree.addAnswers(arrayVenado,decisionTree);
        decisionTree.addAnswers(arrayLechuza,decisionTree);
        decisionTree.addAnswers(arrayPaloma,decisionTree);

        System.out.println("Arbol despues de llenar con respuestas");
        System.out.println(decisionTree.breadthTraversal());


        System.out.println("Nivel del arbol");
        System.out.println(decisionTree.levelCalc(decisionTree.root));

        System.out.println("Imprimir las hojas del arbol");
        decisionTree.printLeafNodes(decisionTree.root);


        System.out.println("Imprimir el atributo de hoja de arboles");
        for (String e : decisionTree.getLeafs()) {
            System.out.println(e);
        }

        ArrayList<String> arrayPath = new ArrayList<>();
//        arrayPath.add("SI");
//        arrayPath.add("SI");
//        arrayPath.add("NO");


        arrayPath.add("NO");
        arrayPath.add("NO");
        arrayPath.add("SI");

        System.out.println("Adivina!");
        decisionTree.guesses(decisionTree,arrayPath);




    }

}
