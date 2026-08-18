# 🏙️ Data Structures: Heaps, Priority Queues & Sorting Algorithms

## 📌 Overview
This repository contains the second project for the **Data Structures** course at the Athens University of Economics and Business (AUEB). The primary objective is to implement advanced Abstract Data Types (ADTs) and sorting algorithms from scratch in **Java**, strictly without relying on built-in `java.util` sorting methods or queue collections. 

The core of this project revolves around analyzing epidemiological data (influenza cases across various cities) by building custom **Min/Max Heaps**, a **Priority Queue**, and a custom **Quicksort** algorithm to efficiently process and filter data streams.

## 📄 Full Assignment Details

For the complete problem descriptions, constraints, and execution examples, please refer to the attached official document: 👉 [DS_Project_2.pdf](./DS23-project2.pdf) *(Note: The document is in Greek)*.

## 🚀 Features & Implementations

### Part A: Custom Quicksort Implementation
* **Functionality:** A program (`Influenza_k.java`) that reads a static list of cities and outputs the top `k` safest cities based on their influenza density (cases per 50,000 residents).
* **Implementation:** Implemented a custom **Quicksort** algorithm from scratch to sort the array of objects in $O(N \log N)$ expected time, handling tie-breakers alphabetically by city name or by ID.

### Part B: Custom ADT (Priority Queue via Min-Heap)
* **Implementation:** Developed `PQ.java` based on a custom `PQInterface.java`. 
* **Underlying Structure:** Built entirely upon a manual array-based **Min-Heap**.
* **Advanced $O(\log N)$ Removal:** Overcame the standard $O(N)$ removal bottleneck by implementing a supplementary `positions` array mapping City IDs to their current heap indices. This guarantees an optimal $O(\log N)$ time complexity for the custom `remove(id)` operation.

### Part C: Dynamic Top-K Selection (Data Streams)
* **Functionality:** A program (`DynamicInfluenza_k_withPQ.java`) that dynamically processes a stream of cities line-by-line, continuously maintaining the top `k` safest cities without storing the entire dataset in memory.
* **Algorithmic Efficiency:** Achieved strict $O(N \log k)$ time complexity using the custom Priority Queue, ensuring high space and time efficiency even for massive datasets where $k \ll N$.

### Part D: Dynamic Median Finder (Bonus)
* **Functionality:** A highly optimized program (`Dynamic_Median.java`) capable of dynamically calculating the median influenza density across the data stream on the fly.
* **Two-Heaps Architecture:** Mastered the classic "Find Median from Data Stream" problem by utilizing two parallel Priority Queues:
  * A **Max-Heap** (`rightHalfPQ`) storing the lower half of the densities.
  * A **Min-Heap** (`leftHalfPQ`) storing the upper half.
* **Algorithmic Efficiency:** Maintains perfectly balanced heaps (size difference $\le 1$), granting strictly $O(1)$ time complexity for median retrieval and $O(\log N)$ for insertion.

## 📂 Repository Structure
* 📁 `src/` : Contains all the Java source code.
  * 📄 `City.java` & `CityInterface.java` (Core Object Representation)
  * 📄 `PQ.java` & `PQInterface.java` (Part B - Custom Priority Queue)
  * 📄 `Influenza_k.java` (Part A - Static Sorting Application)
  * 📄 `DynamicInfluenza_k_withPQ.java` (Part C - Dynamic Top-K Application)
  * 📄 `Dynamic_Median.java` (Part D - Dynamic Median Application)
* 📄 `example.txt` : Sample input dataset.
* 📄 `project2-report.pdf` : A detailed technical report containing mathematical proofs, Big-O algorithmic complexity analysis, and execution traces for the implemented logic.