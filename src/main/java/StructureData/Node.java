package StructureData;

public class Node<E> {
    Node<E> left;
    Node<E> right;
    E data;

    Node(E data){
        this.data = data;
        this.left = this.right = null;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}