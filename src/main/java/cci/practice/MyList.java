package cci.practice;

/**
 * Created by srikanth on 3/5/2016.
 */
public class MyList {
    Node head;
    int size;

    MyList(){
        head = null;
        size = 0;
    }

    public void add(String value){
        Node temp;

        if(head == null)
            head = new Node(value);
        else {
            temp = head;
            while(temp.next != null )
                temp = temp.next;
            temp.next = new Node(value);
        }
        size=size+1;
    }

    public void printList(){
        Node temp = head;
        System.out.println("printing list");
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.getNext();
        }
    }

    public void remove(String value) {
        Node temp = head;
        Node prev = head;
        if( temp == null)
            return;
        else if ( head.value.equals(value)){
            head = head.next;
        }
        else{
            while(temp.next != null) {
                if (temp.next.value.equals(value)) {
                    temp.next = temp.next.next;
                }
            }
        }
    }
}
