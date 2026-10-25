import java.util.Scanner;

public class Main {
    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try { return Integer.parseInt(line); }
            catch (NumberFormatException e) { System.out.println("Invalid input. Please enter a whole number."); }
        }
    }

    private static void compareLists() {
        System.out.println("\n========== SINGLY VS DOUBLY LINKED LIST ==========");
        System.out.printf("%-28s %-28s %-28s%n", "Feature", "Singly Linked List", "Doubly Linked List");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%-28s %-28s %-28s%n", "Links per node", "next", "prev and next");
        System.out.printf("%-28s %-28s %-28s%n", "Traversal", "Forward only", "Forward and backward");
        System.out.printf("%-28s %-28s %-28s%n", "Memory per node", "Lower", "Higher (extra prev link)");
        System.out.printf("%-28s %-28s %-28s%n", "Insert at beginning", "O(1)", "O(1)");
        System.out.printf("%-28s %-28s %-28s%n", "Search", "O(n)", "O(n)");
        System.out.printf("%-28s %-28s %-28s%n", "Delete last node", "O(n)", "O(1) with tail reference");
        System.out.printf("%-28s %-28s %-28s%n", "Implementation", "Simpler", "More link updates needed");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLinkedList singly = new SinglyLinkedList();
        DoublyLinkedList doubly = new DoublyLinkedList();
        int choice;
        System.out.println("====================================================");
        System.out.println("          LINKED LIST MANAGEMENT SYSTEM");
        System.out.println("             DSA MINI PROJECT - JAVA");
        System.out.println("====================================================");
        do {
            System.out.println("\n1. Singly Linked List\n2. Doubly Linked List\n3. Compare Singly vs Doubly Linked List\n4. Exit");
            choice = readInt(sc, "Enter your choice: ");
            switch (choice) {
                case 1: singly.menu(sc); break;
                case 2: doubly.menu(sc); break;
                case 3: compareLists(); break;
                case 4: System.out.println("Thank you for using Linked List Management System. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please select 1-4.");
            }
        } while (choice != 4);
        sc.close();
    }
}
