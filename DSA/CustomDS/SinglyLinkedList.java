package CustomDS;

import java.util.LinkedList;

public class SinglyLinkedList {
    static LinkedList<String> students = new LinkedList<>();

    public static void reverseSinglyLinkedList(LinkedList<String> lst) {
        LinkedList<String> newLst = new LinkedList<>();

        while (!lst.isEmpty()) {
            newLst.add(lst.removeLast());
        }

        for (String item : newLst) {
            System.out.println(item);
        }
    }

    public static void insertNodeFront(LinkedList<String> lst, String toInsert) {
        lst.addFirst(toInsert);
    }

    public static void insertNodeBack(LinkedList<String> lst, String toInsert) {
        lst.addLast(toInsert);
    }

    public static void deleteNodeOfValue(LinkedList<String> lst, String value) {
        lst.remove(value);

        for (String item : lst) {
            System.out.println(item);
        }
    }

    public static void searchForElement(LinkedList<String> lst, String value) {
        for (String item : lst) {
            if (item == value) { System.out.println(true); }
        }

        System.out.println(false);
    }

    public static void returnLength() {}

    public static void main(String[] args) {
        students.add("Adam");
        students.add("Bob");
        students.add("Charlie");
        students.add("Dennis");
        students.add("Elliot");

        // students.add(3, "Foxtrot");

        // students.remove("Dennis");
        // students.remove(4);

        // students.addFirst("Anna");
        // students.addLast("Garry");

        // students.removeFirst();
        // students.removeLast();

        // System.out.println(students.peekFirst());
        // System.out.println(students.peekLast());

        // reverseSinglyLinkedList(students);
        deleteNodeOfValue(students, "Adam");
    }
}
