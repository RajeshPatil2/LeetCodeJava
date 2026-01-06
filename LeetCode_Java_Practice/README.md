# Last Day Where You Can Still Cross

## Problem Overview

You are given a grid (matrix) with **rows** and **columns**.

* `0` means **land**
* `1` means **water**

Initially (Day 0), **all cells are land**.

Every day, **one cell becomes water** based on the given `cells` array.

Your task is to find the **last day** when it is still possible to walk:

* From **any cell in the top row**
* To **any cell in the bottom row**
* Moving only **up, down, left, right**
* Walking **only on land cells (0)**

---

## Input

* `row` → number of rows
* `col` → number of columns
* `cells[i] = [ri, ci]` → cell flooded on day `i`

> Cells are **1-based indexed**

---

## Output

Return the **last day number** when crossing from top to bottom is possible.

---

## Example 1

**Input:**

```
row = 2, col = 2
cells = [[1,1],[2,1],[1,2],[2,2]]
```

**Output:**

```
2
```

**Explanation:**
Crossing is possible till day 2.

---

## Example 2

**Input:**

```
row = 2, col = 2
cells = [[1,1],[1,2],[2,1],[2,2]]
```

**Output:**

```
1
```

---

## Example 3

**Input:**

```
row = 3, col = 3
cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
```

**Output:**

```
3
```

---

## Approach (Very Easy Words)

1. Use **Binary Search on days** (0 to total days)
2. For each day:

   * Mark flooded cells as water
   * Check if path exists from **top row to bottom row**
3. Use **BFS (Queue)** to check the path
4. The **last valid day** is the answer

---

## Why This Solution is Efficient

* Binary Search reduces days check
* BFS ensures correct path checking
* Works within given constraints

---

## Concepts Used

* Binary Search
* Breadth First Search (BFS)
* Matrix Traversal
* Graph Traversal

---

---

**Author:** Rajesh Patil
**Language:** Java
**Difficulty:** Hard (Logic), Easy (Implementation)
