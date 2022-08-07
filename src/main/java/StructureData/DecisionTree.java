package StructureData;
public class DecisionTree<E> {
    public class Node<E> {
        Node<E> left;
        Node<E> right;
        E data;
    }
    public Node root;

    public DecisionTree(E data) {
        root.data = data;
        root.left = root.right = null;
    }

}
