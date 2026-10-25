# Linked List Management System

**DSA Mini Project | Java | 2nd Year College Level**

## Objective
A menu-driven console application to demonstrate linked-list operations through manually implemented Singly Linked List and Doubly Linked List data structures.

## Language and requirements
- Java 8 or newer
- Terminal / command prompt
- No external libraries required

## Features
### Singly Linked List
Insert at beginning/end/position/before/after; delete from beginning/end/position/by value; search; update; display; count; maximum; minimum; middle element; reverse; ascending Bubble Sort; remove duplicates.

### Doubly Linked List
All singly-list operations, plus forward and backward display. The implementation maintains both `prev` and `next` links and tracks both `head` and `tail`.

### Other features
- Main menu and separate operation menus
- 1-based positions
- Handles empty and one-node lists, missing values, invalid positions, duplicate values, zero and negative integers
- Input validation for non-integer menu/data input
- Comparison table for singly and doubly linked lists

## How to compile and run
From the project root:

```bash
javac -d out src/Main.java src/SinglyLinkedList.java src/DoublyLinkedList.java
java -cp out Main
```

If your terminal is already inside the `src` folder:

```bash
javac Main.java SinglyLinkedList.java DoublyLinkedList.java
java Main
```

## Design notes
- The lists are implemented using custom `Node` classes and object references; Java's built-in `List` / `ArrayList` is not used to store list elements.
- Positions are 1-based.
- For an even number of nodes, `Find Middle Element` returns the second middle node.
- `Update` changes the first matching occurrence. `Delete by Value` removes the first matching occurrence.
- Duplicate removal preserves the first occurrence of each value.
- Bubble Sort sorts in ascending order by swapping node data.

## Typical time complexity
| Operation | Singly linked list | Doubly linked list |
|---|---:|---:|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) with tail reference |
| Insert at position | O(n) | O(n) |
| Search / display / count | O(n) | O(n) |
| Delete from beginning | O(1) | O(1) |
| Delete from end | O(n) | O(1) with tail reference |
| Find min / max / middle | O(n) | O(n) |
| Reverse | O(n), O(1) extra space | O(n), O(1) extra space |
| Bubble Sort | O(n²) | O(n²) |
| Remove duplicates | O(n) expected with HashSet | O(n) expected with HashSet |

## Project structure
```text
Linked-List-Management-System/
├── README.md
├── .gitignore
├── src/
│   ├── Main.java
│   ├── SinglyLinkedList.java
│   └── DoublyLinkedList.java
├── sample-output/
│   └── output.txt
└── docs/
    └── project-report.md
```
