Here’s a list of commonly used graph algorithms and their applicability to **directed** and/or **undirected graphs**:

---

## **Graph Algorithms: Directed vs. Undirected**

| **Algorithm**                      | **Directed** | **Undirected** | **Notes**                                                                                                                                     |
|-------------------------------------|--------------|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| **Depth-First Search (DFS)**        | ✅ Yes        | ✅ Yes          | Used for traversal, cycle detection, and connectivity checks.                                                                                 |
| **Breadth-First Search (BFS)**      | ✅ Yes        | ✅ Yes          | Suitable for shortest path in unweighted graphs and level-order traversal.                                                                   |
| **Dijkstra's Algorithm**            | ✅ Yes        | ✅ Yes          | Works for both types as long as all edge weights are non-negative.                                                                           |
| **Bellman-Ford Algorithm**          | ✅ Yes        | ✅ Yes          | Applicable to graphs with negative weights; undirected graphs need edges treated as bidirectional.                                           |
| **Floyd-Warshall Algorithm**        | ✅ Yes        | ✅ Yes          | Computes shortest paths between all pairs of vertices; works with weighted directed or undirected graphs without negative cycles.            |
| **Kruskal's Algorithm**             | ❌ No         | ✅ Yes          | Used for finding the Minimum Spanning Tree (MST) in undirected graphs.                                                                       |
| **Prim's Algorithm**                | ❌ No         | ✅ Yes          | Used for finding the MST; works naturally with undirected graphs.                                                                            |
| **Topological Sorting**             | ✅ Yes        | ❌ No           | Defined only for Directed Acyclic Graphs (DAGs).                                                                                             |
| **Tarjan's Algorithm (SCC)**        | ✅ Yes        | ❌ No           | Finds Strongly Connected Components (SCCs) in directed graphs.                                                                               |
| **Kosaraju's Algorithm (SCC)**      | ✅ Yes        | ❌ No           | Another approach for SCCs in directed graphs.                                                                                               |
| **Union-Find (Disjoint Set)**       | ✅ Yes        | ✅ Yes          | Typically used in Kruskal’s Algorithm or cycle detection in undirected graphs; less common in directed graphs.                               |
| **Cycle Detection**                 | ✅ Yes        | ✅ Yes          | DFS-based for directed graphs; Union-Find or DFS for undirected graphs.                                                                      |
| **A\***                             | ✅ Yes        | ✅ Yes          | A heuristic search algorithm; commonly used in pathfinding for weighted graphs (directed or undirected).                                     |
| **Edmonds-Karp Algorithm**          | ✅ Yes        | ❌ No           | Used for maximum flow problems; applicable to directed graphs representing flow networks.                                                   |
| **Ford-Fulkerson Algorithm**        | ✅ Yes        | ❌ No           | Similar to Edmonds-Karp; works for flow networks represented as directed graphs.                                                            |
| **Johnson's Algorithm**             | ✅ Yes        | ✅ Yes          | Computes shortest paths for all pairs in weighted graphs; handles directed and undirected graphs with positive or non-negative weights.      |
| **Bridges and Articulation Points** | ❌ No         | ✅ Yes          | DFS-based algorithm for finding bridges (critical edges) and articulation points (critical nodes) in undirected graphs.                      |

---

### **Key Observations**
1. **Traversal Algorithms (DFS, BFS)**:
   - Universal for both directed and undirected graphs.

2. **Shortest Path Algorithms**:
   - Algorithms like Dijkstra, Bellman-Ford, and Floyd-Warshall work for both types, provided edge weights are handled appropriately.

3. **Cycle Detection**:
   - Directed graphs: Use DFS with a recursion stack.
   - Undirected graphs: Use DFS or Union-Find.

4. **Minimum Spanning Tree (MST)**:
   - Defined only for undirected graphs since the concept assumes all edges are bidirectional.

5. **Strong Connectivity (SCC)**:
   - Only relevant for directed graphs (e.g., Tarjan's or Kosaraju's algorithms).

6. **Network Flow Algorithms**:
   - Defined for directed graphs representing flow networks.

---

### **Directed Only**
- Topological Sorting
- Strongly Connected Components (SCCs)
- Network Flow Algorithms (Edmonds-Karp, Ford-Fulkerson)

### **Undirected Only**
- Kruskal's and Prim's (MST)
- Bridges and Articulation Points

Would you like a deeper dive into a specific algorithm or its implementation?