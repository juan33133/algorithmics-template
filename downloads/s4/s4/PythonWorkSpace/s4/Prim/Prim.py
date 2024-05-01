from Helper import triangularMatrixFromFile

class Prim: 
    def __init__(self, nodes, graph):
        self.N = nodes
        self.graph = graph

    def printMST(self, parent):
        total_cost = sum(self.graph[i][parent[i]] for i in range(1, self.N))
        print("TOTAL OPTIMAL COST =", total_cost)
        print("*********************")
        print("SELECTED EDGES=")
        for i in range(1, self.N):
            print(f"EDGE {i}: FROM NODE {parent[i]} TO NODE {i} *** COST = {self.graph[i][parent[i]]}")
        return total_cost

    def minPath(self, path, mstSet):
        min_val = float('inf')
        min_index = -1

        for v in range(self.N):
            if path[v] < min_val and not mstSet[v]:
                min_val = path[v]
                min_index = v

        return min_index

    def prim(self):
        path = [float('inf')] * self.N
        parent = [None] * self.N
        path[0] = 0
        mstSet = [False] * self.N
        parent[0] = -1

        for _ in range(self.N - 1):
            u = self.minPath(path, mstSet)
            mstSet[u] = True

            for v in range(self.N):
                if self.graph[u][v] > 0 and not mstSet[v] and self.graph[u][v] < path[v]:
                    path[v] = self.graph[u][v]
                    parent[v] = u

        return self.printMST(parent)


if __name__ == "__main__":
    import sys
    import time

    if len(sys.argv) != 2:
        print("Usage: python Prim.py <graph_file>")
        sys.exit(1)

    graph_file = sys.argv[1]
    graph = triangularMatrixFromFile(graph_file)
    num_vertices = len(graph)

    prim_instance = Prim(num_vertices, graph)

    start_time = time.time()
    total_cost = prim_instance.prim()
    end_time = time.time()

    print(f"Total optimal cost: {total_cost}")
    print(f"Execution time: {end_time - start_time} seconds")
