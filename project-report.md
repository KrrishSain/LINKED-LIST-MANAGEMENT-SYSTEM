# Project Report: Linked List Management System

## 1. Introduction
This Java console project demonstrates dynamic linear data structures using manually implemented singly and doubly linked lists.

## 2. Objectives
- Implement insertion, deletion, search, update, traversal and utility operations.
- Understand node references and link maintenance.
- Compare singly and doubly linked list trade-offs.
- Handle invalid input and common edge cases.

## 3. Data structures
A singly linked node stores data and a `next` reference. A doubly linked node stores data plus `prev` and `next` references. The doubly linked list maintains `head` and `tail` references for traversal and efficient end operations.

## 4. Algorithms
- Reverse singly list: iterative previous/current/next pointer technique.
- Reverse doubly list: swap each node's `prev` and `next`, then swap head and tail.
- Middle: slow and fast references; returns the second middle for an even-sized list.
- Sort: Bubble Sort by swapping data values.
- Remove duplicates: a `HashSet` tracks values already encountered, preserving the first occurrence.

## 5. Complexity
Search, display, count, min/max and middle are O(n). Reversal is O(n) time and O(1) extra space. Bubble Sort is O(n²). Beginning insertion/deletion is O(1). Doubly linked end insertion/deletion is O(1) because a tail reference is maintained; singly linked end insertion/deletion is O(n) without a tail reference.

## 6. Testing checklist
- Empty list display, search, min/max and deletion
- Single-node insert/delete/reverse
- Insert/delete at first, middle and last valid positions
- Invalid and out-of-range positions
- Missing target values
- Duplicate, zero and negative values
- Sort and reverse empty, one-node and multi-node lists
- Doubly linked forward/backward display after mutations

## 7. Conclusion
The project provides hands-on practice with linked-list algorithms, reference management, edge cases and time complexity in Java.
