package cci.practice;

/**
 * Created by srikanth on 3/5/2016.
 */
public class main {


    public static void main(String[] args){
        MyList lst = new MyList();
        lst.add("tester");
        lst.add("temp");
        lst.printList();
        lst.remove("temp");
        lst.printList();

    }
}
