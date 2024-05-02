from Helper import triangularMatrixFromFile

class Prim:
    def __init__(self, V, graph):
        self.V = V
        self.graph = [[0 for column in range(V)]]

    def printMST(self, parent):
        total_cost = sum(self.graph[i][parent[i]] for i in range(1, self.V))
        print("TOTAL OPTIMAL COST =", total_cost)
        print("*********************")
        print("SELECTED EDGES=")
        for i in range(1, self.V):
            print(f"EDGE {i}: FROM NODE {parent[i]} TO NODE {i} *** COST = {self.graph[i][parent[i]]}")
        return total_cost

    def minKey(self, key, mstSet):
        min = 99999
        min_index = 0
        for v in range(self.V):
            if mstSet[v] == False and key[v] < min:
                min = key[v]
                min_index = v
        return min_index

    def primMST(self):
        key = [99999] * self.V
        parent = [None] * self.V
        key[0] = 0
        mstSet = [False] * self.V
        parent[0] = -1

        for _ in range(self.V):
            u = self.minKey(key, mstSet)
            mstSet[u] = True

            for v in range(self.V):
                if self.graph[u][v] > 0 and mstSet[v] == False and key[v] > self.graph[u][v]:
                    key[v] = self.graph[u][v]
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
    total_cost = prim_instance.primMST()
    end_time = time.time()

    print(f"Total optimal cost: {total_cost}")
    print(f"Execution time: {end_time - start_time} seconds")
