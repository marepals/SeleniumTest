package cci.practice;

/**
 * Created by srikanth on 3/6/2016.
 */
public class Node {
    protected String value;
    protected Node next;

    Node(String value){
        this.value = value;
        next = null;
    }
    Node(String value, Node node){
        this.value = value;
        next = node;
    }

    public void setNext(Node node){
        this.next = node;
    }

    public Node getNext(){
        return next;
    }
}
