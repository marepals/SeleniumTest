package cci.practice;

import org.jboss.netty.util.internal.LegacyLinkedTransferQueue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by srikanth on 3/4/2016.
 */
public class Lists {
    public static void main (String [] args){
        ArrayList();
    }

    public static void ArrayList() {
        ArrayList<String> names = new ArrayList<String>();
        // only objects can be passed, no primitive types.
        //for primitive types, use java wrappers Integer, Double, (Integer.getValue(i))
        //Arrays support both primitive and objects.

        names.add("apple");
        names.add("pear");
        System.out.println(names.toString());
        names.set(1, "test");
        System.out.println(names.toString());
        System.out.println(names.indexOf("test"));
        names.remove("test");
        System.out.println(names.toString());
        names.remove(0);
        System.out.println(names.toString());

        //ArrayList supports primitives by autoboxing and unboxing
        ArrayList intarr = new ArrayList();
        intarr.add(1);
        intarr.add(2);
        intarr.add(3);
        System.out.println(intarr.toString());

        ArrayList dblarr = new ArrayList();

        dblarr.add(5.4938);
        dblarr.add(5);
        System.out.println(dblarr.toString());

        ArrayList chrarr = new ArrayList();

        chrarr.add('c');
        chrarr.add('d');
        System.out.println(chrarr.toString());

    }

    public static void LinkedList(){
        LinkedList<String> list = new LinkedList<String>();

        list.add("Srikanth");
        list.add("Gayatri");


        list.add("Nikhil");
        list.add("Akhil");
        list.add("Family");


        // using iterator
        System.out.println("using iterator");
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println((String)itr.next());
        }

        // using for each
        System.out.println("using for each");
        for (String s :list
                ) {
            System.out.println(s);
        }
        System.out.println("for loop");
        for(int i=0; i< list.size(); i++) {

        }
    }
}
