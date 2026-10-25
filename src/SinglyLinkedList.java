import java.util.HashSet;
import java.util.Scanner;

public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public boolean isEmpty() { return head == null; }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        System.out.println("Inserted " + value + " at the beginning.");
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) { head = node; }
        else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = node;
        }
        System.out.println("Inserted " + value + " at the end.");
    }

    public void insertAtPosition(int value, int position) {
        if (position < 1 || position > countNodes() + 1) {
            System.out.println("Invalid position. Valid positions: 1 to " + (countNodes() + 1) + "."); return;
        }
        if (position == 1) { insertAtBeginning(value); return; }
        Node current = head;
        for (int i = 1; i < position - 1; i++) current = current.next;
        Node node = new Node(value);
        node.next = current.next;
        current.next = node;
        System.out.println("Inserted " + value + " at position " + position + ".");
    }

    public void insertAfter(int target, int value) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) { System.out.println("Value " + target + " not found."); return; }
        Node node = new Node(value); node.next = current.next; current.next = node;
        System.out.println("Inserted " + value + " after " + target + ".");
    }

    public void insertBefore(int target, int value) {
        if (head == null) { System.out.println("List is empty."); return; }
        if (head.data == target) { insertAtBeginning(value); return; }
        Node current = head;
        while (current.next != null && current.next.data != target) current = current.next;
        if (current.next == null) { System.out.println("Value " + target + " not found."); return; }
        Node node = new Node(value); node.next = current.next; current.next = node;
        System.out.println("Inserted " + value + " before " + target + ".");
    }

    public void deleteBeginning() {
        if (head == null) { System.out.println("List is empty; nothing to delete."); return; }
        int removed = head.data; head = head.next;
        System.out.println("Deleted " + removed + " from the beginning.");
    }

    public void deleteEnd() {
        if (head == null) { System.out.println("List is empty; nothing to delete."); return; }
        if (head.next == null) { int removed = head.data; head = null; System.out.println("Deleted " + removed + " from the end."); return; }
        Node current = head;
        while (current.next.next != null) current = current.next;
        int removed = current.next.data; current.next = null;
        System.out.println("Deleted " + removed + " from the end.");
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || position > countNodes()) { System.out.println("Invalid position."); return; }
        if (position == 1) { deleteBeginning(); return; }
        Node current = head;
        for (int i = 1; i < position - 1; i++) current = current.next;
        int removed = current.next.data; current.next = current.next.next;
        System.out.println("Deleted " + removed + " from position " + position + ".");
    }

    public void deleteByValue(int value) {
        if (head == null) { System.out.println("List is empty."); return; }
        if (head.data == value) { deleteBeginning(); return; }
        Node current = head;
        while (current.next != null && current.next.data != value) current = current.next;
        if (current.next == null) { System.out.println("Value " + value + " not found."); return; }
        current.next = current.next.next;
        System.out.println("Deleted first occurrence of " + value + ".");
    }

    public int search(int value) {
        Node current = head; int position = 1;
        while (current != null) { if (current.data == value) return position; current = current.next; position++; }
        return -1;
    }

    public void update(int oldValue, int newValue) {
        Node current = head;
        while (current != null && current.data != oldValue) current = current.next;
        if (current == null) { System.out.println("Value " + oldValue + " not found."); return; }
        current.data = newValue; System.out.println("Updated " + oldValue + " to " + newValue + ".");
    }

    public void display() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node current = head;
        while (current != null) { System.out.print(current.data + " -> "); current = current.next; }
        System.out.println("NULL");
    }

    public int countNodes() { int count = 0; for (Node n = head; n != null; n = n.next) count++; return count; }

    public void findMaximum() {
        if (head == null) { System.out.println("List is empty."); return; }
        int max = head.data; for (Node n = head.next; n != null; n = n.next) if (n.data > max) max = n.data;
        System.out.println("Maximum: " + max);
    }

    public void findMinimum() {
        if (head == null) { System.out.println("List is empty."); return; }
        int min = head.data; for (Node n = head.next; n != null; n = n.next) if (n.data < min) min = n.data;
        System.out.println("Minimum: " + min);
    }

    public void findMiddle() {
        if (head == null) { System.out.println("List is empty."); return; }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) { slow = slow.next; fast = fast.next.next; }
        System.out.println("Middle element (second middle for even length): " + slow.data);
    }

    public void reverse() {
        Node previous = null, current = head;
        while (current != null) { Node next = current.next; current.next = previous; previous = current; current = next; }
        head = previous; System.out.println("List reversed.");
    }

    public void sort() {
        if (head == null || head.next == null) { System.out.println("List sorted."); return; }
        boolean swapped;
        do {
            swapped = false; Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) { int temp = current.data; current.data = current.next.data; current.next.data = temp; swapped = true; }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List sorted in ascending order.");
    }

    public void removeDuplicates() {
        HashSet<Integer> seen = new HashSet<>(); Node current = head, previous = null; int removed = 0;
        while (current != null) {
            if (seen.contains(current.data)) { previous.next = current.next; removed++; }
            else { seen.add(current.data); previous = current; }
            current = current.next;
        }
        System.out.println("Removed " + removed + " duplicate node(s).");
    }

    public void menu(Scanner sc) {
        int choice;
        do {
            System.out.println("\n********** Operations on Singly Linked List **********");
            System.out.println(" 1. Insert at Beginning\n 2. Insert at End\n 3. Insert at Position\n 4. Insert After a Node\n 5. Insert Before a Node");
            System.out.println(" 6. Delete from Beginning\n 7. Delete from End\n 8. Delete from Position\n 9. Delete by Value");
            System.out.println("10. Search\n11. Update\n12. Display\n13. Count Nodes\n14. Find Maximum\n15. Find Minimum");
            System.out.println("16. Find Middle Element\n17. Reverse\n18. Sort\n19. Remove Duplicates\n20. Exit");
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
                case 12: display(); break;
                case 13: System.out.println("Node count: " + countNodes()); break;
                case 14: findMaximum(); break;
                case 15: findMinimum(); break;
                case 16: findMiddle(); break;
                case 17: reverse(); break;
                case 18: sort(); break;
                case 19: removeDuplicates(); break;
                case 20: System.out.println("Returning to main menu..."); break;
                default: System.out.println("Invalid choice. Please select 1-20.");
            }
        } while (choice != 20);
    }
}
