package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.add(4);
        myList.add(69);
        myList.add(17);
        myList.add(102);
        myList.add(38);
        myList.add(69);
        myList.add(88);


        myList.add(91, 3);
        myList.ShowList();
        myList.remove(5);
        //System.out.println("Remove = " + myList.remove(17));

        myList.ShowList();

        myList.add(7);
        myList.add(34);
        myList.add(69);
        myList.add(212);
        myList.add(96);

        myList.ShowList();

        myList.remove(4);

        myList.ShowList();

        System.out.println("Index of = " + myList.indexOf(69));
        System.out.println("Index of = " + myList.lastIndexOf(69));
        System.out.println(myList.contains(91) ? "Linked list has element 91" : "Linked list has not element 91");
        System.out.println(myList.contains(2) ? "Linked list has element 2" : "Linked list has not element 2");
    }
}
