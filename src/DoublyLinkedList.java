import java.util.HashSet;
import java.util.Scanner;

public class DoublyLinkedList {
    private static class Node {
        int data; Node prev, next;
        Node(int data) { this.data = data; }
    }
    private Node head, tail;

    public boolean isEmpty() { return head == null; }
    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head == null) head = tail = node;
        else { node.next = head; head.prev = node; head = node; }
        System.out.println("Inserted " + value + " at the beginning.");
    }
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (tail == null) head = tail = node;
        else { tail.next = node; node.prev = tail; tail = node; }
        System.out.println("Inserted " + value + " at the end.");
    }
    public int countNodes() { int count = 0; for (Node n = head; n != null; n = n.next) count++; return count; }
    public void insertAtPosition(int value, int position) {
        if (position < 1 || position > countNodes() + 1) { System.out.println("Invalid position. Valid positions: 1 to " + (countNodes() + 1) + "."); return; }
        if (position == 1) { insertAtBeginning(value); return; }
        if (position == countNodes() + 1) { insertAtEnd(value); return; }
        Node current = head; for (int i = 1; i < position; i++) current = current.next;
        Node node = new Node(value); node.prev = current.prev; node.next = current;
        current.prev.next = node; current.prev = node;
        System.out.println("Inserted " + value + " at position " + position + ".");
    }
    public void insertAfter(int target, int value) {
        Node current = head; while (current != null && current.data != target) current = current.next;
        if (current == null) { System.out.println("Value " + target + " not found."); return; }
        if (current == tail) { insertAtEnd(value); return; }
        Node node = new Node(value); node.prev = current; node.next = current.next;
        current.next.prev = node; current.next = node;
        System.out.println("Inserted " + value + " after " + target + ".");
    }
    public void insertBefore(int target, int value) {
        Node current = head; while (current != null && current.data != target) current = current.next;
        if (current == null) { System.out.println("Value " + target + " not found."); return; }
        if (current == head) { insertAtBeginning(value); return; }
        Node node = new Node(value); node.next = current; node.prev = current.prev;
        current.prev.next = node; current.prev = node;
        System.out.println("Inserted " + value + " before " + target + ".");
    }
    public void deleteBeginning() {
        if (head == null) { System.out.println("List is empty; nothing to delete."); return; }
        int removed = head.data;
        if (head == tail) head = tail = null;
        else { head = head.next; head.prev = null; }
        System.out.println("Deleted " + removed + " from the beginning.");
    }
    public void deleteEnd() {
        if (tail == null) { System.out.println("List is empty; nothing to delete."); return; }
        int removed = tail.data;
        if (head == tail) head = tail = null;
        else { tail = tail.prev; tail.next = null; }
        System.out.println("Deleted " + removed + " from the end.");
    }
    public void deleteAtPosition(int position) {
        int count = countNodes(); if (position < 1 || position > count) { System.out.println("Invalid position."); return; }
        if (position == 1) { deleteBeginning(); return; } if (position == count) { deleteEnd(); return; }
        Node current = head; for (int i = 1; i < position; i++) current = current.next;
        current.prev.next = current.next; current.next.prev = current.prev;
        System.out.println("Deleted " + current.data + " from position " + position + ".");
    }
    public void deleteByValue(int value) {
        Node current = head; while (current != null && current.data != value) current = current.next;
        if (current == null) { System.out.println("Value " + value + " not found."); return; }
        if (current == head) { deleteBeginning(); return; } if (current == tail) { deleteEnd(); return; }
        current.prev.next = current.next; current.next.prev = current.prev;
        System.out.println("Deleted first occurrence of " + value + ".");
    }
    public int search(int value) { int p = 1; for (Node n = head; n != null; n = n.next, p++) if (n.data == value) return p; return -1; }
    public void update(int oldValue, int newValue) {
        for (Node n = head; n != null; n = n.next) if (n.data == oldValue) { n.data = newValue; System.out.println("Updated " + oldValue + " to " + newValue + "."); return; }
        System.out.println("Value " + oldValue + " not found.");
    }
    public void displayForward() {
        if (head == null) { System.out.println("List is empty."); return; }
        System.out.print("NULL <- "); for (Node n = head; n != null; n = n.next) { System.out.print(n.data); if (n.next != null) System.out.print(" <-> "); }
        System.out.println(" -> NULL");
    }
    public void displayBackward() {
        if (tail == null) { System.out.println("List is empty."); return; }
        System.out.print("NULL <- "); for (Node n = tail; n != null; n = n.prev) { System.out.print(n.data); if (n.prev != null) System.out.print(" <-> "); }
        System.out.println(" -> NULL");
    }
    public void findMaximum() {
        if (head == null) { System.out.println("List is empty."); return; }
        int max = head.data; for (Node n = head.next; n != null; n = n.next) if (n.data > max) max = n.data; System.out.println("Maximum: " + max);
    }
    public void findMinimum() {
        if (head == null) { System.out.println("List is empty."); return; }
        int min = head.data; for (Node n = head.next; n != null; n = n.next) if (n.data < min) min = n.data; System.out.println("Minimum: " + min);
    }
    public void findMiddle() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node slow = head, fast = head; while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        System.out.println("Middle element (second middle for even length): " + slow.data);
    }
    public void reverse() {
        Node current = head;
        while (current != null) { Node next = current.next; current.next = current.prev; current.prev = next; current = next; }
        Node temp = head; head = tail; tail = temp; System.out.println("List reversed.");
    }
    public void sort() {
        if (head == null || head.next == null) { System.out.println("List sorted."); return; }
        boolean swapped; do { swapped = false; for (Node n = head; n.next != null; n = n.next) if (n.data > n.next.data) { int t = n.data; n.data = n.next.data; n.next.data = t; swapped = true; } } while (swapped);
        System.out.println("List sorted in ascending order.");
    }
    public void removeDuplicates() {
        HashSet<Integer> seen = new HashSet<>(); Node current = head; int removed = 0;
        while (current != null) {
            Node next = current.next;
            if (seen.contains(current.data)) {
                if (current == head) head = current.next; if (current == tail) tail = current.prev;
                if (current.prev != null) current.prev.next = current.next;
                if (current.next != null) current.next.prev = current.prev;
                removed++;
            } else seen.add(current.data);
            current = next;
        }
        System.out.println("Removed " + removed + " duplicate node(s).");
    }
    public void menu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n********** Operations on Doubly Linked List **********");
            System.out.println(" 1. Insert at Beginning\n 2. Insert at End\n 3. Insert at Position\n 4. Insert After a Node\n 5. Insert Before a Node");
            System.out.println(" 6. Delete from Beginning\n 7. Delete from End\n 8. Delete from Position\n 9. Delete by Value");
            System.out.println("10. Search\n11. Update\n12. Display Forward\n13. Display Backward\n14. Count Nodes");
            System.out.println("15. Find Maximum\n16. Find Minimum\n17. Find Middle Element\n18. Reverse\n19. Sort\n20. Remove Duplicates\n21. Exit");
            choice = Main.readInt(sc, "Enter your choice: ");
            switch (choice) {
                case 1: insertAtBeginning(Main.readInt(sc, "Enter value: ")); break;
                case 2: insertAtEnd(Main.readInt(sc, "Enter value: ")); break;
                case 3: insertAtPosition(Main.readInt(sc, "Enter value: "), Main.readInt(sc, "Enter 1-based position: ")); break;
                case 4: insertAfter(Main.readInt(sc, "Insert after which value? "), Main.readInt(sc, "Enter new value: ")); break;
                case 5: insertBefore(Main.readInt(sc, "Insert before which value? "), Main.readInt(sc, "Enter new value: ")); break;
                case 6: deleteBeginning(); break;
                case 7: deleteEnd(); break;
                case 8: deleteAtPosition(Main.readInt(sc, "Enter 1-based position: ")); break;
                case 9: deleteByValue(Main.readInt(sc, "Enter value to delete: ")); break;
                case 10: { int p = search(Main.readInt(sc, "Enter value to search: ")); System.out.println(p == -1 ? "Value not found." : "Value found at position " + p + "."); break; }
                case 11: update(Main.readInt(sc, "Enter existing value: "), Main.readInt(sc, "Enter new value: ")); break;
                case 12: displayForward(); break;
                case 13: displayBackward(); break;
                case 14: System.out.println("Node count: " + countNodes()); break;
                case 15: findMaximum(); break;
                case 16: findMinimum(); break;
                case 17: findMiddle(); break;
                case 18: reverse(); break;
                case 19: sort(); break;
                case 20: removeDuplicates(); break;
                case 21: System.out.println("Returning to main menu..."); break;
                default: System.out.println("Invalid choice. Please select 1-21.");
            }
        } while (choice != 21);
    }
}
