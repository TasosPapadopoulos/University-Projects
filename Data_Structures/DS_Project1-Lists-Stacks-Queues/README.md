# 🧬 Data Structures: Double-Ended Queue & Applications

## 📌 Overview
This repository contains the first project for the **Data Structures** course at the Athens University of Economics and Business (AUEB). The primary objective is to implement fundamental Abstract Data Types (ADTs) from scratch in **Java**, strictly without relying on built-in `java.util` collections (such as `Vector` or `ArrayList`). 

The core of this project is the implementation of a **Double-Ended Queue (Deque)**, powered by a custom-built **Doubly Linked List**, which is then utilized to solve two distinct algorithmic problems.

## 📄 Full Assignment Details

For the complete problem descriptions, constraints, and execution examples, please refer to the attached official document: 👉 [DS_Project_1.pdf](./Εργασία_1_(εκφώνηση)_(DS23-project1).pdf) *(Note: The document is in Greek)*.

## 🚀 Features & Implementations

### Part A: Custom ADT (Double-Ended Queue)
* **Implementation:** Developed `StringDoubleEndedQueueImpl.java` based on the provided `StringDoubleEndedQueue.java` interface.
* **Underlying Structure:** Built entirely upon a manual Doubly Linked List.
* **Time Complexity:** Achieved strict $O(1)$ time complexity for all core operations (`addFirst`, `removeFirst`, `addLast`, `removeLast`, `getFirst`, `getLast`, and `size`).
* **Exception Handling:** Graceful handling of edge cases, throwing the standard `java.util.NoSuchElementException` when attempting to read from an empty queue.

### Part B: Prefix to Infix Expression Converter
* **Functionality:** A client program (`PrefixToInfix.java`) that reads a mathematical expression in prefix notation and outputs the equivalent infix notation, properly inserting parentheses.
* **Constraints:** Processes single-digit integers and standard operators (`+`, `-`, `*`, `/`).
* **Error Handling:** Validates the input and outputs specific error messages for invalid prefix expressions (e.g., expressions not starting with an operator or containing invalid characters).

### Part C: DNA Watson-Crick Palindrome Checker
* **Biological Context:** In DNA, Adenine (A) complements Thymine (T), and Cytosine (C) complements Guanine (G). A sequence is a Watson-Crick complemented palindrome if replacing each nucleotide with its complement and reversing the sequence yields the original sequence (e.g., `AAAACGTTTT`).
* **Functionality:** A client program (`DNAPalindrome.java`) that validates a DNA sequence string (only allowing uppercase A, T, C, G) and determines if it satisfies the Watson-Crick palindrome property.
* **Algorithmic Efficiency:** Strictly designed to run in $O(N)$ time complexity, processing the sequence of $N$ nucleotides using the custom Double-Ended Queue within a **single loop**.

## 📂 Repository Structure
* 📁 `src/` : Contains all the Java source code.
  * 📄 `StringDoubleEndedQueue.java` (Part A - Interface)
  * 📄 `StringDoubleEndedQueueImpl.java` (Part A - Queue Implementation)
  * 📄 `PrefixToInfix.java` (Part B - Application)
  * 📄 `DNAPalindrome.java` (Part C - Application)
* 📄 `project1-report.pdf` : A detailed technical report containing the algorithmic analysis, justification of the $O(1)$ complexity for the queue, and design decisions for the applications.