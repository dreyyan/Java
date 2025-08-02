package DSA;

import java.util.LinkedList;

public class SinglyLinkedList {
    static LinkedList<String> students = new LinkedList<>();

    public static void main(String[] args) {
        students.add("Adam");
        students.add("Bob");
        students.add("Charlie");
        students.add("Dennis");
        students.add("Elliot");

        students.add(3, "Foxtrot");

        students.remove("Dennis");
        students.remove(4);

        students.addFirst("Anna");
        students.addLast("Garry");

        students.removeFirst();
        students.removeLast();

        System.out.println(students.peekFirst());
        System.out.println(students.peekLast());

        for (String student : students) {
            System.out.println(student);
        }
    }
}
